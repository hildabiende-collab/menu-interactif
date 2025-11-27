package entity;

public class Audio extends Fichier {
    private int duree; // secondes

    public Audio(String nom, double taille, String dateCreation, String extension, int duree) {
        super(nom, taille, dateCreation, extension);
        this.duree = duree;
    }

    public int getDuree() { return duree; }
    public void setDuree(int duree) { this.duree = duree; }

    @Override
    public void afficher() {
        System.out.println("=== Fichier Audio ===");
        System.out.println("Nom : " + nom);
        System.out.println("Taille : " + taille + " KB");
        System.out.println("Date : " + dateCreation);
        System.out.println("Extension : " + extension);
        System.out.println("Durée : " + duree + " sec");
    }
}
