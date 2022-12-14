import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class mobile implements Comparable<mobile>{
	int ram;
	String model;
	double price;
	public int getRam() {
		return ram;
	}
	public void setRam(int ram) {
		this.ram = ram;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public mobile(int ram, String model, double price) {
		super();
		this.ram = ram;
		this.model = model;
		this.price = price;
	}
	public mobile() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "mobile [ram=" + ram + ", model=" + model + ", price=" + price + "]";
	}
	@Override
	public int compareTo(mobile o) {
		if(this.getPrice()>o.getPrice()) {
			return 1;
		}
		else {
			return -1;
		}
	}
	
}
public class ComparableDemo {
	public static void main(String[] args) {
		mobile m1= new mobile(8,"samsung",20000);
		mobile m2= new mobile(6,"apple",80000);
		mobile m3= new mobile(10,"moto",30000);
		
		List<mobile> list =new ArrayList<mobile>();
		list.add(m1);
		list.add(m2);
		list.add(m3);
		Collections.sort(list);
		for(mobile m:list) {
			System.out.println(m);
		}
		
	}
}
