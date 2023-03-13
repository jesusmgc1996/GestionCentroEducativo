package model;

public class Professor {
	
	private int id;
	private String name;
	private String firstSurname;
	private String secondSurname;
	private String dni;
	private String address;
	private String email;
	private String phone;
	
	/**
	 * 
	 */
	public Professor() {
		super();
	}

	/**
	 * @param id
	 * @param name
	 * @param firstSurname
	 * @param secondSurname
	 * @param dni
	 * @param address
	 * @param email
	 * @param phone
	 */
	public Professor(int id, String name, String firstSurname, String secondSurname, String dni, String address,
			String email, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.firstSurname = firstSurname;
		this.secondSurname = secondSurname;
		this.dni = dni;
		this.address = address;
		this.email = email;
		this.phone = phone;
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

	public String getFirstSurname() {
		return firstSurname;
	}

	public void setFirstSurname(String firstSurname) {
		this.firstSurname = firstSurname;
	}

	public String getSecondSurname() {
		return secondSurname;
	}

	public void setSecondSurname(String secondSurname) {
		this.secondSurname = secondSurname;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return name + " " + firstSurname + " " + secondSurname;
	}

}
