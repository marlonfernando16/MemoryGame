package com.example.matchinggamepdm

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.BaseAdapter
import android.widget.ImageView

class ImageAdapter(private val context: Context) :BaseAdapter(){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        val imageView: ImageView
        if(convertView == null){
            imageView = ImageView(this.context)
            imageView.setLayoutParams(AbsListView.LayoutParams(110, 170))
            imageView.scaleType = ImageView.ScaleType.FIT_XY

        }else
            imageView = convertView as ImageView

        imageView.setImageResource(R.drawable.question)
        return imageView
    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int):Long {
        return 0
    }

    override fun getCount(): Int {
        return 16
    }
}