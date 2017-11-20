package de.offis.estream.shared.iec62506.model.hierarchy;

import com.fasterxml.jackson.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseHierarchyNode implements IHierarchyNode<String> {

    @JsonProperty("id")
    private final String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("children")
    private Collection<IHierarchyNode> children;

    @JsonProperty("properties")
    private Map<OptionalPropertyType, IOptionalProperty> properties;

    @JsonProperty("type")
    private final HierarchyNodeType type;


    public BaseHierarchyNode(HierarchyNodeType type, String id) {
        this.type = type;
        this.id = id;
        this.properties = new HashMap<>();
        this.children = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setChildren(Collection<IHierarchyNode> children) {
        this.children = children;
    }

    public void setProperties(Map<OptionalPropertyType, IOptionalProperty> properties) {
        this.properties = properties;
    }

    public void addChild(IHierarchyNode node) {
        this.children.add(node);
    }

    public void addProperty(IOptionalProperty property) {
        this.properties.put(property.getKey(), property);
    }

    public boolean removeProperty(IOptionalProperty property) {
        return this.properties.remove(property.getKey()) != null;
    }

    public boolean removeProperty(String key) {
        return this.properties.remove(key) != null;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Collection<IHierarchyNode> getChildren() {
        return children;
    }

    @Override
    public HierarchyNodeType getType() {
        return type;
    }

    @Override
    public Collection<IOptionalProperty> getProperties() {
        return this.properties.values();
    }
}
