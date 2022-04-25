package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.entities.Livre;


public interface LivreRepo extends JpaRepository<Livre, Integer> {
	
	public java.util.List<Livre> findByOrderByTitreAsc();
	
}
