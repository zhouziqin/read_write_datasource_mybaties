package cn.javass.common.datasource;

public class Test {

	public static void main(String[] args) {
	   
	}
}
class A{
	public static int a = 1;
	static {System.out.println("AAA");}
}
class B extends A{
	public static int b = 1;
	static {System.out.println("BBB");}

}
class  C extends B {
	public static int c = 1;
	static {System.out.println("CCC");}
}
