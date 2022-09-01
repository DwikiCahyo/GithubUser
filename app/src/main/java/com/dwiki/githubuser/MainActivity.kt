package com.dwiki.githubuser

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.dwiki.githubuser.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

   private lateinit var binding: ActivityMainBinding
   private val listUser = ArrayList<Users>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        supportActionBar?.title = " List User"
//        setSupportActionBar(binding.toolbarGithubUser)



        binding.rvUsers.setHasFixedSize(true)
        listUser.addAll(list)
        showRecyclerList()

    }
    private val list:ArrayList<Users>
    get()  {
        val username = resources.getStringArray(R.array.username)
        val nama = resources.getStringArray(R.array.name)
        val location = resources.getStringArray(R.array.location)
        val repository = resources.getStringArray(R.array.repository)
        val company = resources.getStringArray(R.array.company)
        val followers = resources.getStringArray(R.array.followers)
        val following = resources.getStringArray(R.array.following)
        val avatar= resources.obtainTypedArray(R.array.avatar)
        val listUsers = ArrayList<Users>()
        for (i in nama.indices) {
            val users = Users(
                username[i],
                nama[i],
                location[i],
                repository[i],
                company[i],
                followers[i] ,
                following[i],
                avatar.getResourceId(i, -1)
            )
            listUsers.add(users)
        }
        return listUsers
    }

    private fun showRecyclerList(){
        if (applicationContext.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            binding.rvUsers.layoutManager = GridLayoutManager(this, 2)
        } else {
            binding.rvUsers.layoutManager = LinearLayoutManager(this)
        }

        val listUserAdapter = ListUserAdapter(listUser)
        binding.rvUsers.adapter = listUserAdapter

        listUserAdapter.setOnItemClickCallback(object : ListUserAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Users) {
                showDetailUser(data)
            }
        })
    }

    private fun showDetailUser(data:Users){
        val intent = Intent(this,DetailUser::class.java)
        intent.putExtra("users",data)
        startActivity(intent)
    }
}