package at.ac.fhcampuswien.fhmdb.database;

import at.ac.fhcampuswien.fhmdb.models.Movie;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

public class DatabaseManager {
    public static final String DB_URL = "jdbc:h2:file:./db/moviedb";
    public static final String DB_USER = "ms";
    public static final String DB_PASSWORD = "1234";

    private static ConnectionSource connectionSource;
    private static Dao<MovieEntity, Long> dao;
    private static DatabaseManager instance;

    //private --> can not use "new" for instance
    private DatabaseManager() throws SQLException {
        createConnectionSource();
        dao = DaoManager.createDao(connectionSource, MovieEntity.class);
        createTables();
    }

    //for creation / getter
    public static DatabaseManager getInstance() throws SQLException {
        if(instance == null){
            instance = new DatabaseManager();
        }

        return instance;
    }

    public Dao<MovieEntity, Long> getDao()
    {
        return dao;
    }

    //private methods
    private static void createTables() throws SQLException {
        TableUtils.createTableIfNotExists(connectionSource, MovieEntity.class);
    }

    private static void createConnectionSource() throws SQLException {
        connectionSource = new JdbcConnectionSource(DB_URL, DB_USER, DB_PASSWORD);
    }
}
