package com.datamintsolutions.loginwithfacebook

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.facebook.CallbackManager
import com.facebook.FacebookException
import com.facebook.login.LoginResult
import com.facebook.FacebookCallback
import java.util.Arrays.asList
import com.facebook.login.widget.LoginButton
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import android.content.Intent
import android.util.Log
import com.facebook.AccessToken






class MainActivity : AppCompatActivity() {

    var callbackManager = CallbackManager.Factory.create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       init()


    //    val accessToken = AccessToken.getCurrentAccessToken()
    //    val isLoggedIn = accessToken != null && !accessToken.isExpired

    }
    fun init(){


        val EMAIL = "email"


         loginButton.setReadPermissions(Arrays.asList(EMAIL))
        // If you are using in a fragment, call loginButton.setFragment(this);

        // Callback registration
        loginButton.registerCallback(callbackManager, object : FacebookCallback<LoginResult> {
            override fun onSuccess(loginResult: LoginResult) {
                // App code
                Log.e("Token","${loginResult.accessToken.token}")
            }

            override fun onCancel() {
                // App code
            }

            override fun onError(exception: FacebookException) {
                // App code
            }
        })
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        callbackManager.onActivityResult(requestCode, resultCode, data)
        super.onActivityResult(requestCode, resultCode, data)
    }
}
