package models;

import javax.persistence.Entity;

/**
 * Created by thomas on 27/05/15.
 */
@Entity
public class TravelPlace extends Content {
    private String description;
    private long latitude;
    private long longitude;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getLatitude() {
        return latitude;
    }

    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }

    public long getLongitude() {
        return longitude;
    }

    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }
}
