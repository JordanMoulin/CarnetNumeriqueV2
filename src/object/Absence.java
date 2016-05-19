package object;

import java.util.Date;

public class Absence {

	private int id;
	private Date dateDebut;
	private Date dateRetour;
	private int dateRetourHeure;
	private int dateRetourMinute;
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
	
	public void setDateRetourHeure(int dateRetourHeure){
		this.dateRetourHeure=dateRetourHeure;
	}
	
	public void setDateRetourMinute(int dateRetourMinute){
		this.dateRetourMinute=dateRetourMinute;
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
	
	public int getDateRetourHeure(){
		return dateRetourHeure;
	}
	
	public int getDateRetourMinute(){
		return dateRetourMinute;
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
		dateRetourHeure=0;
		dateRetourMinute=0;
		motif="";
		utilisateur= new Utilisateur();
	}
	
	public Absence(int id, Date dateDebut, Date dateRetour, int dateRetourHeure, int dateretourMinute, String motif, Utilisateur utilisateur){
		this.id=id;
		this.dateDebut=dateDebut;
		this.dateRetour=dateRetour;
		this.dateRetourHeure=dateRetourHeure;
		this.dateRetourMinute=dateretourMinute;
		this.motif=motif;
		this.utilisateur=utilisateur;
	}
	
	public Absence(Date dateDebut, Date dateRetour, int dateRetourHeure, int dateRetourMinute, String motif, Utilisateur utilisateur){
		this.dateDebut=dateDebut;
		this.dateRetour=dateRetour;
		this.dateRetourHeure=dateRetourHeure;
		this.dateRetourMinute=dateRetourMinute;
		this.motif=motif;
		this.utilisateur=utilisateur;
	}
}