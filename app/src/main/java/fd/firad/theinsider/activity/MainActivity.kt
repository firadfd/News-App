package fd.firad.theinsider.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import fd.firad.theinsider.R
import fd.firad.theinsider.adapter.NewsAdapter
import fd.firad.theinsider.databinding.ActivityMainBinding
import fd.firad.theinsider.util.Util
import fd.firad.theinsider.viewmodel.NewsViewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: NewsViewModel by viewModels()
    private var rAdapter: NewsAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        if(Util.isOnline(this@MainActivity)){
            viewModel.response.observe(this, Observer {
                binding.progressBar.visibility = View.INVISIBLE
                rAdapter = NewsAdapter(it.articles)
                binding.recycleView.apply {
                    layoutManager = LinearLayoutManager(this@MainActivity)
                    adapter = rAdapter
                }

            })
        }else{
            Toast.makeText(this@MainActivity, "Please Check Your Internet Connection", Toast.LENGTH_SHORT).show()
        }

    }
}