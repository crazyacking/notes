import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class sc_insert extends JFrame{
	public sc_insert(){
		super("成绩表插入");
		Container container=getContentPane();
		container.setLayout(null);
		final JButton button1=new JButton("确认");
    	JButton button2=new JButton("返回");
    	JLabel JLable1=new JLabel("学号:");
    	JLabel JLable2=new JLabel("课程号:");
    	JLabel JLable3=new JLabel("成绩:");
    	final JTextField text1 = new JTextField(20);
    	final JTextField text2 = new JTextField(20);
    	final JTextField text3 = new JTextField(20);
        button1.setBounds(40,300,70,50);
    	button2.setBounds(140,300,70,50);
    	JLable1.setBounds(50,50,50,20);
    	JLable2.setBounds(50,100,50,20);
    	JLable3.setBounds(50,150,50,20);
    	text1.setBounds(100,50,100,20);
    	text2.setBounds(100,100,100,20);
    	text3.setBounds(100,150,100,20);
    	container.add(button1);	
    	container.add(button2);
    	container.add(JLable1);
    	container.add(JLable2);
    	container.add(JLable3);
    	container.add(text1);
    	container.add(text2);
    	container.add(text3);
    	
    	button1.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e) 
    		{
    			try{
    				Class.forName("com.mysql.jdbc.Driver");
    				String url="jdbc:mysql://localhost:3306/test";
    				Connection con=DriverManager.getConnection(url,"root","123456");
    				String Sno=text1.getText();
    				String Sname=text2.getText();
    				String Ssex=text3.getText();
    				PreparedStatement ps=con.prepareStatement("insert into sc values(?,?,?)");
    				ps.setString(1,Sno);
    				ps.setString(2, Sname);
    				ps.setString(3, Ssex);
    				ps.executeUpdate();
    				con.close(); 
    			}
    			catch(ClassNotFoundException ce){
    				System.out.println(ce.getMessage()+"1");
    			}
    			catch (SQLException se){
    				System.out.println(se.getMessage()+"2");
    				JOptionPane.showMessageDialog(button1,"该学号或课程号不存在" );
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
    	sc_insert frame=new sc_insert();
      	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
