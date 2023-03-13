package model;

public class Subject {
	
	private int id;
	private String name;
	private String acronym;
	private int courseId;
	
	/**
	 * 
	 */
	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param name
	 * @param acronym
	 * @param courseId
	 */
	public Subject(int id, String name, String acronym, int courseId) {
		super();
		this.id = id;
		this.name = name;
		this.acronym = acronym;
		this.courseId = courseId;
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

	public String getAcronym() {
		return acronym;
	}

	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	@Override
	public String toString() {
		return name;
	}

}
