package programming;

import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FP04BehaviorParameterization {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> numbers = List.of(12,13,2,8,6,4,3,9,10);
		
		Predicate<? super Integer> evenPredicate = (Integer x) -> x %2 ==0;
		filterAndPrint(numbers, evenPredicate);

		Predicate<? super Integer> oddPredicate = x -> x %2 !=0;
		filterAndPrint(numbers, oddPredicate);
		
		//Behavior parameterization - Passing behavior as an argument
		filterAndPrint(numbers, x -> x%3 ==0);
		
		Function<? super Integer, ? extends Integer> squareFunction = num -> num * num;
		
		
		//List<Integer> squaredNumbers = squareList(numbers, num -> num * num);
		System.out.println("Squared list:"+ mapAndCreateList(numbers, num -> num * num));
		
		List<Integer> cubeNumbers = mapAndCreateList(numbers, num -> num * num * num);

		System.out.println(cubeNumbers);
		
		Function<Integer, String> sumStringFunction = num -> num + " ";
		
		//Function <Input, Output> - takes one IP and returns one OP
		
		Consumer<Integer> action = System.out:: println;
		// Consumer takes an IP and return void
		
		BinaryOperator<Integer> binaryOperator = ( Integer x, Integer y)-> x+y;
		//Binary operator All IP and OP are of same datatype
		
		
		/*
		 * Other Functional interfaces
		 *  supplier
		 *  Unary operator
		 *  
		 *  BiPredicate
		 *  BiFunction
		 *  BiConsumer
		 *  
		 *  IntBinaryOperator
		 *  IntConsumer
		 *  IntFunction
		 *  IntPredicate
		 *  IntSupplier
		 *  
		 *  IntToDoubleFunction
		 *  IntToLongFunction
		 *  IntUnaryOperator
		 */
		
		/*
		 * Supplier : Typically a factory pattern
		 *  No input > return something
		 * */
		
//		Supplier<Integer> randomIntSupplier= () -> 2;
		Supplier<Integer> randomIntSupplier= () -> {
			Random random = new Random();
			return random.nextInt(0,3);
		};
		
		System.out.println("randomIntSupplier:"+ randomIntSupplier.get());
		
		/* Unary Operator 
		 * 
		 * */
		UnaryOperator<Integer> unaryOperator = (x)-> 3 * x;
		System.out.println("unaryOperator: " + unaryOperator.apply(4));
		
		
		
		BiPredicate<Integer, String> biPredicate = (num , str) -> {
			return num > 0 && str.length()>0;
		};
		
		System.out.println("BiPredicate result: "+  biPredicate.test(1, " "));
		
		BiFunction<Integer, String, String> biFunction = (num, str)->{ 
			return num +" --- "+ str;
		};
		
		System.out.println("BiFunction result: "+ biFunction.apply(50, "Bifunction"));
		
		
		BiConsumer<Integer,String> biConsumer = (num,str)->{
			System.out.println(num);
			System.out.println(str);
		};

		biConsumer.accept(80, "Biconsumer");
		
		
		
		IntBinaryOperator intBO = (x,y) ->x+y ;
		
	}

	private static List<Integer> mapAndCreateList(List<Integer> numbers,
			Function<? super Integer, ? extends Integer> mapper) {
		return numbers.stream().map(mapper).collect(Collectors.toList());
	}

	private static void filterAndPrint(List<Integer> numbers, Predicate<? super Integer> predicate) {
		numbers.stream()
		.filter(predicate)
		.forEach(System.out:: println);
	}	
}
