import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class Login extends JFrame implements ActionListener{
    JLabel label1, label2, label3;
    JTextField textField2;
    JPasswordField passwordField3;
    JButton button1,button2,button3;

    HashMap<String, String> users;

    Login(){
        super("APSIT Bank System");

        users=new HashMap<>();

        //Hardcoded values of cardno and pin for users//
        users.put("8766971600", "1600");  //Vivek Maurya//
        users.put("8369451800", "1800");  //Prem Mahajan//
        users.put("7738834700", "4700");  //Vinayak Mishra//
        users.put("8850957300", "7300");  //Mihir Mehta//
        users.put("9653232900", "2900");  //Vedant Mallya//
        

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/Apsit.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,5,130,130);
        add(image);

        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("icon/card.png"));
        Image ii2 = ii1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon ii3 = new ImageIcon(ii2);
        JLabel iimage = new JLabel(ii3);
        iimage.setBounds(630,350,100,100);
        add(iimage);

        label1 = new JLabel("WELCOME TO ATM");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("AvantGarde", Font.BOLD, 38));
        label1.setBounds(230,125,450,40);
        add(label1);

        label2 = new JLabel("Card No:");
        label2.setFont(new Font("Ralway", Font.BOLD, 28));
        label2.setForeground(Color.WHITE);
        label2.setBounds(150,190,375,30);
        add(label2);

        textField2 = new JTextField();
        textField2.setBounds(325,190,230,30);
        textField2.setFont(new Font("Arial", Font.BOLD,14));
        add(textField2);

        label3 = new JLabel("PIN: ");
        label3.setFont(new Font("Ralway", Font.BOLD, 28));
        label3.setForeground(Color.WHITE);
        label3.setBounds(150,250,375,30);
        add(label3);

        passwordField3 = new JPasswordField();
        passwordField3.setBounds(325,250,230,30);
        passwordField3.setFont(new Font("Arial", Font.BOLD, 14));
        add(passwordField3);

        button1 = new JButton("SIGN IN");
        button1.setFont(new Font("Arial", Font.BOLD, 14));
        button1.setForeground(Color.WHITE);
        button1.setBackground(Color.BLACK);
        button1.setBounds(300,300,100, 30);
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("CLEAR");
        button2.setFont(new Font("Arial", Font.BOLD, 14));
        button2.setForeground(Color.WHITE);
        button2.setBackground(Color.BLACK);
        button2.setBounds(430,300,100, 30);
        button2.addActionListener(this);
        add(button2);

        button3 = new JButton("SIGN UP");
        button3.setFont(new Font("Arial", Font.BOLD, 14));
        button3.setForeground(Color.WHITE);
        button3.setBackground(Color.BLACK);
        button3.setBounds(300,350,230, 30);
        button3.addActionListener(this);
        add(button3);

        getContentPane().setBackground(new Color(238,66,66));
        setLayout(null);
        setSize(850,480);
        setLocation(450,200);
        // setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cardno = textField2.getText();
        String pin = passwordField3.getText();
        try{
            if (e.getSource()==button1){
                if (cardno.equals("") || pin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Fill the required fields");
                }
                else if ((users.containsKey(cardno))&&(users.get(cardno).equals(pin))) {
                    setVisible(false);
                    new main_Class(pin);
                }
                    
                    else{
                    JOptionPane.showMessageDialog(null, "Invalid Cardno and Pin");
                }
            
            }else if (e.getSource() == button2){
                textField2.setText("");
                passwordField3.setText("");
            }else if (e.getSource() == button3){
                new Signup();
                setVisible(false);
            }
        }catch (Exception E){
            E.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Login();
    }
}
