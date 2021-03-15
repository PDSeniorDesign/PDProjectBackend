package sbrest.signapi;

import java.util.ArrayList;
import java.util.HashMap;
import org.json.simple.JSONObject;

import sbrest.model.ServiceRequest;

public class Agreements {

	@SuppressWarnings("unchecked")
	public static void sendEmployeeAgreement(ServiceRequest serviceRequest) throws Exception {
		// URL to invoke the agreements end point.
		String accessToken = OAuthTokens.getOauthAccessToken();
		String url = "https://api.na3.adobesign.com:443/api/rest/v6/agreements";
		String email = serviceRequest.getEmployeeEmailAddress();
		
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
				"    \"state\": \"IN_PROCESS\",\r\n" + 
				"    \"mergeFieldInfo\": [\r\n";
				
		requestJson += populateTemplate(serviceRequest);

		requestJson += "]\n}";
		
		responseJson = (JSONObject) OAuthTokens.makeApiCall(url, "POST", headers, requestJson.toString());
		
		String agreementId = responseJson.get("id").toString();
	
	}
	
	@SuppressWarnings("unchecked")
	public static void sendContractorAgreement(ServiceRequest serviceRequest) throws Exception {
		// URL to invoke the agreements end point.
		String accessToken = OAuthTokens.getOauthAccessToken();
		String url = "https://api.na3.adobesign.com:443/api/rest/v6/agreements";
		String email = serviceRequest.getCompanyEmailAddress();
		
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
				"    \"state\": \"IN_PROCESS\",\r\n" + 
				"    \"mergeFieldInfo\": [\r\n";
				
		requestJson += populateTemplate(serviceRequest);

		requestJson += "]\n}";

		responseJson = (JSONObject) OAuthTokens.makeApiCall(url, "POST", headers, requestJson.toString());
		
		String agreementId = responseJson.get("id").toString();
		
	}
	
	public static String populateTemplate(ServiceRequest serviceRequest) {
		String output = "";
		
		if (serviceRequest.isNewRegistration()) {
			output += "{ \"fieldName\": \"newRegistration\", \"defaultValue\": \"Checked\"}, ";
		}
		if (serviceRequest.isDeletePriorRegistration()) {
			output += "{ \"fieldName\": \"deletePriorRegistration\", \"defaultValue\": \"Checked\"}, ";
		}
		if (serviceRequest.isUpdatePriorRegistration()) {
			output += "{ \"fieldName\": \"updatePriorRegistration\", \"defaultValue\": \"Checked\"}, ";
		}
		
		output += "{ \"fieldName\": \"lastName\", \"defaultValue\": \"" + serviceRequest.getLastName() + "\"}, ";
		output += "{ \"fieldName\": \"firstName\", \"defaultValue\": \"" + serviceRequest.getFirstName() + "\"}, ";
		output += "{ \"fieldName\": \"middleInitial\", \"defaultValue\": \"" + serviceRequest.getMiddleInitial() + "\"}, ";
		
		String fullName = serviceRequest.getFirstName() + " ";
		if (!serviceRequest.getMiddleInitial().isEmpty()) {
			fullName += serviceRequest.getMiddleInitial() + " ";
		}
		fullName += serviceRequest.getLastName();
		output += "{ \"fieldName\": \"fullName1\", \"defaultValue\": \"" + fullName + "\"}, ";
		output += "{ \"fieldName\": \"fullName2\", \"defaultValue\": \"" + fullName + "\"}, ";
		output += "{ \"fieldName\": \"fullName3\", \"defaultValue\": \"" + fullName + "\"}, ";
		
		String v2FullName = serviceRequest.getLastName() + ", " + serviceRequest.getFirstName();
		if (!serviceRequest.getMiddleInitial().isEmpty()) {
			v2FullName += " " + serviceRequest.getMiddleInitial();
		}
		output += "{ \"fieldName\": \"v2FullName\", \"defaultValue\": \"" + v2FullName + "\"}, ";
		
		output += "{ \"fieldName\": \"departmentName1\", \"defaultValue\": \"" + serviceRequest.getDepartmentName() + "\"}, ";
		output += "{ \"fieldName\": \"departmentName2\", \"defaultValue\": \"" + serviceRequest.getDepartmentName() + "\"}, ";
		output += "{ \"fieldName\": \"departmentName3\", \"defaultValue\": \"" + serviceRequest.getDepartmentName() + "\"}, ";
		output += "{ \"fieldName\": \"departmentNumber1\", \"defaultValue\": \"" + serviceRequest.getDepartmentNumber() + "\"}, ";
		output += "{ \"fieldName\": \"departmentNumber2\", \"defaultValue\": \"" + serviceRequest.getDepartmentNumber() + "\"}, ";
		output += "{ \"fieldName\": \"businessStreetAddress1\", \"defaultValue\": \"" + serviceRequest.getBusinessStreetAddress() + "\"}, ";
		output += "{ \"fieldName\": \"businessStreetAddress2\", \"defaultValue\": \"" + serviceRequest.getBusinessStreetAddress() + "\"}, ";
		output += "{ \"fieldName\": \"businessCity1\", \"defaultValue\": \"" + serviceRequest.getBusinessCity() + "\"}, ";
		output += "{ \"fieldName\": \"businessCity2\", \"defaultValue\": \"" + serviceRequest.getBusinessCity() + "\"}, ";
		output += "{ \"fieldName\": \"businessZip1\", \"defaultValue\": \"" + serviceRequest.getBusinessZip() + "\"}, ";
		output += "{ \"fieldName\": \"businessZip2\", \"defaultValue\": \"" + serviceRequest.getBusinessZip() + "\"}, ";
		
		if (serviceRequest.isInternetApplication()) {
			output += "{ \"fieldName\": \"internetApplication\", \"defaultValue\": \"Checked\"}, ";
		}
		if (serviceRequest.isExchangeEmail()) {
			output += "{ \"fieldName\": \"exchangeEmail\", \"defaultValue\": \"Checked\"}, ";
		}
		if (serviceRequest.isEmailEncryption()) {
			output += "{ \"fieldName\": \"emailEncryption\", \"defaultValue\": \"Checked\"}, ";
		}
		if (serviceRequest.isWindowsRightsMgmt()) {
			output += "{ \"fieldName\": \"windowsRightsMgmt\", \"defaultValue\": \"Checked\"}, ";
		}
		if (serviceRequest.isTokenlessAuthentication()) {
			output += "{ \"fieldName\": \"tokenlessAuthentication\", \"defaultValue\": \"Checked\"}, ";
		}
		if (serviceRequest.isLacMobileWifiAccess()) {
			output += "{ \"fieldName\": \"lacMobileWifiAccess\", \"defaultValue\": \"Checked\"}, ";
		}
		if (serviceRequest.isCherwellSms()) {
			output += "{ \"fieldName\": \"cherwellSms\", \"defaultValue\": \"Checked\"}, ";
		}
		if (serviceRequest.isGmailAccess()) {
			output += "{ \"fieldName\": \"gmailAccess\", \"defaultValue\": \"Checked\"}, ";
		}
		if (serviceRequest.isYahooMailAccess()) {
			output += "{ \"fieldName\": \"yahooMailAccess\", \"defaultValue\": \"Checked\"}, ";
		}
		if (serviceRequest.isOtherEmailAccess()) {
			output += "{ \"fieldName\": \"otherEmailAccess\", \"defaultValue\": \"Checked\"}, ";
		}
		
		output += "{ \"fieldName\": \"otherEmailDomain\", \"defaultValue\": \"" + serviceRequest.getOtherEmailDomain() + "\"}, ";
		
		if (serviceRequest.isDefaultCountyWidePolicy()) {
			output += "{ \"fieldName\": \"defaultCountyWidePolicy\", \"defaultValue\": \"Checked\"}, ";
		}
		if (serviceRequest.isDepartmentPolicyRule0()) {
			output += "{ \"fieldName\": \"departmentPolicyRule0\", \"defaultValue\": \"Checked\"}, ";
		}
		if (serviceRequest.isDepartmentPolicyRule1()) {
			output += "{ \"fieldName\": \"departmentPolicyRule1\", \"defaultValue\": \"Checked\"}, ";
		}
		if (serviceRequest.isDepartmentPolicyRule2()) {
			output += "{ \"fieldName\": \"departmentPolicyRule2\", \"defaultValue\": \"Checked\"}, ";
		}
		if (serviceRequest.isDepartmentPolicyRule3()) {
			output += "{ \"fieldName\": \"departmentPolicyRule3\", \"defaultValue\": \"Checked\"}, ";
		}
		if (serviceRequest.isDepartmentPolicyRule4()) {
			output += "{ \"fieldName\": \"departmentPolicyRule4\", \"defaultValue\": \"Checked\"}, ";
		}
		if (serviceRequest.isSocialNetworkingFacebook()) {
			output += "{ \"fieldName\": \"socialNetworkingFacebook\", \"defaultValue\": \"Checked\"}, ";
		}
		if (serviceRequest.isSocialNetworkingTwitter()) {
			output += "{ \"fieldName\": \"socialNetworkingTwitter\", \"defaultValue\": \"Checked\"}, ";
		}
		if (serviceRequest.isSocialNetworkingLinkedIn()) {
			output += "{ \"fieldName\": \"socialNetworkingLinkedIn\", \"defaultValue\": \"Checked\"}, ";
		}
		
		output += "{ \"fieldName\": \"businessJustification\", \"defaultValue\": \"" + serviceRequest.getBusinessJustification() + "\"}, ";
		
		output += "{ \"fieldName\": \"submitDate\", \"defaultValue\": \"" + serviceRequest.getSubmitDate() + "\"}, ";
		
		if (serviceRequest.isReplaceLostToken()) {
			output += "{ \"fieldName\": \"replaceLostToken\", \"defaultValue\": \"Checked\"}, ";
		}
		if (serviceRequest.isAddLogonId()) {
			output += "{ \"fieldName\": \"addLogonId\", \"defaultValue\": \"Checked\"}, ";
		}
		if (serviceRequest.isChangeLogonId()) {
			output += "{ \"fieldName\": \"changeLogonId\", \"defaultValue\": \"Checked\"}, ";
		}
		if (serviceRequest.isDeleteLogonId()) {
			output += "{ \"fieldName\": \"deleteLogonId\", \"defaultValue\": \"Checked\"}, ";
		}
		
		output += "{ \"fieldName\": \"workMailingAddress\", \"defaultValue\": \"" + serviceRequest.getWorkMailingAddress() + "\"}, ";
		output += "{ \"fieldName\": \"ibmLogOnId\", \"defaultValue\": \"" + serviceRequest.getIbmLogOnId() + "\"}, ";
		output += "{ \"fieldName\": \"majorGroupCode\", \"defaultValue\": \"" + serviceRequest.getMajorGroupCode() + "\"}, ";
		output += "{ \"fieldName\": \"lsoGroupCode\", \"defaultValue\": \"" + serviceRequest.getLsoGroupCode() + "\"}, ";
		if (serviceRequest.isTsoAccess()) {
			output += "{ \"fieldName\": \"tsoAccess\", \"defaultValue\": \"Checked\"}, ";
		}
		output += "{ \"fieldName\": \"tsoGroupCode\", \"defaultValue\": \"" + serviceRequest.getTsoGroupCode() + "\"}, ";
		output += "{ \"fieldName\": \"subGroup1\", \"defaultValue\": \"" + serviceRequest.getSubGroup1() + "\"}, ";
		output += "{ \"fieldName\": \"subGroup2\", \"defaultValue\": \"" + serviceRequest.getSubGroup2() + "\"}, ";
		output += "{ \"fieldName\": \"subGroup3\", \"defaultValue\": \"" + serviceRequest.getSubGroup3() + "\"}, ";
		if (serviceRequest.isOnlineAccess()) {
			output += "{ \"fieldName\": \"onlineAccess\", \"defaultValue\": \"Checked\"}, ";
		}
		output += "{ \"fieldName\": \"systemApplication1\", \"defaultValue\": \"" + serviceRequest.getSystemApplication() + "\"}, ";
		output += "{ \"fieldName\": \"groupName1\", \"defaultValue\": \"" + serviceRequest.getGroupName() + "\"}, ";
		output += "{ \"fieldName\": \"oldGroup1\", \"defaultValue\": \"" + serviceRequest.getOldGroup() + "\"}, ";
		if (serviceRequest.isUnixAddLogonId()) {
			output += "{ \"fieldName\": \"unixAddLogonId\", \"defaultValue\": \"Checked\"}, ";
		}
		if (serviceRequest.isUnixChangeLogonId()) {
			output += "{ \"fieldName\": \"unixChangeLogonId\", \"defaultValue\": \"Checked\"}, ";
		}
		if (serviceRequest.isUnixDeleteLogonId()) {
			output += "{ \"fieldName\": \"unixDeleteLogonId\", \"defaultValue\": \"Checked\"}, ";
		}
		output += "{ \"fieldName\": \"unixLogOnId\", \"defaultValue\": \"" + serviceRequest.getUnixLogOnId() + "\"}, ";
		output += "{ \"fieldName\": \"unixApplication\", \"defaultValue\": \"" + serviceRequest.getUnixApplication() + "\"}, ";
		output += "{ \"fieldName\": \"unixAccessGroup\", \"defaultValue\": \"" + serviceRequest.getUnixAccessGroup() + "\"}, ";
		output += "{ \"fieldName\": \"unixAccountNumber\", \"defaultValue\": \"" + serviceRequest.getUnixAccountNumber() + "\"}, ";
		output += "{ \"fieldName\": \"billingAccountNumber\", \"defaultValue\": \"" + serviceRequest.getBillingAccountNumber() + "\"}, ";
		if (serviceRequest.isSecurIdVpn()) {
			output += "{ \"fieldName\": \"securIdVpn\", \"defaultValue\": \"Checked\"}, ";
		}
		if (serviceRequest.isAdaptiveAuthenticationVpn()) {
			output += "{ \"fieldName\": \"adaptiveAuthenticationVpn\", \"defaultValue\": \"Checked\"}, ";
		}
		
		if (serviceRequest.isEmployee()) {
			output += "{ \"fieldName\": \"departmentNumber3\", \"defaultValue\": \"" + serviceRequest.getDepartmentNumber() + "\"}, ";
			output += "{ \"fieldName\": \"businessPhoneNumber1\", \"defaultValue\": \"" + serviceRequest.getBusinessPhoneNumber() + "\"}, ";
			output += "{ \"fieldName\": \"businessPhoneNumber2\", \"defaultValue\": \"" + serviceRequest.getBusinessPhoneNumber() + "\"}, ";
			output += "{ \"fieldName\": \"businessPhoneNumber3\", \"defaultValue\": \"" + serviceRequest.getBusinessPhoneNumber() + "\"}, ";
			output += "{ \"fieldName\": \"businessPhoneNumber4\", \"defaultValue\": \"" + serviceRequest.getBusinessPhoneNumber() + "\"}, ";
			output += "{ \"fieldName\": \"businessPhoneNumber5\", \"defaultValue\": \"" + serviceRequest.getBusinessPhoneNumber() + "\"}, ";
			String hostedId = "E" + serviceRequest.getEmployeeNumber();
			output += "{ \"fieldName\": \"hostedId1\", \"defaultValue\": \"" + hostedId + "\"}, ";
			output += "{ \"fieldName\": \"hostedId2\", \"defaultValue\": \"" + hostedId + "\"}, ";
			if (serviceRequest.isLaCountyGovAccess()) {
				output += "{ \"fieldName\": \"laCountyGovAccess\", \"defaultValue\": \"Checked\"}, ";
			}
			output += "{ \"fieldName\": \"employeeNumber1\", \"defaultValue\": \"" + serviceRequest.getEmployeeNumber() + "\"}, ";
			output += "{ \"fieldName\": \"employeeNumber2\", \"defaultValue\": \"" + serviceRequest.getEmployeeNumber() + "\"}, ";
			output += "{ \"fieldName\": \"employeeNumber3\", \"defaultValue\": \"" + serviceRequest.getEmployeeNumber() + "\"}, ";
			output += "{ \"fieldName\": \"employeeNumber4\", \"defaultValue\": \"" + serviceRequest.getEmployeeNumber() + "\"}, ";
			output += "{ \"fieldName\": \"employeeEmailAddress1\", \"defaultValue\": \"" + serviceRequest.getEmployeeEmailAddress() + "\"}, ";
			output += "{ \"fieldName\": \"employeeEmailAddress2\", \"defaultValue\": \"" + serviceRequest.getEmployeeEmailAddress() + "\"}, ";
			output += "{ \"fieldName\": \"employeeEmailAddress3\", \"defaultValue\": \"" + serviceRequest.getEmployeeEmailAddress() + "\"}, ";
			output += "{ \"fieldName\": \"binNumber\", \"defaultValue\": \"" + serviceRequest.getBinNumber() + "\"}, ";
			output += "{ \"fieldName\": \"securityAuthorization\", \"defaultValue\": \"" + serviceRequest.getSecurityAuthorization() + "\"}, ";
		}
		else {
			output += "{ \"fieldName\": \"companyName1\", \"defaultValue\": \"" + serviceRequest.getCompanyName() + "\"}, ";
			output += "{ \"fieldName\": \"companyName2\", \"defaultValue\": \"" + serviceRequest.getCompanyName() + "\"}, ";
			output += "{ \"fieldName\": \"companyEmailAddress1\", \"defaultValue\": \"" + serviceRequest.getCompanyEmailAddress() + "\"}, ";
			output += "{ \"fieldName\": \"companyEmailAddress2\", \"defaultValue\": \"" + serviceRequest.getCompanyEmailAddress() + "\"}, ";
			output += "{ \"fieldName\": \"companyEmailAddress3\", \"defaultValue\": \"" + serviceRequest.getCompanyEmailAddress() + "\"}, ";
			output += "{ \"fieldName\": \"companyStreetAddress1\", \"defaultValue\": \"" + serviceRequest.getCompanyStreetAddress() + "\"}, ";
			output += "{ \"fieldName\": \"companyStreetAddress2\", \"defaultValue\": \"" + serviceRequest.getCompanyStreetAddress() + "\"}, ";
			output += "{ \"fieldName\": \"companyCity1\", \"defaultValue\": \"" + serviceRequest.getCompanyCity() + "\"}, ";
			output += "{ \"fieldName\": \"companyCity2\", \"defaultValue\": \"" + serviceRequest.getCompanyCity() + "\"}, ";
			output += "{ \"fieldName\": \"companyState1\", \"defaultValue\": \"" + serviceRequest.getCompanyState() + "\"}, ";
			output += "{ \"fieldName\": \"companyState2\", \"defaultValue\": \"" + serviceRequest.getCompanyState() + "\"}, ";
			output += "{ \"fieldName\": \"companyZip1\", \"defaultValue\": \"" + serviceRequest.getCompanyZip() + "\"}, ";
			output += "{ \"fieldName\": \"companyZip2\", \"defaultValue\": \"" + serviceRequest.getCompanyZip() + "\"}, ";
			output += "{ \"fieldName\": \"companyPhoneNumber1\", \"defaultValue\": \"" + serviceRequest.getCompanyPhoneNumber() + "\"}, ";
			output += "{ \"fieldName\": \"companyPhoneNumber2\", \"defaultValue\": \"" + serviceRequest.getCompanyPhoneNumber() + "\"}, ";
			output += "{ \"fieldName\": \"companyPhoneNumber3\", \"defaultValue\": \"" + serviceRequest.getCompanyPhoneNumber() + "\"}, ";
			output += "{ \"fieldName\": \"companyPhoneNumber4\", \"defaultValue\": \"" + serviceRequest.getCompanyPhoneNumber() + "\"}, ";
			output += "{ \"fieldName\": \"companyPhoneNumber5\", \"defaultValue\": \"" + serviceRequest.getCompanyPhoneNumber() + "\"}, ";
			output += "{ \"fieldName\": \"contractWorkOrderNumber1\", \"defaultValue\": \"" + serviceRequest.getContractWorkOrderNumber() + "\"}, ";
			output += "{ \"fieldName\": \"contractWorkOrderNumber2\", \"defaultValue\": \"" + serviceRequest.getContractWorkOrderNumber() + "\"}, ";
			output += "{ \"fieldName\": \"contractWorkOrderNumber3\", \"defaultValue\": \"" + serviceRequest.getContractWorkOrderNumber() + "\"}, ";
			output += "{ \"fieldName\": \"contractWorkOrderNumber4\", \"defaultValue\": \"" + serviceRequest.getContractWorkOrderNumber() + "\"}, ";
			output += "{ \"fieldName\": \"contractExpirationDate1\", \"defaultValue\": \"" + serviceRequest.getContractExpirationDate() + "\"}, ";
			output += "{ \"fieldName\": \"contractExpirationDate2\", \"defaultValue\": \"" + serviceRequest.getContractExpirationDate() + "\"}, ";
			output += "{ \"fieldName\": \"countyEmailAddress1\", \"defaultValue\": \"" + serviceRequest.getCountyEmailAddress() + "\"}, ";
			output += "{ \"fieldName\": \"countyEmailAddress2\", \"defaultValue\": \"" + serviceRequest.getCountyEmailAddress() + "\"}, ";
			output += "{ \"fieldName\": \"countyPhoneNumber1\", \"defaultValue\": \"" + serviceRequest.getCountyPhoneNumber() + "\"}, ";
			output += "{ \"fieldName\": \"countyPhoneNumber2\", \"defaultValue\": \"" + serviceRequest.getCountyPhoneNumber() + "\"}, ";
		}
		
		return output.substring(0, output.length()-2);
	}

}
