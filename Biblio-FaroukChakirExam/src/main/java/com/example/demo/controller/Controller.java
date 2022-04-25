package com.example.demo.controller;


import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entities.Livre;
import com.example.demo.service.LivreService;


@RestController
@RequestMapping("/emsi_api/livres")
public class Controller {
	@Autowired
    LivreService Service;
	
	@GetMapping
	public List<Livre> getAllLivres(){
		return Service.GetLivres();	
	}
	
	@GetMapping("/{id}")
	public Livre getLivre(@PathVariable("id") Integer id){
		return Service.GetLivreById(id);		
	}
	
	
	
	@PostMapping("/create")
	public void createLivre(@RequestBody Livre livre) {
		
		Service.AddLivre(livre);
	}
	
	
	
	@PutMapping("/update/{id}")
	public void updateLivre(@RequestBody Livre livre ,@PathVariable("id") Integer id) {

		livre.setDateDernierConsultation(new Date());
		Service.UpdateLivre(livre , id);
	}
	@DeleteMapping("/delete/{id}")
	public void deleteLivre(@PathVariable("id") Integer id) {
		Service.deleteLivre(id);
	}

	
}
