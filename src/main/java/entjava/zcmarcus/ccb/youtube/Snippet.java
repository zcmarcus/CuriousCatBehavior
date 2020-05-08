package entjava.zcmarcus.ccb.youtube;

import com.fasterxml.jackson.annotation.JsonProperty;
import entjava.zcmarcus.ccb.util.URLQueryStringEncoder;

/**
 * The type Snippet.
 */
public class Snippet implements URLQueryStringEncoder {

	@JsonProperty("publishedAt")
	private String publishedAt;

	@JsonProperty("description")
	private String description;

	@JsonProperty("title")
	private String title;

	@JsonProperty("thumbnails")
	private Thumbnails thumbnails;

	@JsonProperty("channelId")
	private String channelId;

	@JsonProperty("channelTitle")
	private String channelTitle;

	@JsonProperty("liveBroadcastContent")
	private String liveBroadcastContent;

	/**
	 * Set published at.
	 *
	 * @param publishedAt the published at
	 */
	public void setPublishedAt(String publishedAt){
		this.publishedAt = publishedAt;
	}

	/**
	 * Get published at string.
	 *
	 * @return the string
	 */
	public String getPublishedAt(){
		return publishedAt;
	}

	/**
	 * Set description.
	 *
	 * @param description the description
	 */
	public void setDescription(String description){
		this.description = description;
	}

	/**
	 * Get description string.
	 *
	 * @return the string
	 */
	public String getDescription(){
		return description;
	}

	/**
	 * Set title.
	 *
	 * @param title the title
	 */
	public void setTitle(String title){
		this.title = title;
	}

	/**
	 * Gets title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Set thumbnails.
	 *
	 * @param thumbnails the thumbnails
	 */
	public void setThumbnails(Thumbnails thumbnails){
		this.thumbnails = thumbnails;
	}

	/**
	 * Get thumbnails thumbnails.
	 *
	 * @return the thumbnails
	 */
	public Thumbnails getThumbnails(){
		return thumbnails;
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

	/**
	 * Set channel title.
	 *
	 * @param channelTitle the channel title
	 */
	public void setChannelTitle(String channelTitle){
		this.channelTitle = channelTitle;
	}

	/**
	 * Get channel title string.
	 *
	 * @return the string
	 */
	public String getChannelTitle(){
		return channelTitle;
	}

	/**
	 * Set live broadcast content.
	 *
	 * @param liveBroadcastContent the live broadcast content
	 */
	public void setLiveBroadcastContent(String liveBroadcastContent){
		this.liveBroadcastContent = liveBroadcastContent;
	}

	/**
	 * Get live broadcast content string.
	 *
	 * @return the string
	 */
	public String getLiveBroadcastContent(){
		return liveBroadcastContent;
	}

	/**
	 * Get url-encoded title string.
	 *
	 * @return the url-encoded string
	 */
	public String getURLEncodedTitle(){
		return encodeValue(title);
	}


	@Override
 	public String toString(){
		return 
			"Snippet{" + 
			"publishedAt = '" + publishedAt + '\'' + 
			",description = '" + description + '\'' + 
			",title = '" + title + '\'' + 
			",thumbnails = '" + thumbnails + '\'' + 
			",channelId = '" + channelId + '\'' + 
			",channelTitle = '" + channelTitle + '\'' + 
			",liveBroadcastContent = '" + liveBroadcastContent + '\'' + 
			"}";
		}
}