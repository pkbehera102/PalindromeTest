package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pojo.ErrorResponse;

/**
 * @author prasa
 *
 */
@RestController
@RequestMapping(value = "/words")
public class WordController {

	@Autowired
	PalindromeService palindromeService;

	/**
	 * 
	 * @param word
	 * @return
	 */
	@RequestMapping(value = "/{word}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Object> checkForPalindrome(@PathVariable("word") String word) {
		try {
			return new ResponseEntity<>(palindromeService.anagramPalindromeCheck(word), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorResponse("Error occured while processing request",
					HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

}
