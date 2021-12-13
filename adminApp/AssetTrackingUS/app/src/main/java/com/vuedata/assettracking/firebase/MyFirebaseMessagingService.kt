package com.vuedata.assettracking.firebase

import android.app.Notification
import com.google.firebase.messaging.FirebaseMessagingService
import android.app.NotificationManager
import com.google.firebase.messaging.RemoteMessage
import com.vuedata.assettracking.firebase.MyFirebaseMessagingService
import com.vuedata.assettracking.firebase.MessageData
import android.content.Intent
import android.app.PendingIntent
import android.net.Uri
import android.media.RingtoneManager
import android.graphics.Color
import android.os.Build
import android.app.NotificationChannel
import android.content.Context
import android.content.SharedPreferences
import android.provider.Settings
import android.util.Log
import androidx.core.app.NotificationCompat
import com.vuedata.assettracking.R
import com.google.gson.GsonBuilder

import com.amazonaws.auth.policy.Principal.AllUsers
import com.amazonaws.mobile.client.Callback
import com.amazonaws.mobile.client.UserStateDetails
import com.amazonaws.mobile.config.AWSConfiguration

import java.util.ArrayList

import com.google.gson.reflect.TypeToken
import com.vuedata.assettracking.ui.AdminActivity

import org.json.JSONArray
import org.json.JSONObject
import java.lang.reflect.Type


class MyFirebaseMessagingService : FirebaseMessagingService() {
    var channelId = "45677"
    var notificationManager: NotificationManager? = null

    /**
     * Called when message is received.
     *
     * @param remoteMessage Object representing the message received from Firebase Cloud Messaging.
     */
    // [START receive_message]
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        // TODO(developer): Handle FCM messages here.
        // Not getting messages here? See why this may be: https://goo.gl/39bRNJ
        Log.d(TAG, "From: " + remoteMessage.from)
        if (remoteMessage == null) {
            Log.i(TAG, "Received null remote message")
            return
        }
        // Check if message contains a data payload.
        if (remoteMessage.data.size > 0) {
            Log.d(TAG, "Message data payload: " + remoteMessage.data["default"].toString())
            var results: NotificationData?=null
            try {
                 results = GsonBuilder().create().fromJson(
                    remoteMessage.data["default"].toString(),
                    NotificationData::class.java
                )
            }catch (e:Exception){}
            val sharedPreferences: SharedPreferences =
                getSharedPreferences("Asset", MODE_PRIVATE)
            if(results!!.detail!!.DeviceId!!.
                equals(""+sharedPreferences.getString("Username",""))) {
                sendNotification(results)
            }
        }

        // Check if message contains a notification payload.
        if (remoteMessage.notification != null) {
            Log.d(
                TAG, "Message Notification Body: " + remoteMessage.notification!!
                    .body
            )
            val datanotify= MessageData(
                remoteMessage.notification!!.body.toString(),
               remoteMessage.notification!!.channelId,
               remoteMessage.notification!!.tag,
                remoteMessage.notification!!.title)
           // sendNotification(datanotify)
        }

        // Also if you intend on generating your own notifications as a result of a received FCM
        // message, here is where that should be initiated. See sendNotification method below.
    }
    // [END receive_message]
    // [START on_new_token]
    /**
     * There are two scenarios when onNewToken is called:
     * 1) When a new token is generated on initial app startup
     * 2) Whenever an existing token is changed
     * Under #2, there are three scenarios when the existing token is changed:
     * A) App is restored to a new device
     * B) User uninstalls/reinstalls the app
     * C) User clears app data
     */
    override fun onNewToken(token: String) {
        Log.d(TAG, "Refreshed token: $token")

        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // FCM registration token to your app server.
       // sendRegistrationToServer(token)
        val sharedPreferences: SharedPreferences =
            getSharedPreferences("Asset", MODE_PRIVATE)
        val myEdit: SharedPreferences.Editor = sharedPreferences.edit()

        // write all the data entered by the user in SharedPreference and apply

        // write all the data entered by the user in SharedPreference and apply
        myEdit.putString("token", token)
        myEdit.apply()
        myEdit.commit()
    }
    // [END on_new_token]
    /**
     * Persist token to third-party servers.
     *
     *
     * Modify this method to associate the user's FCM registration token with any
     * server-side account maintained by your application.
     *
     * @param token The new token.
     */
    private fun sendRegistrationToServer(token: String) {
        // TODO: Implement this method to send token to your app server.

    }

    /**
     * Create and show a simple notification containing the received FCM message.
     *
     * @param data FCM message  received.
     */
    private fun sendNotification(data: NotificationData?) {
        val notificationId = 45
        if (data == null) {
            return
        }
        createNotificationChannel()
        val intent = Intent(this, AdminActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        val pendingIntent = PendingIntent.getActivity(
            this, 0 /* Request code */, intent,
            PendingIntent.FLAG_ONE_SHOT
        )
        val defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        val notificationBuilder: NotificationCompat.Builder
        notificationBuilder = NotificationCompat.Builder(this, channelId)
            .setSmallIcon(R.drawable.ic_car)
            .setContentTitle("Asset Tracker")
            .setContentText(data.detail!!.DeviceId+" is "+data.detail!!.EventType.toString())
            .setAutoCancel(true)
            .setColor(Color.rgb(243, 113, 33))
            .setSound(defaultSoundUri)
            .setPriority(NotificationManager.IMPORTANCE_HIGH)
            .setDefaults(Notification.DEFAULT_SOUND)
            .setContentIntent(pendingIntent)
        notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        notificationManager!!.notify(notificationId, notificationBuilder.build())
    }

    private fun createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = getString(R.string.notifications_admin_channel_name)
            val descriptionText = getString(R.string.notifications_admin_channel_description)
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(channelId, name, importance)
            channel.description = descriptionText
            // Register the channel with the system
            notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            notificationManager!!.createNotificationChannel(channel)
        }
    }

    companion object {
        private const val TAG = "MyFirebaseMsgService"
        private const val REMOTE_MESSAGE_SUBSCRIPTIONS_KEY = "currentStatus"
    }

}