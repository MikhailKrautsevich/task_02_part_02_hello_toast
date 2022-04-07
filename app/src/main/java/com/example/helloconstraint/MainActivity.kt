package com.example.helloconstraint

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var mCount: Int = 0
    private lateinit var mShowCount: TextView
    private lateinit var mBtnZero: Button
    private lateinit var mBtnCount: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mShowCount = findViewById(R.id.show_count)
        mBtnZero = findViewById(R.id.button_zero)
    }

    fun countUp(view: View) {
        mCount++
        showCount()
        updateZeroBtnColor()
        updateCountBtnColor(view)
    }

    fun showToast(view: View) {
        val toast = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT)
        toast.show()
    }

    fun changeToZero(view: View) {
        mCount = 0
        showCount()
        updateZeroBtnColor()
    }

    private fun showCount() {
        mShowCount.text = mCount.toString()
    }

    private fun updateZeroBtnColor() {
        if (mCount > 0) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                mBtnZero.setBackgroundColor(getColor(R.color.purple_500))
            } else mBtnZero.setBackgroundColor(Color.BLUE)
        } else mBtnZero.setBackgroundColor(Color.GRAY)
    }

    private fun updateCountBtnColor(view: View) {
        if (mCount % 2 == 0) {
            view.setBackgroundColor(Color.GREEN)
        } else view.setBackgroundColor(Color.MAGENTA)

    }
}