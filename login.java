import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class login extends JFrame implements ActionListener
{
int i;
JLabel l1,l2;
JTextField t1;
JPasswordField t2;
JButton b;
login()
{
i=0;
l1=new JLabel("Username");
l1.setHorizontalAlignment(JLabel.CENTER);
l2=new JLabel("Password");
t1=new JTextField("");
t2=new JPasswordField("");
b=new JButton("Login");
l2.setHorizontalAlignment(JLabel.CENTER);
t1.setHorizontalAlignment(JTextField.CENTER);
t2.setHorizontalAlignment(JPasswordField.CENTER);
b.addActionListener(this);
add(l1);
add(t1);
add(l2);
add(t2);
add(b);
setVisible(true);
setSize(400,200);
setTitle("server");
setResizable(false);
setLayout(new GridLayout(3,2));
setDefaultCloseOperation(EXIT_ON_CLOSE);
}
public void actionPerformed(ActionEvent e)
{ 
try
{
Connection c=DriverManager.getConnection("jdbc:mysql://root@localhost:3306/haziq","root","hsbullah");
PreparedStatement s=c.prepareStatement("select * from login where name=? AND password=?");
s.setString(1,t1.getText());
s.setString(2,t2.getText());
ResultSet r=s.executeQuery();
if(r.next())
{
JOptionPane.showMessageDialog(this,"User Authenticated");
}
else
{
JOptionPane.showMessageDialog(this,"Invalid user");
}
}
catch(SQLException s)
{
System.out.println(s);
}
}
public static void main(String ar[])
{
new login();
}
}
