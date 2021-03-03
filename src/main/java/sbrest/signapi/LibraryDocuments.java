package sbrest.signapi;

import java.io.IOException;
import java.util.HashMap;

import org.json.simple.JSONObject;

public class LibraryDocuments {
  private static final String LIBRARY_DOCUMENTS_ENDPOINT = "/libraryDocuments";

  /**
   * Fetches the list of all library documents.
   * 
   * @param accessToken access token of the user whose library documents are to be fetched.
   * @return JSON response containing the list of all the library documents for the user.
 * @throws Exception 
   * @throws IOException
   */
  
  public static void main(String[] args) throws Exception {
	  getLibraryDocuments();
  }
  
  public static JSONObject getLibraryDocuments() throws Exception {
    // URL for library documents end point.
	String accessToken = OAuthTokens.getOauthAccessToken();
    String url = "https://api.na3.adobesign.com:443/api/rest/v6" + LIBRARY_DOCUMENTS_ENDPOINT;

    // Create header list.
    HashMap<String, String> headers = new HashMap<String, String>();
    headers.put("Content-Type", "application/json;charset=UTF-8");
    headers.put("Authorization", accessToken);

    // Invoke API and get JSON response.
    JSONObject responseJSON = null;
    responseJSON = (JSONObject) OAuthTokens.makeApiCall(url, "GET", headers, null);
    
    System.out.println(responseJSON.toString());
    
    return responseJSON;
  }

}