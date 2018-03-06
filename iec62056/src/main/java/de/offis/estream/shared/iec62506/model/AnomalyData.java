package de.offis.estream.shared.iec62506.model;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonPropertyOrder({
	"score",
	"features"
})
public class AnomalyData extends Result implements TopologyVisualisable{

	@JsonProperty("score")
	private Double score;
	
	@JsonProperty("features")
	private Collection<String> features;

	@JsonProperty("reference")
	private String reference;

	@JsonProperty("nodeIds")
	private List<String> nodeIds;

	public AnomalyData() {
		this.features = new ArrayList<>();
		this.nodeIds = new ArrayList<>();
		this.score = Double.valueOf(0);
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public void setNodeIds(List<String> nodeIds) {
		this.nodeIds = nodeIds;
	}

	@JsonGetter
	public Double getScore() {
		return score;
	}

	@JsonSetter
	public void setScore(Double score) {
		this.score = score;
	}
	
	@JsonGetter
	public Collection<String> getFeatures() {
		return features;
	}

	@JsonSetter
	public void setFeatures(Collection<Object> features) {
		this.features = features.stream().map(e -> e.toString()).collect(Collectors.toList());
	}

	@SuppressWarnings("unchecked")
	@Override
	public void setValues(Map<String, Object> values) {
		for(Entry<String, Object> e : values.entrySet()) {
			if (getSchema().get(SCORE).equalsIgnoreCase(e.getKey())) {
				setScore((Double) e.getValue());
			} else if (getSchema().get(FEATURES).equalsIgnoreCase(e.getKey())) {
				setFeatures((Collection<Object>) e.getValue());
			} else if (getSchema().get(REFERENCE).equalsIgnoreCase(e.getKey())) {
				setReference((String) e.getValue());
			} else if (getSchema().get(NODE_IDS).equalsIgnoreCase(e.getKey())) {
				setNodeIds((List<String>) e.getValue());
			}
		}
	}
	
	private final String SCORE = "score";
	private final String FEATURES = "features";
	private final String REFERENCE = "reference";
	private final String NODE_IDS = "nodeIds";

	@Override
	public Map<String, String> getSchema() {
		
		Map<String, String> schema = new HashMap<>();
		schema.put(SCORE, "score");
		schema.put(FEATURES, "features");
		schema.put(REFERENCE, "reference");
		schema.put(NODE_IDS, "nodeIds");

		return schema;
	}

	@Override
	public String getReference() {
		return this.reference;
	}

	@Override
	public List<String> getNodeIds() {
		return this.nodeIds;
	}
}
