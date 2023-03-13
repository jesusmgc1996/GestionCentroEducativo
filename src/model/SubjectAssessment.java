package model;

public class SubjectAssessment {
	
	private int id;
	private int professorId;
	private int studentId;
	private int subjectId;
	private float assessment;
	
	/**
	 * 
	 */
	public SubjectAssessment() {
		super();
	}

	/**
	 * @param id
	 * @param professorId
	 * @param studentId
	 * @param subjectId
	 * @param assessment
	 */
	public SubjectAssessment(int id, int professorId, int studentId, int subjectId, float assessment) {
		super();
		this.id = id;
		this.professorId = professorId;
		this.studentId = studentId;
		this.subjectId = subjectId;
		this.assessment = assessment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProfessorId() {
		return professorId;
	}

	public void setProfessorId(int professorId) {
		this.professorId = professorId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public float getAssessment() {
		return assessment;
	}

	public void setAssessment(float assessment) {
		this.assessment = assessment;
	}

	@Override
	public String toString() {
		return "SubjectAssessment [id=" + id + ", professorId=" + professorId + ", studentId=" + studentId
				+ ", subjectId=" + subjectId + ", assessment=" + assessment + "]";
	}

}
