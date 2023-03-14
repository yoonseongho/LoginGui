import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.*;

public class Option extends JFrame {
    private User user;

    JLabel name;

    Option(User user) {
        super("Login_Client");
        this.user = user;

        /* 프레임 크기 설정 */
        setSize(458, 255);

        /* 프레임을 화면 가운데에 배치 */
        setLocationRelativeTo(null);

        /* 프레임을 닫았을 때 메모리에서 제거되도록 설정 */
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* 레이아웃 설정 */
        getContentPane().setLayout(null);

        /* 버튼 생성 */
        JButton btn1 = new JButton("회원정보 수정");
        JButton btn2 = new JButton("회원탈퇴");
        JButton btn3 = new JButton("로그아웃");

        /* 버튼 위치와 크기 설정 */
        btn1.setBounds(126, 57, 200, 40);
        btn2.setBounds(126, 107, 200, 40);
        btn3.setBounds(126, 157, 200, 40);

        /* 환영 메시지 띄우기 */
        name = new JLabel(user.getName() + "님 환영합니다.");
        name.setBounds(170, 5, 200, 40);

        /* 프레임에다가 버튼 추가 */
        getContentPane().add(name);
        getContentPane().add(btn1);
        getContentPane().add(btn2);
        getContentPane().add(btn3);

        /* 프레임이 보이도록 설정 */
        setVisible(true);

        /* 회원정보 수정 버튼 */
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Update(user);
            }
        });

        /* 회원 탈퇴 버튼 */
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Delete(user);
            }
        });

        /* 로그아웃 버튼 */
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Login();
            }
        });
    }
}