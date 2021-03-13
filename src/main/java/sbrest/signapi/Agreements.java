package sbrest.signapi;

import java.util.ArrayList;
import java.util.HashMap;
import org.json.simple.JSONObject;

public class Agreements {

	@SuppressWarnings("unchecked")
	public static JSONObject sendEmployeeAgreement(String email) throws Exception {
		// URL to invoke the agreements end point.
		String accessToken = OAuthTokens.getOauthAccessToken();
		String url = "https://api.na3.adobesign.com:443/api/rest/v6/agreements";
		
		String agreementName = "PD Employee Agreement";
		String documentId = "CBJCHBCAABAA6bgfjW_Jk95KdQ_mzNiuHKcjtz153u2K";

		// Create HTTP header list
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json;charset=UTF-8");
		headers.put("Authorization", accessToken);

		// Invoke API and get JSON response. The ID name determines what the input
		// (request) JSON structure should contain.
		JSONObject responseJson = null;

		// Based on the document type retrieved from above, set the corresponding item
		// in the request JSON structure.
		ArrayList<JSONObject> fileInfos = new ArrayList<JSONObject>();
		JSONObject fileInfo = new JSONObject();
		fileInfo.put("libraryDocumentId", documentId);
		fileInfos.add(fileInfo);
			
		String requestJson = "{" + 
				"    \"fileInfos\": [{\r\n" + 
				"        \"libraryDocumentId\": \"" + documentId + "\"\r\n" + 
				"    }],\r\n" + 
				"    \"name\": \"" + agreementName + "\",\r\n" + 
				"    \"participantSetsInfo\": [{\r\n" + 
				"        \"memberInfos\": [{\r\n" + 
				"            \"email\": \"" + email + "\"\r\n" + 
				"        }],\r\n" + 
				"        \"order\": 1,\r\n" + 
				"        \"role\": \"SIGNER\"\r\n" + 
				"    }],\r\n" + 
				"    \"signatureType\": \"ESIGN\",\r\n" + 
				"    \"state\": \"IN_PROCESS\"\r\n" + 
				"}";

		
		responseJson = (JSONObject) OAuthTokens.makeApiCall(url, "POST", headers, requestJson.toString());
		System.out.println(responseJson.toString());
		
		return responseJson;
	}
	
	@SuppressWarnings("unchecked")
	public static JSONObject sendContractorAgreement(String email) throws Exception {
		// URL to invoke the agreements end point.
		String accessToken = OAuthTokens.getOauthAccessToken();
		String url = "https://api.na3.adobesign.com:443/api/rest/v6/agreements";
		
		String agreementName = "PD Contractor Agreement";
		String documentId = "CBJCHBCAABAANFj6EXi626GhARMLjULZrrA-CHakWujD";

		// Create HTTP header list
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json;charset=UTF-8");
		headers.put("Authorization", accessToken);

		// Invoke API and get JSON response. The ID name determines what the input
		// (request) JSON structure should contain.
		JSONObject responseJson = null;

		// Based on the document type retrieved from above, set the corresponding item
		// in the request JSON structure.
		ArrayList<JSONObject> fileInfos = new ArrayList<JSONObject>();
		JSONObject fileInfo = new JSONObject();
		fileInfo.put("libraryDocumentId", documentId);
		fileInfos.add(fileInfo);
			
		String requestJson = "{" + 
				"    \"fileInfos\": [{\r\n" + 
				"        \"libraryDocumentId\": \"" + documentId + "\"\r\n" + 
				"    }],\r\n" + 
				"    \"name\": \"" + agreementName + "\",\r\n" + 
				"    \"participantSetsInfo\": [{\r\n" + 
				"        \"memberInfos\": [{\r\n" + 
				"            \"email\": \"" + email + "\"\r\n" + 
				"        }],\r\n" + 
				"        \"order\": 1,\r\n" + 
				"        \"role\": \"SIGNER\"\r\n" + 
				"    }],\r\n" + 
				"    \"signatureType\": \"ESIGN\",\r\n" + 
				"    \"state\": \"IN_PROCESS\"\r\n" + 
				"}";

		
		responseJson = (JSONObject) OAuthTokens.makeApiCall(url, "POST", headers, requestJson.toString());
		System.out.println(responseJson.toString());
		
		return responseJson;
	}

}
