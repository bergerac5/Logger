package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import modal.Student;

public class StudentDao {
	
	Student stu = new Student();
	
	public String addStudent(Student stu) {
		String query = "Insert into public.\"StudentRegistration\"  (student_name,phone_number,address) VALUES (?,?,?)";
		try (Connection con = DbConfig.getConnection()){
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, stu.getStudent_name());
			ps.setString(2, stu.getPhone_number());
			ps.setString(3, stu.getAddress());
			int rowAffected = ps.executeUpdate();
			if(rowAffected >0) {
				return "Student Added Successfully";
			}else {
				return "Student Not Added";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "failed to connect to database";
		}		
	}
	
	public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM public.\"StudentRegistration\"";

        try (Connection con = DbConfig.getConnection();
             PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Student stu = new Student();
                stu.setStudent_id(rs.getLong("student_id"));
                stu.setStudent_name(rs.getString("student_name"));
                stu.setPhone_number(rs.getString("phone_number"));
                stu.setAddress(rs.getString("address"));
                students.add(stu);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return students;
    }

	

}
