package nl.fizzylogic.intentify.training;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.PoolingOptions;
import com.datastax.driver.core.querybuilder.Delete;
import com.datastax.driver.core.querybuilder.Insert;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import nl.fizzylogic.intentify.entities.TrainingSample;

import static nl.fizzylogic.intentify.common.CollectionUtils.*;

/**
 * Implementation of the {@link TrainingSampleService}
 */
public class TrainingSampleServiceImpl implements TrainingSampleService {

    private final Cluster cluster;
    private final String databaseName;

    /**
     * Initializes a new instance of {@link TrainingSampleServiceImpl}
     *
     * @param databaseName    Name of the keyspace to connect to
     * @param serverAddresses List of server addresses for the cassandra cluster
     */
    public TrainingSampleServiceImpl(String databaseName, String... serverAddresses) {
        this.databaseName = databaseName;
        PoolingOptions poolingOptions = new PoolingOptions();

        cluster = Cluster.builder()
                .addContactPoints(serverAddresses)
                .withPoolingOptions(poolingOptions)
                .build();
    }

    /**
     * Stores a sample in cassandra the data store
     *
     * @param sample Sample to store
     */
    @Override
    public void storeSample(TrainingSample sample) {
        Insert statement = QueryBuilder
                .insertInto(databaseName, "samples")
                .values(
                        listOf("intent", "text"),
                        listOf(sample.getIntent(), sample.getText())
                );

        cluster.connect().execute(statement);
    }

    /**
     * Deletes all stored samples from the cassandra data store
     */
    @Override
    public void reset() {
        Delete statement = QueryBuilder.delete().from(databaseName, "samples");
        cluster.connect().execute(statement);
    }


}
