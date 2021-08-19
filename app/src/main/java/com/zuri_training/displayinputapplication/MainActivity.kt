package com.zuri_training.displayinputapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.snackbar.Snackbar
import me.relex.circleindicator.CircleIndicator3


class MainActivity : AppCompatActivity() {

    private var titlesList = mutableListOf<String>()
    private var aboutList = mutableListOf<String>()
    private var imageList = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        postToList()

        val viewPager2: ViewPager2 = findViewById(R.id.view_pager2)
        viewPager2.adapter = ViewPagerAdapter(titlesList, aboutList, imageList)
        viewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        val indicator: CircleIndicator3 = findViewById(R.id.indicator)
        indicator.setViewPager(viewPager2)

        val displayButton = findViewById<Button>(R.id.displayInputButton)
        val displayTextView = findViewById<TextView>(R.id.displayTextView)
        val inputField = findViewById<EditText>(R.id.inputEditText)

        displayButton.setOnClickListener {
            if (!inputField.text.isNullOrEmpty()) {
                displayTextView.text = inputField.text
                displayTextView.isVisible = true
            } else if (inputField.text.isNullOrEmpty()) {
                Snackbar.make(this, displayTextView, "Enter input to display", Snackbar.LENGTH_LONG)
                    .show()
            }

        }
    }

    private fun addToList(title: String, about: String, image: Int) {
        titlesList.add(title)
        aboutList.add(about)
        imageList.add(image)
    }

    private fun postToList() {
        for (i in 1..3) {
            when(i){
                1 -> addToList("Zuri Logo", "https://zuri.team", R.drawable.zuri_logo)
                2 -> addToList("HNG logo", "https://zuri.team", R.drawable.hng_logo)
                3 -> addToList("I4G logo", "https://zuri.team", R.drawable.i4g_logo)
            }
        }
    }

}

























