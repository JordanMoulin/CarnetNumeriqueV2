package org.btssio.carnetnumerique.object;

public class Utilisateur {

	private int id;
	private String login;
	private String nom;
	private String prenom;
	private String mdp;
	private String classe;
	
	public void setId(int id){
		this.id=id;
	}

	public void setLogin(String login){
		this.login=login;
	}
	
	public void setNom(String nom){
		this.nom=nom;
	}
	
	public void setPrenom(String prenom){
		this.prenom=prenom;
	}
	
	public void setMdp(String mdp){
		this.mdp=mdp;
	}
	
	public void setClasse(String classe){
		this.classe=classe;
	}
	
	public int getId(){
		return id;
	}
	
	public String getLogin(){
		return login;
	}
	
	public String getNom(){
		return nom;
	}
	
	public String getPrenom(){
		return prenom;
	}
	
	public String getMdp(){
		return mdp;
	}
	
	public String getClasse(){
		return classe;
	}
	
	public Utilisateur(){
		id=0;
		login="";
		nom="";
		prenom="";
		mdp="";
		classe="";
	}
	
	public Utilisateur(int id, String login, String nom, String prenom, String mdp, String classe){
		this.id=id;
		this.login=login;
		this.nom=nom;
		this.prenom=prenom;
		this.mdp=mdp;
		this.classe=classe;
	}
}
