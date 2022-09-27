import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetDemo {
	public static void main(String[] args) {
		Set set = new TreeSet();
		set.add(1);
		set.add(-34);
		set.add(0);
		set.add(345);
		set.add(-67);
		set.add(34);
		set.add(10);
		System.out.println(set);
		Iterator itr  =set.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
}
