package entity;

public class Image extends Fichier {
    private int resolution;

    public Image(String nom, double taille, String dateCreation, String extension, int resolution) {
        super(nom, taille, dateCreation, extension);
        this.resolution = resolution;
    }

    public int getResolution() { return resolution; }
    public void setResolution(int resolution) { this.resolution = resolution; }

    @Override
    public void afficher() {
        System.out.println("=== Fichier Image ===");
        System.out.println("Nom : " + nom);
        System.out.println("Taille : " + taille + " KB");
        System.out.println("Date : " + dateCreation);
        System.out.println("Extension : " + extension);
        System.out.println("Résolution : " + resolution);
    }
}
