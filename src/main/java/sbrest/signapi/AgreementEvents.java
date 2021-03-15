package sbrest.signapi;

import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class AgreementEvents {
	public static void main(String[] args) throws Exception {
		System.out.println(getAgreementEvents("CBJCHBCAABAAGJqiTBPRJBydvCX5VKN_n3WFhNpRC1n5"));
		System.out.println(getMostRecentAgreementEvent("CBJCHBCAABAAGJqiTBPRJBydvCX5VKN_n3WFhNpRC1n5"));
	}
	
	public static JSONObject getAgreementEvents(String agreementId) throws Exception {
		String accessToken = OAuthTokens.getOauthAccessToken();
		String url = "https://api.na3.adobesign.com:443/api/rest/v6/agreements/" + agreementId + "/events";
		
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json;charset=UTF-8");
		headers.put("Authorization", accessToken);

		JSONObject responseJson = (JSONObject) OAuthTokens.makeApiCall(url, "GET", headers, null);
		return responseJson;
	}
	
	public static String getMostRecentAgreementEvent(String agreementId) throws Exception {
		JSONObject response = getAgreementEvents(agreementId);
		JSONArray eventsList = ((JSONArray) response.get("events"));

		JSONObject mostRecentEvent = (JSONObject)eventsList.get(eventsList.size() - 1);
		String lastEventDescription = (String)mostRecentEvent.get("description");
		String lastEventDate = (String)mostRecentEvent.get("date");
		return "Current Status (" + lastEventDate +  "): " + lastEventDescription;
	}
}
