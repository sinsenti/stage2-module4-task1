package com.mjc.stage2.impl;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import com.mjc.stage2.ConnectionFactory;

public class H2ConnectionFactory implements ConnectionFactory {
  private Properties properties = new Properties();

  public H2ConnectionFactory() {
    try (InputStream input = getClass().getClassLoader().getResourceAsStream("h2database.properties")) {
      if (input == null) {
        throw new RuntimeException("Cannot find h2database.properties");
      }
      properties.load(input);
      Class.forName(properties.getProperty("jdbc_driver"));
    } catch (Exception e) {
      throw new RuntimeException("Failed to load database properties or driver", e);
    }
  }

  @Override
  public Connection createConnection() {
    try {
      return DriverManager.getConnection(
          properties.getProperty("db_url"),
          properties.getProperty("user"),
          properties.getProperty("password"));
    } catch (Exception e) {
      throw new RuntimeException("Failed to laod database , MY EXCEPTION");
    }
  }

}
