
class Overload{
	public void run() {
		System.out.println("first run method");
	}
	public void run(int i) {
		System.out.println("second run method");
	}
	public void run(String name) {
		System.out.println("third run method");
	}
}
public class Polymorphism {
	public static void main(String[] args) {
		Overload o = new Overload();
		o.run();
		o.run(1);
		o.run("java");
	}
}
