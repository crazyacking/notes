//��ͨ����ģʽ�����ǽ���һ�������࣬��ʵ����ͬһ�ӿڵ�һЩ�����ʵ���Ĵ���
interface Sender {  					//�ӿ�
    public void Send();  
} 

class MailSender implements Sender {  	//����1�������ʼ�
    public void Send() {  
        System.out.println("this is mailsender!");  
    }  
}

class SmsSender implements Sender {  	//����2�����Ͷ���
    public void Send() {  
        System.out.println("this is sms sender!");  
    }  
}

class SendFactory {    					//������
    public Sender produce(String type) {  
        if ("mail".equals(type)) {  
            return new MailSender();  
        } else if ("sms".equals(type)) {  
            return new SmsSender();  
        } else {  
            System.out.println("��������ȷ������!");  
            return null;  
        }  
    }  
}

public class FactoryTest {    			//���ò���
    public static void main(String[] args) {  
        SendFactory factory = new SendFactory();  
        Sender sender = factory.produce("mail");  	//ע����������ַ�������������Ķ���
        sender.Send();  
    }  
}