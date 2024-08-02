package controler;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.StudentDao;
import modal.Student;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	
	private static final Logger LOGGER = LogManager.getLogger(StudentServlet.class.getName());
	
	StudentDao dao = new StudentDao();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		LOGGER.info("Handling GET request");

		// Adding debug logging to trace execution
		LOGGER.debug("Fetching all students from the database");
		
		try {
			List<Student> student = dao.getAllStudents();
			LOGGER.debug("Fetched " + student.size() + " students");
			
			req.setAttribute("student_id", student);
			req.getRequestDispatcher("/studentLst.jsp").forward(req, res);
			
			LOGGER.debug("Forwarded request to /studentList.jsp");
		} catch (IOException ioException) {
			LOGGER.error("I/O error occurred: ", ioException);
			LOGGER.fatal("Fatal error occurred: ", ioException); // Use error for fatal logging in Log4j 2.x
		} catch (Exception e) {
			LOGGER.error("An error occurred: ", e);
			LOGGER.fatal("Fatal error occurred: ", e); // Use error for fatal logging in Log4j 2.x
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		saveStudent(req, res);
	}
	
	protected void saveStudent(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String StuName = req.getParameter("name");
		String StuPhone = req.getParameter("phoneNumber");
		String StuAddress = req.getParameter("address");
		
		Student student = new Student();
		student.setAddress(StuAddress);
		student.setPhone_number(StuPhone);
		student.setStudent_name(StuName);
		
		String message = dao.addStudent(student);
		req.setAttribute("Message", message);
		req.getRequestDispatcher("/studentList.jsp").forward(req, res);
		
	}
	

}
