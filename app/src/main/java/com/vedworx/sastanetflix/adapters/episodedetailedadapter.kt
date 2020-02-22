package com.vedworx.sastanetflix.adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vedworx.sastanetflix.R
import com.vedworx.sastanetflix.viewmodel.episodes
import com.vedworx.sastanetflix.interfaces.episodelistener
import kotlinx.android.synthetic.main.seriesview.view.*


class episodedetailedadapter : RecyclerView.Adapter<episodedetailedadapter.homescreenadapter>() {
    private val adapterListing = mutableListOf<episodes>()
    var listener: episodelistener? = null

    class homescreenadapter(val view: View) : RecyclerView.ViewHolder(view)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        homescreenadapter(
            LayoutInflater.from(parent.context).inflate(
                R.layout.episodelayout,
                parent,
                false
            )
        )

    override fun getItemCount(): Int {
        return adapterListing.size
    }

    override fun onBindViewHolder(holder: homescreenadapter, position: Int) {
        Glide.with(holder.view).load(adapterListing[position].image).centerCrop()
            .into(holder.view.seriesimageview)

        holder.view.seriesimageview.setOnClickListener {
            listener?.onepisodeitemclicked(it, adapterListing[position])
        }

    }

    fun addListing(lisiting: episodes) {
        adapterListing.add(lisiting)
        notifyDataSetChanged()
    }
}