package de.offis.estream.shared.iec62506.model.hierarchy;

import com.fasterxml.jackson.annotation.JsonGetter;

import java.util.Collection;

public interface IHierarchyNode<T> {
    @JsonGetter
    String getId();

    @JsonGetter
    String getName();

    @JsonGetter
    Collection<IHierarchyNode> getChildren();

    @JsonGetter
    HierarchyNodeType getType();

    @JsonGetter
    Collection<IOptionalProperty> getProperties();
}
