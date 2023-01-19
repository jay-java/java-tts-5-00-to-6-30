package basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_table")
public class User {
	@Id
	@Column(name="user_id")
	private int id;
	@Column(name="user_name")
	private String name;
	private String address;
	
	public User(int id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
	
}
