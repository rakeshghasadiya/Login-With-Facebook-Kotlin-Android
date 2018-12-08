package com.datamintsolutions.loginwithfacebook

import android.app.Application
import com.facebook.FacebookSdk
import com.facebook.appevents.AppEventsLogger

class AppLoginWithFacebook : Application() {

    override fun onCreate() {
        super.onCreate()
        appLoginWithFacebook = this
        FacebookSdk.sdkInitialize(applicationContext)
        AppEventsLogger.activateApp(this)
    }

    companion object {
        lateinit var appLoginWithFacebook: AppLoginWithFacebook
    }
}
