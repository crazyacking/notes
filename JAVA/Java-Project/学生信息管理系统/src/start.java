import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class start extends JFrame{
	public start(){
		Container container=getContentPane();
		container.setLayout(null);
		JButton button1=new JButton("管理员");
    	JButton button2=new JButton("学生");
    	button1.setBounds(50,70,100,50);
    	button2.setBounds(50,120,100,50);
    	container.add(button1);	
    	container.add(button2);
    	button1.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e) 
    		{
    			new admin().setVisible(true);
    			dispose();
    		}
    	});
    	button2.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e) 
    		{
    			new student().setVisible(true);
    			dispose();
    		}
    	});
    	setSize(200,300);
    	setVisible(true);
    	setLocation(500,200);

	}
	
	
	public static void main(String [] args)
    {
    	start frame=new start();
    	frame.setTitle("学生信息管理系统");
      	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
	

}
