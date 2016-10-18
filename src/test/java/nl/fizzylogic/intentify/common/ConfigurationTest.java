package nl.fizzylogic.intentify.common;

import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class ConfigurationTest {
    @Test
    public void loadConfigurationReturnsValidConfigObject() throws Exception {
        Configuration configuration = new Configuration();

        assertThat(configuration.getCassandraHostnames(), is(notNullValue()));
        assertThat(configuration.getKeyspace(), equalTo("intentify"));
    }

    @Test
    public void loadConfigurationFromFileReturnsValidConfigObject() throws Exception {
        try {
            byte[] data = "database.hostnames=127.0.1.0\r\ndatabase.keyspace=sample\r\n".getBytes();
            Files.write(Paths.get("intentify.properties"), data);

            Configuration configuration = new Configuration();

            String[] expectedResults = { "127.0.1.0" };

            assertThat(configuration.getCassandraHostnames(), equalTo(expectedResults));
            assertThat(configuration.getKeyspace(), equalTo("sample"));
        } finally {
            Files.delete(Paths.get("intentify.properties"));
        }
    }
}
