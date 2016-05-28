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
        tf=new JTextField("显示内容",20); 
        add(b1);
        add(tf);
        b1.addMouseListener(new MyMouseListener());
     }
     
     //直接继承接口，必须把接口中所有的5个方法全部实现，哪怕有的方法在这里不需要用到
     private class MyMouseListener implements MouseListener{
        public void mouseEntered(MouseEvent e){
            msg="鼠标在进入！";
            System.out.println(msg);	
            tf.setText(msg);     
        }
        public void mouseExited(MouseEvent e){
        	msg="鼠标在出去！";
            System.out.println(msg);	
            tf.setText(msg);
        }
        public void mousePressed(MouseEvent e){
     	         
            msg="鼠标在动作！";
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