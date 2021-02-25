package com.example.android.movieapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.horizontal_item.view.*

class horizontalAdapter (private  val examplelist :List <horizontal_exitem>) :
    RecyclerView.Adapter<horizontalAdapter.horizontalholder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): horizontalholder {
        val itemview = LayoutInflater.from(parent.context).inflate(R.layout.horizontal_item
            ,parent,false)
        return  horizontalholder(itemview)
    }
    //this function responsible for binding each item
    override fun onBindViewHolder(holder:horizontalholder, position: Int) {
        val currentItem =examplelist[position]
        holder.movView_h.setImageResource(currentItem.imagResoure)
//        holder.moveName.text =currentItem.Name_mov
//        holder.DesMovie.text = currentItem.Des_mov
    }
    override fun getItemCount() =examplelist.size

    class horizontalholder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val movView_h : ImageView =itemView.h_img
//        val moveName : TextView =itemView.movie_name
//        val DesMovie :TextView =itemView.movie_Desc
    }
}
