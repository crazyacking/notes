
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


public class cou_delete extends JFrame{
	public cou_delete(){
		super("课程表删除");
		Container container=getContentPane();
		container.setLayout(null);
	    JButton button1=new JButton("确认");
    	JButton button2=new JButton("返回");
    	JLabel JLable1=new JLabel("请输入要删除课程的编号:");
    	final JTextField text1 = new JTextField(20);
        button1.setBounds(40,300,70,50);
    	button2.setBounds(140,300,70,50);
    	JLable1.setBounds(50,50,200,20);
    	text1.setBounds(80,100,100,20);
    	container.add(button1);	
    	container.add(button2);
    	container.add(JLable1);
    	container.add(text1);
    	
    	button1.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e) 
    		{
    			try{
    				Class.forName("com.mysql.jdbc.Driver");
    				String url="jdbc:mysql://localhost:3306/test";
    				Connection con=DriverManager.getConnection(url,"root","123456");
    				String Cno=text1.getText();
    				PreparedStatement pt=con.prepareStatement("delete from sc where cno=?");
    				pt.setString(1,Cno);
    				pt.executeUpdate();
    				PreparedStatement ps=con.prepareStatement("delete from course where cno=?");
    				ps.setString(1,Cno);
    				ps.executeUpdate();
    				con.close(); 
    			}
    			catch(ClassNotFoundException ce){
    				System.out.println(ce.getMessage()+"1");
    			}
    			catch (SQLException se){
    				System.out.println(se.getMessage()+"2");
    			}
    			new cou().setVisible(true);
    			dispose();
        
    		}  
    	});
    	button2.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e) 
    		{
    			new cou().setVisible(true);
    			dispose();
    		}
    	});
    	setSize(270,400);
    	setVisible(true);
    	setLocation(500,200);
	}

	public static void main(String [] args)
    {
    	cou_delete frame=new cou_delete();
      	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}