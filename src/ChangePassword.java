import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangePassword extends JFrame {
    JLabel l2;
    JTextField tf1;

    ChangePassword(String userId) {
        super("Login_Client");
        setSize(458, 255);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        JButton btn1 = new JButton("변경");
        JButton btn2 = new JButton("취소");
        btn1.setBounds(100, 140, 122, 30);
        btn2.setBounds(250, 140, 122, 30);


        l2 = new JLabel("Password :");
        l2.setBounds(100, 75, 80, 30);

        tf1 = new JPasswordField();
        tf1.setBounds(180, 76, 150, 30);

        getContentPane().add(btn1);
        getContentPane().add(btn2);
        getContentPane().add(l2);
        getContentPane().add(tf1);

        setVisible(true);

        /* 변경 버튼 */
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Access access = new Access();
                User user = access.select(userId);

                if (tf1.getText().isBlank()) {
                    JOptionPane.showMessageDialog(null, "비밀번호를 입력해주세요.", "비밀번호입력", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if(tf1.getText().equals(user.getPassword())) {
                    JOptionPane.showMessageDialog(null, "사용중인 비밀번호입니다.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                } else {
                    user.setPassword(tf1.getText());
                    access.passwordUpdate(userId, user.getPassword());
                    setVisible(false);
                    new Login();
                    JOptionPane.showMessageDialog(null, "수정되었습니다.", "Success", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        /* 취소 버튼 */
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new FindPassword();
            }
        });
    }
}