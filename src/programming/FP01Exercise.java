package programming;

import java.util.List;
import java.util.Scanner;

public class FP01Exercise {

	public static void main(String[] args) {
		List<String> courses = List.of("Aws", "Azure", "GCP", "Java","Spring", "Spring Boot","Hibernate","Docker","Kubernetes");
		
		printAllCourses(courses);

//		Scanner searchKey = new Scanner(System.in);
//		System.out.println("=========== Course Search ==============\n Enter search Key: ");
		searchCourses(courses,"Spring");
		printBigCourses(courses);
		printCharsOfCourses(courses);
		
	}


	private static void printCharsOfCourses(List<String> courses) {
		System.out.println("=========== Char length of All Courses Way 2 ==============");
//		courses.stream()
//		.forEach(course -> 
//			System.out.println(course+ " : "+ course.length()));
		
		//way 2
		courses.stream()
		.map(course -> course + " : "+ course.length())
		.forEach(System.out::println);;
		
	}


	private static void printAllCourses(List<String> courses) {
		System.out.println("=========== All Courses ==============");
		courses.stream().forEach(System.out::println);
	}
	
	private static void searchCourses(List<String> courses, String searchKey) {
		System.out.println("=========== Matching Courses ==============");
		courses.stream()
		.filter(course -> course.contains(searchKey))
		.forEach(System.out::println);
	}
	
	private static void printBigCourses(List<String> courses) {
		System.out.println("=========== Big Courses ==============");
		courses.stream().filter(course -> course.length()>=4)
		.forEach(System.out::println);
	}


	
}
