package telran.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.*;
class StandardCollectionTest {

	@Test
	@Disabled
	void test() {
		List<Integer> list = new ArrayList<> (Arrays.asList(1,2,3,4,5,6,70,-20));
		list.add(5);
		System.out.println(list);
		List<Integer> listSub = list.subList(6, 9);
		System.out.println(listSub);
		listSub.add(1, -2);
		System.out.println(list);
		listSub.sort(Integer::compare);
		listSub.clear();
		System.out.println(list);
		
	}
	
	@Test
	@Disabled
	void displayOccurencesCount() {
		String strings [] = {"lmn", "abc", "abc", "lmn", "a", "lmn"};
		Arrays.stream(strings).collect(Collectors.groupingBy(s -> s, Collectors.
				counting())).entrySet().stream().sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue())).
		forEach(e -> System.out.printf("%s:  %d\n", e.getKey(), e.getValue()));
	}
	
	
	@Test
	void displayDigitsStatistics() {
		new Random().ints(1000000, 1, Integer.MAX_VALUE)
        .mapToObj(String::valueOf)
        .flatMap(e -> Arrays.stream(e.split("")))
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
        .forEach((k,v) -> System.out.printf("The digit %s displayed %d times in the range from 1 to 2147483647 %n", k, v));
	}

}
	
	
	
	
	
	
	
	
	
	
	
	
	

