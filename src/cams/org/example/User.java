package cams.org.example;

public class User {
	private String name, lastname;
	private int id;
	
	public User (int id, String name, String lastname) {
		this.id = id;
		this.name = name;
		this.lastname = lastname;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getName () {
		return this.name;
	}
	
	public String getLastname () {
		return this.lastname;
	}
}
