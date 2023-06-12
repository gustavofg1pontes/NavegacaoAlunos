package BLL;

import DAL.AlunoDAL;

public class AlunoBLL {

    public static void conecta()
    {
        AlunoDAL.connect();
    }

    public static void desconecta()
    {
        AlunoDAL.disconnect();
    }
    public static void geraRS(){
        AlunoDAL.geraRS();
    }
    public static void passaAluno(int op) throws Exception {
        AlunoDAL.passaAluno(op);
    }

}
