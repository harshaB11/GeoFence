package com.vuedata.assettracking.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.amplifyframework.core.Amplify
import com.vuedata.assettracking.R
import com.vuedata.assettracking.databinding.ActivityConfirmSignInBinding
import com.vuedata.assettracking.databinding.ActivityLoginBinding
import java.lang.Exception
import com.amazonaws.mobile.client.AWSMobileClient
import com.amazonaws.mobile.client.Callback
import com.amazonaws.mobile.client.results.SignUpResult
import com.amazonaws.mobile.client.results.UserCodeDeliveryDetails

import android.widget.Toast


class ConfirmSignInActivity : AppCompatActivity() {
    lateinit var binding: ActivityConfirmSignInBinding
    var username: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =
            DataBindingUtil.setContentView(this, R.layout.activity_confirm_sign_in)

        try {
            username = intent.getStringExtra("username")
        } catch (e: Exception) {
        }

        binding.resend.setOnClickListener {
            AWSMobileClient.getInstance()
                .resendSignUp(username, object : Callback<SignUpResult?> {
                    override fun onResult(signUpResult: SignUpResult?) {
                        Log.i(
                            "TAG", "A verification code has been sent via" +
                                    signUpResult!!.getUserCodeDeliveryDetails().getDeliveryMedium()
                                        .toString() + " at " +
                                    signUpResult.getUserCodeDeliveryDetails().getDestination()
                        )
                    }

                    override fun onError(e: Exception?) {
                        Log.e("TAG", e.toString())
                    }
                })
        }

        binding.verifyButton.setOnClickListener {
            val code: String = binding.code.text.toString()
            AWSMobileClient.getInstance()
                .confirmSignUp(username, code, object : Callback<SignUpResult> {
                    override fun onResult(signUpResult: SignUpResult) {
                        runOnUiThread {
                            Log.d(
                                "TAG",
                                "Sign-up callback state: " + signUpResult.confirmationState
                            )
                            if (!signUpResult.confirmationState) {
                                val details = signUpResult.userCodeDeliveryDetails
                                makeToast("Confirm sign-up with: " + details.destination)
                                rememberedDevice()
                                val intent = Intent(applicationContext, LoginActivity::class.java)
                                // start your next activity
                                startActivity(intent)
                                finish()
                            } else {
                                makeToast("Sign-up done.")
                                rememberedDevice()
                                val intent = Intent(applicationContext, LoginActivity::class.java)
                                // start your next activity
                                startActivity(intent)
                                finish()
                            }
                        }
                    }

                    override fun onError(e: Exception) {
                        Log.e("TAG", "Confirm sign-up error", e)
                        makeToast("" + e.message)
                    }
                })

        }
    }

    fun makeToast(msg: String) {
        try {
            Toast.makeText(applicationContext, msg, Toast.LENGTH_LONG).show()
        } catch (e: Exception) {
        }
    }

    fun rememberedDevice() {
        AWSMobileClient.getInstance().deviceOperations.updateStatus(true, object : Callback<Void?> {
            override fun onResult(result: Void?) {
                Log.d("TAG", "onResult: ")
            }

            override fun onError(e: Exception) {
                Log.e("TAG", "onError: ", e)
            }
        })
    }
}