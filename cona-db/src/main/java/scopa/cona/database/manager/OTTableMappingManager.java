package scopa.cona.database.manager;

import scopa.cona.database.model.OTTableMapping;

import java.util.List;
import java.util.Map;

/**
 * Created by panda on 5/10/16.
 */
public interface OTTableMappingManager {
    OTTableMapping selectOTTableMappingById(int otTableMappingId);
    void insertOTTableMapping(OTTableMapping otTableMapping);
    void updateOTTableMapping(OTTableMapping otTableMapping);
    void deleteOTTableMapping(int otTableMappingId);
    void addOTTableMappingByMappingList(List<Map<String, String>> otTableMappingList);
}
