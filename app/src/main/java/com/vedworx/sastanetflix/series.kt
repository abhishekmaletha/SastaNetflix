package com.vedworx.sastanetflix

import com.google.firebase.database.Exclude

data class series(
    @get:Exclude
    var id:String?=null,
    var name:String?=null,
    var image:String?=null
)