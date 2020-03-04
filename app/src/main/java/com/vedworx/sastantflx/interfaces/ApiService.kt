package com.vedworx.sastantflx.interfaces

import com.vedworx.sastantflx.models.Sitcom
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("/3/tv/70523?api_key=eca907ec039ee65992e3aea8d14c0dd3&language=en-US")
    fun fetchSeries():Call<Sitcom>

}