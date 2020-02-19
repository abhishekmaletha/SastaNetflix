package com.vedworx.sastanetflix

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity

class fragmentholder:AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragmentholder)

        val artistsFragment = landingPage.newInstance()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, artistsFragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}




