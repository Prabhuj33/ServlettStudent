package StudentWithHtml;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import StudentWithHtml.dao.StudentDao;
import StudentWithHtml.dto.Student;

public class SelectServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		int id=Integer.parseInt(req.getParameter("id"));
		
		
		StudentDao d=new StudentDao();
		Student dbStudent=d.findByStudentId(id);
		
		if(dbStudent!=null)
		{
			PrintWriter pw=resp.getWriter();
			pw.print(dbStudent);
			
		}
		else 
		{
			PrintWriter pw=resp.getWriter();
			pw.print("Data not present pls check");
			
		}
		
		
		
		
		
	}
	
}
