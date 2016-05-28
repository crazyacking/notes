import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseListenerDemo extends JFrame{
     JButton b1;
     JTextField tf; 
     String msg;
     
     public MouseListenerDemo(){
        setLayout(new FlowLayout());
        b1=new JButton("Button1");
        tf=new JTextField("��ʾ����",20); 
        add(b1);
        add(tf);
        b1.addMouseListener(new MyMouseListener());
     }
     
     //ֱ�Ӽ̳нӿڣ�����ѽӿ������е�5������ȫ��ʵ�֣������еķ��������ﲻ��Ҫ�õ�
     private class MyMouseListener implements MouseListener{
        public void mouseEntered(MouseEvent e){
            msg="����ڽ��룡";
            System.out.println(msg);	
            tf.setText(msg);     
        }
        public void mouseExited(MouseEvent e){
        	msg="����ڳ�ȥ��";
            System.out.println(msg);	
            tf.setText(msg);
        }
        public void mousePressed(MouseEvent e){
     	         
            msg="����ڶ�����";
            System.out.println(msg);	
            tf.setText(msg);     
        }
        public void mouseClicked(MouseEvent e){
        }
        public void mouseReleased(MouseEvent e){
        }
     }
     
     public static void main(String args[]){
        MouseListenerDemo ae=new MouseListenerDemo();
        ae.setSize(400,300);
        ae.setVisible(true); 
     }
     
}