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


public class sc extends JFrame{
	public sc(){
		Container container=getContentPane();
		container.setLayout(null);
		JLabel Jla=new JLabel("成绩表信息");
		JButton button1=new JButton("插入");
    	JButton button2=new JButton("删除");
    	JButton button4=new JButton("显示");
    	JButton button5=new JButton("返回");
    	final JScrollPane jscrollpane1;
    	jscrollpane1=new  JScrollPane();
    	jscrollpane1.setBounds(0,100,400,300);
    	button1.setBounds(20,40,100,50);
    	button2.setBounds(140,40,100,50);
    	button4.setBounds(260,40,100,50);
    	button5.setBounds(150,400,100,50);
    	Jla.setBounds(170,0,100,50);
    	container.add(button1);	
    	container.add(button2);
    	container.add(button4);
    	container.add(button5);
    	container.add(Jla);
    	container.add(jscrollpane1);
    	button1.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e) 
    		{
    			new sc_insert().setVisible(true);
    			dispose();
    		}
    	});
    	button2.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e) 
    		{
    			new sc_delete().setVisible(true);
    			dispose();
    		}
    	});
    	button4.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e) 
    		{
    			try{
    				Class.forName("com.mysql.jdbc.Driver");
    				String url="jdbc:mysql://localhost:3306/test";
    				Connection con=(Connection) DriverManager.getConnection(url,"root","123456");
    				PreparedStatement stat=con.prepareStatement("select * from sc ");
    				ResultSet rs=(ResultSet) stat.executeQuery();
    				int count=0;
    				while(rs.next()){
    					count++;
    				}
    				rs=(ResultSet) stat.executeQuery();
    				Object[][] object1=new Object[count][3];
    				count=0;
    				while(rs.next()){
    					object1[count][0]=rs.getString(1);
    					object1[count][1]=rs.getString(2);
    					object1[count][2]=rs.getString(3);
    					count++;
    				}
    				String title[]={"学号","课程号","成绩"};
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
        
    		}  
    		
    	});
    	button5.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e) 
    		{
    			new three().setVisible(true);
    			dispose();
    		}
    	});
    	setSize(400,500);
    	setVisible(true);
    	setLocation(500,200);

	}
	
	
	public static void main(String [] args)
    {
    	sc frame=new sc();
    	frame.setTitle("成绩表管理系统");
      	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
	



}
