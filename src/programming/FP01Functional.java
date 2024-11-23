package programming;

import java.util.List;

public class FP01Functional {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(12,13,2,8,6,4,9,10,3,5,7);
		List<String> courses = List.of("Aws", "Azure", "GCP", "Spring", "spring Boot","Hibernate","Docker","Kubernetes");

		printAllNumbersInListFunc(numbers);
		printEvenNumbersInListFunc(numbers);
		printOddNumbersInListFunc(numbers);
		printSquaresOfEvenNumbersInListFunc(numbers);
		printCubeOfOddNumbersInListFunc(numbers);


	}

	private static void printCubeOfOddNumbersInListFunc(List<Integer> numbers) {
		// TODO Auto-generated method stub
		System.out.println("=== Cube of Odd numbers ===");
		numbers.stream()
		.filter(num -> num %2 != 0)			//filter odd numbers
		.map(numb -> numb * numb * numb)         	//map number to its cube
		.forEach(System.out::println);
		
	}

	private static void printSquaresOfEvenNumbersInListFunc(List<Integer> numbers) {
		System.out.println("=== Squares of Even numbers ===");
		numbers.stream()
		.filter(num -> num %2 == 0)			//filter even numbers
		.map(numb -> numb * numb)         	//map number to its square
		.forEach(System.out::println);
		
	}

	private static void printOddNumbersInListFunc(List<Integer> numbers) {
		System.out.println("=== Odd numbers ===");
		numbers.stream()
		.filter(num -> num %2!=0).forEach(System.out::println);
	}

	private static void printNum(int num) {
		System.out.println(num);
	}
	
	private static void printAllNumbersInListFunc(List<Integer> numbers) {
		// What to dof
		//convert to stream
		numbers.stream()
		//.forEach(FP01Functional::printNum); //Method Reference
		.forEach(System.out::println); //Method Reference

	}
	
//	private static boolean isEven(int num) {
//		return num%2==0;
//	}
	// Lambda num -> num %2 == 0
	
	private static void printEvenNumbersInListFunc(List<Integer> numbers){
		System.out.println("=== Even numbers ===");
		numbers.stream()
		.filter(num -> num %2 == 0)// Filter only allows even numbers
		.forEach(System.out::println);
		
		//.forEach(FP01Functional::isEven)// Filter only allows even numbers

	}
	
}
