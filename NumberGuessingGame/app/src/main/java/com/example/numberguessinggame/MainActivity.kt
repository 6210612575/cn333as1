package com.example.numberguessinggame

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.lang.reflect.Type
import java.net.Proxy
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var textView: TextView
    lateinit var editText: EditText
    lateinit var CheckAndPlay: Button
    lateinit var Hint : TextView
    lateinit var fill : TextView

    var random: Int = Random.nextInt(1, 1000)
    var status: Boolean = true
    var count = 0

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.TextView)
        editText = findViewById(R.id.EditText)
        CheckAndPlay = findViewById(R.id.CheckAndPlay)
        Hint = findViewById(R.id.Hint)
        fill = findViewById(R.id.fill)

        textView.text = "Try to guess the number \n From 1 - 1000 "

        CheckAndPlay.setText("Check")
        textView.setTextColor(Color.DKGRAY)
        textView.setTextSize(22.0F)
        fill.text = "Please enter your guess"
        fill.setTextColor(Color.DKGRAY)

        CheckAndPlay.setOnClickListener {

            if (status) {

                if (editText.text.isNotEmpty()){
                    val number: Int = editText.text.toString().toInt()

                    fill.text = "Please enter your guess"
                    fill.setTextColor(Color.DKGRAY)

                    if (number < random) {
                        Hint.setTextColor(Color.RED)
                        Hint.text= " Last Number is $number \n >> Hint : It's Higher << \n "
                        editText.text.clear()
                        count++
                    }
                    else if (number > random) {
                        Hint.setTextColor(Color.RED)
                        Hint.text = " Last Number is $number \n >> Hint : It's Lower << \n"
                        editText.text.clear()
                        count++
                    }
                    else {
                        textView.setTextColor(Color.BLUE)
                        status = false
                        textView.text = " Congratulation \n Number is $random \n You Use $count Times "

                        editText.text.clear()
                        Hint.text=""
                        fill.text=""
                        CheckAndPlay.setText("Play Agian")
                    }
                }
                else {
                    fill.text = "Please Fill Your Number "
                    fill.setTextColor(Color.RED)
                }
            }
            else{
                reset()
            }
        }
    }
    fun reset() {
        CheckAndPlay.setText("Check")
        textView.text = "Try to guess the number \n From 1 - 1000 "
        textView.setTextColor(Color.DKGRAY)
        fill.text = "Please enter your guess"
        random = Random.nextInt(1, 1000)
        count = 0
        status = true
        editText.text.clear()
    }
}






