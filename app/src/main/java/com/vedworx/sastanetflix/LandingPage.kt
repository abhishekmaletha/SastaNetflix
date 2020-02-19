import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import com.vedworx.sastanetflix.*
import kotlinx.android.synthetic.main.series.*


class landingPage : Fragment(),seriesclicklistener {

    private lateinit var viewmodelsave: seriesviewmodel
    private var adapter = recyclerViewHomeScreen()

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

        viewmodelsave.getRealitimeUpdates()


        seriesrecyclerview.adapter = adapter

        viewmodelsave._listings.observe(viewLifecycleOwner, Observer {
            adapter.addListing(it)
        })

    }

    companion object {
        fun newInstance(): landingPage = landingPage()
    }


}