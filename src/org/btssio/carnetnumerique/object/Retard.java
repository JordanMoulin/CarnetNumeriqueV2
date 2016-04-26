package org.btssio.carnetnumerique.object;

import java.sql.Time;

public class Retard {

	private int id;
	private Time duree;
	private String motif;
	private Utilisateur utilisateur;
	
	public void setId(int id){
		this.id=id;
	}
	
	public void setDuree(Time duree){
		this.duree=duree;
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
	
	public Time getDuree(){
		return duree;
	}
	
	public String getMotif(){
		return motif;
	}
	
	public Utilisateur getUtilisateur(){
		return utilisateur;
	}
	
	public Retard(){
		id=0;
		duree=null;
		motif="";
		utilisateur= new Utilisateur();
	}
	
	public Retard(int id, Time duree, String motif, Utilisateur utilisateur){
		this.id=id;
		this.duree=duree;
		this.motif=motif;
		this.utilisateur=utilisateur;
	}
	
	public Retard(Time duree, String motif, Utilisateur utilisateur){
		this.duree=duree;
		this.motif=motif;
		this.utilisateur=utilisateur;
	}
	
}
