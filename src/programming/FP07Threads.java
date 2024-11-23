package programming;

import java.util.stream.IntStream;

public class FP07Threads {

	public static void main(String[] args) {
		// Implement threads
		
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				for(int i=0; i< 10000 ; i++) {
					System.out.println(Thread.currentThread().getId() + " : "+ i);;
				}
				
			}
		};
		
		
		//Fumctional approach
		
		Runnable functionalRunnable = () ->{
			for(int i=0; i< 10000 ; i++) {
				System.out.println(Thread.currentThread().getId() + " : "+ i);;
			}
		};
		
		//Also simplify logic by eliminating the loop
		Runnable functionalRunnable2 = () ->{
			IntStream.range(0, 10000).forEach( i-> System.out.println(Thread.currentThread().getId() + " : "+ i));
		};
		

		Thread th1 = new Thread(functionalRunnable2);
		th1.start();
		
		Thread th2 = new Thread(functionalRunnable2);
		th2.start();

		Thread th3 = new Thread(functionalRunnable2);
		th3.start();


	}

}
