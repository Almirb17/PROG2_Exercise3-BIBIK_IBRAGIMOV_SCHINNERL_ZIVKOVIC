package at.ac.fhcampuswien.fhmdb.repos;

import at.ac.fhcampuswien.fhmdb.database.DatabaseManager;
import at.ac.fhcampuswien.fhmdb.database.MovieEntity;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieRepository {
    static Dao<MovieEntity, Long> dao;

    public MovieRepository() throws SQLException {
        this.dao = DatabaseManager.getInstance().getMovieDao();
    }

    public void addToMovies(Movie movie, long apild) throws SQLException
    {
        dao.create(movieToEntity(movie, apild));
    }

    public void removeFromMovies(Movie movie, long apild) throws SQLException
    {
        dao.delete(movieToEntity(movie, apild));
    }

    public List<Movie> getAllMovies() throws SQLException {
        List<MovieEntity> movieEntities = dao.queryForAll();
        List<Movie> movies = new ArrayList<>();
        //no streams --> because then I would have to handle SQL Exc locally
        for (MovieEntity movieEntity : movieEntities) {
            movies.add(EntityToMovie(movieEntity));
        }
        return movies;
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

    private Movie EntityToMovie(MovieEntity movieEntity) throws SQLException
    {
        return new Movie(
                movieEntity.getId(),
                movieEntity.getTitle(),
                movieEntity.getDescription(),
                movieEntity.getGenresListFromString(),
                movieEntity.getReleaseYear(),
                movieEntity.getImgUrl(),
                movieEntity.getLengthInMinutes(),
                movieEntity.getRating()
        );
    }
}
