package com.vedworx.sastanetflix.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.vedworx.sastanetflix.*
import com.vedworx.sastanetflix.adapters.episodedetailedadapter
import com.vedworx.sastanetflix.interfaces.episodelistener
import com.vedworx.sastanetflix.viewmodel.episodes
import com.vedworx.sastanetflix.viewmodel.seriesviewmodel
import kotlinx.android.synthetic.main.episodesdetailed.*

class episodesdetailed : AppCompatActivity(), episodelistener {

    private lateinit var viewmodelsave: seriesviewmodel
    private var adapter =
        episodedetailedadapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewmodelsave = ViewModelProviders.of(this).get(seriesviewmodel::class.java)
        setContentView(R.layout.episodesdetailed)

        val stringg1 = intent.getStringExtra("idd1")
        val stringg2 = intent.getStringExtra("idd2")
        val namee = intent.getStringExtra("name")
        viewmodelsave.getSEpisodesDetailedRealitimeUpdates(stringg1.toString(), stringg2.toString())
        seriesseason.text = namee
        adapter.listener = this
        episodesdetailed.adapter = adapter
        viewmodelsave._episodeslisiting.observe(this, Observer {
            adapter.addListing(it)
            loader.visibility = View.INVISIBLE
        })

    }

    override fun onepisodeitemclicked(view: View, episodesmodel: episodes) {
        when (view.id) {
            R.id.episodename -> {
                val intent = Intent(this, exoplayer::class.java)
                intent.putExtra("link", episodesmodel.link.toString())
                startActivity(intent)
            }
        }
    }

}
