package com.skytecksdk

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.skytech.model.SkyTech
import com.skytech.util.LogoutSkyTech
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val launch = findViewById<TextView>(R.id.launch_sdk)
        val logout = findViewById<Button>(R.id.logout)

        launch.setOnClickListener {
            val credentials = JSONObject()
            credentials.put("language", "en")

            val contact = JSONObject()
            val identity = JSONObject()

            contact.put("email", "user@test.com")
            contact.put("fullname", "test Test")
            contact.put("phone", "+994XXXXXXX")

            identity.put("field", "email")

            credentials.put("contact", contact)
            credentials.put("identity", identity)

            SkyTech.Builder()
                .key("api_key")
                .appID("app_id")
                .firebaseToken("your_fb_token")
                .userCredentials(credentials)
                .open(this)
        }

        logout.setOnClickListener {
            LogoutSkyTech.logout(
                deviceToken = "your_fb_token",
                appId = "app_id"
            )
        }
    }

}
