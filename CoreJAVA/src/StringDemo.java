
public class StringDemo {
	public static void main(String[] args) {
		String s = "tops technologies";
		String s1 = "tops technologies";
		System.out.println(s.length());
		System.out.println(s.charAt(1));
		System.out.println(s.concat(s1));
		System.out.println(s);
		System.out.println(s.contains("tecn"));
		System.out.println(s.compareTo(s1));
		System.out.println(s.compareToIgnoreCase(s1));
		System.out.println(s.equals(s1));
		System.out.println(s.equalsIgnoreCase(s1));
		System.out.println(s.hashCode());
		System.out.println(s.isEmpty());
		String s2 = "		hello java		";
		System.out.println(s2.trim());
	}
}
