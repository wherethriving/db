package scopa.cona.database.manager;

import scopa.cona.database.model.DataDictElement;

/**
 * Created by panda on 5/10/16.
 */
public interface DataDictElementManager {
    DataDictElement selectDataDictElementfById(int dataDictElementId);
    void insertDataDictElement(DataDictElement dataDictElement);
    void updateDataDictElement(DataDictElement dataDictElement);
    void deleteDataDictElement(int dataDictElementId);
}
