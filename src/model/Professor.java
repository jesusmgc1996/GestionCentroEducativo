package model;

public class Professor {
	
	private int id;
	private String name;
	private String firstSurname;
	private String secondSurname;
	private byte[] image;
	private String dni;
	private String address;
	private String email;
	private String phone;
	private String color;
	private int sexTypologyId;
	
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
	 * @param image
	 * @param dni
	 * @param address
	 * @param email
	 * @param phone
	 * @param color
	 * @param sexTypologyId
	 */
	public Professor(int id, String name, String firstSurname, String secondSurname, byte[] image,
			String dni, String address, String email, String phone, String color, int sexTypologyId) {
		super();
		this.id = id;
		this.name = name;
		this.firstSurname = firstSurname;
		this.secondSurname = secondSurname;
		this.image = image;
		this.dni = dni;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.color = color;
		this.sexTypologyId = sexTypologyId;
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

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getSexTypologyId() {
		return sexTypologyId;
	}

	public void setSexTypologyId(int sexTypologyId) {
		this.sexTypologyId = sexTypologyId;
	}

	@Override
	public String toString() {
		return firstSurname + " " + secondSurname + ", " + name;
	}

}
