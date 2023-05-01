package fd.firad.theinsider.activity

import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import fd.firad.theinsider.R
import fd.firad.theinsider.databinding.ActivityViewNewsBinding

class ViewNews : AppCompatActivity() {
    private lateinit var binding: ActivityViewNewsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@ViewNews, R.layout.activity_view_news)
        val url = intent.getStringExtra("news")

        val title = intent.getStringExtra("title")
        val sTitle = "${title?.substring(0,16)}..."
        supportActionBar?.title = sTitle

        binding.webView.loadUrl(url!!)

        binding.webView.webViewClient = object : WebViewClient() {
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                binding.progressBar.visibility = View.VISIBLE
                super.onPageStarted(view, url, favicon)
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                binding.progressBar.visibility = View.INVISIBLE
                super.onPageFinished(view, url)
            }
        }

    }
}