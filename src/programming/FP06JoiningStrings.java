package programming;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FP06JoiningStrings {
	
	public static void main(String[] args) {
		
		List<String> courses = List.of("Aws", "Azure", "GCP", "Java","Spring", "Spring Boot","Hibernate","Docker","Kubernetes");
 
		//Combine strings& FlatMap
		
		System.out.println(courses.stream().collect(Collectors.joining(", ")));
		
		System.out.println(courses.stream().map(course -> course.split("")).flatMap(Arrays::stream).collect(Collectors.toList())
				);
		
		System.out.println(courses.stream().map(course -> course.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList())
				);
		
		
		//Tuples of strings with same no of characters
		List<String> courses1 = List.of("Aws", "Azure", "GCP", "Java","Spring", "Spring Boot","Hibernate","Docker","Kubernetes");
		List<String> courses2 = List.of("Aws", "Azure", "GCP", "Java","Spring", "Spring Boot","Hibernate","Docker","Kubernetes");

		List<List<String>> allTuples = courses1.stream().flatMap(course1-> courses2.stream().map(course2 -> List.of(course1,course2)))
				.collect(Collectors.toList());
		System.out.println("allTuples: \n"+allTuples);

		List<List<String>> uniqueElements = courses1.stream().flatMap(course1 -> courses2.stream().map(course2 -> List.of(course1,course2)))
				.filter(list -> !list.get(0).equals(list.get(1)))
				.collect(Collectors.toList());
		System.out.println("uniqueElements: \n"+uniqueElements);
		
		List<List<String>> tuplesByLength = courses1.stream().flatMap(course1 -> courses2.stream()
				.filter(course2-> course1.length()== course2.length())
				.map(course2 -> List.of(course1,course2)))
				.filter(list -> !list.get(0).equals(list.get(1)))
				.collect(Collectors.toList());
		
		System.out.println("tuplesByLength: \n"+tuplesByLength);
		
		System.out.println(courses.stream().filter(course-> course.length() >6)
				.map(String::toUpperCase).peek(System.out::println).findFirst()
				);
		
		System.out.println(courses.stream().peek(System.out::println).filter(course-> course.length() >6)
				.map(String::toUpperCase).peek(System.out::println).findFirst()
				);
		
		 
		
	}

}
