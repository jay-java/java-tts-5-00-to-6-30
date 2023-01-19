abstract class calculate{
	abstract int multipy(int a,int b);
}
public class anonymous {
	public static void main(String[] args) {
		int c = new calculate() {
			
			@Override
			int multipy(int a, int b) {
				// TODO Auto-generated method stub
				return 0;
			}
		}.multipy(0, 0);
	}
}
