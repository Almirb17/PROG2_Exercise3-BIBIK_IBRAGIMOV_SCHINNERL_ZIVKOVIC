package at.ac.fhcampuswien.fhmdb.repos;

import at.ac.fhcampuswien.fhmdb.database.DatabaseManager;
import at.ac.fhcampuswien.fhmdb.database.MovieEntity;
import at.ac.fhcampuswien.fhmdb.database.WatchlistMovieEntity;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;

import java.sql.SQLException;
import java.util.List;

public class WatchListRepository {
    static Dao<WatchlistMovieEntity, Long> dao;

    public WatchListRepository() throws SQLException {
        this.dao = DatabaseManager.getInstance().getWatchListDao();
    }

    public List<WatchlistMovieEntity> getWatchlist() throws SQLException {
        return dao.queryForAll();
    }

    public void removeFromWatchlist(WatchlistMovieEntity wme) throws SQLException {
        dao.delete(wme);
    }

    public void clearWatchlist() throws SQLException {
        dao.deleteBuilder().delete();
    }

    public void addToWatchlist(WatchlistMovieEntity wme) throws SQLException {
        dao.create(wme);
    }




}
