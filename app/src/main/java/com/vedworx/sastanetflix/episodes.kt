package com.vedworx.sastanetflix

import com.google.firebase.database.Exclude

data class episodes(
    @get:Exclude
    var id: String? = null,
    var image: String? = null,
    var name: String? = null,
    var url: String? = null
)