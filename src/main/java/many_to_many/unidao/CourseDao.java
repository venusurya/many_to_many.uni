package many_to_many.unidao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import many_to_many.uni.dto.Course;



public class CourseDao {
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("venu");
		return entityManagerFactory.createEntityManager();
		
		
	}
	
	
	public void addCourse(Course course) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();

		
		entityManager.persist(course);
		
		entityTransaction.commit();
	}
	
	public void updateCourse(int id,Course course) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Course course2=entityManager.find(Course.class, id);
		if(course2!=null) {
			course.setId(id);
			
			entityTransaction.begin();
			entityManager.merge(course);
			entityTransaction.commit();
			
		}
		else
			System.out.println("Such school is not exist");
	}
	
	public void deleteCourse(int id) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Course course=entityManager.find(Course.class, id);
		if(course!=null)
		{
			entityTransaction.begin();
			entityManager.remove(course);
			entityTransaction.commit();
		}
		else
			System.out.println("Not exist the school");
	}
	
	public void getdetails(int id) {
		EntityManager entityManager=getEntityManager();
		Course course= entityManager.find(Course.class, id);
		if(course!=null)
		System.out.println(course);
		else
			System.out.println("No such school");
	}
	
	public void getDetailsAllCourse() {
		EntityManager entityManager=getEntityManager();
		Query  query=entityManager.createQuery("select a from Course a");
		List<Course> course=query.getResultList();
		System.out.println(course);
	}
	
}