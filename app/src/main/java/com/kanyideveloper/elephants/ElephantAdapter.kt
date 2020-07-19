package com.kanyideveloper.elephants

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_elephant.view.*

class ElephantAdapter : RecyclerView.Adapter<ElephantAdapter.ElephantViewHolder>() {

    private val items = mutableListOf<Elephant>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ElephantViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ElephantViewHolder(inflater.inflate(R.layout.item_elephant, parent, false))
    }

    override fun onBindViewHolder(holder: ElephantViewHolder, position: Int) {
        val item = items[position]
        holder.itemView.run {
            Glide.with(context)
                .load(item.image_url)
                .into(item_elephant_image)
            item_elephant_name.text = item.name
            item_elephant_dob.text = item.dob

            setOnClickListener {

                    //DetailActivity.startActivity(context, item_poster_circle_transformationLayout, item)
                //previousTime = now
            }
        }
    }
    fun addPosterList(list: List<Elephant>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount() = items.size

    class ElephantViewHolder(view: View) : RecyclerView.ViewHolder(view)
}
