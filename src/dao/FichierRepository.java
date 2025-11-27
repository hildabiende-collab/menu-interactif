package dao;

import entity.Fichier;
import java.util.List;

public interface FichierRepository {
    void save(List<Fichier> fichiers);
    List<Fichier> load();
}
