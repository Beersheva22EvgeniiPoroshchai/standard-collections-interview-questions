package telran.util;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class StackInt {
	LinkedList<Integer> list = new LinkedList<>();
	LinkedList<Integer> max = new LinkedList<>();
	
	void push(int num) {
	list.addLast(num);
	if (max.isEmpty() || num >= max.getLast()) {
	max.addLast(num);
		}
	}
	
	int pop() {
	int res = list.removeLast();
	if (res == (max.getLast())) {
	max.removeLast();
	}
	return res;
	}

	boolean isEmpty() {
	return list.isEmpty();
}
	
	int getMax() {
	return max.getLast();	
	}
}

