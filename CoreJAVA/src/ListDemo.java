import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListDemo {
//	<generics>
	public static void main(String[] args) {
		List list = new ArrayList();
		list.add(1);
		list.add("name");
		list.add(false);
		list.add(56.5);
		list.add('e');
		list.add(345);
		System.out.println(list);
		list.remove(2);
		Iterator itr = list.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
}
