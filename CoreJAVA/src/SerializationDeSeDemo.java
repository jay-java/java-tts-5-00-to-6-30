import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

class StudentData implements Serializable{
	int id;
	String name;
	float per;
	StudentData(){
		Scanner sc =new Scanner(System.in);
		System.out.print("enter id : ");
		id = sc.nextInt();
		System.out.print("enter name : ");
		name = sc.next();
		System.out.print("enter per : ");
		per = sc.nextFloat();
	}
	@Override
	public String toString() {
		return "StudentData  : ["+" id : "+id+" name : "+name+" per : "+per+"]";
	}
}
public class SerializationDeSeDemo {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		StudentData s = new StudentData();
		
		FileOutputStream fos = new FileOutputStream("student.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(s);
		oos.flush();
		oos.close();
		System.out.println("object written successfully");
		
		FileInputStream fis = new FileInputStream("student.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		StudentData s1 = (StudentData)ois.readObject();
		System.out.println(s1);
	}
}
