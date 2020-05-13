package entjava.zcmarcus.ccb.youtube;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents the page results count information.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PageInfo{

	@JsonProperty("totalResults")
	private int totalResults;

	@JsonProperty("resultsPerPage")
	private int resultsPerPage;

	/**
	 * Set total results.
	 *
	 * @param totalResults the total results
	 */
	public void setTotalResults(int totalResults){
		this.totalResults = totalResults;
	}

	/**
	 * Get total results int.
	 *
	 * @return the int
	 */
	public int getTotalResults(){
		return totalResults;
	}

	/**
	 * Set results per page.
	 *
	 * @param resultsPerPage the results per page
	 */
	public void setResultsPerPage(int resultsPerPage){
		this.resultsPerPage = resultsPerPage;
	}

	/**
	 * Get results per page int.
	 *
	 * @return the int
	 */
	public int getResultsPerPage(){
		return resultsPerPage;
	}

	@Override
 	public String toString(){
		return 
			"PageInfo{" + 
			"totalResults = '" + totalResults + '\'' + 
			",resultsPerPage = '" + resultsPerPage + '\'' + 
			"}";
		}
}