import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class HashTablkeDemo {
	public static void main(String[] args) {
		Hashtable<Integer, String> map = new Hashtable<Integer, String>();
		map.put(1, "c");//entry
		map.put(2,"c++");
		map.put(3, "java");
		map.put(6, "python");
		map.put(4, "php");
		map.put(5, "node");
		System.out.println(map);
		Set set = map.entrySet();
		Iterator i = set.iterator();
		while(i.hasNext()) {
			Map.Entry entry = (Entry)i.next();
			System.out.println("key : "+entry.getKey());
			System.out.println("value : "+entry.getValue());
		}
	}
}
