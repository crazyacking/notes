public class DemoException{
	
	public static int division(int x,int y){		
		return  x/y;
	}  
	
	public static double division(double x,double y){		
		return  x/y;
	} 
		
	public static void main(String[] args){

		double a=division(1.0,2.0);	//通过
		int b=division(1,2);		//通过
		System.out.println("a="+a);  
		System.out.println("b="+b);				
		
		double c=division(1.0,0.0);		//通过,Infinity的含义是无穷大
		System.out.println("c="+c);
		
		/*
		//问题:运行时错误
		int d;
		d=division(1,0);		//报异常，注意，前面几种情况都没问题，就是这里一个特殊情形下出错，这种出错叫运行时错误
		System.out.println("d="+d);		
		System.out.println("前面出现运行时错误，无法执行这里");
		*/

		//解决问题
		/*
		//可以如此来处理出现的异常错误
		try{
			d=division(1,0);
		}catch(java.lang.ArithmeticException e){
			System.out.println("除数不能为0:"+e.toString());
		//	e.printStackTrace();	 //(3)两种输出查看异常的方式，当然也可不查看出错原因直接用此方式跳过错误执行后面的代码		
		}
		
		System.out.println("哈哈，我也能被执行了");
		*/
		
		
	}
}