package exercises.udemy.springcloud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Profile("sentence")
@RestController
public class SentenceController {

	@Autowired
	private DiscoveryClient discoveryClient;
	
	@GetMapping("/sentence")
	public String getSentence() {
		return getWord("LAB-4-SUBJECT") + " " + getWord("LAB-4-VERB") + " " + getWord("LAB-4-ARTICLE") + " "
				+ getWord("LAB-4-ADJECTIVE") + " " + getWord("LAB-4-NOUN") + ".";
	}
	
	public String getWord(String service) {
		List<ServiceInstance> instances = discoveryClient.getInstances(service);
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(instances.get(0).getUri(), String.class);
	}

}
