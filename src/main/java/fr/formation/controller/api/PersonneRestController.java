package fr.formation.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.model.Personne;

@RestController
@RequestMapping("/pers")
public class PersonneRestController {

	@GetMapping
	public Personne personne() {
		return new Personne("Lebleu", "Marie-Claude", 44);
	}

	@GetMapping(path = "/xml", produces = MediaType.APPLICATION_XML_VALUE)
	public Personne personneXml() {
		return new Personne("Lebleu", "Marie", 44);
	}

	@GetMapping(path = "/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public Personne personneJsonl() {
		return new Personne("Lebleu", "Marie", 44);
	}
	
	@PostMapping
	public ResponseEntity<Void> tototgnfeklbgnfejbnekfjn(@RequestBody Personne p){
		
		System.out.println(p);
		if (p.getNom() == null || p.getNom().trim().isEmpty())
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		else
			return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
		System.out.println("Suppression de l'objet dont l'id est egal à " + id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
}
