package telran.util;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class StackInt {
	LinkedList<Integer> list = new LinkedList<>();
	LinkedList<Integer> max = new LinkedList<>();
	
	

	void push(int num) {
		if (max.isEmpty() || num >= max.getLast()) {
			max.addLast(num);
		}
			list.add(num);
		}
	
	
	int pop() {
	if (list.isEmpty()) {
		throw new NoSuchElementException();
	} else {
		if (list.getLast().equals(max.getLast())) {
			max.removeLast();
		}
		int res = list.removeLast();
		return res;
	}
			
}
	
	boolean isEmpty() {
	return list.isEmpty() ? true : false;
}
	
	int getMax() {
		if (max.isEmpty()) {
			throw new NoSuchElementException();
		} else {
			return max.getLast();	
	}
		
	}
}
