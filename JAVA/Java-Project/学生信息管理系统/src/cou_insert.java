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


public class cou_insert extends JFrame{
	public cou_insert(){
		super("课程表插入");
		Container container=getContentPane();
		container.setLayout(null);
		final JButton button1=new JButton("确认");
    	JButton button2=new JButton("返回");
    	JLabel JLable1=new JLabel("课程号:");
    	JLabel JLable2=new JLabel("课程名:");
    	JLabel JLable3=new JLabel("先行课:");
    	JLabel JLable4=new JLabel("学分:");
    	final JTextField text1 = new JTextField(20);
    	final JTextField text2 = new JTextField(20);
    	final JTextField text3 = new JTextField(20);
    	final JTextField text4 = new JTextField(20);
        button1.setBounds(40,300,70,50);
    	button2.setBounds(140,300,70,50);
    	JLable1.setBounds(50,50,50,20);
    	JLable2.setBounds(50,100,50,20);
    	JLable3.setBounds(50,150,50,20);
    	JLable4.setBounds(50,200,50,20);
    	text1.setBounds(100,50,100,20);
    	text2.setBounds(100,100,100,20);
    	text3.setBounds(100,150,100,20);
    	text4.setBounds(100,200,100,20);
    	container.add(button1);	
    	container.add(button2);
    	container.add(JLable1);
    	container.add(JLable2);
    	container.add(JLable3);
    	container.add(JLable4);
    	container.add(text1);
    	container.add(text2);
    	container.add(text3);
    	container.add(text4);
    	
    	button1.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e) 
    		{
    			try{
    				Class.forName("com.mysql.jdbc.Driver");
    				String url="jdbc:mysql://localhost:3306/test";
    				Connection con=DriverManager.getConnection(url,"root","123456");
    				String cno=text1.getText();
    				String cname=text2.getText();
    				String csex=text3.getText();
    				String cage=text4.getText();
    				PreparedStatement ps=con.prepareStatement("insert into course values(?,?,?,?)");
    				ps.setString(1,cno);
    				ps.setString(2, cname);
    				ps.setString(3, csex);
    				ps.setString(4, cage);
    				ps.executeUpdate();
    				con.close(); 
    			}
    			catch(ClassNotFoundException ce){
    				System.out.println(ce.getMessage()+"1");
    			}
    			catch (SQLException se){
    				System.out.println(se.getMessage()+"2");
    				JOptionPane.showMessageDialog(button1,"该课程号号已存在" );
    			}
    			new cou().setVisible(true);
    			dispose();
        
    		}  
    	});
    	button2.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e) 
    		{
    			new stu().setVisible(true);
    			dispose();
    		}
    	});
    	setSize(270,400);
    	setVisible(true);
    	setLocation(500,200);
	}

	public static void main(String [] args)
    {
    	cou_insert frame=new cou_insert();
      	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

