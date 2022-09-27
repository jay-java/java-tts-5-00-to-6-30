import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetDemo {
	public static void main(String[] args) {
		Set set = new HashSet();
		set.add(1);
		set.add("name");
		set.add('r');
		set.add(345.4);
		set.add(false);
		set.add(3452345);
		set.add(1);
		System.out.println(set);
		Iterator itr  =set.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
}
