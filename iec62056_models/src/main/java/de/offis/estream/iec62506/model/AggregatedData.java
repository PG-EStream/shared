package de.offis.estream.iec62506.model;

import java.util.Map;
import java.util.Map.Entry;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * 
 * @author Jens Plümer
 *
 */
//@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"aggregation_value",
	"aggregation_type"
})
public class AggregatedData extends RawData {
	
//////////////SCHEMA	
	@JsonIgnore
	private static final String AGGREGATION_TYPE_KEY = "aggregation_type" ;//FIXME is ignored by jackson somwehow
	
	@JsonIgnore
	private static final String AGGREGATION_VALUE_KEY = "aggregation_value" ;
//////////////
	
	@JsonProperty("aggregation_value")
	private double aggregationValue;
	
	@JsonProperty("aggregation_type")
	private String aggregationType;
	
	@Override
	public void setValues(Map<String, Object> values) {
		super.setValues(values);
		for(Entry<String, Object> e : values.entrySet()) {
			if(getSchema().get(AGGREGATION_TYPE_KEY).equalsIgnoreCase(e.getKey())) {
				setAggregationType((String) e.getValue());
			} else if (getSchema().get(AGGREGATION_VALUE_KEY).equalsIgnoreCase(e.getKey())) {
				setAggregationValue((double) e.getValue());
			}
		}
	}

	@Override
	public Map<String, String> getSchema() {
		Map<String, String> schema = super.getSchema();
		schema.put(AGGREGATION_TYPE_KEY, "aggregation_type");
		schema.put(AGGREGATION_VALUE_KEY, "aggregation_value");
		return schema;
	}


	@JsonGetter
	public double getAggregationValue() {
		return aggregationValue;
	}

	@JsonSetter
	public void setAggregationValue(double aggregationValue) {
		this.aggregationValue = aggregationValue;
	}

	@JsonGetter
	public String getAggregationType() {
		return aggregationType;
	}

	@JsonSetter
	public void setAggregationType(String aggregationType) {
		this.aggregationType = aggregationType;
	}

}
