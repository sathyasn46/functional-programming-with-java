package programming;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FP02Exercise {

	public static void main(String[] args) {
		// Square every num in List and find sum of squares
		// Cube every num in List and find sum of Cubes
		//Find sum of odd numbers in list

		//List<Integer> numbers = List.of(12,13,2,8,6,4,9,10);
		List<Integer> numbers = List.of(1,2,3,4,12,2,5,6,7,8,9,10,12,13,13);
		List<String> courses = List.of("Aws", "Azure", "GCP", "Java","Spring", "Spring Boot","Hibernate","Docker","Kubernetes");


//		System.out.println("SumofSquares: "+ sumOfSquares(numbers));				
//		System.out.println("SumofCubes "+  sumOfCubes(numbers));
//		System.out.println("SumofOddNos "+  sumOfOddNumbers(numbers));
//		System.out.println("Distinct:  "); distinctNumbers(numbers);
//		List<Integer> squaredList = squaredList(numbers);
//		System.out.println("squaredList: "+ squaredList(numbers));
		
		//create list with even numbers filtered from the list
//		System.out.println("New list with Even nos: "+ createEvenNumbersList(numbers));		
		
		//create list with Course lengths nos
		System.out.println("Courses: "+courses );
		System.out.println("created String Length List: "+ createStringLengthList(courses));

		
	}
	
	private static List<Integer> createStringLengthList(List<String> courses) {
		return courses.stream().map(course -> course.length()).collect(Collectors.toList());
	}

	private static List<Integer> createEvenNumbersList(List<Integer> numbers) {
		return numbers.stream().filter(num -> num %2==0 ).collect(Collectors.toList());
	}

	private static List<Integer> squaredList(List<Integer> numbers) {
		return numbers.stream().map(num -> num*num).collect(Collectors.toList());
	}

	private static void distinctNumbers(List<Integer> numbers) {
		numbers.stream().distinct().forEach(System.out::println);
	}

	
	private static Integer sumOfCubes(List<Integer> numbers) {
		//return numbers.stream().reduce(0, (x,y) -> ( x + (y*y*y)));
		
		//Way Tut
		return numbers.stream().map(x -> x*x*x).reduce(0, Integer::sum);
	}
	
	private static Integer sumOfOddNumbers(List<Integer> numbers) {
//		return  numbers.stream()
//				.filter(num -> num %2 !=0 )
//				.reduce(0,Integer:: sum);
		Predicate<? super Integer> predicate1 = num -> num %2 !=0;
		Integer sum =  numbers.stream()
				.filter(predicate1 ) //Predicate
				.reduce(0,Integer:: sum);
		
		
		return sum;
		
		}
	
	private static Integer sumOfSquares(List<Integer> numbers) {
		//Integer result = numbers.stream().reduce(0, FP02Exercise::calculateSumOfSquares);
		
		//return numbers.stream().reduce(0, (x,y) -> ( x + (y*y)));	
		
		//Way Tut
		return numbers.stream().map(x -> x*x).reduce(0, Integer::sum);
		
		
	}

//	private static Integer calculateSumOfSquares(Integer a, Integer b) {
//		return ( a  + (b*b)) ;
//	}


}
