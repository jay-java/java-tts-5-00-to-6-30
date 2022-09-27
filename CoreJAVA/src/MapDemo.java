import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapDemo {
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "c");//entry
		map.put(2,"c++");
		map.put(3, "java");
		map.put(null, "python");
		map.put(4, null);
		map.put(5, null);
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
