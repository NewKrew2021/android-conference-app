package com.example.ifkakao.util

import android.net.Uri
import com.google.firebase.dynamiclinks.DynamicLink
import com.google.firebase.dynamiclinks.ktx.dynamicLinks
import com.google.firebase.dynamiclinks.ktx.shortLinkAsync
import com.google.firebase.ktx.Firebase

const val SHARE_URI = "https://ifandroid.com/session?idx=%d" // 동적 링크를 통해 앱이 실행되었을 때 전달받을 url
const val DOMAIN_PREFIX = "https://ifandroid.page.link" // 기본 동적 링크 (Intent-Filter를 통해 동작)
const val FALL_BACK_URL = "https://if.kakao.com/session/%d" // 앱이 설치되지 않은 경우 이동할 url

fun makeShareLink(sessionId: Int, successListener: (String) -> Unit, failureListener: () -> Unit) {
    // 비동기적로 동적링크를 생성
    Firebase.dynamicLinks.shortLinkAsync {
        link = Uri.parse(String.format(SHARE_URI, sessionId))
        domainUriPrefix = DOMAIN_PREFIX
        setAndroidParameters(
            DynamicLink.AndroidParameters.Builder()
                .setFallbackUrl(Uri.parse(String.format(FALL_BACK_URL, sessionId))).build()
        )
    }.addOnSuccessListener {
        successListener(it.shortLink.toString())
    }.addOnFailureListener {
        failureListener()
    }
}