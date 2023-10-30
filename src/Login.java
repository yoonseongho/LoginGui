import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    JLabel l2, l3;
    JTextField tf1;
    JPasswordField pf1;

    Login() {
        super("Login_Client");
        setSize(500, 255);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        JButton btn1 = new JButton("로그인");
        JButton btn2 = new JButton("회원가입");
        btn1.setBounds(50, 140, 180, 30);
        btn2.setBounds(280, 140, 180, 30);

        l2 = new JLabel("ID :");
        l2.setBounds(145, 50, 80, 30);

        tf1 = new JTextField();
        tf1.setBounds(180, 50, 150, 30);

        l3 = new JLabel("Password :");
        l3.setBounds(100, 100, 80, 30);

        pf1 = new JPasswordField();
        pf1.setBounds(180, 100, 150, 30);

        getContentPane().add(btn1);
        getContentPane().add(btn2);
        getContentPane().add(l2);
        getContentPane().add(tf1);
        getContentPane().add(l3);
        getContentPane().add(pf1);

        setVisible(true);

        /* 로그인 버튼 */
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = tf1.getText().trim();
                String pw = pf1.getText().trim();
                if (id.length() == 0 || pw.length() == 0) {
                    JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호를 입력 하셔야 됩니다.", "아이디랑 비밀번호를 확인해주세요", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Access access = new Access();
                int result = access.login(id, pw);

                if ( result == 1) {
                    User user = access.select(id);
                    JOptionPane.showMessageDialog(null, "로그인 성공", "로그인 확인", JOptionPane.ERROR_MESSAGE);
                    setVisible(false);
                    new Option(user);
                    return;
                }
                JOptionPane.showMessageDialog(null, "로그인 실패", "로그인 확인", JOptionPane.ERROR_MESSAGE);
                access.close();
            }
        });

        /* 회원가입 버튼 */
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Register();
            }
        });
    }

    public static void main(String[] args) {
        new Login();
    }
}