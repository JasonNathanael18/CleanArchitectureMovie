package com.example.featuremovielist.list

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.Movie
import com.example.featuremovielist.R
import com.example.featuremovielist.databinding.CompInfoItemMovieListBinding
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject

class MovieListAdapter @Inject constructor(@ActivityContext private val context: Context) :
    RecyclerView.Adapter<MovieListAdapter.MovieListViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(view: View, item: Movie)
    }

    inner class MovieListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = CompInfoItemMovieListBinding.bind(view)
    }

    private var onItemClickListener: OnItemClickListener? = null
    var datas = ArrayList<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.comp_info_item_movie_list,
            parent, false
        )
        return MovieListViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {
        val data = datas[position]
//        val glideOpt = RequestOptions().diskCacheStrategy(DiskCacheStrategy.RESOURCE).fitCenter()
//            .placeholder(R.drawable.ic_launcher_foreground).error(R.drawable.ic_launcher_background)
//        Glide.with(context)
//            .load(data.thumbnail)
//            .apply(glideOpt)
//            .thumbnail(0.1f)
//            .transform(CircleCrop())
//            .into(holder.binding.ivThumbnail)

        holder.binding.labelTitle.text = data.title
        holder.binding.labelOverview.text = data.overview
        holder.binding.labelReleaseDate.text = data.releaseDate

        holder.binding.itemUser.setOnClickListener {
            onItemClickListener?.onItemClick(it, datas[position])
        }
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    fun reloadData(paramDatas: List<Movie>) {
        datas.clear()
        datas.addAll(paramDatas)
        notifyDataSetChanged()
    }

    fun addData(newData: List<Movie>) {
        val previousCount = datas.size
        datas.addAll(newData)
        notifyItemRangeInserted(previousCount, datas.size)
    }

    fun clearData() {
        datas.clear()
        notifyDataSetChanged()
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        onItemClickListener = listener
    }
}