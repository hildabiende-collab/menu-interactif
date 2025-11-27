package main;

import dao.FichierListRepository;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        FichierListRepository repo = new FichierListRepository();

        int choix;

        do {
            System.out.println("\n==== MENU GESTION DE FICHIERS ====");
            System.out.println("1. Ajouter un fichier texte");
            System.out.println("2. Ajouter une image");
            System.out.println("3. Ajouter un audio");
            System.out.println("4. Ajouter une vidéo");
            System.out.println("5. Afficher tous les fichiers");
            System.out.println("6. Supprimer un fichier");
            System.out.println("7. Sauvegarder en TXT");
            System.out.println("8. Charger depuis TXT");
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");

            choix = Integer.parseInt(sc.nextLine());

            switch (choix) {

                case 1 -> repo.ajouterTexte(sc);

                case 2 -> repo.ajouterImage(sc);

                case 3 -> repo.ajouterAudio(sc);

                case 4 -> repo.ajouterVideo(sc);

                case 5 -> repo.afficher();

                case 6 -> {
                    System.out.print("Nom du fichier à supprimer : ");
                    String nom = sc.nextLine();
                    repo.supprimer(nom);
                }

                case 7 -> {
                    System.out.print("Nom du fichier TXT à sauvegarder : ");
                    String nomFichier = sc.nextLine();
                    repo.sauvegarderTXT(nomFichier);
                }

                case 8 -> {
                    System.out.print("Nom du fichier TXT à charger : ");
                    String nomFichier = sc.nextLine();
                    repo.chargerTXT(nomFichier);
                }

                case 0 -> System.out.println("Au revoir 👋");

                default -> System.out.println("Choix invalide !");
            }

        } while (choix != 0);
    }
}
