import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class mobil {
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
	public mobil(int ram, String model, double price) {
		super();
		this.ram = ram;
		this.model = model;
		this.price = price;
	}
	public mobil() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "mobile [ram=" + ram + ", model=" + model + ", price=" + price + "]";
	}
	
}
public class ComparatorDemoi {
	public static void main(String[] args) {
		mobil m1= new mobil(8,"samsung",20000);
		mobil m2= new mobil(6,"apple",80000);
		mobil m3= new mobil(10,"moto",30000);
		
		List<mobil> list =new ArrayList<mobil>();
		list.add(m1);
		list.add(m2);
		list.add(m3);
		
		Comparator<mobil> com = new Comparator<mobil>() {
			@Override
			public int compare(mobil o1, mobil o2) {
				if(o1.getRam()>o2.getRam()) {
					return 1;
				}
				else {
					return -1;
				}
			}
		};
		Collections.sort(list, com);
		for(mobil m:list) {
			System.out.println(m);
		}
	}
}
