package nl.fizzylogic.intentify.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * Contains application configuration settings
 */
public class Configuration {
    @SuppressWarnings("squid:S1313")
    private static final String DEFAULT_DATABASE_HOST = "127.0.0.1";

    @SuppressWarnings("squid:S1313")
    private static final String DEFAULT_KEYSPACE = "intentify";

    private final Properties properties = new Properties();

    /**
     * Initializes a new instance of {@link Configuration}
     *
     * @throws IOException Gets thrown when the configuration could not be loaded
     */
    public Configuration() throws IOException {
        properties.putAll(loadFromResources());
        properties.putAll(loadFromFile());
    }

    /**
     * Gets the hostnames of the databases to connect to
     * @return  Returns the configured hostnames
     */
    public final String[] getCassandraHostnames() {
        return properties.getProperty("database.hostnames", DEFAULT_DATABASE_HOST).split(",");
    }

    /**
     * Gets the name of the keyspace to use
     * @return  The keyspace to use
     */
    public final String getKeyspace() {
        return properties.getProperty("database.keyspace", DEFAULT_KEYSPACE);
    }

    /**
     * Loads configuration properties from a local resource
     *
     * @return The configured properties based on the resource file
     * @throws IOException Gets thrown when the resource file doesn't exist
     */
    private Properties loadFromResources() throws IOException {
        Properties props = new Properties();

        try (InputStream propertyStream = getClass().getClassLoader().getResourceAsStream("default.properties")) {
            if (propertyStream != null) {
                props.load(propertyStream);
            }
        }

        return props;
    }

    /**
     * Loads configuration properties from a local file on disk
     *
     * @return The configured properties based on the file
     * @throws IOException Gets thrown when the file could not be read
     */
    private Properties loadFromFile() throws IOException {
        Properties props = new Properties();
        Path filePath = Paths.get("intentify.properties");

        if (!Files.exists(filePath)) {
            return props;
        }

        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            props.load(reader);
        }

        return props;
    }
}
