package com.vedworx.sastanetflix.interfaces

import android.view.View
import com.vedworx.sastanetflix.models.series

interface seriesclicklistener {
    fun onseriesitemclicked(view: View, seriesmodel: series)
}
