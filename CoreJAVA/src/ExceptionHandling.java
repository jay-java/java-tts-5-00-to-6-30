import java.util.InputMismatchException;
import java.util.Scanner;

//1.try 2.catch 3.finally 4.throw 5.throws
class divide{//khushi
	public void division() throws ArithmeticException,InputMismatchException{
			Scanner sc = new Scanner(System.in);
			System.out.println("enter i  = ");
			int i = sc.nextInt();
			System.out.println("enter j  = ");
			int j = sc.nextInt();
			int k = i / j;
			System.out.println(k);
			throw new ArithmeticException();
	}
}
public class ExceptionHandling {//krishna
	public static void main(String[] args) {
		try {
			divide d = new divide();
			d.division();
		} catch (ArithmeticException e) {
			System.out.println("denominator cannot be 0");
		}
		catch(InputMismatchException e) {
			System.out.println("denominator should be numeric");
		}
		
		
//		int i;
//		int j;
//		try {
//			Scanner sc = new Scanner(System.in);
//			System.out.println("enter i  = ");
//			i = sc.nextInt();
//			System.out.println("enter j  = ");
//			j = sc.nextInt();
//			int k = i / j;
//			System.out.println(k);
//			System.exit(0);
//		} catch (ArithmeticException e) {
//			System.out.println("denominator cannot be zero");
//		} catch (InputMismatchException e) {
//			System.out.println("denominator should be numeric value");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		finally {
//			System.out.println("this will excute everytime");
//		}
	}
}
