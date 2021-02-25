package com.example.android.movieapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.ex_item.view.*

class MovieAdapter(
    private  val examplelist :List <Exitem> ,
    private val listner : OnitemClicllistner
) : RecyclerView.Adapter<MovieAdapter.MovieViewholder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewholder {
        val itemview =LayoutInflater.from(parent.context).inflate(R.layout.ex_item
        ,parent,false)
        return  MovieViewholder(itemview)
    }
    //this function responsible for binding each item
    override fun onBindViewHolder(holder: MovieViewholder, position: Int) {
        val currentItem =examplelist[position]
        holder.movView.setImageResource(currentItem.imagResoure)
//        holder.moveName.text =currentItem.Name_mov
//        holder.DesMovie.text = currentItem.Des_mov
    }
    override fun getItemCount() =examplelist.size

   inner class MovieViewholder(itemView: View) : RecyclerView.ViewHolder(itemView),
    View.OnClickListener {


       val movView: ImageView = itemView.movie_pho

        //   val moveName : TextView =itemView.movie_name
         //  val DesMovie :TextView =itemView.movie_Desc
       init {
           itemView.setOnClickListener(this)

       }

       override fun onClick(p0: View?) {
           val position =adapterPosition
           if (position !=RecyclerView.NO_POSITION) {
               listner.onitemclicked(position)
           }
       }
   }
        interface OnitemClicllistner {
            fun onitemclicked(position :Int)
        }
}