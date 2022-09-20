//Inheritance TYpes:
//	1.single
//	2.Multilevel
//	3.Multiple(Not supported)
//	4.Hierarchical
//	5.Hybrid(Not supported)
class GrandParent{
	public void grandParentMethod() {
		System.out.println("grand parent class");
	}
}
class Parent extends GrandParent{
	public void parentMethod() {
		System.out.println("parent class");
	}
}
class Child extends Parent{
	public void childMethod() {
		System.out.println("child class");
	}
}
public class InheritanceDemo {
	public static void main(String[] args) {
		Child c= new Child();
		c.grandParentMethod();
		c.parentMethod();
		c.childMethod();
	}
}
