package com.jayden.ifkakaoclone.data.viewmodel

import com.jayden.ifkakaoclone.data.repository.Repository
import com.jayden.ifkakaoclone.data.repository.SessionRepository
import com.jayden.ifkakaoclone.view.main.model.Session

class SessionViewModel(private val repository: SessionRepository) : Repository {
    override fun getSessions(): List<Session> = repository.getSessions()
}