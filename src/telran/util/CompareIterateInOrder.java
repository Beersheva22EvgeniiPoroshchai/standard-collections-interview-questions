package telran.util;

import java.util.Comparator;

public class CompareIterateInOrder<T> implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
	
		int forComp1 = 0;
		int forComp2 = 0;
		while (o1 > 0) {
			forComp1 += o1 % 10;
			o1 /= 10;
		}
		while (o2 > 0) {
			forComp2 += o2 % 10;
			o2 /= 10;
		}
		return forComp1 < forComp2 ? -1 : 1;		
	}
}

