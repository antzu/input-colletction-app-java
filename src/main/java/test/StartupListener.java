package test;

import test.util.*;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebListener
public class StartupListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {

        String url = PropertyLoader.getProperty("javax.persistence.jdbc.url");
        String schema = FileUtil.readFileFromClasspath("schema.sql");

        try (Connection connection = DriverManager.getConnection(url)) {
            DbUtil.insertFromString(connection, schema);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        JpaUtil.closeFactory();
    }
}