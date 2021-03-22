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

**Common Request Statuses**
STATUS ORIGIN | CODE | DESCRIPTION
-----------|-----|------------
Backend App | DRAFT | The Service Request is saved but not yet submitted by the user.
Backend App | SUBMITTED_FOR_REVIEW | The Service Request is submitted by the user for Admin review.
Adobe Sign API | CREATED | Agreement has been created and signing initiated.
Adobe Sign API | ACTION_REQUESTED | Email sent to current recipient to sign Agreement.
Adobe Sign API | EMAIL_VIEWED | Current recipient has seen Adobe Sign email.
Adobe Sign API | ACTION_COMPLETED | Recipient has signed/approved the Agreement.
Adobe Sign API | RECALLED | Adobe Sign user has cancelled Agreement.

**Full List of Adobe Sign API Request Status Codes:**

['ACCESS_CODE_GENERATED' or 'ACCESS_CODE_CONSUMED' or 'AUTO_CANCELLED_CONVERSION_PROBLEM' or 'ACTION_AUTO_DELEGATED' or 'ACTION_COMPLETED' or 'ACTION_COMPLETED_HOSTED' or 'ACTION_COMPLETED_OFFLINE' or 'ACTION_COMPLETED_OFFLINE_HOSTED' or 'ACTION_COMPLETED_WIDGET_VERIFIED' or 'ACTION_COMPLETED_WIDGET_VERIFIED_API_TOKEN' or 'ACTION_COMPLETED_WIDGET_VERIFICATION_WAIVED' or 'ACTION_DELEGATED' or 'ACTION_REPLACED_SIGNER' or 'ACTION_REQUESTED' or 'CREATED' or 'CREATED_FROM_WIDGET' or 'CREATED_OFFLINE' or 'CREATED_VIA_UPLOAD' or 'CREATED_VIA_ACROBAT' or 'CREATED_VIA_READER' or 'ACTIVATED' or 'DIGITAL_SIGN_UIDAI_SIGNER_CONSENT' or 'DIGSIGNED' or 'DEACTIVATED' or 'DOCUMENTS_DELETED' or 'DOWNLOADED' or 'EMAIL_BOUNCED' or 'EMAIL_VIEWED' or 'EXPIRED' or 'EXPIRED_AUTOMATICALLY' or 'FAXED_BY_SENDER' or 'FAXIN_RECEIVED' or 'KBA_AUTHENTICATED' or 'MODIFIED' or 'OFFLINE_SYNC' or 'OTHER' or 'PAID' or 'PRESIGNED' or 'RECALLED' or 'RECALLED_MAX_SIGNING_KBA_ATTEMPTS' or 'RECALLED_MAX_SIGNING_PASSWORD_ATTEMPTS' or 'RECALLED_MAX_SIGNING_PHONE_ATTEMPTS' or 'REJECTED' or 'SENDER_CREATED_NEW_REVISION' or 'SHARED' or 'SIGNED' or 'SIGNING_URL_REQUESTED' or 'UPLOADED_BY_SENDER' or 'USER_ACK_AGREEMENT_MODIFIED' or 'READY_TO_VAULT' or 'VAULTED' or 'WEB_IDENTITY_AUTHENTICATED' or 'WEB_IDENTITY_SPECIFIED' or 'WRITTEN_DOWNLOAD' or 'WRITTEN_SIGNED']
