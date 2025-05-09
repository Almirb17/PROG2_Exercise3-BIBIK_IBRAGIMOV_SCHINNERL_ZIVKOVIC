package at.ac.fhcampuswien.fhmdb.database;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "watchlist")
public class WatchlistMovieEntity {
    //no duplicates for primary key
    @DatabaseField(canBeNull = false)
    private long id;

    @DatabaseField(canBeNull = false)
    private String apiId;

    public WatchlistMovieEntity() {}

    public WatchlistMovieEntity(long id, String apiId) {
        this.id = id;
        this.apiId = apiId;
    }

    @Override
    public String toString()
    {
        return "id: " + id + ", apiId: " + apiId;
    }
}
