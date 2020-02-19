import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import com.vedworx.sastanetflix.*
import kotlinx.android.synthetic.main.series.*
import kotlinx.android.synthetic.main.seriesdetailed.*


class seriesdetailed() : Fragment(), seriesclicklistener {

    private lateinit var viewmodelsave: seriesviewmodel
    private var adapter = seriesdetailedadapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewmodelsave = ViewModelProviders.of(this).get(seriesviewmodel::class.java)

        return inflater.inflate(
            R.layout.seriesdetailed,
            container,
            false
        )
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val bundle = arguments
        val stringg = bundle?.getString("idd")
        val namee = bundle?.getString("name")
        viewmodelsave.getSeriesDetailedRealitimeUpdates(stringg.toString())
        seriesname.text = namee




        seriesdetailedrecycler.adapter = adapter
        adapter.listener = this
        viewmodelsave._listings.observe(viewLifecycleOwner, Observer {
            adapter.addListing(it)
        })

    }

    companion object {
        fun newInstance(): landingPage = landingPage()
    }

    override fun onseriesitemclicked(view: View, seriesmodel: series) {
        when (view.id) {
            R.id.seriesimageview -> {
                val bundle = Bundle()
                val fragmentswitch = episodesdetailed()
                bundle.putString("idd",seriesmodel.id)
                bundle.putString("name", seriesmodel.name)
                fragmentswitch.arguments = bundle
                val manager = fragmentManager
                manager?.beginTransaction()?.replace(R.id.container, fragmentswitch)?.commit()
            }
        }
    }


}