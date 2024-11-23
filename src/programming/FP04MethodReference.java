package programming;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class FP04MethodReference {
	
	private static void customPrint(String str) {
		System.out.println(str);
	}

	public static void main(String[] args) {
		/*
		 * Method Reference
		 *  Syntax  ::
		 *  We can use MR for instance methods Eg: toUppercase
		 *   We can use custom static methods in method references eg: customPrint() in this class
		 *   We can use for constructor reference
		 */
		
		List<String> courses = List.of("Aws", "Azure", "GCP", "Java","Spring", "Spring Boot","Hibernate","Docker","Kubernetes");
		
//		courses.stream()
//		.map( course-> course.toUpperCase())
//		.forEach(System.out::println);
		
		courses.stream()
		.map(String::toUpperCase)
		.forEach(FP04MethodReference::customPrint);
		
		//Supplier<String> supplierManual = ()->new String("Custom supplier");
		
		//constructor reference
		Supplier<String> supplierManual = String::new;
		
		System.out.println("Supplier:"+supplierManual.get());
	}

}
