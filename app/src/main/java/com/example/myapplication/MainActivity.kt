package com.example.myapplication

import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.util.Log
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.fragment.app.Fragment
import android.widget.Button as Button

class MainActivity : AppCompatActivity() {

    var code: String = ""

    lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)

        val button1: Button = findViewById(R.id.button1)
        button1.setOnClickListener { it ->
            clearAppend(1)
        }

        val button2: Button = findViewById(R.id.button2)
        button2.setOnClickListener { it ->
            clearAppend(2)
        }

        val button3: Button = findViewById(R.id.button3)
        button3.setOnClickListener { it ->
            clearAppend(3)
        }

        val button4: Button = findViewById(R.id.button4)
        button4.setOnClickListener { it ->
            clearAppend(4)
        }

        val button5: Button = findViewById(R.id.button5)
        button5.setOnClickListener { it ->
            clearAppend(5)
        }

        val button6: Button = findViewById(R.id.button6)
        button6.setOnClickListener { it ->
            clearAppend(6)
        }

        val button7: Button = findViewById(R.id.button7)
        button7.setOnClickListener { it ->
            clearAppend(7)
        }

        val button8: Button = findViewById(R.id.button8)
        button8.setOnClickListener { it ->
            clearAppend(8)
        }

        val button9: Button = findViewById(R.id.button9)
        button9.setOnClickListener { it ->
            clearAppend(9)
        }

        val button_back: Button = findViewById(R.id.back)
        button_back.setOnClickListener { it ->
            textView.setTextColor(resources.getColor(R.color.gray_black))
            val asd = textView.getText().toString().dropLast(1)
            textView.setText(asd)
        }
        button_back.setOnLongClickListener { it ->
            textView.setTextColor(resources.getColor(R.color.gray_black))
            textView.text = ""
            true
        }

        val button0: Button = findViewById(R.id.button0)
        button0.setOnClickListener { it ->
            clearAppend(0)
        }

        val buttonOk: Button = findViewById(R.id.OK)
        val animShake = AnimationUtils.loadAnimation(this, R.anim.shake_false)
        val animShake2 = AnimationUtils.loadAnimation(this, R.anim.shake_true)
        buttonOk.setOnClickListener { it ->
            var isSame: Boolean = false
            if(textView.getText().toString().contains("1567")){ isSame = true }
            if(isSame==true){
                textView.setTextColor(resources.getColor(R.color.blue))
                textView.startAnimation(animShake2)
            }
            else{
                textView.setTextColor(resources.getColor(R.color.red))
                textView.startAnimation(animShake)
            }
        }
    }

    fun clearAppend(number: Int) {
        if(textView.text.contains("Введ")){ textView.text = "" }
        if(textView.text.length <= 3){textView.append(number.toString())}
    }



    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.i("dan", "onSaveInstanceState")
        outState.putString("key",textView.text.toString())
        outState.putInt("key2",textView.currentTextColor)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.i("dan", "onRestoreInstanceState")
        val text = savedInstanceState.getString("key")
        val color = savedInstanceState.getInt("key2")
        textView.text = text
        textView.setTextColor(color)
    }

}