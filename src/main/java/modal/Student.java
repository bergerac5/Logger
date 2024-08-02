package modal;

public class Student {

	private Long Student_id;
	private String Student_name;
	private String Phone_number;
	private String Address;
	
	
	public Student() {
				
		super();
		// TODO Auto-generated constructor stub
	}


	public Student(Long student_id) {
		super();
		Student_id = student_id;
	}


	public Student(String student_name, String phone_number, String address) {
		super();
		Student_name = student_name;
		Phone_number = phone_number;
		Address = address;
	}


	public Long getStudent_id() {
		return Student_id;
	}


	public void setStudent_id(Long student_id) {
		Student_id = student_id;
	}


	public String getStudent_name() {
		return Student_name;
	}


	public void setStudent_name(String student_name) {
		Student_name = student_name;
	}


	public String getPhone_number() {
		return Phone_number;
	}


	public void setPhone_number(String phone_number) {
		Phone_number = phone_number;
	}


	public String getAddress() {
		return Address;
	}


	public void setAddress(String address) {
		Address = address;
	}
	
	
}
