package com.survivalcoding.ifkakao.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.survivalcoding.ifkakao.databinding.ConferenceItemBinding
import com.survivalcoding.ifkakao.extension.loadUrl
import com.survivalcoding.ifkakao.holder.ConferenceListViewHolder
import com.survivalcoding.ifkakao.model.conferenceData.Data


class ConferenceListAdapter :
    ListAdapter<Data, ConferenceListViewHolder>(ConferenceCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConferenceListViewHolder {
        val binding =
            ConferenceItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ConferenceListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ConferenceListViewHolder, position: Int) {
        val currentItem = getItem(holder.adapterPosition)
        holder.binding.apply {
            field.text = currentItem.field

            if(currentItem.title.contains("<br>")){
                val res = currentItem.title.split("<br>")
                val stringBuffer = StringBuffer()
                for(token in res){
                    stringBuffer.append(token)
                    stringBuffer.append("\n")
                }
                title.text = stringBuffer.toString()
            }else{
                title.text = currentItem.title
            }
            thumbnail.loadUrl(currentItem.linkList.pcImage[0].url)
            runningTime.text = getRunningTime(currentItem)
        }
    }

    fun getRunningTime(conferenceItem: Data) : String{
        return conferenceItem.linkList.video[0].description
    }


}