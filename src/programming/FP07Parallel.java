package programming;

import java.util.List;
import java.util.stream.LongStream;

public class FP07Parallel {

	public static void main(String[] args) {
		// Utilize multicores with parallelization
		
		long time = System.currentTimeMillis();

		List<Integer> numbers = List.of(12,13,2,8,6,4,9,10);


		//System.out.println(LongStream.range(0, 1000000000).sum());
		System.out.println(numbers.stream().reduce(0,Integer::sum));

		
		//Parallel
		
		//System.out.println(LongStream.range(0, 1000000000).parallel().sum());
		
		// System.out.println(numbers.stream().parallel().reduce(0,Integer::sum));
		
		System.out.print("Execution time: "); System.out.println(System.currentTimeMillis() - time);

	}

}
