//OOPS->
//1.Class 
//2.Object
//3.Inheritatance
//4.POLymorphism
//5.Abstraction
//6.Encapsulation
class abc{
	int i;
	String name;
	public void run() {
		System.out.println("this is run method "+i+" "+name);
	}
}
public class ClassObject {
	public static void main(String[] args) {
		abc a = new abc();
		a.i=1;
		a.name="java";
		a.run();
		abc a1 = new abc();
		a1.i=2;
		a1.name="c++";
		a1.run();
	}
}
