package object;

import java.text.DateFormat;
import java.util.Date;

/**
 * Classe Retard, contenant toutes les informations concernant un ticket de retard.
 * @author Erwan
 *
 */
public class Retard {

	private int id;
	private Date dater;
	private int duree;
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
	 * Mutateurs de l'attribut dater
	 * @param dater Date
	 */
	public void setDater(Date dater){
		this.dater=dater;
	}
	
	/**
	 * Mutateurs de l'attribut duree
	 * @param duree int
	 */
	public void setDuree(int duree){
		this.duree=duree;
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
	 * Accesseur de l'attribut dater
	 * @return String - Attribut dater au format jj/mm/yy
	 */
	public String getDater(){
		DateFormat date = DateFormat.getDateInstance(DateFormat.SHORT);
		return date.format(dater);
	}
	
	/**
	 * Accesseur de l'attribut duree
	 * @return int - Attribut duree
	 */
	public int getDuree(){
		return duree;
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
	 * Constructeur par défaut de Retard
	 */
	public Retard(){
		id=0;
		dater=null;
		duree=0;
		motif="";
		utilisateur= new Utilisateur();
	}
	
	/**
	 * Constructeur de Retard avec tous les paramètres.
	 * @param id int
	 * @param dater Date
	 * @param duree int
	 * @param motif String
	 * @param utilisateur {@link Utilisateur}
	 */
	public Retard(int id, Date dater, int duree, String motif, Utilisateur utilisateur){
		this.id=id;
		this.dater=dater;
		this.duree=duree;
		this.motif=motif;
		this.utilisateur=utilisateur;
	}
	
	/**
	 * Constructeur de Retard avec quelques paramètres, ceux utiisés pour l'insertion en BDD.
	 * @param duree int
	 * @param motif String
	 * @param utilisateur {@link Utilisateur}
	 */
	public Retard(int duree, String motif, Utilisateur utilisateur){
		this.duree=duree;
		this.motif=motif;
		this.utilisateur=utilisateur;
	}
	
}
