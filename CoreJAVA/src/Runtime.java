class D{
	public void run() {
		System.out.println("run method inside d class");
	}
}
class E extends D{
	public void run() {
		System.out.println("run method inside E class");
		super.run();
	}
}
public class Runtime {
	public static void main(String[] args) {
		E e = new E();
		e.run();
	}
}
