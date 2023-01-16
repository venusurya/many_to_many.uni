package many_to_many.unidao;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import many_to_many.uni.dto.Course;
import many_to_many.uni.dto.Student;



public class StudentDao {
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("venu");
		return entityManagerFactory.createEntityManager();

	}

	public void addStudent(Student student, List<Integer> list) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
        List<Course>course=new ArrayList<Course>();
		for (Integer integer : list) {
			Course course1 = entityManager.find(Course.class, integer);
			
			course.add(course1);
			
		
		}
		
        student.setCourse(course);
        System.out.println(student);
		entityManager.merge(student);

		entityTransaction.commit();
	}

	public void updateStudent(int id, Student student,List<Integer>list) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Student student2 = entityManager.find(Student.class, id);
		if (student2 != null) {
			student.setId(id);
			
			  List<Course>course=new ArrayList<Course>();
				for (Integer integer : list) {
					Course course1 = entityManager.find(Course.class, integer);
					course.add(course1);
					
				
				}
				student.setCourse(course);
			entityTransaction.begin();
			entityManager.merge(student);
			entityTransaction.commit();

		} else
			System.out.println("Such student is not exist");
	}

	public void deleteStudent(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Student student = entityManager.find(Student.class, id);
		if (student != null) {
			entityTransaction.begin();
			entityManager.remove(student);
			entityTransaction.commit();
		} else
			System.out.println("Not exist the student");
	}

	public void getdetails(int id) {
		EntityManager entityManager = getEntityManager();
		Student student = entityManager.find(Student.class, id);
		if (student != null)
			System.out.println(student);
		else
			System.out.println("No such student");
	}

	public void getDetailsAllStudent() {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("select a from Student a");
		List<Student> student = query.getResultList();
		System.out.println(student);
	}

}
