package com.example.demo.entities;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Entity @Table(name ="livres")
@Data
public class Livre {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer _id;
	
	@Column(name="ISBN",unique=true,updatable = false)
	private Integer ISBN;
	
	@Temporal(TemporalType.TIMESTAMP) @Column(nullable = false) 
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss.SSS")
	private Date DateSortie;
	
	@Temporal(TemporalType.TIMESTAMP) @CreationTimestamp @Column(nullable = false)
	private Date DateDernierConsultation;
	
	
	
	
	@Column(name="Titre",length=50,nullable=false)
	private String Titre;
	
	@Column(name="MaisonEdition",length=50,nullable=false)
	private String MaisonEdition;
	
	@Column(name="NombrePage",nullable=false)
	private Integer NombrePage;
	
	@Column(name="Auteur",length=50,nullable=false)
	private String Auteur;
	
	
	@Column(name="IsAvailable")
	private Boolean IsAvailable;
	
	
}
