package com.vedworx.sastanetflix.activities

import android.content.Intent
import android.os.Bundle

import android.view.View

import androidx.appcompat.app.AppCompatActivity

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.firebase.database.FirebaseDatabase
import com.vedworx.sastanetflix.*
import com.vedworx.sastanetflix.adapters.seriesdetailedadapter
import com.vedworx.sastanetflix.interfaces.seriesclicklistener
import com.vedworx.sastanetflix.models.series
import com.vedworx.sastanetflix.viewmodel.seriesviewmodel
import kotlinx.android.synthetic.main.seriesdetailed.*


class seriesdetailed : AppCompatActivity(),
    seriesclicklistener {
    private var db: FirebaseDatabase? = null
    private lateinit var viewmodelsave: seriesviewmodel
    private var adapter =
        seriesdetailedadapter()
    private var linkOfEpisodeFragment: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.seriesdetailed)
        viewmodelsave = ViewModelProviders.of(this).get(seriesviewmodel::class.java)

        val stringg = intent.getStringExtra("idd")
        val namee = intent.getStringExtra("name")
        viewmodelsave.getSeriesDetailedRealitimeUpdates(stringg.toString())
        seriesname.text = namee

        linkOfEpisodeFragment = stringg

        seriesdetailedrecycler.adapter = adapter
        adapter.listener = this

        viewmodelsave._listings.observe(this, Observer
        {
            adapter.addListing(it)
            loaderseriesdetailed.visibility = View.INVISIBLE
        })

    }

    override fun onseriesitemclicked(view: View, seriesmodel: series) {
        when (view.id) {
            R.id.seriesimageview -> {
                val intent = Intent(this, episodesdetailed::class.java)
                intent.putExtra("idd1", linkOfEpisodeFragment)
                intent.putExtra("idd2", seriesmodel.id)
                intent.putExtra("name", seriesmodel.name)
                startActivity(intent)
            }
        }
    }
}



