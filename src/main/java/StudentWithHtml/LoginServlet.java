package StudentWithHtml;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import StudentWithHtml.dao.StudentDao;
import StudentWithHtml.dto.Student;

public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	String email =req.getParameter("email");
	String password=req.getParameter("password");
	
	StudentDao da=new StudentDao(); 
	
	List<Student> stu=da.getAllStudent();
	
	boolean value=false;
	String dbPassword=null;
	
		
	

	
	
	for(Student students: stu)
	{
		if(email.equals(students.getEmail()))
		{
	    value=true;
	    dbPassword=students.getPassword();
       break;
       }
		
	
	}
	   if(value)
	   {
	      if(password.equals(dbPassword))
	      {
	    	  PrintWriter pw=resp.getWriter();
	    	  pw.print("login sucessfully");
	    	  
	      }
	      else
	      {
	    	  PrintWriter pw=resp.getWriter();
	    	  pw.print("invalid password");
	      
	    
	   } 
	   }
	   else
	   {
		   PrintWriter pw=resp.getWriter();
		   pw.print("Sorry email is not present");
		   
	   }

	

		 	}
	
	
	
	}

	
	

