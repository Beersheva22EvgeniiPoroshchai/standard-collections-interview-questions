package telran.structure;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.OptionalInt;
import java.util.Set;

public class McImplement implements MultiCounters {
	
	Map<Object, Integer> items;
	
	McImplement() {
		items = new HashMap<Object, Integer> ();
	}
	
	@Override
	public Integer addItem(Object item) {
		Integer res = items.get(item);
		if (res == null) {
			items.put(item, 1);
			res = 1;
		} else {
			items.put(item, ++res);
		}
		return res;
	}

	@Override
	public Integer getValue(Object item) {
		
		return items.get(item);
	}

	@Override
	public boolean remove(Object item) {
		boolean res = false;
		Integer count = items.get(item);
		if (count != null) {
			items.remove(item);
			res = true;
		}
		return res;
 	}

	@Override
	public Set<Object> getMaxItems() {
		Set<Object> res = new HashSet<>();
		Set<Entry<Object, Integer>> set = items.entrySet();
		Collection<Integer> value = items.values();
		OptionalInt max = value.stream().mapToInt(n -> n).max();
		set.stream().filter(n -> n.getValue().equals(max.getAsInt())).forEach(n -> res.add(n.getKey()));
		return res;
	}
}
