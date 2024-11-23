package programming;

import java.math.BigInteger;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

class Course{
	private String name;
	private String category;
	private int reviewScore;
	private int noOfStudents;
	
	
	
	public Course(String name, String category, int reviewScore, int noOfStudents) {
		super();
		this.name = name;
		this.category = category;
		this.reviewScore = reviewScore;
		this.noOfStudents = noOfStudents;
	}

	public String toString() {
		return name + ":"+ category + ":"+ noOfStudents +":"+ reviewScore;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getReviewScore() {
		return reviewScore;
	}

	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}

	public int getNoOfStudents() {
		return noOfStudents;
	}

	public void setNoOfStudents(int noOfStudents) {
		this.noOfStudents = noOfStudents;
	}
	
	
}

public class FP05Custom {

	public static void main(String[] args) {

		//Utility methods in stream
		
		List<Course> courses = List.of(
				new Course("Java" , "Language",9, 41),
				new Course("Python" , "Language",8, 45),
				new Course("Javascript" , "Language",9, 47),
				new Course(".NET" , "Language",8, 41),
				new Course("Azure" , "Cloud",8, 55),
				new Course("AWS" , "Cloud",9, 55),
				new Course("GCP" , "Cloud",7, 43),
				new Course("Spring" , "Framework",5, 59),
				new Course("Spring Boot" , "Framework",10, 60),
				new Course("Angular" , "Framework",10, 65),
				new Course("React" , "Framework",10, 20),
				new Course("DJango" , "Framework",6, 41),
				new Course("MySQL" , "DB",8, 51),
				new Course("MongoDB" , "DB",10, 53)
				);
		
		
		Predicate<? super Course> reviewScoreGT8Predicate = course -> course.getReviewScore() > 8;
		Predicate<? super Course> reviewScoreGT9Predicate = course -> course.getReviewScore() > 9;
		Predicate<? super Course> reviewScoreLT7Predicate = course -> course.getReviewScore() < 7;
		
		Predicate<? super Course> reviewScoreLT5Predicate = createPredicatewithReview(5);

		Predicate<? super Course> matchCategoryPredicate = course -> course.getCategory().contains("Framework");
		
		
		

		
//		System.out.println(courses.stream().allMatch(reviewScoreGT8Predicate));
//		
//		System.out.println(courses.stream().noneMatch(reviewScoreGT9Predicate));
//		
//		System.out.println(courses.stream().anyMatch(reviewScoreGT9Predicate));
		
//		System.out.println(courses.stream().count());
		//System.out.println(courses.stream().findFirst());
//		System.out.println(courses.stream().findAny());
//		System.out.println(courses.stream().skip(2));

		Comparator<Course> noOfStudentsAscending = Comparator.comparing(Course::getNoOfStudents);
		Comparator noOfStudentsDescending = Comparator.comparing(Course::getNoOfStudents).reversed();
		
		Comparator<Course> noOfStudentsAndReview = Comparator.comparing(Course::getNoOfStudents)
				.thenComparing(Course::getReviewScore);
		
		Comparator<Course> noOfStudentsAndReviewDesc = Comparator.comparing(Course::getNoOfStudents)
				.thenComparing(Course::getReviewScore)
				.reversed();
		
//		Comparator<Course> noOfStudentsAndReviewDesc2 = Comparator.comparing(Course::getNoOfStudents).reversed()
//				.thenComparing(Course::getReviewScore).reversed();


		
//		System.out.println(courses.stream().sorted(noOfStudentsAscending).collect(Collectors.toList()));
//		System.out.println(courses.stream().sorted(noOfStudentsDescending).collect(Collectors.toList()));
//		System.out.println(courses.stream().sorted(noOfStudentsAndReview).collect(Collectors.toList()));
//		System.out.println(courses.stream().sorted(noOfStudentsAndReviewDesc).collect(Collectors.toList()));
		
		//skip, limit takewhile, dropwhile
		
//		System.out.println(courses.stream().sorted(noOfStudentsAndReviewDesc).limit(4).collect(Collectors.toList()));
//		System.out.println(courses.stream().sorted(noOfStudentsAndReviewDesc).skip(2).limit(4).collect(Collectors.toList()));

		System.out.println(courses);
		
		Predicate<Course> reviewGT8 = course -> course.getReviewScore() >=8 ;
		Predicate<Course> reviewGT5 = course -> course.getReviewScore() <4 ;

//		System.out.println(courses.stream().takeWhile(reviewGT8).collect(Collectors.toList()));
//		System.out.println(courses.stream().dropWhile(reviewGT8).collect(Collectors.toList()));

		
//		System.out.println(courses.stream().max(noOfStudentsAndReview));
//		System.out.println(courses.stream().min(noOfStudentsAndReview));
		
		//understanding default
		System.out.println(courses.stream()
				.filter(reviewGT5).min(noOfStudentsAndReview)
				.orElse(new Course("GOLang","Language",8,17)));


		System.out.println(courses.stream()
				.filter(reviewScoreGT8Predicate)
				.mapToInt(Course::getNoOfStudents)
				.sum());
		
		System.out.println(courses.stream()
				.filter(reviewScoreGT8Predicate)
				.mapToInt(Course::getNoOfStudents)
				.average());
		
		System.out.println(courses.stream()
				.filter(reviewScoreGT8Predicate)
				//.mapToInt(Course::getNoOfStudents)
				.count());

//		System.out.println(courses.stream()
//				.filter(reviewScoreGT8Predicate)
//				.mapToInt(Course::getNoOfStudents)
//				.max());
		
		
		Comparator<Course> studentCountComparator = Comparator.comparing(Course::getNoOfStudents);
	//	System.out.println(courses.stream().sorted(studentCountComparator).collect(Collectors.toList()));
		System.out.println(courses.stream().max(Comparator.comparing(Course::getNoOfStudents)));

		System.out.println(courses.stream()
		.collect(Collectors.groupingBy(Course::getCategory)));
		/*
		 * {Language=[Java:Language:41:9, Python:Language:45:8,
		 * Javascript:Language:47:9, .NET:Language:41:8], Cloud=[Azure:Cloud:55:8,
		 * AWS:Cloud:55:9, GCP:Cloud:43:7], DB=[MySQL:DB:51:8, MongoDB:DB:53:10],
		 * Framework=[Spring:Framework:59:5, Spring Boot:Framework:60:10,
		 * Angular:Framework:65:10, React:Framework:20:10, DJango:Framework:41:6]}
		 */
		
		
		System.out.println(courses.stream()
		.collect(Collectors.groupingBy(Course::getCategory, Collectors.counting())));
		//{Language=4, Cloud=3, DB=2, Framework=5}
		
		
		Comparator<Course> categoryReview = Comparator.comparing(Course::getReviewScore);
		System.out.println(courses.stream()
				.collect(Collectors.groupingBy(Course::getCategory, Collectors.maxBy(categoryReview) ))
				);
		//{Language=Optional[Java:Language:41:9], Cloud=Optional[AWS:Cloud:55:9], DB=Optional[MongoDB:DB:53:10], Framework=Optional[Spring Boot:Framework:60:10]}
		
		
		System.out.println(courses.stream().collect(Collectors.groupingBy(Course::getCategory, Collectors.mapping(Course::getName, Collectors.toList())))
				);
		//{Language=[Java, Python, Javascript, .NET], Cloud=[Azure, AWS, GCP], DB=[MySQL, MongoDB], Framework=[Spring, Spring Boot, Angular, React, DJango]}
		
		System.out.println("===Practice GroupBy===");
		
		System.out.println(courses.stream()
				.collect(Collectors.groupingBy( Course::getCategory))
				);
		/* {Language=[Java:Language:41:9, Python:Language:45:8, Javascript:Language:47:9, .NET:Language:41:8], Cloud=[Azure:Cloud:55:8, AWS:Cloud:55:9, GCP:Cloud:43:7], DB=[MySQL:DB:51:8, MongoDB:DB:53:10], Framework=[Spring:Framework:59:5, 
		Spring Boot:Framework:60:10, Angular:Framework:65:10, React:Framework:20:10, DJango:Framework:41:6]} */
		
		System.out.println(courses.stream()
				.collect(Collectors.groupingBy(Course::getCategory,
						Collectors.counting()))
				); //{Language=4, Cloud=3, DB=2, Framework=5}
		
		Comparator<Course> reviewComparator = Comparator.comparing(Course::getReviewScore);
		//Highest reviewed course
		System.out.println(courses.stream()
				.collect(Collectors.groupingBy(Course::getCategory,
						Collectors.maxBy(reviewComparator)))
				);//{Language=Optional[Java:Language:41:9], Cloud=Optional[AWS:Cloud:55:9], DB=Optional[MongoDB:DB:53:10], Framework=Optional[Spring Boot:Framework:60:10]}
		
		System.out.println(courses.stream()
				.collect(Collectors.groupingBy(Course::getCategory,Collectors.mapping( Course::getName, Collectors.toList() )))
				);//{Language=[Java, Python, Javascript, .NET], Cloud=[Azure, AWS, GCP], DB=[MySQL, MongoDB], Framework=[Spring, Spring Boot, Angular, React, DJango]}
		
		Map<String, Optional<Course>> topCoursesDetails = courses.stream()
				.collect(Collectors.groupingBy(Course::getCategory,
						Collectors.maxBy(reviewComparator)));
		
		for( int i=0; i< topCoursesDetails.size(); i++ ) {
			Optional<Course> topcourse = topCoursesDetails.get(topCoursesDetails);
			
		}
		courses.stream()
		.collect(Collectors.groupingBy(Course::getCategory,
				Collectors.maxBy(reviewComparator)));
		
		//Jshell
		
		IntStream.range(1, 10); // excludes 10
		IntStream.rangeClosed(1, 10); //includes 10
		
		IntStream.iterate(1, e -> e+2).limit(10).sum();
		
		IntStream.iterate(2, e -> e*2).limit(10).sum();
		
		IntStream.iterate(1, e -> e+2).limit(10).peek(System.out::println).sum();
		
		//Need to box to convert to list
		IntStream.iterate(1, e -> e+2).limit(10).boxed().collect(Collectors.toList());
		
		//Factorial
		System.out.println("=== Factorial===");
		System.out.println(IntStream.rangeClosed(1, 50).reduce(1, (x,y)-> x*y));

		System.out.println(LongStream.rangeClosed(1, 50).reduce(1, (x,y)-> x*y));

		System.out.println(LongStream.rangeClosed(1, 50).reduce(1L, (x,y)-> x*y));

		System.out.println(LongStream.rangeClosed(1, 21).reduce(1, (x,y)-> x*y));

		System.out.println(LongStream.rangeClosed(1, 50).mapToObj(BigInteger::valueOf).reduce(BigInteger.ONE, BigInteger::multiply));

		
		BigInteger res = LongStream.rangeClosed(1, 50).mapToObj(BigInteger::valueOf).reduce(BigInteger.ONE, BigInteger::multiply);
		
		//System.out.println(res);
	}
	
	//Higher order Function- Function that returns another function (logic)

	private static Predicate<? super Course> createPredicatewithReview(int cutOffReviewScore) {
		return course -> course.getReviewScore() < cutOffReviewScore;
	}
	

}
