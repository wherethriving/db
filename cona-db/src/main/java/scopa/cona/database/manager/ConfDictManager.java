package scopa.cona.database.manager;

import scopa.cona.database.model.ConfDict;

/**
 * Created by panda on 5/10/16.
 */
public interface ConfDictManager {
    ConfDict selectConfDictById(int confDictId);
    void insertConfDict(ConfDict confDict);
    void updateConfDict(ConfDict confDict);
    void deleteConfDict(int confDictId);
}
