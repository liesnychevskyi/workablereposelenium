package core.helpers.database;

import core.helpers.logger.MyLogger;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.TimeZone;


public class DatabaseHelper
{
    private static Logger log = MyLogger.getLogger(DatabaseHelper.class);
    private static String url = "jdbc:mysql://localhost:3306/my_family?serverTimezone=" + TimeZone.getDefault().getID();
   // private static String url = "jdbc:mysql://localhost/my_family"; // localhost
    private static String driverName = "com.mysql.jdbc.Driver";
    private static String userName = "root";
    private static String password = "";
    private static Connection connection;
    private static DatabaseHelper instance = null;
    //-------------------------------------------------------------//
    public DatabaseHelper()
    {
        connection = getSingleInstanceConnection();
    }
    //==============================================================//
        public  void LoadDriver()
        {
            try {
                // The newInstance() call is a work around for some
                // broken Java implementations

                Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            } catch (Exception ex)
            {
                // handle the error
            }
        }
    //==============================================================//
    public static DatabaseHelper getInstance()
    {
        if(instance == null)
        {
            instance = new DatabaseHelper();
        }
        return instance;
    }
    //=============================================================//
     /*
    This method will connect us to database
     */
    private Connection getSingleInstanceConnection()
    {
        try
        {
            Class.forName(driverName);
            try
            {
                Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                connection = DriverManager.getConnection(url, userName, password);
                if(connection != null)
                {
                    log.info("Connected to Person Base..");
                }
            }
            catch (SQLException e)
            {
                log.error("Failed to create Person Base connection.." + e);
            }
            catch (IllegalAccessException e)
            {
                e.printStackTrace();
            }
            catch (InstantiationException e)
            {
                e.printStackTrace();
            }
        }
        catch (ClassNotFoundException e)
        {
            log.info("Driver not found ");
        }
        return connection;
    }
    //================================================================//
    public Connection getConnection()
    {
        return connection;
    }
    //===============================================================//
    public static ResultSet getResultSet(String dbQuery)
    {
        instance = DatabaseHelper.getInstance();
        connection = instance.getConnection();
        log.info("Executing query: " + dbQuery);
        try
        {
            Statement stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery(dbQuery);
            return result;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

}
