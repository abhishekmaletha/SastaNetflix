package com.vedworx.sastanetflix

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.fragmentholder.*
import landingPage
import searchfragment

class fragmentholder : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragmentholder)

        toolbar.title="Sasta Netflix"
        val adapter = fragmentholderadapter(supportFragmentManager)
        adapter.addFragment(landingPage(), "Sitcom")
        adapter.addFragment(searchfragment(), "Documentary")
        adapter.addFragment(animepage(), "Anime")
        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)
    }
}




