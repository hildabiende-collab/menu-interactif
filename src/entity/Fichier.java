package entity;

public abstract class Fichier {
    protected String nom;
    protected double taille; // en KB
    protected String dateCreation;
    protected String extension;

    public Fichier(String nom, double taille, String dateCreation, String extension){
        this.nom = nom;
        this.taille = taille;
        this.dateCreation = dateCreation;
        this.extension = extension;
    }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public double getTaille() { return taille; }
    public void setTaille(double taille) { this.taille = taille; }

    public String getDateCreation() { return dateCreation; }
    public void setDateCreation(String dateCreation) { this.dateCreation = dateCreation; }

    public String getExtension() { return extension; }
    public void setExtension(String extension) { this.extension = extension; }

    public void description() {
        System.out.println("Nom : " + nom);
        System.out.println("Taille (KB) : " + taille);
        System.out.println("Date de création : " + dateCreation);
        System.out.println("Extension : " + extension);
    }
    public abstract void afficher();
}
