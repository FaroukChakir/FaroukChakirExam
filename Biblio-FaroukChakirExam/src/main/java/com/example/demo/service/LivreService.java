package com.example.demo.service;


import java.util.Date;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Livre;
import com.example.demo.repo.LivreRepo;



@Service
public class LivreService {

	@Autowired
	LivreRepo livrerepo;
	
	
	
	/********************************************************************************************************/
	/********************************************************************************************************/
	/*Get data functions*/
	public List<Livre> GetLivres(){
		return livrerepo.findByOrderByTitreAsc();
	}
	/*Get data functions*/
	/********************************************************************************************************/
	
	
	/********************************************************************************************************/
	/*Get by ID data functions*/
	public Livre GetLivreById(Integer _Id)
	{
		return livrerepo.findById(_Id).orElse(null);
	}
	/*Get by ID data functions*/
	/********************************************************************************************************/
	
	
	/********************************************************************************************************/
	/*AddLivre functions*/
	public void AddLivre(Livre livre)
	{
		livrerepo.save(livre);
	}
	
	/*AddLivre function*/
	/********************************************************************************************************/
	/********************************************************************************************************/
	/*update function*/
	
	
	/********************************************************************************************************/
	/********************************************************************************************************/
	/*Checking new value if null */
	public String CheckEmpty(String OldVal , String NewVal)
	{
		if(NewVal==null)
		{
			return NewVal;
		}
		return OldVal;
		
	}
	/*Checking new value if null */
	/********************************************************************************************************/
	/********************************************************************************************************/
	
	public void UpdateLivre(Livre livre,Integer _Id)
	{
		/*for(int i=0;i<=livrerepo.count()-1;i++)
		{
			if(livrerepo.findById(_Id)!=null)
			{
				livrerepo.findById(_Id).set
			}
		}*/
		Livre FoundBook = 	 livrerepo.findById(_Id).orElseThrow();
		
		
		/********************************************************************************************************/
		
		/* Update my String attributes after cheking if new value's null or not */
		
		FoundBook.setAuteur(CheckEmpty(livre.getAuteur(), FoundBook.getAuteur()));
		
		
		FoundBook.setAuteur(CheckEmpty(livre.getAuteur(), FoundBook.getAuteur()));
		
		FoundBook.setTitre(CheckEmpty(livre.getTitre(), FoundBook.getTitre()));
		
		/* Update my String attributes after cheking if new value's null or not */
		/********************************************************************************************************/

		/* Update my other attributes after cheking if new value's null or not */
		
		FoundBook.setIsAvailable(livre.getIsAvailable()!= null ?livre.getIsAvailable() : FoundBook.getIsAvailable());
		
		FoundBook.setNombrePage(livre.getNombrePage()!=null ?livre.getNombrePage() : FoundBook.getNombrePage());
		
		
		FoundBook.setDateDernierConsultation(new Date());
		
		FoundBook.setDateSortie(livre.getDateSortie()!=null ? livre.getDateSortie(): FoundBook.getDateSortie());
		
		/* Update my other attributes after cheking if new value's null or not */
		/********************************************************************************************************/
		
		/*saving my update into database  */
		
		
		livrerepo.save(FoundBook);
		
		
		/********************************************************************************************************/
		
	}
	/*update function*/
	/********************************************************************************************************/
	/********************************************************************************************************/
	/*Delete functions*/
	
	public void deleteLivre(Integer id) {
		livrerepo.deleteById(id);
	}
	/*Delete functions*/
/********************************************************************************************************/
	
	
}
