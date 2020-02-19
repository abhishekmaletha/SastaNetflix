package com.vedworx.sastanetflix

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.seriesview.view.*


class recyclerViewHomeScreen : RecyclerView.Adapter<recyclerViewHomeScreen.homescreenadapter>() {
    private val adapterListing = mutableListOf<series>()

    class homescreenadapter(val view: View) : RecyclerView.ViewHolder(view)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = homescreenadapter(
        LayoutInflater.from(parent.context).inflate(R.layout.seriesview, parent, false)
    )

    override fun getItemCount(): Int {
        return adapterListing.size
    }

    override fun onBindViewHolder(holder: homescreenadapter, position: Int) {
        Glide.with(holder.view).load(adapterListing[position].image)
            .into(holder.view.seriesimageview)

    }

    fun addListing(lisiting: series) {
        adapterListing.add(lisiting)
        notifyDataSetChanged()
    }
}