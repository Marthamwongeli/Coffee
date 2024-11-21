package com.akirachix.cupfulcanvasapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ThankYouActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thank_you)

        val returnToMenuButton = findViewById<Button>(R.id.returnToMenuButton)
        val exitAppButton = findViewById<Button>(R.id.exitAppButton)

        // Navigate back to the main menu
        returnToMenuButton.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }

        // Exit the app
        exitAppButton.setOnClickListener {
            finishAffinity() // Close all activities
        }
    }
}
