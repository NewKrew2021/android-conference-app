package com.jayden.ifkakaoclone.view.delegate

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.jayden.ifkakaoclone.databinding.ActivityDelegateTestBinding
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class DelegateTestActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDelegateTestBinding

    private val userSettings by lazy {
        UserSettings(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDelegateTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userSettings.userName = "jayden"
        log(userSettings.userName)
    }

    private fun log(message: String?) = Log.d(javaClass.simpleName, message ?: "")
}

class UserSettings(override val context: Context) : PreferenceModel {
    var userName by PreferenceLoader()
}

interface PreferenceModel {
    val context: Context
}

/**
 * provideDelegate operator 함수를 정의하고 by 키워드를 사용하여
 * 해당 operator 가 반환하는 Delegate 를 userName 에 할당
 *
 * SharedPreference 를 구성자 호출 시 얻어온다.
 */
class PreferenceLoader(private val default: String = "") {
    operator fun provideDelegate(
        thisRef: PreferenceModel,
        property: KProperty<*>
    ): ReadWriteProperty<PreferenceModel, String> {

        return PreferenceDelegate(
            thisRef.context.getSharedPreferences(
                thisRef.javaClass.simpleName,
                Context.MODE_PRIVATE
            ),
            property.name,
            default
        )
    }
}

/**
 * Property<in T, V>
 *     - T : 프로퍼티를 선언하고 있는 클래스 타입 (PreferenceModel)
 *     - V : get / set 하는 value 데이터 타입 (String)
 *
 * property.name = userName (변수명)
 */
class PreferenceDelegate(
    private val preference: SharedPreferences,
    private val key: String,
    private val default: String,
) : ReadWriteProperty<PreferenceModel?, String> {

    override fun getValue(thisRef: PreferenceModel?, property: KProperty<*>): String =
        preference.getString(key, default) ?: ""

    override fun setValue(thisRef: PreferenceModel?, property: KProperty<*>, value: String) {
        preference.edit().putString(key, value).apply()
    }
}