package com.survivalcoding.ifkakao.repository


import android.util.Log
import com.survivalcoding.ifkakao.model.Requests
import com.survivalcoding.ifkakao.model.conferenceData.Data
import com.survivalcoding.ifkakao.network.Network
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object ConferenceRepository : Repository {

    override fun getRequests(callback: (List<Data>) -> Unit) {
        Network.retrofitService.getData().enqueue(object : Callback<Requests> {
            override fun onResponse(call: Call<Requests>, response: Response<Requests>) {
                val request = response.body()
                request?.let {
                    if(it.success){
                        callback.invoke(it.data)
                    }
                    else{
                        callback.invoke(emptyList())
                    }
                }
            }

            override fun onFailure(call: Call<Requests>, t: Throwable) {
                Log.d("Network", "onFailure: Network Error")
            }

        })
    }
}

