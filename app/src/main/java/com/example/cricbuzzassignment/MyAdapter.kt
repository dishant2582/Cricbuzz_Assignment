package com.example.cricbuzzassignment

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class MyAdapter(val context: Activity, val productArrayList: List<Data>, val hashMap: HashMap<Int,String>):
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.each_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return productArrayList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentitem = productArrayList[position]
        holder.htitle.text = currentitem.note
        holder.matchtype.text = currentitem.type
        holder.status.text = currentitem.status
        holder.date.text = currentitem.starting_at.subSequence(0,10);

    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val htitle = itemView.findViewById<TextView>(R.id.textView)
        val matchtype = itemView.findViewById<TextView>(R.id.textView2)
        val date = itemView.findViewById<TextView>(R.id.textdate)
        val status = itemView.findViewById<TextView>(R.id.textView4)
    }

}