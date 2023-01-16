package many_to_many.uni.controller;


import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import many_to_many.uni.dto.Course;
import many_to_many.uni.dto.Student;
import many_to_many.unidao.CourseDao;
import many_to_many.unidao.StudentDao;



public class Main {

	public static void main(String[] args) {
		CourseDao dao = new CourseDao();
		StudentDao daoo = new StudentDao();

		

		Scanner sc = new Scanner(System.in);

		System.out.println("======welcome=======");
		boolean back = true;
		do {
			System.out.println("Enter your choice \n 1.About course \n 2.About student \n 3.Exit ");
			int choose = sc.nextInt();
			switch (choose) {
			case 1: {

				boolean check = true;
				do {

					System.out.println("choose your options \n 1.Add cousre \n 2.Update course \n 3.Delete course "
							+ "\n 4.Display course \n 5.Display all courses \n 6.Exit ");
					int choie = sc.nextInt();
					switch (choie) {
					case 1: {

						System.out.println("pls provide course details");
						System.out.println("Enter cousre name");
						String name = sc.next();
						System.out.println("Enter fees");
						long fee = sc.nextLong();
						System.out.println("Enter duration");
						int duration = sc.nextInt();
						Course course = new Course();
						course.setDuration(duration);
						course.setFees(fee);
						course.setName(name);
						dao.addCourse(course);

					}
						break;
					case 2: {
						System.out.println("Enter id course to update");
						int id = sc.nextInt();
						System.out.println("Enter cousre name");
						String name = sc.next();
						System.out.println("Enter fees");
						long fee = sc.nextLong();
						System.out.println("Enter duration");
						int duration = sc.nextInt();
						Course course = new Course();
						course.setDuration(duration);
						course.setFees(fee);
						course.setName(name);

						dao.updateCourse(id, course);
					}
						break;
					case 3: {
						System.out.println("Enter id course to delete");
						int id = sc.nextInt();
						dao.deleteCourse(id);

					}
						break;
					case 4: {
						System.out.println("Enter id course to display");
						int id = sc.nextInt();
						dao.getdetails(id);
					}
						break;
					case 5: {
						dao.getDetailsAllCourse();
					}
						break;
					case 6: {
						check = false;
					}

					}
				} while (check);

			}
				break;
			case 2: {
				boolean check = true;
				do {
					System.out.println("Enter your choice \n 1.Save student \n 2.update student"
							+ "\n 3.Delete student \n 4.Details of student \n 5.all students \n 6.Exit");
					int choice = sc.nextInt();
					switch (choice) {
					case 1: {
                        System.out.println("Enter id");
                        int num=sc.nextInt();
						System.out.println("Enter name");
						String name = sc.next();
						System.out.println("Enter address");
						String address = sc.next();
						System.out.println("Enter phone");
						long phone = sc.nextLong();
						Student student = new Student();
						student.setId(num);
						student.setAddress(address);
						student.setPhone(phone);
						student.setName(name);

						List<Integer> course = new ArrayList<Integer>();
						boolean c = true;
						do {
							System.out.println(" \n 1.Add subject \n 2.Exit");
							int option = sc.nextInt();
							switch (option) {
							case 1: {
								System.out.println("Enter course id");
								int id = sc.nextInt();
								

								course.add(id);
							}
								break;
							case 2: c=false;

							}
						} while (c);						
						
						daoo.addStudent(student,course);

					}
						break;// case 1
					case 2: {
						System.out.println("Enter student id to update");
						int id = sc.nextInt();
						
						System.out.println("Enter name");
						String name = sc.next();
						System.out.println("Enter address");
						String address = sc.next();
						System.out.println("Enter phone");
						long phone = sc.nextLong();
						Student student = new Student();
						
						student.setAddress(address);
						student.setPhone(phone);
						student.setName(name);
						
						List<Integer> course = new ArrayList<Integer>();
						boolean c = true;
						do {
							System.out.println(" \n 1.Add subject \n 2.Exit");
							int option = sc.nextInt();
							switch (option) {
							case 1: {
								System.out.println("Enter course id");
								int id1 = sc.nextInt();
								

								course.add(id1);
							}
								break;
							case 2: c=false;

							}
						}while(c);
						
						daoo.updateStudent(id, student,course);
					}
						break;
					case 3: {
						System.out.println("Enter student id to delete");
						int id = sc.nextInt();
						daoo.deleteStudent(id);
					}
						break;
					case 4: {
						System.out.println("Enter student id to get details");
						int id = sc.nextInt();
						daoo.getdetails(id);
					}
						break;
					case 5: {
						daoo.getDetailsAllStudent();
					}
						break;
					case 6: {
						check = false;
					}

					}

				} while (check);

			}
				break;
			case 3: {
				back = false;
			}
				break;

			}
		} while (back);
		System.out.println("=====thank you======");

	}

}