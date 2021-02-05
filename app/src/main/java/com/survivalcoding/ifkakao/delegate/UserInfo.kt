package com.survivalcoding.ifkakao.delegate

import android.content.Context

class UserInfo(override val context: Context) : UserModel {
    var userName by DelegateLoader("비어있음(초기화 필요)")
    var userEnglishName by DelegateLoader("비어있음(초기화 필요)")
}

interface UserModel {
    val context: Context
}