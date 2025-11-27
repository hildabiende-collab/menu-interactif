package dao;

import entity.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FichierListRepository implements FichierRepository {

    private List<Fichier> fichiers = new ArrayList<>();

    // ========================
    //  MÉTHODES DE BASE
    // ========================

    @Override
    public void ajouter(Fichier f) {
        fichiers.add(f);
    }

    @Override
    public void afficher() {
        if (fichiers.isEmpty()) {
            System.out.println("Aucun fichier à afficher.");
            return;
        }

        for (Fichier f : fichiers) {
            f.afficher();
            System.out.println("------------------");
        }
    }

    @Override
    public void supprimer(String nom) {
        fichiers.removeIf(f -> f.getNom().equalsIgnoreCase(nom));
    }

    // =======================================
    //  SAUVEGARDE DES DONNÉES DANS UN .TXT
    // =======================================

    @Override
    public void sauvegarderTXT(String nomFichier) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(nomFichier))) {

            for (Fichier f : fichiers) {

                if (f instanceof Texte t) {
                    pw.println("TEXTE;" + t.getNom() + ";" + t.getTaille() + ";" +
                            t.getDateCreation() + ";" + t.getExtension() + ";0");
                }

                else if (f instanceof Image i) {
                    pw.println("IMAGE;" + i.getNom() + ";" + i.getTaille() + ";" +
                            i.getDateCreation() + ";" + i.getExtension() + ";" +
                            i.getResolution());
                }

                else if (f instanceof Audio a) {
                    pw.println("AUDIO;" + a.getNom() + ";" + a.getTaille() + ";" +
                            a.getDateCreation() + ";" + a.getExtension() + ";" +
                            a.getDuree());
                }

                else if (f instanceof Video v) {
                    pw.println("VIDEO;" + v.getNom() + ";" + v.getTaille() + ";" +
                            v.getDateCreation() + ";" + v.getExtension() + ";" +
                            v.getQualite());
                }
            }

            System.out.println("Sauvegarde TXT effectuée !");
        } catch (IOException e) {
            System.out.println("Erreur lors de la sauvegarde TXT : " + e.getMessage());
        }
    }

    // =======================================
    //  CHARGEMENT DES DONNÉES DEPUIS UN .TXT
    // =======================================

    @Override
    public void chargerTXT(String nomFichier) {
        fichiers.clear();

        try (BufferedReader br = new BufferedReader(new FileReader(nomFichier))) {

            String ligne;

            while ((ligne = br.readLine()) != null) {
                String[] tab = ligne.split(";");

                String type = tab[0];
                String nom = tab[1];
                double taille = Double.parseDouble(tab[2]);
                String date = tab[3];
                String ext = tab[4];
                String info = tab[5];

                switch (type) {
                    case "TEXTE" ->
                            fichiers.add(new Texte(nom, taille, date, ext));

                    case "IMAGE" ->
                            fichiers.add(new Image(nom, taille, date, ext,
                                    Integer.parseInt(info)));

                    case "AUDIO" ->
                            fichiers.add(new Audio(nom, taille, date, ext,
                                    Integer.parseInt(info)));

                    case "VIDEO" ->
                            fichiers.add(new Video(nom, taille, date, ext,
                                    Integer.parseInt(info)));
                }
            }

            System.out.println("Chargement TXT effectué !");
        } catch (IOException e) {
            System.out.println("Erreur lors du chargement TXT : " + e.getMessage());
        }
    }

    // =======================================
    //   MÉTHODES D’AJOUT AVEC SCANNER
    // =======================================

    public void ajouterTexte(Scanner sc) {
        System.out.print("Nom : ");
        String nom = sc.nextLine();

        System.out.print("Taille : ");
        double taille = Double.parseDouble(sc.nextLine());

        System.out.print("Date : ");
        String date = sc.nextLine();

        System.out.print("Extension : ");
        String ext = sc.nextLine();

        ajouter(new Texte(nom, taille, date, ext));
    }

    public void ajouterImage(Scanner sc) {
        System.out.print("Nom : ");
        String nom = sc.nextLine();

        System.out.print("Taille : ");
        double taille = Double.parseDouble(sc.nextLine());

        System.out.print("Date : ");
        String date = sc.nextLine();

        System.out.print("Extension : ");
        String ext = sc.nextLine();

        System.out.print("Résolution : ");
        int res = Integer.parseInt(sc.nextLine());

        ajouter(new Image(nom, taille, date, ext, res));
    }

    public void ajouterAudio(Scanner sc) {
        System.out.print("Nom : ");
        String nom = sc.nextLine();

        System.out.print("Taille : ");
        double taille = Double.parseDouble(sc.nextLine());

        System.out.print("Date : ");
        String date = sc.nextLine();

        System.out.print("Extension : ");
        String ext = sc.nextLine();

        System.out.print("Durée (sec) : ");
        int d = Integer.parseInt(sc.nextLine());

        ajouter(new Audio(nom, taille, date, ext, d));
    }

    public void ajouterVideo(Scanner sc) {
        System.out.print("Nom : ");
        String nom = sc.nextLine();

        System.out.print("Taille : ");
        double taille = Double.parseDouble(sc.nextLine());

        System.out.print("Date : ");
        String date = sc.nextLine();

        System.out.print("Extension : ");
        String ext = sc.nextLine();

        System.out.print("Qualité : ");
        int q = Integer.parseInt(sc.nextLine());

        ajouter(new Video(nom, taille, date, ext, q));
    }
}
