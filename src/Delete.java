import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.*;

public class Delete extends JFrame {

        JLabel txt;

        Delete(User user) {
            super("Login_Client");

            /* 프레임 크기 설정 */
            setSize(458, 255);

            /* 프레임을 화면 가운데에 배치 */
            setLocationRelativeTo(null);

            /* 프레임을 닫았을 때 메모리에서 제거되도록 설정 */
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            /* 레이아웃 설정 */
            getContentPane().setLayout(null);

            /* 버튼 생성 */
            txt = new JLabel("삭제하시겠습니까?");
            txt.setBounds(170, 5, 200, 40);
            JButton btn1 = new JButton("Yes");
            JButton btn2 = new JButton("No");

            /* 버튼 위치와 크기 설정 */
            btn1.setBounds(120, 57, 210, 40);
            btn2.setBounds(120, 107, 210, 40);

            /* 프레임에다가 버튼 추가 */
            getContentPane().add(btn1);
            getContentPane().add(btn2);
            getContentPane().add(txt);

            /* 프레임이 보이도록 설정 */
            setVisible(true);

            /* 삭제 Yse 버튼 */
            btn1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Access access = new Access();
                    access.delete(user.getUserId());
                    setVisible(false);
                    new Login();
                    JOptionPane.showMessageDialog(null, "삭제되었습니다.", "delete", JOptionPane.DEFAULT_OPTION);
                    access.close();
                }
            });

            /* 삭제 No 버튼 */
            btn2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                    new Option(user);
                }
            });
        }
    }