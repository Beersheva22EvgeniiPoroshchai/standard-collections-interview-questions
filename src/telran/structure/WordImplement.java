package telran.structure;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeSet;


public class WordImplement implements Words {

	private TreeSet<String> set = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
	@Override
	public boolean addWord(String word) {
		return set.add(word);
	}

	@Override
	public List<String> getWordsByPrefix(String prefix) {
		return new ArrayList<>(set.subSet(prefix, getPrefixLimit(prefix)));
	}

	private String getPrefixLimit(String prefix) {
		char lastChar = prefix.charAt(prefix.length() -1);
		char limitChar = (char) (lastChar + 1);
		return prefix.substring(0, prefix.length() -1) + limitChar;
	}
}
