package at.ac.fhcampuswien.fhmdb.repos;

import at.ac.fhcampuswien.fhmdb.database.DatabaseManager;
import at.ac.fhcampuswien.fhmdb.database.MovieEntity;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;

import java.sql.SQLException;
import java.util.List;

public class MovieRepository {
    static Dao<MovieEntity, Long> dao;

    public MovieRepository() throws SQLException {
        this.dao = DatabaseManager.getInstance().getDao();
    }

    public void addToMovies(Movie movie, long apild) throws SQLException
    {
        dao.create(movieToEntity(movie, apild));
    }

    public void removeFromMovies(Movie movie, long apild) throws SQLException
    {
        dao.delete(movieToEntity(movie, apild));
    }

    public List<MovieEntity> getAllMovies() throws SQLException
    {
        return dao.queryForAll();
    }

    private MovieEntity movieToEntity(Movie movie, long apild) throws SQLException
    {
        return new MovieEntity(
                apild,
                movie.getTitle(),
                movie.getDescription(),
                movie.getGenresAsString(),
                movie.getReleaseYear(),
                movie.getImgUrl(),
                movie.getLengthInMinutes(),
                movie.getRating()
        );
    }

    private MovieEntity EntityToMovie(Movie movie, long apild) throws SQLException
    {
        return new MovieEntity(
                apild,
                movie.getTitle(),
                movie.getDescription(),
                movie.getGenresAsString(),
                movie.getReleaseYear(),
                movie.getImgUrl(),
                movie.getLengthInMinutes(),
                movie.getRating()
        );
    }
}
