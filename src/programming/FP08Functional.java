package programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FP08Functional {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		String[] arr = {"Java","Spring", "Spring boot","Azure", "Aws","GCP","Angular"};
//		List<String> modifyableCourses = Arrays.asList(arr);
		
		List<String> courses = List.of("Java","Spring", "Spring boot","Azure", "Aws","GCP","Angular");
		
		//courses.replaceAll(str -> str.toUpperCase());
		/*
		 * Reason -- Collection created with List.of is immutable
		 * Exception in thread "main" java.lang.UnsupportedOperationException
			at java.base/java.util.ImmutableCollections.uoe(ImmutableCollections.java:142)
			at java.base/java.util.ImmutableCollections$AbstractImmutableList.replaceAll(ImmutableCollections.java:259)
			at programming.FP08Functional.main(FP08Functional.java:17)
		 * */
		
		List<String> modifyableCourses = new ArrayList<>(courses);
		
		modifyableCourses.replaceAll(str -> str.toUpperCase());
		
		System.out.println(modifyableCourses);
		
		modifyableCourses.removeIf(course-> course.length() <7);
		
		System.out.println(modifyableCourses);


	}

}
