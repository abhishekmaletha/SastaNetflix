package com.vedworx.sastanetflix

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var simpleExoPlayer: SimpleExoPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val extras = intent.extras
        val dashUrl = extras?.getString("link")

        try {
            var bandWidthMeter = DefaultBandwidthMeter()
            var trackSelector = DefaultTrackSelector(AdaptiveTrackSelection.Factory(bandWidthMeter))
            simpleExoPlayer = ExoPlayerFactory.newSimpleInstance(this, trackSelector)
            var uri=Uri.parse(dashUrl)
            var defaultHttpDataSourceFactory= DefaultHttpDataSourceFactory("exoplayer_video")
            var extractorsFactory=DefaultExtractorsFactory()
            var mediaSource=ExtractorMediaSource(uri,defaultHttpDataSourceFactory,extractorsFactory,null,null)
            simpleExoPlayerView.player=simpleExoPlayer
            simpleExoPlayer.prepare(mediaSource)
            simpleExoPlayer.playWhenReady=true
            progressBar.visibility=View.INVISIBLE
        }
        catch (e:Exception){
            Log.e("Exception",e.toString())
        }


    }


    override fun onStart() {
        super.onStart()

    }

    override fun onPause() {
        super.onPause()

    }

    override fun onStop() {
        super.onStop()

    }


}
