package entity;

public class Audio extends Fichier implements Affichable, Lisible {

    private double duree; // secondes

    public Audio(String nom, double taille, String extension, double duree) {
        super(nom, taille, extension);
        this.duree = duree;
    }

    @Override
    public void afficherInfos() {
        System.out.println("Audio : " + nom + " (" + extension + "), " + taille + " Ko, durée : " + duree + " sec");
    }

    @Override
    public void lire() {
        System.out.println("Lecture de l'audio : " + nom);
    }
}
