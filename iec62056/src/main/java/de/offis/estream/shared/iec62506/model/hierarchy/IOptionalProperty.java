package de.offis.estream.shared.iec62506.model.hierarchy;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

public interface IOptionalProperty<T> {
    @JsonGetter
    OptionalPropertyType getKey();

    @JsonGetter
    T getValue();
}
