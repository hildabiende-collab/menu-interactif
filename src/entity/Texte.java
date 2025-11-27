package entity;

public class Texte extends Fichier implements Affichable, Lisible {

    private int nbCaracteres;

    public Texte(String nom, double taille, String extension, int nbCaracteres) {
        super(nom, taille, extension);
        this.nbCaracteres = nbCaracteres;
    }

    @Override
    public void afficherInfos() {
        System.out.println("Texte : " + nom + " (" + extension + "), " + taille + " Ko, " + nbCaracteres + " caractères");
    }

    @Override
    public void lire() {
        System.out.println("Lecture du texte : " + nom);
    }
}
