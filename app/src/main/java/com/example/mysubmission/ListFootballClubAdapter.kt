package com.example.mysubmission

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions



class ListFootballClubAdapter(private val listFootballClub: ArrayList<FootballClub>) :
    RecyclerView.Adapter<ListFootballClubAdapter.ListViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_football_club, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listFootballClub.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, detail, photo) = listFootballClub[position]

        Glide.with(holder.itemView.context)
            .load(photo)
            .apply(RequestOptions().override(150,150))
            .into(holder.imgPhoto)

        holder.tvName.text = name
        holder.tvDetail.text = detail



        holder.itemView.setOnClickListener{

            val intentDetail = Intent(holder.itemView.context, DetailPageActivity::class.java)
            intentDetail.putExtra(DetailPageActivity.EXTRA_NAME, name)
            intentDetail.putExtra(DetailPageActivity.EXTRA_DETAIL, detail)
            intentDetail.putExtra(DetailPageActivity.EXTRA_PHOTO, photo)
            holder.itemView.context.startActivity(intentDetail)
        }


    }

    inner class ListViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvDetail: TextView = itemView.findViewById(R.id.tv_item_detail)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)

        }

}