import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MouseAdapterDemo extends JFrame{
     JButton b1;
     JTextField tf; 
     String msg;
     
     public MouseAdapterDemo(){
     	Container con=this.getContentPane();
        con.setLayout(new FlowLayout());
        b1=new JButton("Button1");
        tf=new JTextField("��ʾ����",20); 
        con.add(b1);
        con.add(tf);
        b1.addMouseListener(new MyMouseListener());
     }
     
     //�̳��������ֻ࣬Ҫ����Ҫ����������������д�Ϳ����ˣ����õķ�������Ҫʵ��
     private class MyMouseListener extends MouseAdapter{
        public void mouseEntered(MouseEvent e){
            msg="����ڽ��룡";
            System.out.println(msg);	
            tf.setText(msg);     
        }
        public void mousePressed(MouseEvent e){
     	         
            msg="����ڶ�����";
            System.out.println(msg);	
            tf.setText(msg);     
        }
        
     }
     
     public static void main(String args[]){
        MouseAdapterDemo ae=new MouseAdapterDemo();
        ae.setLocation(300,300);
        ae.setSize(400,300);
        ae.setVisible(true); 
        ae.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }
     
}