
public class StringBufferDemo {
	public static void main(String[] args) {
		StringBuffer s = new StringBuffer("hello java");
		StringBuffer s1 = new StringBuffer("hi");
		System.out.println(s.append(s1));
		System.out.println(s);
	}
}
