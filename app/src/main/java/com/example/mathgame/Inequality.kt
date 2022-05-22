package com.example.mathgame

import android.app.Activity
import android.app.PendingIntent.getActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment

class Inequality : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inequality)

        val num1: Int = (0..100).random()
        val num2: Int = (0..100).random()
        val num3: Int = (0..100).random()

        val ed3: EditText = findViewById(R.id.editTextNumber3)
        val ed5: EditText = findViewById(R.id.editTextNumber5)
        val ed11: EditText = findViewById(R.id.editTextNumber11)

        val ed: EditText = findViewById(R.id.editTextNumber)
        val ed4: EditText = findViewById(R.id.editTextNumber4)
        val ed10: EditText = findViewById(R.id.editTextNumber10)

        ed3.setText(num1.toString())
        ed5.setText(num2.toString())
        ed11.setText(num3.toString())

        var res: Boolean = false
        val bt2: Button = findViewById(R.id.button2)
        val intent = Intent(this, MainActivity::class.java)

        bt2.setOnClickListener {

            if (ed.text.toString().toInt() > ed3.text.toString().toInt()) {
                if (ed4.text.toString().toInt() < ed5.text.toString().toInt()) {
                    if (ed10.text.toString().toInt() == ed10.text.toString().toInt()) {
                        res = true
                    }
                }
            }


                if (res) {
                    val m2: MainActivity = MainActivity()
                    m2.receiveFeedback("Play Again", "You Win", "Congratulation")

                }
            else{
                    val m2: MainActivity = MainActivity()
                    m2.receiveFeedback("Try Again", "You Lose", "You will get it next time")

                }

                startActivity(intent)





        }


    }
}