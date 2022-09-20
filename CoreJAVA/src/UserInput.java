import java.util.Scanner;

class data{
	public void call() {
		System.out.println("this is call function inside data class");
	}
}
public class UserInput {
	public static void main(String[] args) {
		data d1 = new data();
		d1.call();
		int i;
		float f;
		double d;
		String name;
		char c;
		Scanner sc = new Scanner(System.in);
		System.out.println("enter  name = ");
		name = sc.next();
		System.out.println(name);
		System.out.println("enter i = ");
		i = sc.nextInt();
		System.out.println("i = "+i);
		System.out.println("enter f = ");
		f = sc.nextFloat();
		System.out.println("f = "+f);
		System.out.println("enter d = ");
		d = sc.nextDouble();
		System.out.println("d = "+d);
		System.out.println("enter c = ");
		c = sc.next().charAt(0);
		System.out.println("c = "+c);
	}
}
