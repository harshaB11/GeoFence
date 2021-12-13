package com.vuedata.assettracking.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.amazonaws.mobile.client.AWSMobileClient
import com.amazonaws.mobile.client.Callback
import com.amazonaws.mobile.client.results.SignUpResult
import com.amazonaws.mobile.client.results.UserCodeDeliveryDetails
import com.amplifyframework.auth.AuthUserAttributeKey
import com.amplifyframework.auth.options.AuthSignUpOptions
import com.amplifyframework.core.Amplify
import com.vuedata.assettracking.R
import com.vuedata.assettracking.databinding.ActivityLoginBinding
import com.vuedata.assettracking.databinding.ActivityRegistrationBinding
import java.util.HashMap

class RegistrationActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegistrationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =
            DataBindingUtil.setContentView(this, R.layout.activity_registration)

        binding.registration.setOnClickListener {

            val username: String = binding.username.text.toString()
            val password: String = binding.pws.text.toString()
            val attributes: MutableMap<String, String> = HashMap()
            attributes["email"] = binding.email.text.toString()
            AWSMobileClient.getInstance()
                .signUp(username, password, attributes, null, object : Callback<SignUpResult?> {
                    override fun onResult(signUpResult: SignUpResult?) {
                        runOnUiThread {
                            Log.d(
                                "TAG",
                                "Sign-up callback state: " + signUpResult!!.getConfirmationState()
                            )
                            if (!signUpResult!!.getConfirmationState()) {
                                val details: UserCodeDeliveryDetails =
                                    signUpResult.getUserCodeDeliveryDetails()
                                Toast.makeText(
                                    applicationContext,
                                    "Confirm sign-up with: " + details.destination,
                                    Toast.LENGTH_LONG
                                ).show()
                                val intent =
                                    Intent(applicationContext, ConfirmSignInActivity::class.java)
                                // start your next activity
                                intent.putExtra("username", binding.username.text.toString())
                                startActivity(intent)
                                finish()
                            } else {
                                Toast.makeText(
                                    applicationContext,
                                    "Sign-up done.",
                                    Toast.LENGTH_LONG
                                ).show()
                                val intent =
                                    Intent(applicationContext, ConfirmSignInActivity::class.java)
                                // start your next activity
                                intent.putExtra("username", binding.username.text.toString())
                                startActivity(intent)
                                finish()
                            }
                        }
                    }

                    override fun onError(e: Exception?) {
                        Log.e("TAG", "Sign-up error", e)
                        try {
                            Toast.makeText(applicationContext, "" + e!!.message, Toast.LENGTH_LONG)
                                .show()
                        } catch (e: Exception) {
                        }
                    }


                })
        }
    }
}