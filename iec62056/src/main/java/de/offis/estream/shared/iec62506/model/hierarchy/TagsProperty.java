package de.offis.estream.shared.iec62506.model.hierarchy;

import java.util.HashMap;
import java.util.Map;

public class TagsProperty implements IOptionalProperty<Map<String, String>> {
    private Map<String, String> tags;

    public TagsProperty() {
        this.tags = new HashMap<>();
    }

    public void setTag(String key, String value) {
        this.tags.put(key, value);
    }

    private boolean removeTag(String key) {
        return this.tags.remove(key) != null;
    }

    @Override
    public OptionalPropertyType getKey() {
        return OptionalPropertyType.tags;
    }

    @Override
    public Map<String, String> getValue() {
        return tags;
    }
}
