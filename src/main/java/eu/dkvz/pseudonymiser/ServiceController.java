package eu.dkvz.pseudonymiser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class ServiceController {
	
	@Autowired
	private PseudonymiserService pService;

	@CrossOrigin(origins = "*")
	@RequestMapping("/{value}")
	public String rootPseudo(@PathVariable String value) throws Exception {
		return this.getPseudo(value).toLowerCase();
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping("/as-json/{value}")
	public Map<String, String> jsonPseudo(@PathVariable String value) throws Exception {
		Map<String, String> ret = new HashMap<>();
		ret.put("result", this.getPseudo(value).toLowerCase());
		return ret;
	}
	
	private String getPseudo(String value) throws Exception {
		try {
			if (value != null && !value.isEmpty()) {
				return pService.getPseudo(value);
			} else {
				throw new Exception("You need to provide a value in the URL");
			}
		} catch (Exception ex) {
			throw new Exception("Oops, something wen't wrong! Don't worry, we have a pack of moneys w... Yeah no it's probably broken BYE");
		}
	}
	
}
