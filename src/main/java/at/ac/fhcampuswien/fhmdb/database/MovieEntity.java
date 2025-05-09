package at.ac.fhcampuswien.fhmdb.database;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "movie")
public class MovieEntity {

    //no duplicates for primary key
    @DatabaseField(generatedId = true)
    private long id;

    //column name = attribute name (per default)
    @DatabaseField()
    private long apild;

    @DatabaseField()
    private String title;

    @DatabaseField()
    private String description;

    @DatabaseField()
    private String genres;

    @DatabaseField()
    private int releaseYear;

    @DatabaseField()
    private String imgUrl;

    @DatabaseField()
    private int lengthInMinutes;

    @DatabaseField()
    private double rating;


    public MovieEntity() {}

    public MovieEntity(long apild, String title, String description, String genres, int releaseYear, String imgUrl, int lengthInMinutes, double rating) {
        this.apild = apild;
        this.title = title;
        this.description = description;
        this.genres = genres;
        this.releaseYear = releaseYear;
        this.imgUrl = imgUrl;
        this.lengthInMinutes = lengthInMinutes;
        this.rating = rating;
    }
}
