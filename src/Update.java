import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Update extends JFrame {

    Update(User user) {
        super("Login_Client");
        /* 프레임 생성 */
        JPasswordField pf1;
        JLabel l2, l3, l4;
        JTextField tf1, tf2;
        l2 = new JLabel("UserID :");
        l2.setBounds(105, 30, 80, 10);
        tf1 = new JTextField();
        tf1.setText(user.getUserId());
        tf1.setEnabled(false);
        tf1.setBounds(170, 20, 150, 30);


        l3 = new JLabel("Password :");
        l3.setBounds(85, 55, 80, 45);

        pf1 = new JPasswordField();
        pf1.setBounds(170, 60, 150, 30);

        l4 = new JLabel("Name :");
        l4.setBounds(110, 100, 80, 30);

        tf2 = new JTextField();
        tf2.setBounds(170, 100, 150, 30);


        /* 프레임 크기 설정 */
        setSize(458, 255);

        /* 프레임을 화면 가운데에 배치 */
        setLocationRelativeTo(null);

        /* 프레임을 닫았을 때 메모리에서 제거되도록 설정 */
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* 레이아웃 설정 */
        getContentPane().setLayout(null);

        /* 버튼 생성 */
        JButton btn1 = new JButton("수정");
        JButton btn2 = new JButton("취소");

        /* 버튼 위치와 크기 설정 */
        btn1.setBounds(100, 170, 122, 30);
        btn2.setBounds(250, 170, 122, 30);

        /* 프레임에다가 버튼 추가 */
        getContentPane().add(btn1);
        getContentPane().add(btn2);
        getContentPane().add(l2);
        getContentPane().add(tf1);
        getContentPane().add(l3);
        getContentPane().add(pf1);
        getContentPane().add(l4);
        getContentPane().add(tf2);

        /* 프레임이 보이도록 설정 */
        setVisible(true);


        /* 수정버튼 클릭시 */
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Access access = new Access();
                String password = pf1.getText();
                String name = tf2.getText();
                if(pf1.getText().equals("") || tf2.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "비밀번호 또는 이름을 입력해주세요.", "비밀번호,이름입력", JOptionPane.DEFAULT_OPTION);
                }
                else {
                    user.setPassword(password);
                    user.setName(name);
                    access.update(user);
                    setVisible(false);
                    new Login();
                    JOptionPane.showMessageDialog(null, "수정되었습니다.", "update", JOptionPane.DEFAULT_OPTION);
                }
                access.close();
            }
        });

        /* 취소 버튼 클릭시 */
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Option(user);
            }
        });
    }
}