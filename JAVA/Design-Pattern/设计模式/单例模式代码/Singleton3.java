//���������Ż���ı�Singleton2��ʵ�ָ����ף���Ч��Ҳ�Ϻõĵ���ģʽ
public class Singleton3 {  
  
    private static Singleton3 instance = null;  
  
    private Singleton3() {  
    }  
  
  	//����������⣬����Ҳ����������
    private static synchronized void syncInit() {  
        if (instance == null) {  
            instance = new Singleton3();  
        }  
    }  
  
  	//��������
    public static Singleton3 getInstance() {  
        if (instance == null) {  
            syncInit();  
        }  
        return instance;  
    }  
}