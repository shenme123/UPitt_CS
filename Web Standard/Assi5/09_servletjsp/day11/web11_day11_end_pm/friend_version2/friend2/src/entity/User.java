package entity;

public class User {
	private int id;
	private String username;
	private String name;
	private String pwd;
	private int age;
	private String ask;
	public String getAsk() {
		return ask;
	}
	public void setAsk(String ask) {
		this.ask = ask;
	}
	public User() {
	}
	
	private String gender;
	private String phone;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public User(String username, String name, String pwd, int age, String gender, String phone) {
		this.username = username;
		this.name = name;
		this.pwd = pwd;
		this.age = age;
		this.gender = gender;
		this.phone = phone;
	}
}
