package com.skytech.util

import android.webkit.CookieManager
import android.webkit.WebStorage
import com.skytech.data.ApiService
import com.skytech.data.RetrofitClientInstance
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

object LogoutSkyTech {

    @JvmStatic
    fun logout(deviceToken: String, appId: String) {
        WebStorage.getInstance().deleteAllData()

        // Clear all the cookies
        CookieManager.getInstance().removeAllCookies(null);
        CookieManager.getInstance().flush();

        val body = hashMapOf<String, String>()
        body["X-DEVICE-TOKEN"] = deviceToken
        body["X-APP-ID"] = appId

        val api: ApiService =
            RetrofitClientInstance.getRetrofitInstance()!!.create(ApiService::class.java)
        CoroutineScope(IO).launch {
            try {
                api.logout(body)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
