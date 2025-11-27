package entity;

public class Image extends Fichier implements Affichable {

    private int largeur;
    private int hauteur;

    public Image(String nom, double taille, String extension, int largeur, int hauteur) {
        super(nom, taille, extension);
        this.largeur = largeur;
        this.hauteur = hauteur;
    }

    @Override
    public void afficherInfos() {
        System.out.println("Image : " + nom + " (" + extension + "), " + taille + " Ko, " + largeur + "x" + hauteur);
    }
}
