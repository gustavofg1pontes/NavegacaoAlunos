package DAL;

import entities.Aluno;

import java.sql.*;
import java.time.LocalDate;

public class AlunoDAL {

    private static final String stringConnection = System.getenv("DATABASE_URL");
    private static final String stringUser = System.getenv("DATABASE_USER");
    private static final String stringPassword = System.getenv("DATABASE_PASSWORD");
    private static ResultSet rsNav;
    private static Connection connection;

    public static void connect() {
        try {
            connection = DriverManager.getConnection(stringConnection, stringUser, stringPassword);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void disconnect() {
        if (connection == null) return;

        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void geraRS() {
        try {
            Statement st = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rsNav = st.executeQuery("SELECT * FROM alunostabela");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
        }
    }

    public static void passaAluno(int op) throws Exception {
        boolean flag;


        flag = switch (op) {
            case 1 -> rsNav.first();
            case 2 -> rsNav.previous();
            case 3 -> rsNav.next();
            case 4 -> rsNav.last();
            default -> false;
        };
        if (flag) {
            Aluno.setRa(rsNav.getString("ra"));
            Aluno.setNome(rsNav.getString("nome"));
            Aluno.setSexo(rsNav.getString("sexo"));
            Aluno.setDataNascimento(LocalDate.parse(rsNav.getString("dataNascimento")));
            Aluno.setTelefone(rsNav.getString("telefone"));
        } else {
            throw new Exception("Impossível");
        }
    }
}
