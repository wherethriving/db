package scopa.cona.database.mappers;

import scopa.cona.database.model.DataDictElement;

/**
 * Created by panda on 5/10/16.
 */
public interface DataDictElementMapper {
    DataDictElement selectDataDictElementfById(int dataDictElementId);
    void insertDataDictElement(DataDictElement DataDictElement);
    void updateDataDictElement(DataDictElement DataDictElement);
    void deleteDataDictElement(int dataDictElementId);
}
