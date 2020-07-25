package cn.Model.haha;

public class Student {
	private int id;
	private String name;
	private int age;
	private String address;
	private String time1;
	private String time2;
	
	public Student() {
		super();
	}
	public Student(int id, String name, int age, String address,String time1,String time2) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
		this.time1 =time1;
		this.time2 =time2;
	}
	public Student(int id, String name, int age, String address,String time2) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
		this.time2 =time2;
	}
	public Student(int id, String name, int age, String address) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
	}
	public Student( String name, int age, String address,String time2) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
		this.time2 = time2;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTime1() {
		return time1;
	}

	public void setTime1(String time1) {
		this.time1 = time1;
	}
	public String getTime2() {
		return time2;
	}
	public void setTime2(String time2) {
		this.time2 = time2;
	}
	
}
