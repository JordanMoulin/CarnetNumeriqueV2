package org.btssio.carnetnumerique.object;

import java.sql.Date;

public class Absence {

	private int id;
	private Date dateDebut;
	private Date dateRetour;
	private String motif;
	private Utilisateur utilisateur;
	
	public void setId(int id){
		this.id=id;
	}
	
	public void setDateDebut(Date dateDebut){
		this.dateDebut=dateDebut;
	}	
	
	public void setDateRetour(Date dateRetour){
		this.dateRetour=dateRetour;
	}
	
	public void setMotif(String motif){
		this.motif=motif;
	}
	
	public void setUtilisateur(Utilisateur utilisateur){
		this.utilisateur=utilisateur;
	}
	
	public int getId(){
		return id;
	}
	
	public Date getDateDebut(){
		return dateDebut;
	}
	
	public Date getDateRetour(){
		return dateRetour;
	}
	
	public String getMotif(){
		return motif;
	}
	
	public Utilisateur getUtilisateur(){
		return utilisateur;
	}
	
	public Absence(){
		id=0;
		dateDebut=null;
		dateRetour=null;
		motif="";
		utilisateur= new Utilisateur();
	}
	
	public Absence(int id, Date dateDebut, Date dateRetour, String motif, Utilisateur utilisateur){
		this.id=id;
		this.dateDebut=dateDebut;
		this.dateRetour=dateRetour;
		this.motif=motif;
		this.utilisateur=utilisateur;
	}
	
}