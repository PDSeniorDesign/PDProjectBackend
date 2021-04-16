package sbrest.signapi;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import sbrest.model.ServiceRequest;

public class AgreementEvents {
	public static void main(String[] args) throws Exception {
		System.out.println(getAgreementEvents("CBJCHBCAABAAprK6W-ka1gwrz00FTa7AnZSwgJh9JrNG"));
		
		System.out.println(getMostRecentAgreementEvent("CBJCHBCAABAAprK6W-ka1gwrz00FTa7AnZSwgJh9JrNG"));
		
		System.out.println(getMostRecentAgreementEventType("CBJCHBCAABAAprK6W-ka1gwrz00FTa7AnZSwgJh9JrNG"));
		
	}
	
	public static ServiceRequest updateRequestStatus(ServiceRequest s) throws Exception {
		if (s.getAgreementId() != null) {
			if (!s.getAgreementId().isEmpty() && !s.getRequestStatus().contains("cancelled") && !s.getRequestStatus().startsWith("Signed")) {
				JSONObject eventHistory = getAgreementEvents(s.getAgreementId());
				JSONArray eventsList = ((JSONArray) eventHistory.get("events"));
				
				// Add non-Adobe Event History (index 0 & 1) from the service request to new eventHistory array.
				ArrayList<String> newEventHistory = new ArrayList<String>();
				newEventHistory.add(s.getEventHistory().get(0));
				newEventHistory.add(s.getEventHistory().get(1));
				
				JSONObject lastEvent = new JSONObject();
				
				for (int i = 0; i < eventsList.size(); i++) {
					JSONObject event = (JSONObject)eventsList.get(i);
					String date = (String)event.get("date");
					
					String datePortion = date.substring(0, 10);
					String timePortion = date.substring(11, 19);
					int hour = Integer.parseInt(timePortion.substring(0, 2));
					
					String consistentHour = ((hour + 5) % 24) + "";
					if (consistentHour.length() == 1) {
						consistentHour = "0" + consistentHour;
					}
					
					String newTimePortion = consistentHour + timePortion.substring(2);
					
					String formattedDate = datePortion + " " + newTimePortion;
					
					String description = (String)event.get("description");
					String type = (String)event.get("type");
					
					if (type.equals("CREATED")) {
						description = "The agreement has been created in Adobe Sign";
					}
					
					if (!type.equals("EMAIL_VIEWED")) {
						lastEvent = event;
						newEventHistory.add("(" + formattedDate + ") " + description);
					}
				}
				
				s.setEventHistory(newEventHistory);
				
				String participantEmail = (String)lastEvent.get("participantEmail");
				String lastEventType = (String)lastEvent.get("type");
				
				int matchesFound = 0;
				String participant = "";
				
				if (s.isEmployee()) {
					if (participantEmail.equalsIgnoreCase(s.getEmployeeEmailAddress())) {
						matchesFound++;
						participant = "Employee";
					}
				}
				else {
					if (participantEmail.equalsIgnoreCase(s.getCompanyEmailAddress())) {
						matchesFound++;
						participant = "Contractor";
					}
				}
				
				if (participantEmail.equalsIgnoreCase(s.getManagerEmail())) {
					matchesFound++;
					participant = "Manager";
				}
				
				if (s.getDivChiefManagerEmail() != null) {
					if (participantEmail.equalsIgnoreCase(s.getDivChiefManagerEmail())) {
						matchesFound++;
						participant = "Division Chief";
					}
				}
				
				if (s.getDepartmentHeadEmail() != null) {
					if (participantEmail.equalsIgnoreCase(s.getDepartmentHeadEmail())) {
						matchesFound++;
						participant = "Department Head";
					}
				}
				
				if (s.getDeptInfoSecurityOfficerEmail() != null) {
					if (participantEmail.equalsIgnoreCase(s.getDeptInfoSecurityOfficerEmail())) {
						matchesFound++;
						participant = "Department Info Security Officer";
					}
				}
				
				if (s.getApplicationCoordinatorEmail() != null) {
					if (participantEmail.equalsIgnoreCase(s.getApplicationCoordinatorEmail())) {
						matchesFound++;
						participant = "Application Coordinator";
					}
				}
					
				if (matchesFound > 1) {
					participant = participantEmail;
				}
		
				switch (lastEventType) {
					case "CREATED":
						s.setRequestStatus("Agreement created in Adobe Sign");
						break;
					case "ACTION_REQUESTED":
						s.setRequestStatus("Out for signature (" + participant + ")");
						break;
					case "ACTION_COMPLETED":
						s.setRequestStatus("Signed by " + participant);
						break;
					case "RECALLED":
						s.setRequestStatus("Agreement cancelled in Adobe Sign");
						break;
					default:
						s.setRequestStatus("Adobe: " + lastEventType + " (" + participant + ")");
				}
				
			}
		}
		
		return s;
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
	
	public static String getMostRecentAgreementEventType(String agreementId) throws Exception {
		JSONObject response = getAgreementEvents(agreementId);
		JSONArray eventsList = ((JSONArray) response.get("events"));

		JSONObject mostRecentEvent = (JSONObject)eventsList.get(eventsList.size() - 1);
		String lastEventType = (String)mostRecentEvent.get("type");
		return lastEventType;
	}
}
