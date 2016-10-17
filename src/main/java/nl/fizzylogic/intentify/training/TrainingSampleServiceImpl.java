package nl.fizzylogic.intentify.training;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.PoolingOptions;
import com.datastax.driver.core.querybuilder.Insert;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import nl.fizzylogic.intentify.entities.TrainingSample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    @SafeVarargs
    private static <T> List<T> listOf(T... items) {
        List<T> results = new ArrayList<>(items.length);
        Collections.addAll(results, items);

        return results;
    }
}
