package com.example.kotlinlogin_2

import android.content.Intent
import android.graphics.Color
import android.graphics.Paint.Join
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private lateinit var gestureDetector: GestureDetector

    val Headings = listOf("Quality", "Convenient", "Local")

    val Description = listOf("Sell your farm fresh products directly to consumers, cutting out the middleman and reducing emissions of the global supply chain.", "Our team of delivery drivers will make sure your orders are picked up on time and promptly delivered to your customers.", "We love the earth and know you do too! Join us in reducing our local carbon footprint one order at a time. ")

    val screens = listOf(R.drawable.screen1, R.drawable.screen2, R.drawable.screen3)

    val toggles = listOf(R.drawable.toggle1, R.drawable.toggle2, R.drawable.toggle3)

    val change_colour = listOf("#5DA15F", "#D5715B", "#F8C569")

    private lateinit var Heading_View: TextView

    private lateinit var Description_View: TextView

    private lateinit var Toggle: ImageView

    private lateinit var Screen: View

    private lateinit var Join_Button: Button

    private lateinit var Login: TextView


    var current_screen = 0

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gestureDetector = GestureDetector(this, GestureListener())

            Screen = findViewById<View>(R.id.screen_background)

            Heading_View = findViewById<TextView>(R.id.Heading)

            Description_View = findViewById<TextView>(R.id.Description)

            Toggle = findViewById<ImageView>(R.id.Toggle)

            Join_Button = findViewById<Button>(R.id.JoinButton)

            Login = findViewById(R.id.Login)

            Login.setOnClickListener{

                val intent = Intent(this, Login_Registration::class.java)
                startActivity(intent) // Start the SecondActivity


            }


    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return gestureDetector.onTouchEvent(event!!) || super.onTouchEvent(event)
    }

    inner class GestureListener : GestureDetector.SimpleOnGestureListener() {
        private val SWIPE_THRESHOLD = 100
        private val SWIPE_VELOCITY_THRESHOLD = 100

        override fun onFling(
            e1: MotionEvent?,
            e2: MotionEvent,
            velocityX: Float,
            velocityY: Float
        ): Boolean {
            val diffX = e2?.x?.minus(e1?.x ?: 0f) ?: 0f
            val diffY = e2?.y?.minus(e1?.y ?: 0f) ?: 0f

            if (Math.abs(diffX) > Math.abs(diffY)) {
                if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                    if (diffX > 0) {
                        onSwipeRight()
                    } else {
                        onSwipeLeft()
                    }
                    return true
                }
            }

            return false
        }
    }

    private fun onSwipeRight() {



        if ( current_screen != 0){

            current_screen -= 1
            change_content()

        }

    }

    private fun onSwipeLeft() {


        if ( current_screen != 2){

            current_screen += 1
            change_content()

        }

    }

    private fun change_content() {
        Screen.setBackgroundResource(screens[current_screen])
        Heading_View.setText(Headings[current_screen])
        Description_View.setText(Description[current_screen])
        Toggle.setImageResource(toggles[current_screen])
        Join_Button.setBackgroundColor(Color.parseColor(change_colour[current_screen]))


    }


}