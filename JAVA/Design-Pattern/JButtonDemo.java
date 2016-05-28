import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class JButtonDemo extends JFrame{
    public JButtonDemo(){
    	super("JButtonDemo"); 						//窗口标题 	    	
		JButton jl=new JButton("按钮");				//定义一个按钮       		
    	/*
    	//方式一    	
    	this.getContentPane().setLayout(new FlowLayout());//设置为流式布局
    	this.getContentPane().add(jl);
    	*/
    	
    	//方式二
    	//Container con:依据"角色"定义出的类，其含义是在JFrame上面的容器性质，放置其他组件
    	Container con=this.getContentPane();	
    	con.setLayout(new FlowLayout());		
    	con.add(jl);    
    	
    	this.setLocation(450,280);
    	this.setSize(300,400);
    	this.setVisible(true);
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   	}
   	
   	public static void main(String args[]){
   	  JButtonDemo jd=new JButtonDemo();	
   	}
   		 
}
