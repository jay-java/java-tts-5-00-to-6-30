import java.util.Enumeration;
import java.util.Vector;

public class VerctorDemo {
	public static void main(String[] args) {
		Vector vr = new Vector();
		vr.add(1);
		vr.add("name");
		vr.add(12.34);
		vr.add(true);
		System.out.println(vr);
		Enumeration em = vr.elements();
		while(em.hasMoreElements()) {
			System.out.println(em.nextElement());
		}
	}
}
