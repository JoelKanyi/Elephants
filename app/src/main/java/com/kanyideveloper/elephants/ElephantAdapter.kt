package com.kanyideveloper.elephants

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_elephant.view.*

import com.kanyideveloper.elephants.ElephantDetails
import com.kanyideveloper.elephants.R


class ElephantAdapter : RecyclerView.Adapter<ElephantAdapter.ElephantViewHolder>() {

    private val items = mutableListOf<Elephant>()
    private var previousTime = System.currentTimeMillis()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ElephantViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ElephantViewHolder(inflater.inflate(R.layout.item_elephant, parent, false))
    }

    override fun onBindViewHolder(holder: ElephantViewHolder, position: Int) {
        val item = items[position]
        holder.itemView.run {
            Glide.with(context)
                .load(item.image)
                .into(item_elephant_image)
            item_elephant_name.text = item.name
            item_elephant_dob.text = "D.O.B ${item.dob}"

            setOnClickListener {
                val now = System.currentTimeMillis()
                if (now - previousTime >= item_elephant_transformationLayout.duration)
                    ElephantDetails.startActivity(context, item_elephant_transformationLayout, item)
                previousTime = now
            }
        }
    }
    fun addElephantList(list: List<Elephant>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount() = items.size

    class ElephantViewHolder(view: View) : RecyclerView.ViewHolder(view)
}
