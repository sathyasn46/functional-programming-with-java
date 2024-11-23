package programming;

import java.util.ArrayList;
import java.util.List;

public class FP03Functional {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> numbers = List.of(12,13,2,8,6,4,9,10);
		Integer sum = addListFunctional(numbers);
		System.out.println("Sum: "+sum);
	}

	
	
	private static Integer addListFunctional(List<Integer> numbers) {
		//way 1 Method reference
		Integer result1 = numbers.stream().reduce(0, FP03Functional::addElements);
		
		//way 2 Lambda expression
		Integer result2=  numbers.stream().reduce(0, (x,y)-> (x+y) );
		
		//way3 ibuilt function
		
		Integer result3 = numbers.stream().reduce(0, Integer::sum);
		
		
		System.out.println( "Result 1 :" + result1 + " Result 2 :" + result2 +" Result 3 :" +  result3);
		return result3;
	}

	
	private static Integer addElements(int aggregate, int nextNummber) {
		return aggregate+ nextNummber;
	}

}
