package eu.dkvz.pseudonymiser;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

@Service
public class PseudonymiserService {
	
	public static String PS_FILENAME = "words.txt";
	
	private Pseudonymiser pseudo;
	
	@PostConstruct
	private void initialize() {
		this.pseudo = new Pseudonymiser(PseudonymiserService.PS_FILENAME);
	}
	
	public String getPseudo(String value) throws Exception {
		return this.pseudo.hashAndFind(value);
	}
	
}
