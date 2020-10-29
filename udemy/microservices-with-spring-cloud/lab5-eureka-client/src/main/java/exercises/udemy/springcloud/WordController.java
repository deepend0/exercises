package exercises.udemy.springcloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ConditionalOnMissingBean(SentenceController.class)
public class WordController {
	@Value("${words}")
	private String words;
	
	 @GetMapping("/")
	  public String getWord() {
	    String[] wordArray = words.split(",");
	    int i = (int)Math.round(Math.random() * (wordArray.length - 1));
	    return wordArray[i];
	  }
}
