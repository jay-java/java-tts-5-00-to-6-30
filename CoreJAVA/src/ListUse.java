import java.util.ArrayList;
import java.util.List;

class EmpData{
	int id;
	String name;
	double salary;
	EmpData(int id,String name,double salary){
		this.id=id;
		this.name=name;
		this.salary=salary;
	}
	@Override
	public String toString() {
		return "id : "+id+" name : "+name+" salary : "+salary;
	}
}
public class ListUse {
	public static void main(String[] args) {
		EmpData e1 = new EmpData(1, "krishna", 10000);
		EmpData e2 = new EmpData(2, "sneha", 20000);
		EmpData e3 = new EmpData(3, "khushi",30000);
		List<EmpData> list = new ArrayList<EmpData>();
		list.add(e1);
		list.add(e2);
		list.add(e3);
		System.out.println(list);
	}
}
