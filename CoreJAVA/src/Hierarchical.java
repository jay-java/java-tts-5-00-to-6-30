class A{
	public void classA() {
		System.out.println("grand parent class");
	}
}
class B extends A{
	public void clasB() {
		System.out.println("parent class");
	}
}
class C extends A{
	public void classC() {
		System.out.println("child class");
	}
}
public class Hierarchical {
	public static void main(String[] args) {
		B b = new B();
		b.classA();
		b.clasB();
		C c = new C();
		c.classA();
		c.classC();
	}
}
