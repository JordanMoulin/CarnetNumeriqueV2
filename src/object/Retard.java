package object;

import java.sql.Time;
import java.util.Date;

public class Retard {

	private int id;
	private Date dater;
	private Time duree;
	private String motif;
	private Utilisateur utilisateur;
	
	public void setId(int id){
		this.id=id;
	}
	
	public void setDater(Date dater){
		this.dater=dater;
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
	
	public Date getDater(){
		return dater;
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
		dater=null;
		duree=null;
		motif="";
		utilisateur= new Utilisateur();
	}
	
	public Retard(int id, Date dater, Time duree, String motif, Utilisateur utilisateur){
		this.id=id;
		this.dater=dater;
		this.duree=duree;
		this.motif=motif;
		this.utilisateur=utilisateur;
	}
	
	public Retard(Date dater, Time duree, String motif, Utilisateur utilisateur){
		this.dater=dater;
		this.duree=duree;
		this.motif=motif;
		this.utilisateur=utilisateur;
	}
	
}
