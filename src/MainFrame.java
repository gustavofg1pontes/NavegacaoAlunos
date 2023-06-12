import BLL.AlunoBLL;
import entities.Aluno;

import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDate;

public class MainFrame extends JFrame {
    private JPanel JMainFrame;
    private JLabel lblIcon;
    private JLabel lblTitulo;
    private JLabel lblRa;
    private JLabel lblNome;
    private JLabel lblSexo;
    private JLabel lblDataNascimento;
    private JLabel lblTelefone;
    private JTextField txtRa;
    private JTextField txtNome;
    private JTextField txtSexo;
    private JTextField txtDataNascimento;
    private JTextField txtTelefone;
    private JPanel JPanelButtons;
    private JButton btnFirst;
    private JButton btnLast;
    private JButton btnNext;
    private JButton btnPrevious;

    public MainFrame(){
        setContentPane(JMainFrame);
        setSize(600, 350);
        setTitle("Navegação de alunos");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                try{
                    AlunoBLL.conecta();
                    AlunoBLL.geraRS();
                }catch (Exception er){
                    JOptionPane.showMessageDialog(JMainFrame, er.getMessage());
                }
            }

            @Override
            public void windowClosed(WindowEvent e) {
                AlunoBLL.desconecta();
            }
        });
        btnFirst.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                passaAluno(1);
            }
        });
        btnPrevious.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                passaAluno(2);
            }
        });
        btnNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                passaAluno(3);
            }
        });
        btnLast.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                passaAluno(4);
            }
        });
    }

    public void mostrarAluno(){
        txtRa.setText(Aluno.getRa());
        txtNome.setText(Aluno.getNome());
        txtSexo.setText(Aluno.getSexo());
        txtDataNascimento.setText(Aluno.getDataNascimento().format(Aluno.dtf));
        txtTelefone.setText(Aluno.getTelefone());
    }

    public void passaAluno(int op){
        try{
            AlunoBLL.passaAluno(op);
            mostrarAluno();
        }catch (Exception er){
            JOptionPane.showMessageDialog(JMainFrame, er.getMessage());
        }
    }
}
