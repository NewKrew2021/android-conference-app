package com.survivalcoding.ifkakao.delegate

import android.content.SharedPreferences
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class UserDelegate(
    private val sharedPreference: SharedPreferences,
    private val key: String,
    private val default: String, ) : ReadWriteProperty<UserModel, String> {
    override fun setValue(thisRef: UserModel, property: KProperty<*>, value: String) {
        sharedPreference.edit().putString(key, value).apply()
    }

    override fun getValue(thisRef: UserModel, property: KProperty<*>): String {
        return sharedPreference.getString(key, default)!!
    }

}