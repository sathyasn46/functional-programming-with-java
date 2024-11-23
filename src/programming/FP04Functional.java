package programming;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FP04Functional {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> numbers = List.of(12,13,2,8,6,4,9,10);
		
		//Functional interfaces
		
//		numbers.stream()
//		.filter(num -> num %2 ==0)
//		.map(num -> num * num)
//		.forEach(System.out:: println);
		
		//understand these lambdas
		
		Predicate<Integer> isEvenPredicate = num -> num %2 ==0;
		//internal
				Predicate<Integer> isEvenPredicateManual = new Predicate<Integer>() {
					@Override
					public boolean test(Integer num) {
						return num %2 ==0;
					}
				};
						
		
		Function<Integer, Integer> squareFunction = num -> num * num;
		//internal
		Function<Integer, Integer> squareFunctionManual = new Function<Integer, Integer>() {
			@Override
			public Integer apply(Integer num) {
				// TODO Auto-generated method stub
				return num * num;
			}
		};
		
		
		Consumer<Integer> consumer = System.out:: println;
		//internal
		Consumer<Integer> consumerManual = new Consumer<Integer>() {
			
			@Override
			public void accept(Integer num) {
				System.out.println(num);
			}
		};
		
		
		
		numbers.stream()
		.filter(isEvenPredicateManual)
		.map(squareFunctionManual)
		.forEach(consumerManual);
		
		
		// Lambda exp is something like an object- First class citizens
		
		//sum
		BinaryOperator<Integer> accumulator = Integer::sum;
		
		//internal
		BinaryOperator<Integer> accumulatorManual = new BinaryOperator<Integer>() {
			//anonymous class
			@Override
			public Integer apply(Integer t, Integer u) {
				return t + u ;
			}
		};
		
		Integer resultSum = numbers.stream().reduce(0,accumulator);

		//the Functional interface having one abstract method (eg:appply ,accept, test) is function descriptor
		
	}

	
	
	private static Integer addListFunctional(List<Integer> numbers) {
		//way 1 Method reference
		Integer result1 = numbers.stream().reduce(0, FP04Functional::addElements);
		
		//way 2 Lambda expression
		Integer result2=  numbers.stream().reduce(0, (x,y) -> (x+y) );
		
		//way3 ibuilt function
		
		Integer result3 = numbers.stream().reduce(0, Integer::sum);
		
		
		System.out.println( "Result 1 :" + result1 + " Result 2 :" + result2 +" Result 3 :" +  result3);
		return result3;
	}

	
	private static Integer addElements(int aggregate, int nextNummber) {
		return aggregate+ nextNummber;
	}

}
