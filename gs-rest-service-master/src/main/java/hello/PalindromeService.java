package hello;

import java.util.List;

import pojo.PalindromeStatus;

/**
 * @author prasa
 *
 */
public interface PalindromeService {

	public List<String> findCombinations(String s);
	public PalindromeStatus anagramPalindromeCheck(String input);
}
