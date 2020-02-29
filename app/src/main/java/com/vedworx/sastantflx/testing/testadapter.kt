package com.vedworx.sastantflx.testing

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vedworx.sastantflx.R
import kotlinx.android.synthetic.main.testing.view.*


class testadapter(private val sitComs: List<Sitcoms>) : RecyclerView.Adapter<testadapter.testingadapter>() {

    class testingadapter(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): testingadapter {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.testing, parent, false)
        return testingadapter(view)
    }

    override fun getItemCount(): Int {
        return sitComs.size
    }

    override fun onBindViewHolder(holder: testingadapter, position: Int) {
        val sitcoms = sitComs[position]
        holder.view.nameofseries.text = sitcoms.name
    }

}