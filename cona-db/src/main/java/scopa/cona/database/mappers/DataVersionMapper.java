package scopa.cona.database.mappers;


import scopa.cona.database.model.ConsumerDataVersion;
import scopa.cona.database.model.ProducerDataVersion;

import java.util.List;

public interface DataVersionMapper {
    public void insertDataVersionProducer(ProducerDataVersion pv);
    public void insertDataVersionConsumer(ConsumerDataVersion cv);
    public void updateDataVersionProduce(ProducerDataVersion pv);
    public void updateDataVersionConsumer(ConsumerDataVersion cv);
    public ProducerDataVersion selectDataVersionProduceById(Integer id);

    /**
     * 可以设置completed
     * @param pv
     * @return 结果根据id降序
     */
    public List<ProducerDataVersion> selectDataVersionProduceBySourceAndTable(ProducerDataVersion pv);
    public ConsumerDataVersion selectDataVersionConsumerById(Integer id);

    /**
     * 可以设置consumered
     * @param cv
     * @return 结果根据id降序
     */
    public List<ConsumerDataVersion> selectDataVersionConsumerByNameAndOrigId(ConsumerDataVersion cv);
}
