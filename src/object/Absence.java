package object;

import java.text.DateFormat;
import java.util.Date;

/**
 * Classe Absence, contenant toutes les informations concernant un ticket d'absence.
 * @author Erwan
 *
 */
public class Absence {

	private int id;
	private Date dateDebut;
	private Date dateRetour;
	private int dateRetourHeure;
	private int dateRetourMinute;
	private String motif;
	private Utilisateur utilisateur;
	
	/**
	 * Mutateurs de l'attribut id
	 * @param id int
	 */
	public void setId(int id){
		this.id=id;
	}
	
	/**
	 * Mutateurs de l'attribut dateDebut
	 * @param dateDebut Date
	 */
	public void setDateDebut(Date dateDebut){
		this.dateDebut=dateDebut;
	}	

	/**
	 * Mutateurs de l'attribut dateRetour
	 * @param dateRetour Date
	 */
	public void setDateRetour(Date dateRetour){
		this.dateRetour=dateRetour;
	}
	
	/**
	 * Mutateurs de l'attribut dateRetourHeure
	 * @param dateRetourHeure int
	 */
	public void setDateRetourHeure(int dateRetourHeure){
		this.dateRetourHeure=dateRetourHeure;
	}
	
	/**
	 * Mutateurs de l'attribut dateRetourMinute
	 * @param dateRetourMinute int
	 */
	public void setDateRetourMinute(int dateRetourMinute){
		this.dateRetourMinute=dateRetourMinute;
	}
	
	/**
	 * Mutateurs de l'attribut motif
	 * @param motif String
	 */
	public void setMotif(String motif){
		this.motif=motif;
	}
	
	/**
	 * Mutateurs de l'attribut utilisateur
	 * @param utilisateur {@link Utilisateur}
	 */
	public void setUtilisateur(Utilisateur utilisateur){
		this.utilisateur=utilisateur;
	}
	
	/**
	 * Accesseur de l'attribut id
	 * @return int - Attribut id
	 */
	public int getId(){
		return id;
	}
	
	/**
	 * Accesseur de l'attribut dateDebut
	 * @return String - Attribut dateDebut au format jj/mm/yy
	 */
	public String getDateDebut(){
		DateFormat date = DateFormat.getDateInstance(DateFormat.SHORT);
		return date.format(dateDebut);
	}
	
	/**
	 * Accesseur de l'attribut dateRetour
	 * @return String - Attribut dateRetour au format jj/mm/yy
	 */
	public String getDateRetour(){
		DateFormat date = DateFormat.getDateInstance(DateFormat.SHORT);
		return date.format(dateRetour);
	}
	
	/**
	 * Accesseur de l'attribut dateRetourHeure
	 * @return String - Attribut dateRetourHeure
	 */
	public String getDateRetourHeure(){
		return dateRetourHeure < 10 ? "0" + dateRetourHeure : "" + dateRetourHeure;
	}
	
	/**
	 * Accesseur de l'attribut dateRetourMinute
	 * @return String - Attribut dateRetourMinute
	 */
	public String getDateRetourMinute(){
		return dateRetourMinute < 10 ? "0" + dateRetourMinute : "" + dateRetourMinute;
	}
	
	/** 
	 * Accesseur de l'attribut motif
	 * @return String - Attribut motif
	 */
	public String getMotif(){
		return motif;
	}
	
	/**
	 * Accesseur de l'attribut utilisateur
	 * @return {@link Utilisateur} - Attribut utilisateur
	 */
	public Utilisateur getUtilisateur(){
		return utilisateur;
	}
	
	/**
	 * Constructeur par défaut de Absence
	 */
	public Absence(){
		id=0;
		dateDebut=null;
		dateRetour=null;
		dateRetourHeure=0;
		dateRetourMinute=0;
		motif="";
		utilisateur= new Utilisateur();
	}
	
	/**
	 * Constructeur de Absence avec tous les paramètres.
	 * @param id int
	 * @param dateDebut Date
	 * @param dateRetour Date
	 * @param dateRetourHeure int
	 * @param dateretourMinute int
	 * @param motif String
	 * @param utilisateur {@link Utilisateur}
	 */
	public Absence(int id, Date dateDebut, Date dateRetour, int dateRetourHeure, int dateretourMinute, String motif, Utilisateur utilisateur){
		this.id=id;
		this.dateDebut=dateDebut;
		this.dateRetour=dateRetour;
		this.dateRetourHeure=dateRetourHeure;
		this.dateRetourMinute=dateretourMinute;
		this.motif=motif;
		this.utilisateur=utilisateur;
	}
	
	/**
	 * Constructeur de Absence avec quelques paramètres, ceux utiisés pour l'insertion en BDD.
	 * @param dateDebut Date
	 * @param dateRetour Date
	 * @param dateRetourHeure int
	 * @param dateRetourMinute int
	 * @param motif String
	 * @param utilisateur {@link Utilisateur}
	 */
	public Absence(Date dateDebut, Date dateRetour, int dateRetourHeure, int dateRetourMinute, String motif, Utilisateur utilisateur){
		this.dateDebut=dateDebut;
		this.dateRetour=dateRetour;
		this.dateRetourHeure=dateRetourHeure;
		this.dateRetourMinute=dateRetourMinute;
		this.motif=motif;
		this.utilisateur=utilisateur;
	}
}