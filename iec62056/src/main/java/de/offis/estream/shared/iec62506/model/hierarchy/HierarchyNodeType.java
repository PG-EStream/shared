package de.offis.estream.shared.iec62506.model.hierarchy;

public enum HierarchyNodeType {
    // add other types here, js runtime has no real reflection
    ROOT,
    SUBGRID,
    TRANSFORMATOR,
    NODE,
    SMGW,
    SMART_METER;
}
