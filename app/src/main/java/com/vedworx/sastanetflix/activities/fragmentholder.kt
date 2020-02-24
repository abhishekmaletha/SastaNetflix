package com.vedworx.sastanetflix.activities

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.vedworx.sastanetflix.R
import com.vedworx.sastanetflix.adapters.fragmentholderadapter
import com.vedworx.sastanetflix.fragments.animepage
import com.vedworx.sastanetflix.fragments.documentarypage
import com.vedworx.sastanetflix.ui.profile
import kotlinx.android.synthetic.main.fragmentholder.*
import landingPage
import profileEnter
import searchfragment
import toast


class fragmentholder : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragmentholder)
        setSupportActionBar(toolbar)
        toolbar.title = "Sasta Netflix"
        val adapter = fragmentholderadapter(
            supportFragmentManager
        )
        adapter.addFragment(landingPage(), "Series")
        adapter.addFragment(documentarypage(), "Documentary")
        adapter.addFragment(searchfragment(), "Search")
        adapter.addFragment(animepage(), "Anime")
        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.navigation, menu)
        return true
    }

 override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.profile_navigation -> {
                val intent = Intent(this, profile::class.java)
                this.startActivity(intent)
        }

            else -> return super.onOptionsItemSelected(item)
        }
        return true
    }
}






