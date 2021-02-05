package com.survivalcoding.ifkakao.delegate

import android.content.Context
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class DelegateLoader(private val default: String) {

    operator fun provideDelegate(
        thisRef: UserInfo,
        property: KProperty<*>
    ): ReadWriteProperty<UserInfo, String> {
        return UserDelegate(
            thisRef.context.getSharedPreferences(
                thisRef.javaClass.simpleName,
                Context.MODE_PRIVATE
            ),
            property.name,
            default
        )
    }

}