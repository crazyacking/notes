import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class sc_delete extends JFrame{
	public sc_delete(){
		super("成绩表删除");
		Container container=getContentPane();
		container.setLayout(null);
		final JButton button1=new JButton("确认");
    	JButton button2=new JButton("返回");
    	JLabel JLable1=new JLabel("请输入要删除学生的学号和课程号:");
    	final JTextField text1 = new JTextField(20);
    	final JTextField text2 = new JTextField(20);
        button1.setBounds(40,300,70,50);
    	button2.setBounds(140,300,70,50);
    	JLable1.setBounds(50,50,200,20);
    	text1.setBounds(80,100,100,20);
    	text2.setBounds(80,130,100,20);
    	container.add(button1);	
    	container.add(button2);
    	container.add(JLable1);
    	container.add(text1);
    	container.add(text2);
    	
    	button1.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e) 
    		{
    			try{
    				Class.forName("com.mysql.jdbc.Driver");
    				String url="jdbc:mysql://localhost:3306/test";
    				Connection con=DriverManager.getConnection(url,"root","123456");
    				String Sno=text1.getText();
    				String Cno=text2.getText();
    				PreparedStatement pt=con.prepareStatement("delete from sc where sno=?and cno=?");
    				pt.setString(1,Sno);
    				pt.setString(2,Cno);
    				pt.executeUpdate();
    				con.close(); 
    			}
    			catch(ClassNotFoundException ce){
    				System.out.println(ce.getMessage()+"1");
    			}
    			catch (SQLException se){
    				System.out.println(se.getMessage()+"2");
    				JOptionPane.showMessageDialog(button1,"该学号已存在" );
    			}
    			new sc().setVisible(true);
    			dispose();
        
    		}  
    	});
    	button2.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e) 
    		{
    			new sc().setVisible(true);
    			dispose();
    		}
    	});
    	setSize(270,400);
    	setVisible(true);
    	setLocation(500,200);
	}

	public static void main(String [] args)
    {
    	sc_delete frame=new sc_delete();
      	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
