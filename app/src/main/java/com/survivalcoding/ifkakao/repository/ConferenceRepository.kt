package com.survivalcoding.ifkakao.repository

import android.telecom.Conference
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.survivalcoding.ifkakao.model.Conferences
import com.survivalcoding.ifkakao.model.Requests
import com.survivalcoding.ifkakao.model.conferenceData.Data

class ConferenceRepository : Repository {
    override fun getConferenceList(): List<Conferences> {
        val dummy: String = """
            [
                {
                    "name": "SwiftLeeds",
                    "link": "https://swiftleeds.co.uk/",
                    "start": "2020-10-07",
                    "end": "2020-10-08",
                    "location": "🇬🇧 Leeds, UK"
                },
                {
                    "name": "MobOS",
                    "link": "http://romobos.com/",
                    "start": "2020-02-20",
                    "end": "2020-02-21",
                    "location": "🇷🇴 Cluj-Napoca, Romania"
                },
                {
                    "name": "dot Swift",
                    "link": "http://www.dotswift.io",
                    "start": "2020-02-03",
                    "end": "2020-02-03",
                    "location": "🇫🇷 Paris, France"
                },
                {
                    "name": "Mobilization",
                    "link": "http://2019.mobilization.pl/",
                    "start": "2019-10-26",
                    "end": "2019-10-26",
                    "location": "🇵🇱 Łódź, Poland"
                },
                {
                    "name": "try! Swift Tokyo",
                    "link": "https://www.tryswift.co/events/2020/tokyo/en/",
                    "start": "2020-03-18",
                    "end": "2020-03-20",
                    "location": "🇯🇵 Tokyo, Japan"
                },
                {
                    "name": "Mobius",
                    "link": "https://mobiusconf.com/en/",
                    "start": "2019-11-07",
                    "end": "2019-11-08",
                    "location": "🇷🇺 Moscow, Russia"
                },
                {
                    "name": "NSBrazil",
                    "link": "https://nsbrazil.com/en/",
                    "start": "2019-11-09",
                    "end": "2019-11-10",
                    "location": "🇧🇷 São Paulo, Brazil"
                },
                {
                    "name": "MobileOptimized 2019",
                    "link": "https://moconf.by/",
                    "start": "2019-10-19",
                    "end": "2019-10-19",
                    "location": "🇧🇾 Minsk, Belarus",
                    "cocoa-only": false
                }
            ]
        """.trimIndent()
        val moshi = Moshi.Builder()
            .build()
        val type = Types.newParameterizedType(List::class.java, Conferences::class.java)
        val jsonAdapter = moshi.adapter<List<Conferences>>(type)
        val list = jsonAdapter.fromJson(dummy)
        return list ?: emptyList()
    }

    override fun getRequests(): List<Data> {
        val dummy = """
            {
                "success": true,
                "code": 0,
                "data": [
                    {
                    "idx": 28,
                    "createdUserIdx": 10,
                    "createdDateTime": "2020-11-03 08:23:42",
                    "lastModifiedUserIdx": 4,
                    "lastModifiedDateTime": "2020-11-17 08:48:19",
                    "categoryIdx": 6,
                    "title": "오프닝 키노트",
                    "content": "if(kakao)2020은 더 나은 세상을 만들기 위한 카카오의 많은 생각과 도전들을 담았습니다.\n오프닝키노트를 시작으로 11월 18일부터 3일 동안 다양한 카카오의 이야기가 펼쳐집니다. \nif(kakao)에서 카카오의 변화를 함께 확인해 보시죠!\n\n오늘도 카카오는 일상을 바꾸는 중.",
                    "contentTag": "#ifkakao2020 #이프카카오2020 #카카오컨퍼런스",
                    "reservationDate": "20201118",
                    "reservationTime": "1000",
                    "spotlightYn": "Y",
                    "field": "서비스",
                    "sessionType": "Opening",
                    "linkList": {
                    "FILE": [],
                    "IMAGE": [],
                    "WEB_URL": [],
                    "VIDEO": [
                    {
                    "idx": 4625,
                    "contentsIdx": 28,
                    "type": "VIDEO",
                    "fileSize": 0,
                    "url": "https://tv.kakao.com/embed/player/cliplink/414004572",
                    "description": "08:27",
                    "mainYn": "N"
                    }
                    ],
                    "PC_THUMBNAIL": [],
                    "MO_THUMBNAIL": [],
                    "TALK_THUMBNAIL": [],
                    "SPEACKER_PROFILE": [
                    {
                    "idx": 4623,
                    "contentsIdx": 28,
                    "type": "SPEACKER_PROFILE",
                    "fileSize": 98915,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1604538731227",
                    "description": "여민수, 조수용_카카오 CEO (Sean, Mason)-1.png",
                    "mainYn": "N"
                    },
                    {
                    "idx": 4624,
                    "contentsIdx": 28,
                    "type": "SPEACKER_PROFILE",
                    "fileSize": 95882,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1604538791773",
                    "description": "여민수, 조수용_카카오 CEO (Sean, Mason)-2.png",
                    "mainYn": "N"
                    }
                    ],
                    "PC_MAIN_IMAGE": [
                    {
                    "idx": 4618,
                    "contentsIdx": 28,
                    "type": "PC_MAIN_IMAGE",
                    "fileSize": 128169,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1604391750673",
                    "description": "추천_PC_1000x800.png",
                    "mainYn": "N"
                    }
                    ],
                    "MO_MAIN_IMAGE": [
                    {
                    "idx": 4619,
                    "contentsIdx": 28,
                    "type": "MO_MAIN_IMAGE",
                    "fileSize": 63378,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1604391754938",
                    "description": "추천_MO_640x512.png",
                    "mainYn": "N"
                    }
                    ],
                    "PC_IMAGE": [
                    {
                    "idx": 4620,
                    "contentsIdx": 28,
                    "type": "PC_IMAGE",
                    "fileSize": 134467,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1604391757468",
                    "description": "세션_PC_1560x878.png",
                    "mainYn": "Y"
                    }
                    ],
                    "MO_IMAGE": [
                    {
                    "idx": 4621,
                    "contentsIdx": 28,
                    "type": "MO_IMAGE",
                    "fileSize": 42786,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1604391759700",
                    "description": "세션_MO_720x406.png",
                    "mainYn": "N"
                    }
                    ],
                    "SHARE_IMAGE": [
                    {
                    "idx": 4622,
                    "contentsIdx": 28,
                    "type": "SHARE_IMAGE",
                    "fileSize": 46186,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1604752661982",
                    "description": "공유이미지_800x400.png",
                    "mainYn": "N"
                    }
                    ],
                    "PC_SPOTLIGHT": [
                    {
                    "idx": 4616,
                    "contentsIdx": 28,
                    "type": "PC_SPOTLIGHT",
                    "fileSize": 24478,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1604391741464",
                    "description": "스포트라이트_PC_248x248.png",
                    "mainYn": "N"
                    }
                    ],
                    "MO_SPOTLIGHT": [
                    {
                    "idx": 4617,
                    "contentsIdx": 28,
                    "type": "MO_SPOTLIGHT",
                    "fileSize": 15664,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1604391743813",
                    "description": "스포트라이트_MO_184x184.png",
                    "mainYn": "N"
                    }
                    ]
                    },
                    "contentsSpeackerList": [
                    {
                    "idx": 1374,
                    "contentsIdx": 28,
                    "nameKo": "조수용",
                    "nameEn": "Sean",
                    "company": "카카오",
                    "occupation": "CEO"
                    },
                    {
                    "idx": 1375,
                    "contentsIdx": 28,
                    "nameKo": "여민수",
                    "nameEn": "Mason",
                    "company": "카카오",
                    "occupation": "CEO"
                    }
                    ],
                    "favoriteYn": "N",
                    "newCountentsYn": "N",
                    "updateCountentsYn": "N",
                    "reservationYn": "N",
                    "reservationUTC": 1605628800000,
                    "companyName": "카카오",
                    "speackerName": "Sean조수용",
                    "videoYn": "Y"
                    }
                ],
                "errorMessage": null
            }
        """.trimIndent()

        val moshi = Moshi.Builder()
            .build()
        val jsonAdapter = moshi.adapter(Requests::class.java)
        val request = jsonAdapter.fromJson(dummy)?: Requests(success = false, code = -1, data = emptyList(), errorMessage = "Response is null")
        if(request.success){
            return request.data
        }
        return emptyList()
    }
}