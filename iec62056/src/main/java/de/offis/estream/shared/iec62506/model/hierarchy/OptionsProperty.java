package de.offis.estream.shared.iec62506.model.hierarchy;

import java.util.HashMap;
import java.util.Map;

public class OptionsProperty implements IOptionalProperty<Map<String, Object>> {

    private Map<String, Object> options;

    public OptionsProperty() {
        this.options = new HashMap<>();
    }

    public void setOption(String key, String value) {
        this.options.put(key, value);
    }

    private boolean removeOption(String key) {
        return this.options.remove(key) != null;
    }

    @Override
    public OptionalPropertyType getKey() {
        return OptionalPropertyType.options;
    }

    @Override
    public Map<String, Object> getValue() {
        return this.options;
    }
}
