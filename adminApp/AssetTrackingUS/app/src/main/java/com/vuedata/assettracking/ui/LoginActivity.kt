package com.vuedata.assettracking.ui

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import com.vuedata.assettracking.databinding.ActivityLoginBinding
import com.amazonaws.mobile.client.AWSMobileClient
import android.widget.Toast
import androidx.core.view.isVisible
import com.amazonaws.mobile.client.Callback
import com.vuedata.assettracking.R
import com.amazonaws.mobile.client.results.SignInResult
import com.amazonaws.mobile.client.results.SignInState
import com.amazonaws.mobile.client.UserState
import com.amazonaws.mobile.client.UserStateDetails


class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    val TAG = "LoginActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =
            DataBindingUtil.setContentView(this, R.layout.activity_login)


        binding.token.setOnClickListener {
            val sharedPreferences: SharedPreferences =
                getSharedPreferences("Asset", MODE_PRIVATE)
            binding.gettoken.setText("" + sharedPreferences.getString("token", ""))
            if (binding.gettoken.isVisible) {
                binding.token.setText("Device Token")
                binding.gettoken.visibility = View.GONE
            } else {
                binding.token.setText("Hide")
                binding.gettoken.visibility = View.VISIBLE
            }

        }

        // 'this' refers the current active activity
        AWSMobileClient.getInstance()
            .initialize(applicationContext, object : Callback<UserStateDetails> {
                override fun onResult(userStateDetails: UserStateDetails) {
                    when (userStateDetails.userState) {
                        UserState.SIGNED_IN -> runOnUiThread {
                            Log.i(TAG, "Logged IN")


                            val intent = Intent(applicationContext, AdminActivity::class.java)
                            // start your next activity
                            startActivity(intent)
                            finish()
                        }
                        UserState.SIGNED_OUT -> runOnUiThread {
                            Log.i(TAG, "Logged OUT")
                        }
                        else -> AWSMobileClient.getInstance().signOut()
                    }
                }

                override fun onError(e: Exception) {
                    Log.e(TAG, e.toString())
                    makeToast("" + e.message)

                }
            })

        binding.login.setOnClickListener {

            AWSMobileClient.getInstance()
                .signIn(
                    binding.email.text.toString(),
                    binding.pws.text.toString(),
                    null,
                    object : Callback<SignInResult> {
                        override fun onResult(signInResult: SignInResult) {
                            runOnUiThread {
                                Log.d(TAG, "Sign-in callback state: " + signInResult.signInState)
                                when (signInResult.signInState) {
                                    SignInState.DONE -> {
                                        makeToast("Sign-in done.")
                                        val sharedPreferences: SharedPreferences =
                                            getSharedPreferences("Asset", MODE_PRIVATE)
                                        binding.gettoken.setText("" + sharedPreferences.getString("token", ""))
                                        val myEdit: SharedPreferences.Editor = sharedPreferences.edit()
                                        myEdit.putString("Username",binding.email.text.toString().toLowerCase())
                                        myEdit.apply()
                                        myEdit.commit()
                                        AWSMobileClient.getInstance().deviceOperations.updateStatus(
                                            false,
                                            object : Callback<Void?> {
                                                override fun onResult(result: Void?) {
                                                    Log.d(TAG, "onResult: ")
                                                }

                                                override fun onError(e: Exception) {
                                                    Log.e(TAG, "onError: ", e)
                                                }
                                            })
                                        val intent =
                                            Intent(applicationContext, AdminActivity::class.java)
                                        // start your next activity
                                        startActivity(intent)
                                        finish()
                                    }
                                    SignInState.SMS_MFA -> makeToast("Please confirm sign-in with SMS.")
                                    SignInState.NEW_PASSWORD_REQUIRED -> makeToast("Please confirm sign-in with new password.")
                                    else -> makeToast("Unsupported sign-in confirmation: " + signInResult.signInState)
                                }
                            }
                        }

                        override fun onError(e: Exception) {
                            Log.e(TAG, "Sign-in error", e)
                            makeToast("" + e.message)
                        }
                    })
        }


        binding.registration.setOnClickListener {
            val intent = Intent(this, RegistrationActivity::class.java)
            // start your next activity
            startActivity(intent)
        }
    }

    fun makeToast(msg: String) {
        try {
            Toast.makeText(applicationContext, msg, Toast.LENGTH_LONG).show()
        } catch (e: Exception) {
        }
    }
}