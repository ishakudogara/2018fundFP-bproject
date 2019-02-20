package fr.epita.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

// TODO: Auto-generated Javadoc
/**
 * The Class Configuration.
 */
public class Configuration {

	
	/** The properties. */
	private Properties properties;
	
	/** The configuration. */
	private static Configuration configuration;

	/**
	 * Instantiates a new configuration.
	 */
	private Configuration() {
		try {
			properties.load(new FileInputStream(new File("application.properties")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Gets the single instance of Configuration.
	 *
	 * @return single instance of Configuration
	 */
	public static Configuration getInstance() {
		if (configuration == null) {
			configuration = new Configuration();
		}
		return configuration;
	}
	
	/**
	 * Gets the property value.
	 *
	 * @param key the key
	 * @return the property value
	 */
	public String getPropertyValue(String key) {
		return properties.getProperty(key);
	}
	
	
	
	
}
