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
    "createDate":"10/15/2020",
    "submitDate":"11/01/2020",
    "registrationType":"New",
    "requestType":null,
    "lastName":"Doe",
    "firstName":"John",
    "middleInitial":"F",
    "requestStatus":"”Active”",
    "employeeNumber":15,
    "hostedId":265,
    "departmentName":"Example Department",
    "departmentNumber":512,
    "companyName":null,
    "companyEmailAddress":null,
    "departmentEmailAddress":"john_doe@example.com",
    "countyEmailAddress":null,
    "employeeEmailAddress":null,
    "businessStreetAddress":"500 Example Ave.",
    "businessCity":"Los Angeles",
    "businessState":"CA",
    "businessZip":"90032",
    "businessPhoneNumber":"555-263-8342",
    "workMailingAddress":null,
    "companyStreetAddress":null,
    "companyCity":null,
    "companyState":null,
    "companyZip":null,
    "companyPhoneNumber":null,
    "countyPhoneNumber":null,
    "workPhoneNumber":null,
    "contractWorkOrderNumber":null,
    "contractExpirationDate":null,
    "customerSignature":null,
    "customerSignatureDate":null,
    "ibmLogOnId":null,
    "majorGroupCode":null,
    "lsoGroupCode":null,
    "securityAuthorization":null,
    "tsoAccess":false,
    "tsoGroupCode":null,
    "binNumber":null,
    "subGroup1":null,
    "subGroup2":null,
    "subGroup3":null,
    "onlineAccess":false,
    "systemApplication":null,
    "groupName":null,
    "oldGroup":null,
    "apsAo":null,
    "dmvSystemCode":null,
    "jaiSystemLocation":null,
    "unixRequestType":null,
    "unixLogOnId":null,
    "unixApplication":null,
    "unixAccessGroup":null,
    "unixAccountNumber":null,
    "billingAccountNumber":null,
    "accessType":null,
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
    "otherEmailDomain":null,
    "businessJustification":"Access required to these technologies.",
    "defaultCountyWidePolicy":false,
    "departmentPolicyRule0":false,
    "departmentPolicyRule1":false,
    "departmentPolicyRule2":false,
    "departmentPolicyRule3":false,
    "departmentPolicyRule4":false,
    "socialNetworkingFacebook":false,
    "socialNetworkingTwitter":false,
    "socialNetworkingLinkedIn":false
}
```
More detailed instructions in src/main/resources/HowToRunBackend.pdf
