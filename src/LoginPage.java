import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class LoginPage implements ActionListener {
    JFrame frame = new JFrame();
    JButton login = new JButton("Login");
    JButton reset = new JButton("Reset");
    JTextField userIDField = new JTextField();
    JPasswordField userPassword = new JPasswordField();
    JButton show = new JButton("Show");
    //Makes all characters written appear as dots(like an actual password NO WAAY)
    JLabel userID = new JLabel("userID");
    JLabel password = new JLabel("Password");
    JLabel message = new JLabel();

    HashMap<String, String> loginInfo = new HashMap<>();

    LoginPage(HashMap<String, String> loginInfoOriginal) {

        //Frame setup
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
        frame.setLayout(null);
        frame.add(login);
        frame.add(reset);

        //UserID label
        userID.setBounds(50, 100, 75, 25);
        userID.setVisible(true);
        frame.add(userID);

        //Password label
        password.setBounds(50, 150, 75, 25);
        password.setVisible(true);
        frame.add(password);

        //Message label
        message.setBounds(50, 200, 100, 50);
        message.setFont(new Font(null, Font.ITALIC, 25));
        frame.add(message);
        message.setVisible(true);
        //UserIDField field
        userIDField.setBounds(125, 100, 200, 25);
        frame.add(userIDField);
        userIDField.setVisible(true);

        //UserPassword field
        userPassword.setBounds(125, 150, 200, 25);
        frame.add(userPassword);
        userPassword.setVisible(true);

        //Login button
        login.setBounds(125, 200, 100, 25);
        login.setFocusable(false);
        frame.add(login);
        login.setVisible(true);
        login.addActionListener(this);

        //Reset button
        reset.setBounds(225, 200, 100, 25);
        reset.setFocusable(false);
        frame.add(reset);
        reset.setVisible(true);
        reset.addActionListener(this);

        //ShowPass button
        show.setBounds(325, 150, 100, 25);
        show.setFocusable(false);
        show.addActionListener(this);
        frame.add(show);
        show.setVisible(true);

        loginInfo = loginInfoOriginal;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == reset) {
            userIDField.setText("");
            userPassword.setText("");
        }

        //Shows and hides the password
        if (userPassword.getEchoChar() != '\u0000') {
            userPassword.setEchoChar('\u0000');
        } else {
            userPassword.setEchoChar((Character) UIManager.get("PasswordField.echoChar"));
        }
        //Login button function
        if (e.getSource() == login) {

            String userID = userIDField.getText();
            String password = String.valueOf(userPassword.getPassword());

            if (loginInfo.containsKey(userID)) {
                if (loginInfo.get(userID).equals(password)) {
                    message.setForeground(Color.green);
                    message.setText("Login successful");
                    frame.dispose();
                    //closes the LoginPage and leaves only the WelcomePage
                    WelcomePage welcomePage = new WelcomePage(userID);
                    //(userID) displays your name in the WelcomePage
                } else {
                    message.setForeground(Color.red);
                    message.setText("Wrong password");
                }

            } else {
                message.setForeground(Color.red);
                message.setText("username not found");
            }
        }
    }
}