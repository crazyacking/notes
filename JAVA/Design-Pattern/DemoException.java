public class DemoException{
	
	public static int division(int x,int y){		
		return  x/y;
	}  
	
	public static double division(double x,double y){		
		return  x/y;
	} 
		
	public static void main(String[] args){

		double a=division(1.0,2.0);	//ͨ��
		int b=division(1,2);		//ͨ��
		System.out.println("a="+a);  
		System.out.println("b="+b);				
		
		double c=division(1.0,0.0);		//ͨ��,Infinity�ĺ����������
		System.out.println("c="+c);
		
		/*
		//����:����ʱ����
		int d;
		d=division(1,0);		//���쳣��ע�⣬ǰ�漸�������û���⣬��������һ�����������³������ֳ��������ʱ����
		System.out.println("d="+d);		
		System.out.println("ǰ���������ʱ�����޷�ִ������");
		*/

		//�������
		/*
		//���������������ֵ��쳣����
		try{
			d=division(1,0);
		}catch(java.lang.ArithmeticException e){
			System.out.println("��������Ϊ0:"+e.toString());
		//	e.printStackTrace();	 //(3)��������鿴�쳣�ķ�ʽ����ȻҲ�ɲ��鿴����ԭ��ֱ���ô˷�ʽ��������ִ�к���Ĵ���		
		}
		
		System.out.println("��������Ҳ�ܱ�ִ����");
		*/
		
		
	}
}