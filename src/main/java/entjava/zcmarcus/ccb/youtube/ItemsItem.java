package entjava.zcmarcus.ccb.youtube;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
  * Represents a YouTube search result item.
  */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemsItem{

	@JsonProperty("snippet")
	private Snippet snippet;

	@JsonProperty("kind")
	private String kind;

	@JsonProperty("etag")
	private String etag;

	@JsonProperty("id")
	private Id id;

	/**
	 * Set snippet.
	 *
	 * @param snippet the snippet
	 */
	public void setSnippet(Snippet snippet){
		this.snippet = snippet;
	}

	/**
	 * Get snippet snippet.
	 *
	 * @return the snippet
	 */
	public Snippet getSnippet(){
		return snippet;
	}

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
	 * Set etag.
	 *
	 * @param etag the etag
	 */
	public void setEtag(String etag){
		this.etag = etag;
	}

	/**
	 * Get etag string.
	 *
	 * @return the string
	 */
	public String getEtag(){
		return etag;
	}

	/**
	 * Set id.
	 *
	 * @param id the id
	 */
	public void setId(Id id){
		this.id = id;
	}

	/**
	 * Get id id.
	 *
	 * @return the id
	 */
	public Id getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"ItemsItem{" + 
			"snippet = '" + snippet + '\'' + 
			",kind = '" + kind + '\'' + 
			",etag = '" + etag + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}