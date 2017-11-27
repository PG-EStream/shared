package de.offis.estream.shared.iec62506.model.hierarchy;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Coordinates {
    @JsonProperty("lat")
    private float lat;
    @JsonProperty("lon")
    private float lon;


    public Coordinates(float lat, float lon) {
        this.lat = lat;
        this.lon = lon;
    }

    @JsonGetter
    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    @JsonGetter
    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }
}
