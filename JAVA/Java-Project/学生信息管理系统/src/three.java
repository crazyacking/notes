import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class three extends JFrame{
	public three(){
		Container container=getContentPane();
		container.setLayout(null);
		JButton button1=new JButton("学生表");
    	JButton button2=new JButton("课程表");
    	JButton button3=new JButton("成绩表");
    	button1.setBounds(50,20,100,50);
    	button2.setBounds(50,80,100,50);
    	button3.setBounds(50,140,100,50);
    	container.add(button1);	
    	container.add(button2);
    	container.add(button3);
    	button1.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e) 
    		{
    			new stu().setVisible(true);
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
    	button3.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e) 
    		{
    			new sc().setVisible(true);
    			dispose();
    		}
    	});
    	setSize(200,300);
    	setVisible(true);
    	setLocation(500,200);

	}
	
	
	public static void main(String [] args)
    {
    	three frame=new three();
    	frame.setTitle("学生信息管理系统");
      	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
	

}
