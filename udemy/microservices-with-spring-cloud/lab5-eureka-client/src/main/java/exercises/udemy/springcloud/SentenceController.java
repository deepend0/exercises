package exercises.udemy.springcloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Profile("sentence")
@RestController
public class SentenceController {

	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/sentence")
	public String getSentence() {
		return getWord("LAB-5-SUBJECT") + " " + getWord("LAB-5-VERB") + " " + getWord("LAB-5-ARTICLE") + " "
				+ getWord("LAB-5-ADJECTIVE") + " " + getWord("LAB-5-NOUN") + ".";
	}
	
	public String getWord(String service) {
		return restTemplate.getForObject("http://" + service, String.class);
	}

}
