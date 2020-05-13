package entjava.zcmarcus.ccb.youtube;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The search results set object.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SearchData{

	@JsonProperty("regionCode")
	private String regionCode;

	@JsonProperty("kind")
	private String kind;

	@JsonProperty("nextPageToken")
	private String nextPageToken;

	@JsonProperty("prevPageToken")
	private String prevPageToken;

	@JsonProperty("pageInfo")
	private PageInfo pageInfo;

	@JsonProperty("etag")
	private String etag;

	@JsonProperty("items")
	private List<ItemsItem> items;

	/**
	 * Set region code.
	 *
	 * @param regionCode the region code
	 */
	public void setRegionCode(String regionCode){
		this.regionCode = regionCode;
	}

	/**
	 * Get region code string.
	 *
	 * @return the string
	 */
	public String getRegionCode(){
		return regionCode;
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
	 * Set next page token.
	 *
	 * @param nextPageToken the next page token
	 */
	public void setNextPageToken(String nextPageToken){
		this.nextPageToken = nextPageToken;
	}

	/**
	 * Get next page token string.
	 *
	 * @return the string
	 */
	public String getNextPageToken(){
		return nextPageToken;
	}

	/**
	 * Gets prev page token.
	 *
	 * @return the prev page token
	 */
	public String getPrevPageToken() { return prevPageToken; }

	/**
	 * Sets prev page token.
	 *
	 * @param prevPageToken the prev page token
	 */
	public void setPrevPageToken(String prevPageToken) { this.prevPageToken = prevPageToken; }

	/**
	 * Set page info.
	 *
	 * @param pageInfo the page info
	 */
	public void setPageInfo(PageInfo pageInfo){
		this.pageInfo = pageInfo;
	}

	/**
	 * Get page info page info.
	 *
	 * @return the page info
	 */
	public PageInfo getPageInfo(){
		return pageInfo;
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
	 * Set items.
	 *
	 * @param items the items
	 */
	public void setItems(List<ItemsItem> items){
		this.items = items;
	}

	/**
	 * Get items list.
	 *
	 * @return the list
	 */
	public List<ItemsItem> getItems(){
		return items;
	}

	@Override
 	public String toString(){
		return 
			"SearchData{" + 
			"regionCode = '" + regionCode + '\'' + 
			",kind = '" + kind + '\'' + 
			",nextPageToken = '" + nextPageToken + '\'' +
			",prevPageToken = '" + prevPageToken + '\'' +
			",pageInfo = '" + pageInfo + '\'' + 
			",etag = '" + etag + '\'' + 
			",items = '" + items + '\'' + 
			"}";
		}
}