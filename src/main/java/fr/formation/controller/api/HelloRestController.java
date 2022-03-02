package fr.formation.controller.api;

import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {

	
	@RequestMapping(path = "/helloworld", method = RequestMethod.GET)
	public String helloWorld() {
		return "hello world !";
	}
	
	@GetMapping("/alea")
	public Integer alea() {
		return new Random().nextInt(100);
	}
	
	@GetMapping("/alea2")
	public ResponseEntity<Integer> alea2() {
		int rand = new Random().nextInt(100);
		// renvoyer la valeur si > 50
		// renvoyer une erreur si <= 50
		
		if (rand > 50) {
			return new ResponseEntity<>(rand, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/formulaire")
	public String formulaire(String nom, String prenom, Integer age) {
		return "Bonjour, vous vous appelez " + prenom + " " + nom + " et vous avez " + age + " ans";
	}
	
	@GetMapping("/passage/{n}/{p}")
	public String passage(@PathVariable("n") String nom, @PathVariable("p") String prenom) {
		return "Hello, vous vous appelez " + prenom + " " + nom;
	}
	
}















