
class Constructor{
	int i;
	String name;
	double d;
	Constructor(){
		System.out.println("default");
	}
	Constructor(int i,String name,double d){
		System.out.println("para");
		System.out.println(i+name+d);
		this.i = i;
		this.name=name;
		this.d = d;
	}
	public void show() {
		System.out.println("i = "+i+" name : "+name+" d = "+d);
	}
}
class copy{
	int i;
	String name;
	double d;
	copy(Constructor c1){
		this.i = c1.i;
		this.name = c1.name;
		this.d = c1.d;
	}
	public void show() {
		System.out.println("i = "+i+" name : "+name+" d = "+d);
	}
}
public class ConstructorDemo {
	public static void main(String[] args) {
		System.out.println("hello");
		Constructor c1 = new Constructor(1,"java",34.4);
		c1.show();
		copy c  = new copy(c1);
		c.show();
		c.i=1;
	}
}
