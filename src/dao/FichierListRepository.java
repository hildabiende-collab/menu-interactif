package dao;

import entity.Fichier;
import java.util.List;

public class FichierListRepository implements FichierRepository {

    private List<Fichier> fichiers;

    @Override
    public void save(List<Fichier> fichiers) {
        this.fichiers = fichiers; // on sauvegarde la liste en mémoire
    }

    @Override
    public List<Fichier> load() {
        return fichiers; // on renvoie la liste sauvegardée
    }
}
