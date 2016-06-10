package scopa.cona.database.manager;

import scopa.cona.database.model.ConfDictElement;

/**
 * Created by panda on 5/10/16.
 */
public interface ConfDictElementManager {
    ConfDictElement selectConfDictElementById(int confDictElementId);
    void insertConfDictElement(ConfDictElement confDictElement);
    void updateConfDictElement(ConfDictElement confDictElement);
    void deleteConfDictElement(int confDictElementId);
}
