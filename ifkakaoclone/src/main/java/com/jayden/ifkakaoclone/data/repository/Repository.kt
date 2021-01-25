package com.jayden.ifkakaoclone.data.repository

import com.jayden.ifkakaoclone.view.main.model.Session

interface Repository {
    fun fetchContents(callback: (List<Session>) -> Unit)
}