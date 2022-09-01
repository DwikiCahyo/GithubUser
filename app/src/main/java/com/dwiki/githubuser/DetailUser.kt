package com.dwiki.githubuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dwiki.githubuser.databinding.ActivityDetailUserBinding


class DetailUser : AppCompatActivity() {

    private lateinit var binding: ActivityDetailUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        detailActivity()
    }

   private fun detailActivity(){
        val users = intent.getParcelableExtra<Users>("users")

        binding.apply {
//            tvUsername.text = users?.username
            tvName.text = users?.nama
            numFollower.text = users?.followers
            numFollowing.text = users?.following
            numRepo.text = users?.repository
            tvLocation.text =users?.location
            tvCompany.text = users?.company
            imgUser.setImageResource(users!!.avatar)
        }

        supportActionBar?.title = users?.username.toString()


    }
}