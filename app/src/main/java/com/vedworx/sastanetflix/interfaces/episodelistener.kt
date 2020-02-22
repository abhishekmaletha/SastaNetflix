package com.vedworx.sastanetflix.interfaces

import android.view.View
import com.vedworx.sastanetflix.viewmodel.episodes

interface episodelistener {
    fun onepisodeitemclicked(view: View, episodesmodel: episodes)
}