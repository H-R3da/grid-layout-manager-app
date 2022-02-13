package com.basic.programming.mygridlayoutapp.adapters

import android.content.Context
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.basic.programming.mygridlayoutapp.MainActivity
import com.basic.programming.mygridlayoutapp.R
import com.basic.programming.mygridlayoutapp.model.CharItem
import java.util.concurrent.TimeUnit


class AlphaAdapters(var context: Context, var arrayList: ArrayList<CharItem>, var mMediaPlayer: MediaPlayer?) :
    RecyclerView.Adapter<AlphaAdapters.ItemHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val viewHolder = LayoutInflater.from(parent.context)
            .inflate(R.layout.grid_view_layout_items, parent, false)
        return ItemHolder(viewHolder)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }



    override fun onBindViewHolder(holder: ItemHolder, position: Int) {

        val charItem: CharItem = arrayList.get(position)
        var  numb1 = 0

        holder.icons.setImageResource(charItem.icons!!)
        holder.titles.text = charItem.alpha


        holder.titles.setOnClickListener {
            numb1++
            //Toast.makeText(context, charItem.alpha, Toast.LENGTH_LONG).show()
            Toast.makeText(context, numb1.toString(), Toast.LENGTH_LONG).show()

            mMediaPlayer = MediaPlayer.create(context, R.raw.laugh)
            mMediaPlayer!!.seekTo(0)
            mMediaPlayer!!.start()
            /*
            TimeUnit.SECONDS.sleep(2L)
            Toast.makeText(context,"test text", Toast.LENGTH_SHORT).show()
            mMediaPlayer!!.pause()
             */
        }

    }

    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var icons = itemView.findViewById<ImageView>(R.id.icon_image_view)
        var titles = itemView.findViewById<TextView>(R.id.title_text_view)

    }
}