package com.survivalcoding.ifkakao.data.viewmodel

import com.survivalcoding.ifkakao.data.repository.Repository
import com.survivalcoding.ifkakao.view.main.model.Conference

class ConferenceViewModel(private val repository: Repository) : Repository {
    override fun getItems(): List<Conference> = repository.getItems()
}