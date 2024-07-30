package StudentWithHtml;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import StudentWithHtml.dao.StudentDao;
import StudentWithHtml.dto.Student;

public class UpdateServlet extends HttpServlet
{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	int id=Integer.parseInt(req.getParameter("id"));
	String name=req.getParameter("name");
	String email=req.getParameter("email");
	String password =req.getParameter("password");
	String address=req.getParameter("address");
	long phone =Long.parseLong(req.getParameter("phone"));
	
	
	Student s=new Student();
	s.setName(name);
	s.setAddress(address);
	s.setEmail(email);
	s.setPassword(password);
	s.setPhone(phone);
	
	
	StudentDao d=new StudentDao();
	Student dbStudent=d.updateStudent(id,s);
	PrintWriter pw=resp.getWriter();
	if(dbStudent!=null)
	{
		pw.print("data update sucessfully");
	}
   
	else
	{
		pw.print("pls check id it's not present");
	}
   
   
}
}
