package object;

/**
 * Classe Utilisateur, contenant toutes les informations concernant un utilisateur.
 * @author Erwan
 *
 */
public class Utilisateur {
/**
 * 
 * Propriétés
 * 
 */
	private String login;
	private String nom;
	private String prenom;
	private String mdp;
	private String classe;
	private int categ;
	
	/**
	 * Mutateurs de l'attribut login
	 * @param login String
	 */
	public void setLogin(String login){
		this.login=login;
	}
	
	/**
	 * Mutateurs de l'attribut nom
	 * @param nom String
	 */
	public void setNom(String nom){
		this.nom=nom;
	}
	
	/**
	 * Mutateurs de l'attribut prenom
	 * @param prenom String
	 */
	public void setPrenom(String prenom){
		this.prenom=prenom;
	}
	
	/**
	 * Mutateurs de l'attribut mdp
	 * @param mdp String
	 */
	public void setMdp(String mdp){
		this.mdp=mdp;
	}
	
	/**
	 * Mutateurs de l'attribut classe
	 * @param classe String
	 */
	public void setClasse(String classe){
		this.classe=classe;
	}
	
	/**
	 * Mutateurs de l'attribut categ
	 * @param categ int
	 */
	public void setCateg(int categ){
		this.categ=categ;
	}
	
	/**
	 * Accesseur de l'attribut login
	 * @return String - Attribut login
	 */
	public String getLogin(){
		return login;
	}
	
	/**
	 * Accesseur de l'attribut nom
	 * @return String - Attribut nom
	 */
	public String getNom(){
		return nom;
	}
	
	/**
	 * Accesseur de l'attribut prenom
	 * @return String - Attribut prenom
	 */
	public String getPrenom(){
		return prenom;
	}
	
	/**
	 * Accesseur de l'attribut mdp
	 * @return String - Attribut mdp
	 */
	public String getMdp(){
		return mdp;
	}
	
	/**
	 * Accesseur de l'attribut classe
	 * @return String - Attribut clasee
	 */
	public String getClasse(){
		return classe;
	}
	
	/**
	 * Accesseur de l'attribut categ
	 * @return int - Attribut categ
	 */
	public int getCateg(){
		return categ;
	}
	
	/**
	 * Constructeur par défaut de Utilisateur
	 */
	public Utilisateur(){
		login="";
		nom="";
		prenom="";
		mdp="";
		classe="";
		categ=0;
	}
	
	/**
	 * Constructeur de Utilisateur avec tous les paramètres.
	 * @param login String
	 * @param nom String
	 * @param prenom String
	 * @param mdp String
	 * @param classe String
	 * @param categ int
	 */
	public Utilisateur(String login, String nom, String prenom, String mdp, String classe, int categ){
		this.login=login;
		this.nom=nom;
		this.prenom=prenom;
		this.mdp=mdp;
		this.classe=classe;
		this.categ=categ;
	}
	
	/**
	 * Méthode permetant de réinitialiser à zéro un objet Utilisateur
	 * @return Utilisateur - Un nouvel objet Utilisateur vide
	 */
	public Utilisateur clean(){
		return new Utilisateur();
	}
}
