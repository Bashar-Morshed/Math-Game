package com.example.mathgame

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import android.app.Notification.EXTRA_NOTIFICATION_ID
import androidx.annotation.RequiresApi

var exp: String = "" // Expression
var res1: String = "Play Game"
var t2: String = ""
var t3: String = ""
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val bt: Button = findViewById(R.id.button)
        val sp: Spinner = findViewById(R.id.spinner)
        val txt2: TextView = findViewById(R.id.textView2)
        val txt3: TextView = findViewById(R.id.textView3)


        var flag: String = "mathematical expressions"
        val intent = Intent(this, Inequality::class.java)
        val intent2 = Intent(this, Math::class.java)




        bt.setText(res1)
        txt2.text = t2
        txt3.text = t3



        var options = arrayOf( "inequality expressions","mathematical expressions")
        sp.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, options)

        sp.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = options.get(p2)

                if(flag == "mathematical expressions") {


                    var dialog_var = CustomDialogFragment()
                    dialog_var.show(supportFragmentManager, "Custom Dialog")

                    bt.setOnClickListener {
                        val message: String = "Enter the right numbers to complete the equations"
                        intent2.putExtra("key", message)
                        startActivity(intent2)
                    }
                }
                else {
                    bt.setOnClickListener {
                        startActivity(intent)

                    }
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }


        }











    }
    fun receiveFeedback(feedback: String){
        exp = feedback


    }

    fun receiveFeedback(txt1: String, txt2: String, txt3: String ){

        res1 = txt1
        t2 = txt2
        t3 = txt3



    }




}