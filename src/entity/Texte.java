package entity;

public class Texte extends Fichier {

    public Texte(String nom, double taille, String dateCreation, String extension) {
        super(nom, taille, dateCreation, extension);

    }

    @Override
    public void afficher() {
        System.out.println("=== Fichier Texte ===");
        System.out.println("Nom : " + nom);
        System.out.println("Taille : " + taille + "KB");
        System.out.println("Date : " + dateCreation);
        System.out.println("Extension : " + extension);
    }
}
