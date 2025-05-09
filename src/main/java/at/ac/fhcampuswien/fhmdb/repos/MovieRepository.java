package at.ac.fhcampuswien.fhmdb.repos;

import at.ac.fhcampuswien.fhmdb.database.DatabaseManager;
import at.ac.fhcampuswien.fhmdb.database.MovieEntity;
import at.ac.fhcampuswien.fhmdb.exceptions.DatabaseException;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieRepository {
    static Dao<MovieEntity, Long> dao;

    public MovieRepository() throws DatabaseException {
        this.dao = DatabaseManager.getInstance().getMovieDao();
    }

    public List<Movie> getAllMovies() throws DatabaseException {

        List<MovieEntity> movieEntities;
        try {
            movieEntities = dao.queryForAll();
        }
        catch (SQLException e) {
            throw new DatabaseException("Fehler beim Abruf der gesamten Movies", e);
        }

        List<Movie> movies = new ArrayList<>();
        //no streams --> because then I would have to handle SQL Exc locally
        for (MovieEntity movieEntity : movieEntities) {
            movies.add(EntityToMovie(movieEntity));
        }
        return movies;
    }

    public void deleteMovie(Movie movie) throws DatabaseException {
        try {
            dao.delete(movieToEntity(movie));
        }
        catch (SQLException e) {
            throw new DatabaseException("Fehler beim Löschen der Movie " + movie.toString(), e);
        }
    }

    public void clearMovies() throws DatabaseException {
        try {
            dao.deleteBuilder().delete();
        }
        catch (SQLException e) {
            throw new DatabaseException("Fehler beim Löschen aller Movies", e);
        }
    }

    public void addAllMovies(List<Movie> movies) throws DatabaseException {
        for(Movie movie : movies)
        {
            try {
                dao.create(movieToEntity(movie));
            }
            catch (SQLException e) {
                throw new DatabaseException("Fehler beim Anlegen der Movie " + movie.toString() + " von Liste", e);
            }
        }
    }


    //private
    private MovieEntity movieToEntity(Movie movie) throws DatabaseException {
        try {
        return new MovieEntity(
                movie.getId(),
                movie.getTitle(),
                movie.getDescription(),
                movie.getGenresAsString(),
                movie.getReleaseYear(),
                movie.getImgUrl(),
                movie.getLengthInMinutes(),
                movie.getRating()
        );
        }
        catch (Exception e) {
            throw new DatabaseException("Fehler beim Umwandeln Movie " + movie.toString() + " to Movie Entity", e);
        }
    }

    private Movie EntityToMovie(MovieEntity movieEntity) throws DatabaseException {
        try {
            return new Movie(
                    movieEntity.getApiId(),
                    movieEntity.getTitle(),
                    movieEntity.getDescription(),
                    movieEntity.getGenresListFromString(),
                    movieEntity.getReleaseYear(),
                    movieEntity.getImgUrl(),
                    movieEntity.getLengthInMinutes(),
                    movieEntity.getRating()
            );
        }
        catch (Exception e) {
            throw new DatabaseException("Fehler beim Umwandeln EntityMovie " + movieEntity.toString() + " to Movie", e);
        }
    }
}
