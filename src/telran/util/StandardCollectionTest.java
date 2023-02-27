package telran.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.TreeSet;
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
	@Disabled
	void displayDigitsStatistics() {
	new Random().ints(1_000_000, 1, Integer.MAX_VALUE)
    .mapToObj(String::valueOf)
    .flatMap(e -> Arrays.stream(e.split("")))
    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
    .forEach((k,v) -> System.out.printf("The digit %s displayed %d times in the range from 1 to 2_147_483_647 %n", k, v));
	}
	
	
	@Test
	@Disabled
	void displayDigitsStatistics2ndSolution() {
	new Random().ints(1_000_000, 1, Integer.MAX_VALUE).flatMap(n -> Integer.toString(n)
	.chars()).boxed().collect(Collectors.groupingBy(digit -> digit, Collectors.counting()))
	.entrySet().stream().sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
	.forEach(e -> System.out.printf("%c: %d\n", e.getKey(), e.getValue()));
	}
	
	@Test
	void maxNumberWithNegativeImageTest() {
		int ar[] = {10000000, 3, -2, -200, 200, -3, 2};
		int ar1[] = {1000000, -1000000000, 3, -4};
		assertEquals(200, maxNumberWithNegativeImage(ar));
		assertEquals(-1, maxNumberWithNegativeImage(ar1));
	}
	
	
		int maxNumberWithNegativeImage(int[] array) {
		HashSet<Integer> set = new HashSet<>();
		int res = 0;
		for (int i = 0; i < array.length; i++) {
			set.add(array[i]);
			if (set.contains(-1 * array[i])) {
			res = Math.max(res, Math.abs(array[i]));
		}
	}
		return res == 0 ? -1 : res;
}
	
		@Test
		void treeIteratingTest() {
		int array[] = {1, 11, 111, 32, 9, 1234, 99, 992};
		int exp[] = new int[array.length];
		TreeSet<Integer> tree = createAndIterateTreeInOrder(array);  
		Iterator<Integer> it = tree.iterator();
		int i=0;
		while (it.hasNext()) {
			exp[i++]= it.next();
		}
		assertArrayEquals(array, exp);
	}
		
		private TreeSet<Integer> createAndIterateTreeInOrder(int[] array) {
		Comparator<Integer> comp = new CompareIterateInOrder<Integer>();
		TreeSet<Integer> newTree = new TreeSet<>(comp);
		for (int i = 0; i < array.length; i++) {
			newTree.add(array[i]);
		}
		System.out.println(newTree);
		return newTree;
	}
}
	


	
	
	
	
	
	
	
	
	
	
	
	
	

