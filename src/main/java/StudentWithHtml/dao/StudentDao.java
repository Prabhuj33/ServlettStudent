package StudentWithHtml.dao;

import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import StudentWithHtml.dto.Student;

public class StudentDao
{

	public EntityManager getEntityManager()
	{
		return Persistence.createEntityManagerFactory("vinod").createEntityManager();
	}
	
	
	public void saveStudent(Student student)
	{
		EntityManager em=getEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.persist(student);
		et.commit();
	}


	public List<Student> getAllStudent() {

		EntityManager em=getEntityManager();
		
		Query q=em.createQuery("select s from Student s");
		List<Student> list=q.getResultList();
		return list;
	}


	public Student findByStudentId(int id) {
	
		EntityManager em=getEntityManager();
		Student dbStudent=em.find(Student.class, id);
		if(dbStudent!=null)
		{
			return dbStudent;
		}
		else {
			return null;	
		}
		
	}


	public Student deleteStudent(int id) {
		EntityManager em=getEntityManager();
		EntityTransaction et=em.getTransaction();
		Student dbStudent=em.find(Student.class,id );
	
		if(dbStudent!=null)
		{
			et.begin();
			em.remove(dbStudent);
			et.commit();
			return dbStudent;
		}
		else 
		{
			return null;
	
		}
			}


	public Student updateStudent(int id,Student student) 
	{
		
		EntityManager em=getEntityManager();
		EntityTransaction et=em.getTransaction();
		Student dbStudent=em.find(Student.class, id);
		if(dbStudent!=null)
		{
			et.begin();
			em.merge(dbStudent);
			et.commit();
			return student;
		}

		else 
		{
			return null;
		}
		

	
	
	
	}


}
