interface inter1{
	public void interface1();
	public static void interface4() {
		System.out.println("interface 4");
	}
}
interface inter2 extends inter1{
	public void interface2();
}
interface inter3{
	public void interface3();
}
class Call implements inter2,inter3{
	public void interface1() {
		System.out.println("interface 1");
	}
	public void interface3() {
		System.out.println("interface 3");
	}
	public void interface2() {
		System.out.println("interface 2");
	}
}
public class InterfaceDemo {
	public static void main(String[] args) {
		Call c = new Call();
		inter1.interface4();
	}
}
