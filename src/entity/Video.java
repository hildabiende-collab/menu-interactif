package entity;

public class Video extends Fichier {
    private int qualite; // ex : 720, 1080

    public Video(String nom, double taille, String dateCreation, String extension, int qualite) {
        super(nom, taille, dateCreation, extension);
        this.qualite = qualite;
    }

    public int getQualite() { return qualite; }
    public void setQualite(int qualite) { this.qualite = qualite; }

    @Override
    public void afficher() {
        System.out.println("=== Fichier Vidéo ===");
        System.out.println("Nom : " + nom);
        System.out.println("Taille : " + taille + " KB");
        System.out.println("Date : " + dateCreation);
        System.out.println("Extension : " + extension);
        System.out.println("Qualité : " + qualite);
    }
}
