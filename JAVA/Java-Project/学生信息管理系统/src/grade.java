
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


public class grade extends JFrame{
	private static final String a=null;
	public grade(final String a){
		Container container=getContentPane();
		container.setLayout(null);
    	JButton button5=new JButton("返回");
    	final JScrollPane jscrollpane1;
    	jscrollpane1=new  JScrollPane();
    	jscrollpane1.setBounds(0,0,200,250);
    	button5.setBounds(50,200,100,50);
    	container.add(button5);
    	container.add(jscrollpane1);
    	try{
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/test";
			Connection con=(Connection) DriverManager.getConnection(url,"root","123456");
			PreparedStatement stat=con.prepareStatement("select * from sc where sno=?");
			stat.setString(1, a);
			ResultSet rs=(ResultSet) stat.executeQuery();
			int count=0;
			while(rs.next()){
				count++;
			}
			rs=(ResultSet) stat.executeQuery();
			Object[][] object1=new Object[count][2];
			count=0;
			while(rs.next()){
				object1[count][0]=rs.getString(2);
				String b=(String) object1[count][0];
				PreparedStatement stat1=con.prepareStatement("select * from course where cno=?");
				stat1.setString(1, b);
				ResultSet rs1=(ResultSet) stat1.executeQuery();
				while(rs1.next())
				{
				object1[count][0]=rs1.getString(2);
				}
				object1[count][1]=rs.getString(3);
				count++;
			}
			String title[]={"课程","成绩"};
			JTable jtable1 = new JTable(object1,title);
			
			jscrollpane1.getViewport().add(jtable1);
			setVisible(true);
			con.close();
		}
		catch(ClassNotFoundException ce){
			System.out.println(ce.getMessage()+"1");
		}
		catch (SQLException se){
			System.out.println(se.getMessage()+"2");
		}

    	button5.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e) 
    		{
    			new personal(a).setVisible(true);
    			dispose();
    		}
    	});
    	setSize(200,300);
    	setVisible(true);
    	setLocation(500,200);

	}
	
	
	public static void main(String [] args)
    {
		grade frame=new grade(a);
    	frame.setTitle("学生表管理系统");
      	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
	



}
