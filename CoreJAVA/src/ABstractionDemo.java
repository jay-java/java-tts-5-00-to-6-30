abstract class RBI{
	abstract public void interest();
	abstract public void homeloan();
	public static void repoRate() {
		System.out.println("repo rate : 4%");
	}
}
class SBI extends RBI{
	public void interest() {
		System.out.println("sbi interest : 7%");
	}
	public void homeloan() {
		System.out.println("SBI home loan : 8%");
	}
}
class JAVA extends RBI{
	public void interest() {
		System.out.println("java interest : 6%");
	}
	public void homeloan() {
		System.out.println("java hoem loan : 6%");
	}
}
public class ABstractionDemo {
	public static void main(String[] args) {
		SBI s = new SBI();
		s.interest();
		s.homeloan();
		s.repoRate();
		JAVA j = new JAVA();
		j.interest();
		j.homeloan();
	}
}
