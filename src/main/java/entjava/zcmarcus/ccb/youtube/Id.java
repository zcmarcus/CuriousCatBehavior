package entjava.zcmarcus.ccb.youtube;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Represents a search result item ID.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Id{

	@JsonProperty("kind")
	private String kind;

	@JsonProperty("videoId")
	private String videoId;

	@JsonProperty("channelId")
	private String channelId;

	/**
	 * Set kind.
	 *
	 * @param kind the kind
	 */
	public void setKind(String kind){
		this.kind = kind;
	}

	/**
	 * Get kind string.
	 *
	 * @return the string
	 */
	public String getKind(){
		return kind;
	}

	/**
	 * Set video id.
	 *
	 * @param videoId the video id
	 */
	public void setVideoId(String videoId){
		this.videoId = videoId;
	}

	/**
	 * Get video id string.
	 *
	 * @return the string
	 */
	public String getVideoId(){
		return videoId;
	}

	/**
	 * Set channel id.
	 *
	 * @param channelId the channel id
	 */
	public void setChannelId(String channelId){
		this.channelId = channelId;
	}

	/**
	 * Get channel id string.
	 *
	 * @return the string
	 */
	public String getChannelId(){
		return channelId;
	}

	@Override
 	public String toString(){
		return 
			"Id{" + 
			"kind = '" + kind + '\'' + 
			",videoId = '" + videoId + '\'' + 
			",channelId = '" + channelId + '\'' + 
			"}";
		}
}