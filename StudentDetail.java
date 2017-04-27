package spree;

public class StudentDetail {
	private String studentName;
	private String studentID;
	private String collegeName;
	private String email;
	public StudentDetail(String studentID, String studentName,
			String collegeName, String email) {
		super();
		this.studentName = studentName;
		this.studentID = studentID;
		this.collegeName = collegeName;
		this.email = email;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
