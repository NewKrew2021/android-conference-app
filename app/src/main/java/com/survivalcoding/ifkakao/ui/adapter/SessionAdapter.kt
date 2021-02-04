package com.survivalcoding.ifkakao.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.survivalcoding.ifkakao.data.model.response.ConferenceSessionResponse
import com.survivalcoding.ifkakao.databinding.ItemSessionBinding

class SessionAdapter : RecyclerView.Adapter<SessionViewHolder>() {

    private var sessionList: MutableList<ConferenceSessionResponse> = ArrayList()

    private lateinit var sessionClickListener: ((session: ConferenceSessionResponse) -> Unit)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SessionViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemSessionBinding.inflate(inflater, parent, false)
        return SessionViewHolder(binding)
    }

    override fun getItemCount() = sessionList.size

    override fun onBindViewHolder(holder: SessionViewHolder, position: Int) {
        holder.bindView((sessionList[position]))
        holder.clickEventProcess(sessionList[position], sessionClickListener)
    }

    fun setList(list: List<ConferenceSessionResponse>) {
        this.sessionList = list as MutableList<ConferenceSessionResponse>
        notifyDataSetChanged()
    }

    fun setSessionClickListener(listener: (session: ConferenceSessionResponse) -> Unit) {
        this.sessionClickListener = listener
    }

}

class SessionViewHolder(private val binding: ItemSessionBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bindView(session: ConferenceSessionResponse) {
        binding.session = session
        binding.ivThumbnailSession.clipToOutline = true
    }

    fun clickEventProcess(
        session: ConferenceSessionResponse,
        listener: (session: ConferenceSessionResponse) -> Unit
    ) {
        binding.layoutItemSession.setOnClickListener {
            listener.invoke(session)
        }
    }
}