package demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class User {
	@Id
	private int id;
	private String name;
	private String address;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
	
}
