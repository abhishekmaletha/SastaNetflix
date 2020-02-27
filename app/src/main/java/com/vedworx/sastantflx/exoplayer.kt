package com.vedworx.sastantflx


import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import tcking.github.com.giraffeplayer2.GiraffePlayer
import tcking.github.com.giraffeplayer2.VideoInfo
import tcking.github.com.giraffeplayer2.VideoView
import java.security.AccessController.getContext


class exoplayer : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_player2)

        val extras = intent.extras
        var STREAM_URL=extras?.getString("link").toString()

        GiraffePlayer.play(applicationContext,  VideoInfo(STREAM_URL).setFullScreenOnly(true).setShowTopBar(false).setBgColor(Color.BLACK))
    }




    companion object {
        const val STREAM_URL = "http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4"
    }
}