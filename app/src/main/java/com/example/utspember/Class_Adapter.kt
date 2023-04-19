package com.example.utspember

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Class_Adapter (private val mItems: List<Item_data>, private val mLayoutManager: GridLayoutManager) :
    RecyclerView.Adapter<Class_Adapter.ItemViewHolder>() {
    companion object {
        const val SPAN_COUNT_ONE = 1
        const val SPAN_COUNT_TWO = 2

        const val VIEW_TYPE_SMALL = 1
        const val VIEW_TYPE_BIG = 2
    }

    override fun getItemViewType(position: Int): Int {
        val spanCount = mLayoutManager.spanCount
        return if (spanCount == SPAN_COUNT_ONE) VIEW_TYPE_BIG else VIEW_TYPE_SMALL
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return if (viewType == VIEW_TYPE_BIG) {
            val view = inflater.inflate(R.layout.grid_layout, parent, false)
            ItemViewHolder(view, viewType)
        } else {
            val view = inflater.inflate(R.layout.list_layout, parent, false)
            ItemViewHolder(view, viewType)
        }
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = mItems[position]
        holder.title.text = item.getnama()
        holder.iv.setImageResource(item.getImg())
        if (getItemViewType(position) == VIEW_TYPE_BIG) {
            holder.info?.text = " ${item.getnim()}  \n ${item.getumur()} tahun"
        }else if(getItemViewType(position) == VIEW_TYPE_SMALL) {
            holder.info?.text = " ${item.getnim()}  \n ${item.getumur()} tahun"
        }else{

        }
    }

    override fun getItemCount(): Int = mItems.size

    inner class ItemViewHolder(itemView: View, viewType: Int) : RecyclerView.ViewHolder(itemView) {
        val iv: ImageView
        val title: TextView
        val info: TextView?

        init {
            if (viewType == VIEW_TYPE_BIG) {
                iv = itemView.findViewById(R.id.IVfoto)
                title = itemView.findViewById(R.id.TVnama)
                info = itemView.findViewById(R.id.TVnim)
            } else {
                iv = itemView.findViewById(R.id.IVfoto)
                title = itemView.findViewById(R.id.TVnama)
                info = itemView.findViewById(R.id.TVnim)
            }
        }
    }
}