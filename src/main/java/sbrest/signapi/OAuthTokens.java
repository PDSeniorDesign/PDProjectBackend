package sbrest.signapi;

import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import javax.net.ssl.HttpsURLConnection;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class OAuthTokens {
	private final static String OAUTH_ACCESS_TOKEN_ENDPOINT = "/token";
	private final static String OAUTH_REFRESH_TOKEN_ENDPOINT = "/refresh";
	private final static String BEARER = "Bearer ";

	public final static String OAUTH_BASE_URL = "https://api.na3.adobesign.com/oauth";

	/**
	 * TODO Provide an OAuth access token or integration key. If not provided then a
	 * new OAuth access token will be requested from AdobeSign server based on
	 * credentials provided in the OAuthCredentials.json file. You can also provide
	 * a refresh token in OAUTH_REFRESH_TOKEN variable below to refresh the OAuth
	 * access token.
	 */
	private final static String OAUTH_ACCESS_TOKEN = "";

	/**
	 * TODO Provide refresh token here. This will be used to refresh the OAuth
	 * access token. If refresh token is not provided then a new OAuth access token
	 * will be generated with new refresh token.
	 */
	private final static String OAUTH_REFRESH_TOKEN = "3AAABLblqZhBqIMVIHXmIVCo8AKV0BGfltLJFHDp08PU2CsYcltic7aEsLPMRCxNohBA35mPjXac*";

	/**
	 * Fetches the access token for the specified user.
	 * 
	 * @param requestJSONFile Reference to the file containing template request JSON
	 *                        required for this API invocation.
	 * @return access token.
	 * @throws Exception
	 */
	
	public static void main(String[] args) throws Exception {
		System.out.println("OAuth Access Token : " + getOauthAccessToken());
	}
	
	public static String getOauthAccessToken() throws Exception {

		// If an OAuth access token is available, use that instead of requesting a new
		// one.
		if (!OAUTH_ACCESS_TOKEN.isEmpty())
			return BEARER + OAUTH_ACCESS_TOKEN;

		// Otherwise if an OAuth refresh token is available, use it to request an
		// updated OAuth access token.
		if (!OAUTH_REFRESH_TOKEN.isEmpty())
			return getOauthAccessTokenFromRefreshToken();

		// URL for token endpoint.
		String url = OAUTH_BASE_URL + OAUTH_ACCESS_TOKEN_ENDPOINT;

		// Create header list.
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/x-www-form-urlencoded");

		String requestBody = "code=CBNCKBAAHBCAABAA9-ergMOskDe84KYlH5l5sGKGaCGyNE9_" + "&client_id=CBJCHBCAABAAbdOJinH8YyWRMugJuWD77xsFM8gFaev_" 
				+ "&client_secret=LNnwSiZov_hznKE6z74_ijB-xFI1w_dw" + "&redirect_uri=https://google.com"
				 + "&grant_type=authorization_code";

		// Invoke API and get JSON response.
		JSONObject responseJSON = null;
		responseJSON = (JSONObject) makeApiCall(url, "POST", headers, requestBody);

		// Provide this refresh token value to OAUTH_REFRESH_TOKEN static variable
		// declared above in this class.
		// This refresh token will be used to receive an updated OAuth access token for
		// future calls.
		System.out.println("OAuth Refresh Token : " + (String) responseJSON.get("refresh_token"));

		// Extract and return access token from the JSON response.
		return (String) responseJSON.get("access_token");

	}

	private static String getOauthAccessTokenFromRefreshToken() throws Exception {

		// URL for refresh token end point.
		String url = OAUTH_BASE_URL + OAUTH_REFRESH_TOKEN_ENDPOINT;

		// Create header list.
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/x-www-form-urlencoded");

		String requestBody = "refresh_token=" + OAUTH_REFRESH_TOKEN
				+ "&client_id=CBJCHBCAABAAbdOJinH8YyWRMugJuWD77xsFM8gFaev_"
				+ "&client_secret=LNnwSiZov_hznKE6z74_ijB-xFI1w_dw" + "&grant_type=refresh_token";

		// Invoke API and get JSON response.
		JSONObject responseJSON = null;
		responseJSON = (JSONObject) makeApiCall(url, "POST", headers, requestBody);

		// Extract and return access token from the JSON response.
		String token = (String) responseJSON.get("access_token");
		return "Bearer " + token;

	}

	public static Object makeApiCall(String apiUrl, String method, HashMap<String, String> headers, String body) throws IOException {
		Object response = null;

		// Open an HTTPS connection in preparation for the call.
		HttpsURLConnection conn = createRequest(apiUrl, method, headers, body);
		if (conn != null) {
			try {
				// Make the call over the opened connection.
				response = executeRequest(conn);
			} finally {
				// Irrespective of success or failure, close the connection.
				conn.disconnect();
			}
		}
		return response;
	}

	private static HttpsURLConnection createRequest(String apiUrl, String method, HashMap<String, String> headers, String body)
			throws IOException {
		// Initiate connection to URL
		HttpsURLConnection conn = null;
		boolean allGood = false;

		try {
			conn = openConnection(apiUrl);
			if (conn != null) {
				// Set the HTTP Request method.
				conn.setRequestMethod(method);

				// Add header field/value pairs to the API request.
				for (Entry<String, String> map : headers.entrySet())
					conn.setRequestProperty(map.getKey(), map.getValue());

				// Set body for the API call if one is specified
				if (body != null)
					setRequestBody(conn, body);

				// If we reached here no exceptions were thrown.
				allGood = true;
			}
		} catch (MalformedURLException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		} finally {
			// Disconnect in the face of any exception. We could have simply caught
			// Exception and rethrown that, but the
			// method does not declare that it throws general Exceptions (since it in fact
			// does not explicitly do so).
			if (!allGood && conn != null)
				conn.disconnect();
		}
		return conn;
	}
	
	private static void setRequestBody(HttpsURLConnection conn, String body) throws IOException {
	    DataOutputStream outStream = null;
	    try {
	      outStream = new DataOutputStream(conn.getOutputStream());
	      outStream.write(body.getBytes("UTF-8"));
	    }
	    catch (IOException e) {
	      throw e;
	    }
	    finally {
	      if (outStream != null)
	        outStream.close();
	    }
	  }

	private static Object executeRequest(HttpsURLConnection conn) throws IOException {
		Object responseObj = null; // return as an Object since actual type is not yet known
		int status = 0;

		// Open the URL connection, and await a response.
		try {
			conn.connect();
			status = conn.getResponseCode();

			// Check for successful API invocation
			if (status >= 200 && status <= 299) {
				// Success. Get the response body using the connection's regular input stream.
				responseObj = getSuccessfulResponseObj(conn);
			} else {
				// Error. Don't set responseObj. Instead show on the console what is retrieved
				// using the connection's error stream.
				getFailedResponseObj(conn, status);
			}
		} catch (IOException e) {
			throw e;
		}
		return responseObj;
	}

	private static Object getSuccessfulResponseObj(HttpsURLConnection conn) throws IOException {
		Object responseObj = null;
		InputStream connStream = null;
		try {
			connStream = conn.getInputStream();
			if (connStream != null) {
				// Read the bytes of the response body.
				String responseContentType = conn.getContentType();
				byte[] responseBytes = getResponseBytes(conn, connStream);

				// Set responseObj based on the content type of the response received. Note that
				// even though the type of responseObj is
				// Object, type-casting to JSONObject helps track class cast exceptions if they
				// occur.
				if (responseContentType.equals("application/json;charset=UTF-8"))
					responseObj = (JSONObject) JSONValue.parse(new String(responseBytes, "UTF-8"));
				else
					responseObj = responseBytes;
			}
		} catch (UnsupportedEncodingException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		} finally {
			if (connStream != null)
				connStream.close();
		}
		return responseObj;
	}

	private static void getFailedResponseObj(HttpsURLConnection conn, int errorCode) throws IOException {
		InputStream connStream = null;
		try {
			// Get the body of the response as an array of bytes using the connection's
			// error stream.
			connStream = conn.getErrorStream();
			if (connStream != null) {
				String responseContentType = conn.getContentType();
				byte[] responseBytes = getResponseBytes(conn, connStream);

				// Write out the error details to the console, but don't set response. We want
				// to return null to indicate an error.
				if (responseContentType.equals("application/json;charset=UTF-8")) {
					JSONObject jobj = (JSONObject) JSONValue.parse(new String(responseBytes, "UTF-8"));
					System.out.println("Message: " + jobj.get("message"));
					System.out.println("Code: " + jobj.get("code"));
				}
			}
		} catch (UnsupportedEncodingException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		} finally {
			if (connStream != null)
				connStream.close();
		}
	}
	
	private static byte[] getResponseBytes(HttpsURLConnection conn, InputStream connStream) throws IOException {
	    byte[] responseBytes = new byte[4096];
	    InputStream inputStream = new BufferedInputStream(connStream);
	    int totalBytesRead = 0;

	    try {
	      int bytesRead = inputStream.read(responseBytes);

	      // Read all the bytes of the connection stream. Since it may happen that the content length is unknown we must keep reallocating our
	      // buffer as we encounter new data. Note that this may not be the most efficient way to do this.
	      while (bytesRead >= 0) {
	        totalBytesRead += bytesRead;

	        // Allocate a larger byte array for the next read operation.
	        responseBytes = Arrays.copyOf(responseBytes, totalBytesRead + 4096);

	        // Read into the re-allocated buffer. 
	        bytesRead = inputStream.read(responseBytes, totalBytesRead, responseBytes.length - totalBytesRead);
	      }
	      
	      // Final reallocation to return an array that is precisely the length of the data that was read in.
	      responseBytes = Arrays.copyOfRange(responseBytes, 0, totalBytesRead);
	    }
	    catch (IOException e) {
	      throw e;
	    }
	    
	    return responseBytes;
	  }
	
	private static HttpsURLConnection openConnection(String apiUrl) throws MalformedURLException, IOException {
	    HttpsURLConnection conn = null;
	    try {
	      URL url = new URL(apiUrl);
	      conn = (HttpsURLConnection) url.openConnection();
	    }
	    catch (MalformedURLException e) {
	      throw e;
	    }
	    catch (IOException e) {
	      throw e;
	    }

	    if (conn != null) {
	      // This connection is used for both input and output.
	      conn.setDoInput(true);
	      conn.setDoOutput(true);
	    }
	    return conn;
	  }
}
