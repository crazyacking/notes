import java.awt.Container;
import java.awt.GraphicsConfiguration;
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

import com.mysql.jdbc.ResultSet;


public class information extends JFrame{
	private static final String a=null;
	public information(final String a){
    String sno = null;
    String sname=null;
    String ssex=null;
    String sage=null;
    String sdept=null;
	try{
	Class.forName("com.mysql.jdbc.Driver");
	String url="jdbc:mysql://localhost:3306/test";
	Connection con=DriverManager.getConnection(url,"root","123456");
	PreparedStatement stat=con.prepareStatement("select * from student where sno=?");
	stat.setString(1,a);
	ResultSet rs=(ResultSet) stat.executeQuery();
	while(rs.next())
	{
	 sno=rs.getString(1);
	 sname=rs.getString(2);
	 ssex=rs.getString(3);
	 sage=rs.getString(4);
	 sdept=rs.getString(5);
	}
    			}
    catch(ClassNotFoundException ce){
          	System.out.println(ce.getMessage()+"1");
    		}
    catch (SQLException se){
    		System.out.println(se.getMessage()+"2");
    		}
		Container container=getContentPane();
		container.setLayout(null);
    	JButton button1=new JButton("返回");
    	JLabel JLable1=new JLabel("学号:");
    	JLabel JLable2=new JLabel("姓名:");
    	JLabel JLable3=new JLabel("性别:");
    	JLabel JLable4=new JLabel("年龄:");
    	JLabel JLable5=new JLabel("系别:");
    	JLabel JLable_1 = new JLabel(sno);
    	JLabel JLable_2 = new JLabel(sname);
    	JLabel JLable_3 = new JLabel(ssex);
    	JLabel JLable_4 = new JLabel(sage);
    	JLabel JLable_5 = new JLabel(sdept);
        button1.setBounds(100,300,70,50);
    	JLable1.setBounds(50,50,50,20);
    	JLable2.setBounds(50,100,50,20);
    	JLable3.setBounds(50,150,50,20);
    	JLable4.setBounds(50,200,50,20);
    	JLable5.setBounds(50,250,50,20);
    	JLable_1.setBounds(100,50,100,20);
    	JLable_2.setBounds(100,100,100,20);
    	JLable_3.setBounds(100,150,100,20);
    	JLable_4.setBounds(100,200,100,20);
    	JLable_5.setBounds(100,250,100,20);
    	container.add(button1);	
    	container.add(JLable1);
    	container.add(JLable2);
    	container.add(JLable3);
    	container.add(JLable4);
    	container.add(JLable5);
    	container.add(JLable_1);
    	container.add(JLable_2);
    	container.add(JLable_3);
    	container.add(JLable_4);
    	container.add(JLable_5);
    	button1.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e) 
    		{
    			new personal(a).setVisible(true);
    			dispose();
    		}
    	});
    	setSize(270,400);
    	setVisible(true);
    	setLocation(500,200);
	}

	public static void main(String [] args)
    {
		information frame=new information(a);
      	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
