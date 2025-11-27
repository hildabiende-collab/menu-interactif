package entity;

public class Video extends Fichier implements Affichable, Lisible {

    private double duree; // secondes

    public Video(String nom, double taille, String extension, double duree) {
        super(nom, taille, extension);
        this.duree = duree;
    }

    @Override
    public void afficherInfos() {
        System.out.println("Vidéo : " + nom + " (" + extension + "), " + taille + " Ko, durée : " + duree + " sec");
    }

    @Override
    public void lire() {
        System.out.println("Lecture de la vidéo : " + nom);
    }
}
