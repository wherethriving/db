package scopa.cona.database.manager;

import scopa.cona.database.model.AttrConf;

/**
 * Created by panda on 5/10/16.
 */
public interface AttrConfManager {
    AttrConf selectAttrConfById(int attrConfId);
    void insertAttrConf(AttrConf attrConf);
    void updateAttrConf(AttrConf attrConf);
    void deleteAttrConf(int attrConfId);
}
