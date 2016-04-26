package org.btssio.carnetnumerique.object;

public class Categorie {

	private int idCateg;
	private String libelle;
	
	public void setIdCateg(int idCateg){
		this.idCateg=idCateg;
	}
	
	public void setLibelle(String libelle){
		this.libelle=libelle;
	}
	
	public int getIdCateg(){
		return idCateg;
	}
	
	public String getLibelle(){
		return libelle;
	}
	
	public Categorie(){
		idCateg=0;
		libelle="";
	}
	
	public Categorie(int idCateg, String libelle){
		this.idCateg=idCateg;
		this.libelle=libelle;
	}
}
