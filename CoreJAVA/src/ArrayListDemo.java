import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListDemo {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(1);
		list.add("name");
		list.add(false);
		list.add(56.5);
		list.add('e');
		list.add(345);
		list.add(1);
		System.out.println(list);
//		list.remove(2);
		Iterator itr = list.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
}
