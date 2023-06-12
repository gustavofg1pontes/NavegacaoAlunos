package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Aluno {
    private static String ra;
    private static String nome;
    private static String sexo;
    private static LocalDate dataNascimento;
    private static String telefone;

    public final static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public String toString() {
        return "Ra: " + ra + "; Nome: " + nome + "; Sexo: " + sexo + "; Nascimento: " + dataNascimento
                + "; Telefone: " + telefone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return ra.equals(aluno.ra) && nome.equals(aluno.nome) && sexo.equals(aluno.sexo) && dataNascimento.equals(aluno.dataNascimento) && telefone.equals(aluno.telefone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ra, nome, sexo, dataNascimento, telefone);
    }

    public static String getRa() {
        return ra;
    }

    public static void setRa(String _ra) {
        ra = _ra;
    }

    public static String getNome() {
        return nome;
    }

    public static void setNome(String _nome) {
        nome = _nome;
    }

    public static String getSexo() {
        return sexo;
    }

    public static void setSexo(String _sexo) {
        sexo = _sexo;
    }

    public static LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public static void setDataNascimento(LocalDate _dataNascimento) {
        dataNascimento = _dataNascimento;
    }

    public static String getTelefone() {
        return telefone;
    }

    public static void setTelefone(String _telefone) {
        telefone = _telefone;
    }
}
