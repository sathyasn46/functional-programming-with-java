package programming;

import java.util.ArrayList;
import java.util.List;

public class FP02Structured {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> numbers = List.of(12,13,2,8,6,4,9,10);
		printAllNumbersInListStructured(numbers);
		Integer sum = addListStructured(numbers);
		System.out.println("Sum: "+sum);
	}

	private static Integer addListStructured(List<Integer> numbers) {
		int sum=0;
		for(Integer num :numbers) {
			sum+=num;
		}
		return sum;
	}

	private static void printAllNumbersInListStructured(List<Integer> numbers) {
		// TODO Auto-generated method stub
		System.out.println(numbers);
		
	}

}
