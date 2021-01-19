package com.survivalcoding.ifkakao.conference.data

import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken

class DataModel() : Model {
    private val data = """[
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
    ]""".trimIndent()

    // Gson 사용 https://rain2002kr.tistory.com/44
    override fun get(): List<DataModelItem> {
        val gson = GsonBuilder().create()   // Gson 객체 만들기
        val collectionType = object : TypeToken<List<DataModelItem>>() {}.type  // json데이터 타입 지정
        // fromJson : Json >> TypeToken의 제네릭 타입 (여기선 List<DataModelItem>)
        return gson.fromJson(data, collectionType)
    }

}