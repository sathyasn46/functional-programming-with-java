package programming;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class FP07Files {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Files.lines(Paths.get("file1.txt"))
		.forEach(System.out::println);
		
		System.out.println(Files.lines(Paths.get("file1.txt")).count());
		
		//Find unique words in file
		Files.lines(Paths.get("file1.txt"))
		.map(str-> str.split(" "))
		.flatMap(Arrays::stream)
		.distinct().sorted()
		.forEach(System.out::println);
		
//		Files.list(Paths.get("."))
//		.forEach(System.out::println);
		
		Files.list(Paths.get("."))
		.filter(Files::isDirectory)
		.forEach(System.out::println);
		
		
	}

}
