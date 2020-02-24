package com.vedworx.sastanetflix.activities
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import com.vedworx.sastanetflix.*
import com.vedworx.sastanetflix.adapters.searchadapter
import com.vedworx.sastanetflix.interfaces.seriesclicklistener
import com.vedworx.sastanetflix.models.series
import com.vedworx.sastanetflix.viewmodel.seriesviewmodel
import kotlinx.android.synthetic.main.searchlayout.*
import kotlinx.android.synthetic.main.searchlayout.loaderofLanding
import kotlinx.android.synthetic.main.searchlayout.view.*



class searchfragment : Fragment(),
    seriesclicklistener {

    private lateinit var viewmodelsave: seriesviewmodel
    private var adapter = searchadapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(
            R.layout.searchlayout,
            container,
            false
        )
        viewmodelsave = ViewModelProviders.of(this).get(seriesviewmodel::class.java)

        view.search_edittext.addTextChangedListener {
                    if (!it.toString().isEmpty()) {
                        viewmodelsave.fetchSeriesResults(it.toString())
                    }
        }

        return view

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)



        adapter.listener = this
        search_recyclerview.adapter = adapter
        viewmodelsave.serieslisiting.observe(viewLifecycleOwner, Observer {
            adapter.setSeries(it)
            loaderofLanding.visibility = View.INVISIBLE
        })

    }

    override fun onseriesitemclicked(view: View, seriesmodel: series) {
        when (view.id) {
            R.id.seriesimageview -> {
                val intent = Intent(context, seriesdetailed::class.java)
                intent.putExtra("idd", seriesmodel.id)
                intent.putExtra("name", seriesmodel.name)
                startActivity(intent)
            }
        }
    }


}