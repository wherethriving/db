package scopa.cona.database.manager;

import scopa.cona.database.model.DataDict;

/**
 * Created by panda on 5/10/16.
 */
public interface DataDictManager {
    DataDict selectDataDictById(int dataDictId);
    void insertDataDict(DataDict dataDict);
    void updateDataDict(DataDict dataDict);
    void deleteDataDict(int dataDictId);
}
