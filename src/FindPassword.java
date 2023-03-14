import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FindPassword extends JFrame {
    JLabel l2;
    JTextField tf1;

    FindPassword() {
        super("Login_Client");
        setSize(458, 255);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        JButton btn1 = new JButton("확인");
        JButton btn2 = new JButton("취소");
        btn1.setBounds(100, 140, 122, 30);
        btn2.setBounds(250, 140, 122, 30);

        l2 = new JLabel("UserID :");
        l2.setBounds(120, 75, 80, 30);
        tf1 = new JTextField();
        tf1.setBounds(180, 76, 150, 30);

        getContentPane().add(btn1);
        getContentPane().add(btn2);
        getContentPane().add(l2);
        getContentPane().add(tf1);

        setVisible(true);

        /* 확인 버튼 */
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tf1.getText().isBlank()) {
                    JOptionPane.showMessageDialog(null, "아이디를 입력하세요.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                Access access = new Access();
                User user = access.select(tf1.getText());
                if (user == null) {
                    JOptionPane.showMessageDialog(null, "아이디를 찾을 수 없습니다.", "Not found", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                setVisible(false);
                new ChangePassword(user.getUserId());
            }
        });

        /* 취소 버튼 */
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Login();
            }
        });
    }
}