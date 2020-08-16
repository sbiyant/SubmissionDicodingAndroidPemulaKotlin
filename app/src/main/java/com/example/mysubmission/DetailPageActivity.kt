package com.example.mysubmission

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_page)

        val actionBar = supportActionBar
        actionBar!!.title = "Club Information"
        actionBar.setDisplayHomeAsUpEnabled(true)

        val tvClubName = findViewById<TextView>(R.id.tv_club_name)
        val imgClub = findViewById<ImageView>(R.id.img_football_club)
        val tvClubDetail = findViewById<TextView>(R.id.tv_club_detail)

        val getClubName = intent.getStringExtra(EXTRA_NAME)
        val getImgClub = intent.getIntExtra(EXTRA_PHOTO, 0)
        val getClubDetail = intent.getStringExtra(EXTRA_DETAIL)

        tvClubName.text = getClubName
        imgClub.setImageResource(getImgClub)
        tvClubDetail.text = getClubDetail
    }

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_PHOTO = "extra_photo"
        const val EXTRA_DETAIL = "extra_detail"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}