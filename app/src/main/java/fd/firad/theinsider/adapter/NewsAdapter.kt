package fd.firad.theinsider.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import fd.firad.theinsider.activity.ViewNews
import fd.firad.theinsider.databinding.NewsItemBinding
import fd.firad.theinsider.model.Article
import javax.inject.Inject

class NewsAdapter @Inject constructor(private val nList: List<Article>) :
    RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {
    class NewsViewHolder(val binding: NewsItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = NewsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return nList.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val data = nList[position]
        holder.binding.nItem = data
        Picasso.get().load(data.urlToImage).into(holder.binding.image)

        holder.binding.root.setOnClickListener {
            val intent = Intent(holder.binding.image.context, ViewNews::class.java)
            intent.putExtra("news", nList[position].url)
            intent.putExtra("title", nList[position].title)
            holder.binding.image.context.startActivity(intent)
        }

    }
}