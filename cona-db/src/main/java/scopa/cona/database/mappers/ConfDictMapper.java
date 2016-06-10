package scopa.cona.database.mappers;

import scopa.cona.database.model.ConfDict;

/**
 * Created by panda on 5/10/16.
 */
public interface ConfDictMapper {
    ConfDict selectConfDictById(int confDictId);
    void insertConfDict(ConfDict confDict);
    void updateConfDict(ConfDict confDict);
    void deleteConfDict(int confDictId);
}
