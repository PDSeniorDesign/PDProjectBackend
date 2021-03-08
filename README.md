# PDProjectBackend

## Description
&nbsp;
Backend operations for the L.A. County Public Defender's modernized database project.

## API Description
&nbsp;
**1. Service Request**

METHOD | ENDPOINT | DESCRIPTION
-----------|-----|------------
GET | service_requests | Gets all the service requests in the database
GET | service_requests/{id} | Get a specific service request based on id
POST | service_requests | Add a service request
PUT | service_request/{id} | Update a service request

&nbsp;
**2. Request Status**

METHOD | ENDPOINT | DESCRIPTION
-----------|-----|------------
GET | request_statuses/{id} | Get the service request's request status

&nbsp;
## Installation
&nbsp;
1. Download repository to your PC
2. Import to Eclipse (or IDE of choice) as Maven project
3. Import values into your SQL server from src/main/resources/backend.sql
4. Update application.properties to reflect your SQL database as noted:
   * spring.datasource.url=jdbc:mysql://{hostname}:{port}/{database}
   * spring.datasource.username={username}
   * spring.datasource.password={password}
5. Run DemoApplication.java
6. Test the 4 endpoints by opening them in your browser. All but service_requests should be populated at this point:
   * http://{hostname}:{port}/fields
   * http://{hostname}:{port}/forms
   * http://{hostname}:{port}/mappings
   * http://{hostname}:{port}/service_requests

Your backend is now running! Feel free to test the service_requests endpoint by entering the following POST request into Postman Desktop:

```
{
   "newRegistration":true,
   "deletePriorRegistration":false,
   "updatePriorRegistration":false,
   "replaceLostToken":false,
   "addLogonId":true,
   "changeLogonId":false,
   "deleteLogonId":false,
   "lastName":"Doe",
   "firstName":"John",
   "middleInitial":"F",
   "employeeNumber":"15",
   "departmentName":"Example Department",
   "departmentNumber":"512",
   "companyName":"Jim's Burgers",
   "companyEmailAddress":"jgarc659@calstatela.edu",
   "countyEmailAddress":"example@lacounty.gov",
   "employeeEmailAddress":"employee@publicdefender.gov",
   "businessStreetAddress":"500 Example Ave.",
   "businessCity":"Los Angeles",
   "businessState":"CA",
   "businessZip":"90032",
   "businessPhoneNumber":"555-263-8342",
   "workMailingAddress":"100 3rd St, Los Angeles, CA, 90032",
   "companyStreetAddress":"123 Apple St.",
   "companyCity":"Los Angeles",
   "companyState":"CA",
   "companyZip":"90032",
   "companyPhoneNumber":"232-626-1673",
   "countyPhoneNumber":"612-626-7832",
   "contractWorkOrderNumber":"C2672721",
   "contractExpirationDate":"06/01/2021",
   "ibmLogOnId":"23626",
   "majorGroupCode":"272727",
   "lsoGroupCode":"2352762",
   "securityAuthorization":"Authorization",
   "tsoAccess":true,
   "tsoGroupCode":"Group Code",
   "binNumber":"Bin Number",
   "subGroup1":"Test Subgroup",
   "subGroup2":"Test Subgroup",
   "subGroup3":"Test Subgroup",
   "onlineAccess":true,
   "systemApplication":"System Application",
   "groupName":"Test Group",
   "oldGroup":"Old Group",
   "unixAddLogonId":true,
   "unixChangeLogonId":false,
   "unixDeleteLogonId":false,
   "unixLogOnId":"261361",
   "unixApplication":"Unix Application",
   "unixAccessGroup":"Unix Access Group",
   "unixAccountNumber":"Unix Account Number",
   "billingAccountNumber":"844362",
   "securIdVpn":false,
   "adaptiveAuthenticationVpn":false,
   "internetApplication":true,
   "exchangeEmail":false,
   "emailEncryption":false,
   "laCountyGovAccess":true,
   "tokenlessAuthentication":false,
   "lacMobileWifiAccess":true,
   "cherwellSms":false,
   "windowsRightsMgmt":false,
   "gmailAccess":true,
   "yahooMailAccess":false,
   "otherEmailAccess":false,
   "businessJustification":"Access required to these technologies.",
   "defaultCountyWidePolicy":false,
   "departmentPolicyRule0":false,
   "departmentPolicyRule1":true,
   "departmentPolicyRule2":false,
   "departmentPolicyRule3":false,
   "departmentPolicyRule4":false,
   "socialNetworkingFacebook":true,
   "socialNetworkingTwitter":false,
   "socialNetworkingLinkedIn":false,
   "complete":false,
   "employee":false
}
```
More detailed instructions in src/main/resources/HowToRunBackend.pdf
