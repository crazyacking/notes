import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class JButtonDemo extends JFrame{
    public JButtonDemo(){
    	super("JButtonDemo"); 						//���ڱ��� 	    	
		JButton jl=new JButton("��ť");				//����һ����ť       		
    	/*
    	//��ʽһ    	
    	this.getContentPane().setLayout(new FlowLayout());//����Ϊ��ʽ����
    	this.getContentPane().add(jl);
    	*/
    	
    	//��ʽ��
    	//Container con:����"��ɫ"��������࣬�京������JFrame������������ʣ������������
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
