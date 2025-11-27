package dao;

import entity.Fichier;

public interface FichierRepository {

    void ajouter(Fichier f);

    void afficher();

    void supprimer(String nom);

    void sauvegarderTXT(String nomFichier);

    void chargerTXT(String nomFichier);
}
