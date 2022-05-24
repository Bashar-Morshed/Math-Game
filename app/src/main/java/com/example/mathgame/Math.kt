package com.example.mathgame

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class Math : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_math)

        createNotificationChannel()

        var num1: Int = (0..100).random()
        var num2: Int = (0..100).random()
        var num3: Int = (0..100).random()

        var num4: Int = (0..100).random()
        var num5: Int = (0..100).random()
        var num6: Int = (0..100).random()

        val ed7: EditText = findViewById(R.id.editTextNumber7)
        val ed12: EditText = findViewById(R.id.editTextNumber12)
        val ed15: EditText = findViewById(R.id.editTextNumber15)

        val ed6: EditText = findViewById(R.id.editTextNumber6)
        val ed9: EditText = findViewById(R.id.editTextNumber9)
        val ed14: EditText = findViewById(R.id.editTextNumber14)

        val txt5: TextView = findViewById(R.id.textView5)
        val txt7: TextView = findViewById(R.id.textView7)
        val txt8: TextView = findViewById(R.id.textView8)
        val intent3 = Intent(this, MainActivity::class.java)

        val txt13: TextView = findViewById(R.id.textView13)

        val bundle: Bundle? = intent.extras
        bundle?.let {
            val msg2 = bundle.getString("key")
            txt13.setText(msg2)

        }




        if (exp == "Addition") {
            txt5.text = "+"
            txt7.text = "+"
            txt8.text = "+"

            while (num1 < num4 ) {
                num4 = (1..100).random()
            }

            while (num2 < num5 ) {
                num5 = (1..100).random()
            }
            while (num3 < num6 ) {
                num6 = (1..100).random()
            }
        } else if (exp == "Subtraction") {
            txt5.text = "-"
            txt7.text = "-"
            txt8.text = "-"

            while (num1 > num4 ) {
                num4 = (1..100).random()
            }

            while (num2 > num5 ) {
                num5 = (1..100).random()
            }
            while (num3 > num6 ) {
                num6 = (1..100).random()
            }
        } else if (exp == "Multiplication") {
            txt5.text = "x"
            txt7.text = "x"
            txt8.text = "x"

            num1 = (1..10).random()
            num2 = (1..10).random()
            num3 = (1..10).random()

            while (num1 % num4 != 0) {
                num4 = (1..10).random()
            }

            while (num2 % num5 != 0) {
                num5 = (1..10).random()
            }
            while (num3 % num6 != 0) {
                num6 = (1..10).random()
            }

        } else {
            txt5.text = "/"
            txt7.text = "/"
            txt8.text = "/"

            num1 = (1..10).random()
            num2 = (1..10).random()
            num3 = (1..10).random()
            num4 = (1..10).random()
            num5 = (1..10).random()
            num6 = (1..10).random()
        }

        ed7.setText(num1.toString())
        ed12.setText(num2.toString())
        ed15.setText(num3.toString())
        ed6.setText(num4.toString())
        ed9.setText(num5.toString())
        ed14.setText(num6.toString())


        var res2: Boolean = false
        val bt3: Button = findViewById(R.id.button3)

        val ed2: EditText = findViewById(R.id.editTextNumber2)
        val ed8: EditText = findViewById(R.id.editTextNumber8)
        val ed13: EditText = findViewById(R.id.editTextNumber13)

        bt3.setOnClickListener {

            if (exp == "Addition") {
                if ((num1 - num4) == ed2.text.toString().toInt()) {
                    if ((num2 - num5) == ed8.text.toString().toInt()) {
                        if ((num3 - num6) == ed13.text.toString().toInt()) {
                            res2 = true
                        }
                    }
                }

            } else if (exp == "Subtraction") {
                if ((num1 + num4) == ed2.text.toString().toInt()) {
                    if ((num2 + num5) == ed8.text.toString().toInt()) {
                        if ((num3 + num6) == ed13.text.toString().toInt()) {
                            res2 = true
                        }
                    }
                }

            } else if (exp == "Multiplication") {

                if ((num1 / num4) == ed2.text.toString().toInt()) {
                    if ((num2 / num5) == ed8.text.toString().toInt()) {
                        if ((num3 / num6) == ed13.text.toString().toInt()) {
                            res2 = true
                        }
                    }
                }

            } else {
                if ((num1 * num4) == ed2.text.toString().toInt()) {
                    if ((num2 * num5) == ed8.text.toString().toInt()) {
                        if ((num3 * num6) == ed13.text.toString().toInt()) {
                            res2 = true
                        }
                    }
                }


            }

            if (res2) {
                val m3: MainActivity = MainActivity()
                m3.receiveFeedback("Play Again", "You Win", "Congratulation")

            } else {
                val m3: MainActivity = MainActivity()
                m3.receiveFeedback("Try Again", "You Lose", "You will get it next time")

            }

            startActivity(intent3)
        }
    }
    private var notificationId1 :Int = 123
    private val channelId = "App_Channel.testNotification"
    private val description = "Trying to test different types notification"

    private  fun notidication1(){

        val builder = NotificationCompat.Builder(this, channelId)
            .setSmallIcon(R.mipmap.l)
            .setContentTitle("Math Game")
            .setContentText("Hope you enjoyed the game and do not forget to play again")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

            .setAutoCancel(true)
        with(NotificationManagerCompat.from(this)){
            notify(notificationId1,builder.build())
        }
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "test_notification"
            val descriptionText = description
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(channelId, name, importance).apply {
                description = descriptionText
            }
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    override fun onStop() {
        notidication1()
        super.onStop()
    }


}