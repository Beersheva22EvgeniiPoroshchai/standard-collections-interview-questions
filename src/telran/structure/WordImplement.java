package telran.structure;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;


public class WordImplement implements Words {

	LinkedHashSet<String> www = new LinkedHashSet<>();
	LinkedHashSet<String> bigLetWord = new LinkedHashSet<>();

	@Override
	public boolean addWord(String word) {
		boolean res = false;
		if (bigLetWord.contains(word.toUpperCase()) == false) {
			www.add(word);
			bigLetWord.add(word.toUpperCase());
			res = true;
		}
		return res;
	}

	@Override
	public List<String> getWordsByPrefix(String prefix) {
		List<String> res = new ArrayList<>();
		www.stream().filter(n -> n.toUpperCase().startsWith(prefix.toUpperCase())).forEach(n -> res.add(n));
		return res;
	}

}
