import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.vedworx.sastanetflix.*
import com.vedworx.sastanetflix.adapters.recyclerviewseriesscreen
import com.vedworx.sastanetflix.interfaces.seriesclicklistener
import com.vedworx.sastanetflix.models.series
import com.vedworx.sastanetflix.viewmodel.seriesviewmodel
import kotlinx.android.synthetic.main.series.*


class landingPage : Fragment(),
    seriesclicklistener {

    private lateinit var viewmodelsave: seriesviewmodel
    private var adapter =
        recyclerviewseriesscreen()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewmodelsave = ViewModelProviders.of(this).get(seriesviewmodel::class.java)

        return inflater.inflate(
            R.layout.series,
            container,
            false
        )

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        viewmodelsave.fetchSeries()
        seriesrecyclerview.adapter = adapter
        adapter.listener = this
        viewmodelsave.serieslisiting.observe(viewLifecycleOwner, Observer {
            adapter.setSeries(it)
            loaderofLanding.visibility = View.INVISIBLE
        })


    }

    companion object {
        fun newInstance(): landingPage = landingPage()
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