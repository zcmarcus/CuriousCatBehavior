package entjava.zcmarcus.ccb.youtube;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchData{

	@JsonProperty("regionCode")
	private String regionCode;

	@JsonProperty("kind")
	private String kind;

	@JsonProperty("nextPageToken")
	private String nextPageToken;

	@JsonProperty("pageInfo")
	private PageInfo pageInfo;

	@JsonProperty("etag")
	private String etag;

	@JsonProperty("items")
	private List<ItemsItem> items;

	public void setRegionCode(String regionCode){
		this.regionCode = regionCode;
	}

	public String getRegionCode(){
		return regionCode;
	}

	public void setKind(String kind){
		this.kind = kind;
	}

	public String getKind(){
		return kind;
	}

	public void setNextPageToken(String nextPageToken){
		this.nextPageToken = nextPageToken;
	}

	public String getNextPageToken(){
		return nextPageToken;
	}

	public void setPageInfo(PageInfo pageInfo){
		this.pageInfo = pageInfo;
	}

	public PageInfo getPageInfo(){
		return pageInfo;
	}

	public void setEtag(String etag){
		this.etag = etag;
	}

	public String getEtag(){
		return etag;
	}

	public void setItems(List<ItemsItem> items){
		this.items = items;
	}

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
			",pageInfo = '" + pageInfo + '\'' + 
			",etag = '" + etag + '\'' + 
			",items = '" + items + '\'' + 
			"}";
		}
}