# Geofence

Asset Tracker

Two kinds of user able to login in App, one of the Norma User like Driver, Currier boy etc. second one is Admin user. 

Normal User (Truck Driver):
sign up user with only 3 parameter username (must be unique, unable to create same username.), email and password.
If user successfully sign up then will send verification code in register email id after verifying sign up, user able to login with username and password.
Once user login successfully, every time does not require login. Until user does not uninstall APK.
Tracking Device:
location permission should be allowed by user for tracking purpose that is mandatory else android OS restrict to tracking device functionality. User Device is register by username, so admin will be easy to identify and track to specific person.
 when user successfully login and allow location permission then device tracker will start. If click on cross icon car button, then tracker will stop to tracking. 

Admin User (Owner):
sign up user with only 3 parameter username (must be unique, unable to create same username.), email and password
If user successfully sign up then will send verification code in register email id after verifying sign up, user able to login with username and password.
Once user login successfully, every time does not require login. Until user does not uninstall APK.

If tracker inside the geofence area, then user will get notification that Asset Enter and user will exit from geofence area then user will get notification that Asset Exit. So admin will notify who is enter or exit.


Track Device:
Admin able to track all device at time and admin able to track and delete specific device. 
geofence area draw by polygon shape on map. So, admin is easy to understand device is inside the area or outside the area.
Track All device:
click on track all device button then all devices will show on map, admin able to check on map where is asset right now. When admin click on marker then display information about device username and time.

Track and delete specific device:
Click on track and delete specific device then user able to see list of usernames, admin able to delete any username if admin don’t want to track that person.
If user click on specific username row, then open map and admin able to track that specific user on map.




Technical:

 Used AWS service for Development of Asset Tracker

Authentication:

sign up, sign in and verification code send to user by using AWS Cognito. When user successfully login then Rembert device info in AWS. So if any time admin can check history of register user.


Not used any 3rd party API for authenticate user, used android library like com.amazonaws:aws-android-sdk-core:2.36.0



Location Service:
 used AWS location service for asset tracker. Used map style Esri Light, add geofence collection file. Geofence collocation create by using http://geojson.io. After link tracker with geofence. So when asset enter and exit then user will notify by using notification

Tracker:

Tracker always have any unique device id. Tracker will identify from that id. But in Asset Tracker app,  username as unique parameter so we are passing Username as device Id. But we can pass any other unique parameter as according requirement.  

Role: 

Set role for geofence collocation, tracker and map like BatchDevicePositionUpdate, ListofDeviceTrack etc. without role set it will not work.


Notification:
used AWS Event Bridge for send notification to user. Create rule set pattern for enter and exit Tracker from geofence collection.
Create SNS for send push notification to android device. as platform used FCM. So, AWS send push notification via FCM.
As of now, not taken development for register FCM token on AWS Server DB. Manually add FCM token in SNS. Only single time need to add FCM device token when user APK install.

Also, CloudWatch added in event bridge so from logs we can check event bridge is working fine or not?
