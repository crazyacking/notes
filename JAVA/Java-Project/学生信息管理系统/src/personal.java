import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;


public class personal extends JFrame{
	private static final String a=null;
	public personal(final String a){
		Container container=getContentPane();
		container.setLayout(null);
    	JButton button1=new JButton("个人资料");
    	JButton button2=new JButton("学习成绩");
    	button1.setBounds(50,40,100,50);
    	button2.setBounds(50,100,100,50);
    	container.add(button1);
    	container.add(button2);
    	button1.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e) 
    		{
    			new information(a).setVisible(true);
    			dispose();
    		}
    	});
      	button2.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e) 
    		{
    			new grade(a).setVisible(true);
    			dispose();
    		}
    	});
    	setSize(200,250);
    	setVisible(true);
    	setLocation(500,200);

	}
	
	
	public static void main(String [] args)
    {
    	personal frame=new personal(a);
    	frame.setTitle("学生表管理系统");
      	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
	



}
