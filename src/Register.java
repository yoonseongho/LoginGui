import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Register extends JFrame {

    int USE = 0;

    Register() {
        super("Login_Client");
        JLabel Id, password, name;
        JTextField tf1, name1;
        JPasswordField pf1;

        /* 프레임 크기 설정 */
        setSize(458, 255);

        /* 프레임을 화면 가운데에 배치 */
        setLocationRelativeTo(null);

        /* 프레임을 닫았을 때 메모리에서 제거되도록 설정 */
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* 레이아웃 설정 */
        getContentPane().setLayout(null);

        /* 버튼 생성 */
        JButton btn1 = new JButton("가입");
        JButton btn2 = new JButton("취소");
        JButton article = new JButton("중복확인");

        /* 텍스트 생성 */
        Id = new JLabel("UserID :");
        tf1 = new JTextField();
        password = new JLabel("Password : ");
        pf1 = new JPasswordField();
        name = new JLabel("Name : ");
        name1 = new JTextField();

        /* 버튼 위치와 크기 설정 */
        /* X, Y, 길이, 높이 */
        Id.setBounds(120, 30, 80, 30);
        tf1.setBounds(180, 30, 150, 30);
        password.setBounds(100, 70, 80, 30);
        pf1.setBounds(180, 70, 150, 30);
        name.setBounds(123, 110, 80, 30);
        name1.setBounds(180, 110, 150, 30);
        btn1.setBounds(135, 165, 90, 30);
        article.setBounds(330, 30, 90, 30);
        btn2.setBounds(250, 165, 90, 30);

        /* 프레임에다가 버튼 추가 */
        getContentPane().add(btn1);
        getContentPane().add(Id);
        getContentPane().add(tf1);
        getContentPane().add(password);
        getContentPane().add(pf1);
        getContentPane().add(name);
        getContentPane().add(name1);
        getContentPane().add(article);
        getContentPane().add(btn2);

        /* 프레임이 보이도록 설정 */
        setVisible(true);

        /* 회원 가입 버튼 */
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tf1.getText().trim().equals("") || pf1.getText().trim().equals("") || name1.getText().trim().equals("")) {
                    JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호 또는 이름을 입력 하셔야 됩니다.", "아이디,비번,이름을 입력", JOptionPane.ERROR_MESSAGE);
                    return;
                } else if(USE == 0){
                    JOptionPane.showMessageDialog(null, "중복확인을 해주세요", "중복체크", JOptionPane.ERROR_MESSAGE);
                } else {
                    Access access = new Access();

                    User user = new User(tf1.getText(), pf1.getText(), name1.getText());
                    int result = access.insertUser(user);
                    if (result > 0) {
                        JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다.", "회원가입성공", JOptionPane.INFORMATION_MESSAGE);
                        setVisible(false);
                        new Login();
                    } else {
                        JOptionPane.showMessageDialog(null, "실패", "회원가입실패", JOptionPane.ERROR_MESSAGE);
                    }
                    access.close();
                }
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

        /* 중복 확인 버튼 */
        article.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tf1.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "아이디를 입력해주세요.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    Access access = new Access();
                    User user = new User();
                    String userId = tf1.getText();
                    user = access.select(userId);
                    if (user == null) {
                        USE = 1;
                        JOptionPane.showMessageDialog(null, "사용하실수 있는 아이디입니다.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        USE = 0;
                        JOptionPane.showMessageDialog(null, user.getName() + "님이 가입되어 있습니다.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    access.close();
                }
            }
        });
    }
}