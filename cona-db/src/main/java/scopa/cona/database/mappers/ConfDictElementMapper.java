package scopa.cona.database.mappers;

import scopa.cona.database.model.ConfDictElement;

/**
 * Created by panda on 5/10/16.
 */
public interface ConfDictElementMapper {
    ConfDictElement selectConfDictElementById(int confDictElementId);
    void insertConfDictElement(ConfDictElement confDictElement);
    void updateConfDictElement(ConfDictElement confDictElement);
    void deleteConfDictElement(int confDictElementId);
}
