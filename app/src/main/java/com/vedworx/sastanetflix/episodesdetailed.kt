import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.vedworx.sastanetflix.*
import kotlinx.android.synthetic.main.episodesdetailed.*
import kotlinx.android.synthetic.main.seriesdetailed.*


class episodesdetailed() : Fragment(), episodelistener {

    private lateinit var viewmodelsave: seriesviewmodel
    private var adapter = episodedetailedadapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewmodelsave = ViewModelProviders.of(this).get(seriesviewmodel::class.java)

        return inflater.inflate(
            R.layout.episodesdetailed,
            container,
            false
        )
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val bundle = arguments
        val stringg1 = bundle?.getString("idd1")
        val stringg2 = bundle?.getString("idd2")
        val namee = bundle?.getString("name")
        viewmodelsave.getSEpisodesDetailedRealitimeUpdates(stringg1.toString(), stringg2.toString())
        seriesseason.text = namee
        adapter.listener = this
        episodesdetailed.adapter = adapter
        viewmodelsave._episodeslisiting.observe(viewLifecycleOwner, Observer {
            adapter.addListing(it)
            loader.visibility = View.INVISIBLE
        })

    }

    companion object {
        fun newInstance(): landingPage = landingPage()
    }

    override fun onepisodeitemclicked(view: View, episodesmodel: episodes) {
        when (view.id) {
            R.id.seriesimageview -> {
                val intent = Intent(context, MainActivity::class.java)
                intent.putExtra("link", episodesmodel.link.toString())
                startActivity(intent)
            }
        }
    }


}