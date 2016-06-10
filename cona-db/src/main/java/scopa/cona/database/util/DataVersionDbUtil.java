package scopa.cona.database.util;

import scopa.cona.database.manager.DataVersionManager;
import scopa.cona.database.model.ConsumerDataVersion;
import scopa.cona.database.model.ProducerDataVersion;

import java.util.Date;
import java.util.List;

/**
 * Created by zhangdekun on 16-5-9.
 */
public class DataVersionDbUtil {
    private static DataVersionManager DataVersionManager = DBeans.bean(DataVersionManager.class);
    /**
     * 这个source和table下最近最新完成的版本
     * @param sourceId
     * @param tableId
     * @return
     */
    public static ProducerDataVersion getOldLastProducerVersion(Integer sourceId,Integer tableId){
        return DataVersionManager.getOldlastProducerVersion(sourceId,tableId,true);
    }

    /**
     * 刷新数据库
     * @param id 存在时更新，不存在时添加
     * @param sourceId
     * @param tableId
     * @param version
     * @param completed
     * @param start
     * @param end
     * @param completedTime
     */
    public static void flushProducerVersion(Integer id,Integer sourceId,Integer tableId,Integer version,Boolean completed,Object start,Object end,Date completedTime){
        if(id==null){
            DataVersionManager.addDataVersionProducer(sourceId,tableId,version,start,end);
        }else {
            DataVersionManager.updateDataVersionProducer(id,version,start,end,completed,completedTime);
        }
    }

    /**
     *
     * @param id
     * @param sourceId
     * @param tableId
     * @param consumerName
     * @param versionProduerId
     * @param version
     * @param consumered
     * @param consumeredTime
     */
    public static void flushConsumerVersion(Integer id,Integer sourceId,Integer tableId,String consumerName, Integer versionProduerId, Integer version, Boolean consumered, Date consumeredTime){
        if(id==null){
            DataVersionManager.addDataVersionConsumer(sourceId,tableId,consumerName,versionProduerId,version);
        }else {
            DataVersionManager.updateDataVersionConsumer(id,consumerName,versionProduerId,version,consumered,consumeredTime);
        }
    }
    public static List<ConsumerDataVersion> consumeredList(Integer sourceId, Integer tableId, String consumerName, Boolean consumered) {
        return DataVersionManager.consumeredList(sourceId,tableId,consumerName,consumered);
    }
    public static List<ProducerDataVersion> producerList(Integer sourceId, Integer tableId, Boolean completed) {
        return DataVersionManager.producerList(sourceId,tableId,completed);
    }
}
