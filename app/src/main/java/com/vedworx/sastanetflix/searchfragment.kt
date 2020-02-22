import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import com.vedworx.sastanetflix.*
import kotlinx.android.synthetic.main.searchlayout.*
import kotlinx.android.synthetic.main.searchlayout.view.*


class searchfragment : Fragment(), seriesclicklistener {

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
        })

    }

    override fun onseriesitemclicked(view: View, seriesmodel: series) {
        when (view.id) {
            R.id.seriesimageview -> {
                val bundle = Bundle()
                val fragmentswitch = seriesdetailed()
                bundle.putString("idd", seriesmodel.id)
                bundle.putString("name", seriesmodel.name)
                fragmentswitch.arguments = bundle
                val manager = fragmentManager
                manager?.beginTransaction()?.replace(R.id.container, fragmentswitch)?.commit()
            }
        }
    }


}