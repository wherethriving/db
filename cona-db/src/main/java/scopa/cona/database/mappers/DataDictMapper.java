package scopa.cona.database.mappers;

import scopa.cona.database.model.DataDict;

/**
 * Created by panda on 5/10/16.
 */
public interface DataDictMapper {
    DataDict selectDataDictById(int dataDictId);
    void insertDataDict(DataDict dataDict);
    void updateDataDict(DataDict dataDict);
    void deleteDataDict(int dataDictId);
}
