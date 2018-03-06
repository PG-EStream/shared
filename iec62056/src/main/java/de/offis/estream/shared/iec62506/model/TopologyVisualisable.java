package de.offis.estream.shared.iec62506.model;

import java.util.List;

/**
 * Created by viktorspadi on 06.03.18.
 */
public interface TopologyVisualisable {
    String getReference();
    List<String> getNodeIds();
}
