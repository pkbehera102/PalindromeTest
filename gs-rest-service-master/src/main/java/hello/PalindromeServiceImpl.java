package hello;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Service;

import pojo.PalindromeStatus;

/**
 * @author prasa
 *
 */
@Service
public class PalindromeServiceImpl implements PalindromeService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see hello.PalindromeService#findCombinations(java.lang.String)
	 */
	public List<String> findCombinations(String input) {
		String[] indexes = new String[input.length()];
		List<String[]> combination = new ArrayList<>();
		for (Integer i = 0; i < input.length(); i++) {
			indexes[i] = i.toString();
		}
		for (int i = 0; i < input.length(); i++) {
			combination.add(indexes);
		}
		List<String> result = new ArrayList<>();
		Set<String> outPut = new HashSet<>();
		for (int i = 0; i < combination.size(); i++) {
			int count = 0;
			CopyOnWriteArrayList<String> tmpList = new CopyOnWriteArrayList<>();
			String cmb = "";
			cmb = cmb + i;
			tmpList.add(cmb);
			for (int j = 1; j < combination.size(); j++) {
				count++;
				String[] currentCombination = combination.get(j);
				for (String c : currentCombination) {
					for (String f : tmpList) {
						if (f.length() == 1) {
							if (!f.equals(c)) {
								// tmpList.remove(f);
								tmpList.add(f + c);
							}
						} else if (!(f.contains(c)) && f.length() == j)

						{
							tmpList.add(f + c);
						}
					}
				}
				for (String key : tmpList) {
					if (key.length() == j) {
						tmpList.remove(key);

					}

				}

			}

			outPut.addAll(tmpList);

		}

		for (String o : outPut) {

			String r = new String();
			for (char c : o.toCharArray()) {
				r = r + input.charAt((Integer.parseInt(Character.toString(c))));
			}
			result.add(r);
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hello.PalindromeService#anagramPalindromeCheck(java.lang.String)
	 */
	public PalindromeStatus anagramPalindromeCheck(String input) {
		PalindromeStatus status = new PalindromeStatus();
		status.setWord(input);
		status.setAnagramOfPalindrome(false);
		status.setPalindrome(false);
		List<String> combinations = findCombinations(input);
		for (String anagramOfPalindromeCheck : combinations) {
			if (anagramOfPalindromeCheck
					.equalsIgnoreCase(new StringBuffer(anagramOfPalindromeCheck).reverse().toString())) {
				status.setAnagramOfPalindrome(true);
			}
		}
		if (input.equals(new StringBuffer(input).reverse().toString())) {
			status.setPalindrome(true);
		}
		return status;
	}

}
