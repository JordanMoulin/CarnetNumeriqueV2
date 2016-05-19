package object;

import java.util.Date;

public class Retard {

	private int id;
	private Date dater;
	private int duree;
	private String motif;
	private Utilisateur utilisateur;
	
	public void setId(int id){
		this.id=id;
	}
	
	public void setDater(Date dater){
		this.dater=dater;
	}
	
	public void setDuree(int duree){
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
	
	public Date getDater(){
		return dater;
	}
	
	public int getDuree(){
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
		dater=null;
		duree=0;
		motif="";
		utilisateur= new Utilisateur();
	}
	
	public Retard(int id, Date dater, int duree, String motif, Utilisateur utilisateur){
		this.id=id;
		this.dater=dater;
		this.duree=duree;
		this.motif=motif;
		this.utilisateur=utilisateur;
	}
	
	public Retard(int duree, String motif, Utilisateur utilisateur){
		this.duree=duree;
		this.motif=motif;
		this.utilisateur=utilisateur;
	}
	
}
