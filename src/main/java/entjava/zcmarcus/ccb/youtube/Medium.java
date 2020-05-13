package entjava.zcmarcus.ccb.youtube;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a medium-quality YouTube video thumbnail.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Medium{

	@JsonProperty("width")
	private int width;

	@JsonProperty("url")
	private String url;

	@JsonProperty("height")
	private int height;

	/**
	 * Set width.
	 *
	 * @param width the width
	 */
	public void setWidth(int width){
		this.width = width;
	}

	/**
	 * Get width int.
	 *
	 * @return the int
	 */
	public int getWidth(){
		return width;
	}

	/**
	 * Set url.
	 *
	 * @param url the url
	 */
	public void setUrl(String url){
		this.url = url;
	}

	/**
	 * Get url string.
	 *
	 * @return the string
	 */
	public String getUrl(){
		return url;
	}

	/**
	 * Set height.
	 *
	 * @param height the height
	 */
	public void setHeight(int height){
		this.height = height;
	}

	/**
	 * Get height int.
	 *
	 * @return the int
	 */
	public int getHeight(){
		return height;
	}

	@Override
 	public String toString(){
		return 
			"Medium{" + 
			"width = '" + width + '\'' + 
			",url = '" + url + '\'' + 
			",height = '" + height + '\'' + 
			"}";
		}
}