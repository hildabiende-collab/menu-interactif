import entity.*;
import dao.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        FichierRepository repo = new FichierListRepository();

        if (repo.load() == null) {
            repo.save(new ArrayList<>());
        }

        List<Fichier> fichiers = repo.load();

        int choix;
        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Ajouter un fichier");
            System.out.println("2. Afficher tous les fichiers");
            System.out.println("3. Modifier le nom d'un fichier");
            System.out.println("4. Supprimer un fichier");
            System.out.println("0. Quitter");
            System.out.print("Choix : ");

            choix = sc.nextInt();
            sc.nextLine();

            switch (choix) {

                case 1 -> {
                    System.out.print("Type de fichier (texte/image/audio/video) : ");
                    String type = sc.nextLine();

                    System.out.print("Nom : ");
                    String nom = sc.nextLine();

                    System.out.print("Taille (Ko) : ");
                    double taille = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Extension : ");
                    String ext = sc.nextLine();

                    switch (type.toLowerCase()) {
                        case "texte" -> {
                            System.out.print("Nombre de caractères : ");
                            int nbCaract = sc.nextInt();
                            sc.nextLine();
                            fichiers.add(new Texte(nom, taille, ext, nbCaract));
                        }
                        case "image" -> {
                            System.out.print("Largeur : ");
                            int largeur = sc.nextInt();
                            System.out.print("Hauteur : ");
                            int hauteur = sc.nextInt();
                            sc.nextLine();
                            fichiers.add(new Image(nom, taille, ext, largeur, hauteur));
                        }
                        case "audio" -> {
                            System.out.print("Durée (sec) : ");
                            double duree = sc.nextDouble();
                            sc.nextLine();
                            fichiers.add(new Audio(nom, taille, ext, duree));
                        }
                        case "video" -> {
                            System.out.print("Durée (sec) : ");
                            double duree = sc.nextDouble();
                            sc.nextLine();
                            fichiers.add(new Video(nom, taille, ext, duree));
                        }
                        default -> System.out.println("Type inconnu !");
                    }

                    repo.save(fichiers);
                }

                case 2 -> {
                    if (fichiers.isEmpty()) {
                        System.out.println("Aucun fichier disponible !");
                    } else {
                        System.out.println("=== Liste des fichiers ===");
                        for (Fichier f : fichiers) {
                            if (f instanceof Affichable aff) {
                                aff.afficherInfos();
                            } else {
                                System.out.println(f.getClass().getSimpleName() + " : " + f.getNom());
                            }
                        }
                    }
                }

                case 3 -> {
                    System.out.print("Nom actuel du fichier : ");
                    String oldNom = sc.nextLine();
                    Fichier fModif = fichiers.stream()
                            .filter(f -> f.getNom().equalsIgnoreCase(oldNom))
                            .findFirst().orElse(null);

                    if (fModif != null) {
                        System.out.print("Nouveau nom : ");
                        String newNom = sc.nextLine();
                        fModif.setNom(newNom);
                        repo.save(fichiers);
                        System.out.println("Nom modifié !");
                    } else {
                        System.out.println("Fichier introuvable !");
                    }
                }

                case 4 -> {
                    System.out.print("Nom du fichier à supprimer : ");
                    String nomSuppr = sc.nextLine();
                    Fichier fSuppr = fichiers.stream()
                            .filter(f -> f.getNom().equalsIgnoreCase(nomSuppr))
                            .findFirst().orElse(null);

                    if (fSuppr != null) {
                        fichiers.remove(fSuppr);
                        repo.save(fichiers);
                        System.out.println("Fichier supprimé !");
                    } else {
                        System.out.println("Fichier introuvable !");
                    }
                }

                case 0 -> System.out.println("Au revoir !");
                default -> System.out.println("Choix invalide !");
            }

        } while (choix != 0);

        sc.close();
    }
}
