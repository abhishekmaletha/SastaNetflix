package com.vedworx.sastanetflix

import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.MediaController

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var mediaController: MediaController
    private var playBackPosition = 0
    private val dashUrl =
        "http://dl9.rmdlsv.com/tv-series/Peaky-Blinders/S01/480P/Peaky.Blinders.S01E01.480p.BluRay.x264.mkv"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mediaController = MediaController(this)
        simpleVideoView.setOnPreparedListener {
            mediaController.setAnchorView(videoContainer)
            simpleVideoView.setMediaController(mediaController)
            simpleVideoView.seekTo(playBackPosition)
            simpleVideoView.start()
        }
        simpleVideoView.setOnInfoListener { player, what, extras ->
            if (what == MediaPlayer.MEDIA_INFO_VIDEO_RENDERING_START)
                progressBar.visibility = View.INVISIBLE
                true
            }

        }



    override fun onStart() {
        super.onStart()
        val uri = Uri.parse(dashUrl)
        simpleVideoView.setVideoURI(uri)
        progressBar.visibility = View.VISIBLE
    }

    override fun onPause() {
        super.onPause()
        simpleVideoView.pause()
        playBackPosition=simpleVideoView.currentPosition
    }

    override fun onStop() {
        super.onStop()
        simpleVideoView.stopPlayback()
    }


}
