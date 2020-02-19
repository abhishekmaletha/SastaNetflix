package com.vedworx.sastanetflix


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.seriesdetailed.view.*
import kotlinx.android.synthetic.main.seriesview.view.*


class episodedetailedadapter : RecyclerView.Adapter<episodedetailedadapter.homescreenadapter>() {
    private val adapterListing = mutableListOf<episodes>()
    var listener: episodelistener? = null

    class homescreenadapter(val view: View) : RecyclerView.ViewHolder(view)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = homescreenadapter(
        LayoutInflater.from(parent.context).inflate(R.layout.seriesview, parent, false)
    )

    override fun getItemCount(): Int {
        return adapterListing.size
    }

    override fun onBindViewHolder(holder: homescreenadapter, position: Int) {
        Glide.with(holder.view).load(adapterListing[position].image).centerCrop()
            .into(holder.view.seriesimageview)

        holder.view.seriesimageview.setOnClickListener {
            listener?.onepisodeitemclicked(it, adapterListing[position])
            holder.view.seriesnamee.text = ""
        }

    }

    fun addListing(lisiting: episodes) {
        adapterListing.add(lisiting)
        notifyDataSetChanged()
    }
}