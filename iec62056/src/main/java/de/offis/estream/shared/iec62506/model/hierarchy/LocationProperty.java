package de.offis.estream.shared.iec62506.model.hierarchy;

import com.fasterxml.jackson.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LocationProperty implements IOptionalProperty<Coordinates>{

    private Coordinates coordinates;

    public LocationProperty() {
        this.coordinates = new Coordinates(0,0);
    }

    public LocationProperty(float lat, float lon) {
        this.coordinates = new Coordinates(lat, lon);
    }

    public LocationProperty(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setValue(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    @JsonGetter
    @Override
    public OptionalPropertyType getKey() {
        return OptionalPropertyType.location;
    }

    @Override
    public Coordinates getValue() {
        return this.coordinates;
    }
}

