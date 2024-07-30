package StudentWithHtml;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import StudentWithHtml.dao.StudentDao;
import StudentWithHtml.dto.Student;

public class DeleteServlet   extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id=Integer.parseInt(req.getParameter("id"));
		  
		StudentDao d=new StudentDao();
		Student st=d.deleteStudent(id);
		PrintWriter pw=resp.getWriter();
		if(st!=null)
		{
			pw.print("data delected sucessfully");
		}
		else 
		{
			pw.print("Sorry id is not be present");
		}
	}
}
