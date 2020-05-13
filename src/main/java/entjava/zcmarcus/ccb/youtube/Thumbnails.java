package entjava.zcmarcus.ccb.youtube;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a search result video's thumbnails.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Thumbnails{

	@JsonProperty("default")
	private JsonMemberDefault jsonMemberDefault;

	@JsonProperty("high")
	private High high;

	@JsonProperty("medium")
	private Medium medium;

	/**
	 * Set json member default.
	 *
	 * @param jsonMemberDefault the json member default
	 */
	public void setJsonMemberDefault(JsonMemberDefault jsonMemberDefault){
		this.jsonMemberDefault = jsonMemberDefault;
	}

	/**
	 * Get json member default json member default.
	 *
	 * @return the json member default
	 */
	public JsonMemberDefault getJsonMemberDefault(){
		return jsonMemberDefault;
	}

	/**
	 * Set high.
	 *
	 * @param high the high
	 */
	public void setHigh(High high){
		this.high = high;
	}

	/**
	 * Get high high.
	 *
	 * @return the high
	 */
	public High getHigh(){
		return high;
	}

	/**
	 * Set medium.
	 *
	 * @param medium the medium
	 */
	public void setMedium(Medium medium){
		this.medium = medium;
	}

	/**
	 * Get medium medium.
	 *
	 * @return the medium
	 */
	public Medium getMedium(){
		return medium;
	}

	@Override
 	public String toString(){
		return 
			"Thumbnails{" + 
			"default = '" + jsonMemberDefault + '\'' + 
			",high = '" + high + '\'' + 
			",medium = '" + medium + '\'' + 
			"}";
		}
}