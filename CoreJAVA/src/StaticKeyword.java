class Emp{
	static {
		System.out.println("this is static block in emp class");
	}
	int id;
	String ename;
	static String cname ="tops";
	Emp(int id, String ename){
		this.id=id;
		this.ename=ename;
	}
	public void show() {
		System.out.println("id  : "+id+" ename : "+ename+" cname : "+cname);
	}
	public static void staticMethod() {
		System.out.println("static method in emp class");
	}
}
public class StaticKeyword {
	static {
		System.out.println("this is static block in main class");
	}
	public static void main(String[] args) {
		Emp e1 = new Emp(1,"c");
		Emp e2 = new Emp(2,"c++");
		Emp e3 = new Emp(3,"java");
		e1.show();
		e2.show(); 
		e3.show();
		e1.staticMethod();
		Emp.staticMethod();
	}
}
