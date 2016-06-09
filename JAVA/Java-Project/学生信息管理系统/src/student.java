import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;


public class student extends JFrame{
	String user,password;
	public student(){
		super("学生信息管理系统");
		Container container=getContentPane();
		container.setLayout(null);
		final JButton button1=new JButton("确认");
    	JButton button2=new JButton("返回");
    	JLabel JLable1=new JLabel("账号");
    	JLabel JLable2=new JLabel("密码");
    	JLabel JLable3=new JLabel("学生登录");
    	final JTextField text1 = new JTextField(15);
    	final JPasswordField text2 = new JPasswordField(15);
        button1.setBounds(100,150,70,50);
    	button2.setBounds(170,150,70,50);
    	JLable1.setBounds(100,50,50,20);
    	JLable2.setBounds(100,100,50,20);
    	JLable3.setBounds(130,20,100,20);
    	text1.setBounds(150,50,100,20);
    	text2.setBounds(150,100,100,20);
    	container.add(button1);	
    	container.add(button2);
    	container.add(JLable1);
    	container.add(JLable2);
    	container.add(JLable3);
    	container.add(text1);
    	container.add(text2);
    	
    	button1.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e) 
    		{
    			user=text1.getText();
    			password=text2.getText();
    			try{
    				Class.forName("com.mysql.jdbc.Driver");
    				String url="jdbc:mysql://localhost:3306/test";
    				Connection con=(Connection) DriverManager.getConnection(url,"root","123456");
    				PreparedStatement stat=con.prepareStatement("select * from student where sno=? ");
    				stat.setString(1,user);
    				ResultSet rs=(ResultSet) stat.executeQuery();
    				if(rs.next())
    				{
    					if(user.equals(password))
    					{
    						String a=user;
    						new personal(a).setVisible(true);
    		    			dispose();
    					}
    					else
    					{
    						JOptionPane.showMessageDialog(button1,  "密码错误");
    					}
    					
    				}
    				else
    				{
    					JOptionPane.showMessageDialog(button1,  "用户名不存在");
    				}
    				con.close();
    			}
    			catch(ClassNotFoundException ce){
    				System.out.println(ce.getMessage()+"1");
    			}
    			catch (SQLException se){
    				System.out.println(se.getMessage()+"2");
    			}
        
    		} 
    	});
    	button2.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e) 
    		{
    			new start().setVisible(true);
    			dispose();
    		}
    	});
    	setSize(300,300);
    	setVisible(true);
    	setLocation(500,200);
	}

	public static void main(String [] args)
    {
    	student frame=new student();
      	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
