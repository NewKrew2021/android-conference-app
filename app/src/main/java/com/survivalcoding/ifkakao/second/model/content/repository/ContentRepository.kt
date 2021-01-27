package com.survivalcoding.ifkakao.second.model.content.repository

import com.squareup.moshi.Moshi
import com.survivalcoding.ifkakao.second.model.content.ContentData
import com.survivalcoding.ifkakao.second.model.content.Contents
import com.survivalcoding.ifkakao.second.model.content.Repository
import com.survivalcoding.ifkakao.second.network.JsonServiceFactory

class ContentRepository : Repository {
    private val dummy = """{
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
    },
    {
      "idx": 7,
      "createdUserIdx": 10,
      "createdDateTime": "2020-11-03 07:58:20",
      "lastModifiedUserIdx": 4,
      "lastModifiedDateTime": "2020-11-17 08:48:38",
      "categoryIdx": 6,
      "title": "디지털화된 일상에서<br>카카오톡이 만드는 새로운 세상",
      "content": "카카오의 대표 서비스 카카오톡에 새롭게 추가되는 신규 기능들을 소개합니다.\n\n카톡에서 주고받은 대화와 디지털 자산들을 안전하게 보관할 수 있는 \n네트워크 드라이브 서비스인 ‘톡서랍’.\n톡서랍의 저장 공간을 활용한 새로운 채팅방인 ‘팀채팅’.\n다양한 관계에 따라 여러 개의 프로필을 만들고, \n어떤 상대에게 노출할지 스스로 결정할 수 있는 ‘멀티프로필’. \n공개 프로필 검색을 통해 특별한 자격을 가진 사람과 \n새로운 관계를 맺을 수 있는 ‘인물 검색’.\n모바일 환경에서 신원을 증명하고 본인임을 인증할 수 있는 ‘디지털 신분증’.\n\n카카오가 기대하는 새로운 관계 맺기와 소중한 만남의 확장, 그리고 더욱 편리해진 디지털 일상의 모습을 만나보실 수 있습니다.",
      "contentTag": "#카카오톡 #신규서비스 #톡서랍 #팀채팅 #멀티프로필 #인물검색 #디지털신분증 #카카오인증서 #디지털자산",
      "reservationDate": "20201118",
      "reservationTime": "1000",
      "spotlightYn": "Y",
      "field": "서비스",
      "sessionType": "A Type",
      "linkList": {
        "FILE": [],
        "IMAGE": [],
        "WEB_URL": [],
        "VIDEO": [
          {
            "idx": 4651,
            "contentsIdx": 7,
            "type": "VIDEO",
            "fileSize": 0,
            "url": "https://tv.kakao.com/embed/player/cliplink/414072174",
            "description": "12:50",
            "mainYn": "N"
          }
        ],
        "PC_THUMBNAIL": [],
        "MO_THUMBNAIL": [],
        "TALK_THUMBNAIL": [],
        "SPEACKER_PROFILE": [
          {
            "idx": 4650,
            "contentsIdx": 7,
            "type": "SPEACKER_PROFILE",
            "fileSize": 110402,
            "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1604539026422",
            "description": "김택수_카카오 CPD (Felix).png",
            "mainYn": "N"
          }
        ],
        "PC_MAIN_IMAGE": [
          {
            "idx": 4645,
            "contentsIdx": 7,
            "type": "PC_MAIN_IMAGE",
            "fileSize": 205390,
            "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1604390236169",
            "description": "추천_PC_1000x800.png",
            "mainYn": "N"
          }
        ],
        "MO_MAIN_IMAGE": [
          {
            "idx": 4646,
            "contentsIdx": 7,
            "type": "MO_MAIN_IMAGE",
            "fileSize": 89976,
            "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1604390239014",
            "description": "추천_MO_640x512.png",
            "mainYn": "N"
          }
        ],
        "PC_IMAGE": [
          {
            "idx": 4647,
            "contentsIdx": 7,
            "type": "PC_IMAGE",
            "fileSize": 615662,
            "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1604390251871",
            "description": "세션_PC_1560x878.png",
            "mainYn": "Y"
          }
        ],
        "MO_IMAGE": [
          {
            "idx": 4648,
            "contentsIdx": 7,
            "type": "MO_IMAGE",
            "fileSize": 122135,
            "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1604390254880",
            "description": "세션_MO_720x406.png",
            "mainYn": "N"
          }
        ],
        "SHARE_IMAGE": [
          {
            "idx": 4649,
            "contentsIdx": 7,
            "type": "SHARE_IMAGE",
            "fileSize": 150637,
            "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1604390257442",
            "description": "공유이미지_800x400.png",
            "mainYn": "N"
          }
        ],
        "PC_SPOTLIGHT": [
          {
            "idx": 4643,
            "contentsIdx": 7,
            "type": "PC_SPOTLIGHT",
            "fileSize": 40926,
            "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1604390263970",
            "description": "스포트라이트_PC_248x248.png",
            "mainYn": "N"
          }
        ],
        "MO_SPOTLIGHT": [
          {
            "idx": 4644,
            "contentsIdx": 7,
            "type": "MO_SPOTLIGHT",
            "fileSize": 22635,
            "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1604390266654",
            "description": "스포트라이트_MO_184x184.png",
            "mainYn": "N"
          }
        ]
      },
      "contentsSpeackerList": [
        {
          "idx": 1378,
          "contentsIdx": 7,
          "nameKo": "김택수",
          "nameEn": "Felix",
          "company": "카카오",
          "occupation": "카카오 CPO"
        }
      ],
      "favoriteYn": "N",
      "newCountentsYn": "N",
      "updateCountentsYn": "N",
      "reservationYn": "N",
      "reservationUTC": 1605628800000,
      "companyName": "카카오",
      "speackerName": "Felix김택수",
      "videoYn": "Y"
    },
    {
      "idx": 9,
      "createdUserIdx": 10,
      "createdDateTime": "2020-11-03 08:00:15",
      "lastModifiedUserIdx": 4,
      "lastModifiedDateTime": "2020-11-18 00:56:16",
      "categoryIdx": 6,
      "title": "비즈니스. 톡처럼 쉬워지다.",
      "content": "카카오톡에서 비즈니스는 어떻게 하는 걸까요? \n톡처럼 쉽게 비즈니스를 할 수 있는 방법은 없을까요?\n\n카카오가 여러분의 비즈니스를 쉽게 성장시킬 수 있도록 변화합니다.\n카카오 비즈니스의 개념과, 변화하는 플랫폼의 모습, 그리고 그 활용법에 대해 알아보겠습니다.",
      "contentTag": "#카카오비즈니스 #카카오톡채널 #카카오광고 #카카오비즈도구 ",
      "reservationDate": "20201118",
      "reservationTime": "1000",
      "spotlightYn": "Y",
      "field": "비즈니스",
      "sessionType": "A Type",
      "linkList": {
        "FILE": [],
        "IMAGE": [],
        "WEB_URL": [],
        "VIDEO": [
          {
            "idx": 5060,
            "contentsIdx": 9,
            "type": "VIDEO",
            "fileSize": 0,
            "url": "https://tv.kakao.com/embed/player/cliplink/414132708",
            "description": "16:01",
            "mainYn": "N"
          }
        ],
        "PC_THUMBNAIL": [],
        "MO_THUMBNAIL": [],
        "TALK_THUMBNAIL": [],
        "SPEACKER_PROFILE": [
          {
            "idx": 5059,
            "contentsIdx": 9,
            "type": "SPEACKER_PROFILE",
            "fileSize": 124788,
            "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1604540120076",
            "description": "정의정_카카오 CBO (Charles).png",
            "mainYn": "N"
          }
        ],
        "PC_MAIN_IMAGE": [
          {
            "idx": 5054,
            "contentsIdx": 9,
            "type": "PC_MAIN_IMAGE",
            "fileSize": 62592,
            "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1604390375519",
            "description": "추천_PC_1000x800.png",
            "mainYn": "N"
          }
        ],
        "MO_MAIN_IMAGE": [
          {
            "idx": 5055,
            "contentsIdx": 9,
            "type": "MO_MAIN_IMAGE",
            "fileSize": 38896,
            "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1604390377789",
            "description": "추천_MO_640x512.png",
            "mainYn": "N"
          }
        ],
        "PC_IMAGE": [
          {
            "idx": 5056,
            "contentsIdx": 9,
            "type": "PC_IMAGE",
            "fileSize": 82812,
            "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1604390380477",
            "description": "세션_PC_1560x878.png",
            "mainYn": "Y"
          }
        ],
        "MO_IMAGE": [
          {
            "idx": 5057,
            "contentsIdx": 9,
            "type": "MO_IMAGE",
            "fileSize": 35207,
            "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1604390383217",
            "description": "세션_MO_720x406.png",
            "mainYn": "N"
          }
        ],
        "SHARE_IMAGE": [
          {
            "idx": 5058,
            "contentsIdx": 9,
            "type": "SHARE_IMAGE",
            "fileSize": 35108,
            "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1604390385934",
            "description": "공유이미지_800x400.png",
            "mainYn": "N"
          }
        ],
        "PC_SPOTLIGHT": [
          {
            "idx": 5052,
            "contentsIdx": 9,
            "type": "PC_SPOTLIGHT",
            "fileSize": 13966,
            "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1604390360031",
            "description": "스포트라이트_PC_248x248.png",
            "mainYn": "N"
          }
        ],
        "MO_SPOTLIGHT": [
          {
            "idx": 5053,
            "contentsIdx": 9,
            "type": "MO_SPOTLIGHT",
            "fileSize": 9811,
            "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1604390361551",
            "description": "스포트라이트_MO_184x184.png",
            "mainYn": "N"
          }
        ]
      },
      "contentsSpeackerList": [
        {
          "idx": 1471,
          "contentsIdx": 9,
          "nameKo": "정의정",
          "nameEn": "Charles",
          "company": "카카오",
          "occupation": "카카오 CBO"
        }
      ],
      "favoriteYn": "N",
      "newCountentsYn": "N",
      "updateCountentsYn": "N",
      "reservationYn": "N",
      "reservationUTC": 1605628800000,
      "companyName": "카카오",
      "speackerName": "Charles정의정",
      "videoYn": "Y"
    },
    {
      "idx": 11,
      "createdUserIdx": 10,
      "createdDateTime": "2020-11-03 08:02:16",
      "lastModifiedUserIdx": 4,
      "lastModifiedDateTime": "2020-11-19 09:26:24",
      "categoryIdx": 6,
      "title": "카카오를 지탱하는<br>기술에 대하여",
      "content": "카카오에서 기술의 가치에 대해서 이야기 나눕니다.\n또한, 카카오의 주요 기술의 현황과 관련된 기술 세션을 소개하며, \n카카오가 바라는 개발자 인재상에 대해 이야기합니다.",
      "contentTag": "#Developer #Tech #Engineering #Data #Platform #Dev-Culture #Dev-Talent",
      "reservationDate": "20201118",
      "reservationTime": "1000",
      "spotlightYn": "Y",
      "field": "기술",
      "sessionType": "A Type",
      "linkList": {
        "FILE": [],
        "IMAGE": [],
        "WEB_URL": [],
        "VIDEO": [
          {
            "idx": 5400,
            "contentsIdx": 11,
            "type": "VIDEO",
            "fileSize": 0,
            "url": "https://tv.kakao.com/embed/player/cliplink/414199815",
            "description": "18:56",
            "mainYn": "N"
          }
        ],
        "PC_THUMBNAIL": [],
        "MO_THUMBNAIL": [],
        "TALK_THUMBNAIL": [],
        "SPEACKER_PROFILE": [
          {
            "idx": 5399,
            "contentsIdx": 11,
            "type": "SPEACKER_PROFILE",
            "fileSize": 112251,
            "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1604540086909",
            "description": "신정환_카카오 CTO (Maydeen).png",
            "mainYn": "N"
          }
        ],
        "PC_MAIN_IMAGE": [
          {
            "idx": 5394,
            "contentsIdx": 11,
            "type": "PC_MAIN_IMAGE",
            "fileSize": 129197,
            "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1604390471646",
            "description": "추천_PC_1000x800.png",
            "mainYn": "N"
          }
        ],
        "MO_MAIN_IMAGE": [
          {
            "idx": 5395,
            "contentsIdx": 11,
            "type": "MO_MAIN_IMAGE",
            "fileSize": 77257,
            "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1604390474787",
            "description": "추천_MO_640x512.png",
            "mainYn": "N"
          }
        ],
        "PC_IMAGE": [
          {
            "idx": 5396,
            "contentsIdx": 11,
            "type": "PC_IMAGE",
            "fileSize": 185624,
            "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1604390478593",
            "description": "세션_PC_1560x878.png",
            "mainYn": "Y"
          }
        ],
        "MO_IMAGE": [
          {
            "idx": 5397,
            "contentsIdx": 11,
            "type": "MO_IMAGE",
            "fileSize": 78021,
            "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1604390480970",
            "description": "세션_MO_720x406.png",
            "mainYn": "N"
          }
        ],
        "SHARE_IMAGE": [
          {
            "idx": 5398,
            "contentsIdx": 11,
            "type": "SHARE_IMAGE",
            "fileSize": 78609,
            "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1604390484442",
            "description": "공유이미지_800x400.png",
            "mainYn": "N"
          }
        ],
        "PC_SPOTLIGHT": [
          {
            "idx": 5392,
            "contentsIdx": 11,
            "type": "PC_SPOTLIGHT",
            "fileSize": 32411,
            "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1604390454809",
            "description": "스포트라이트_PC_248x248.png",
            "mainYn": "N"
          }
        ],
        "MO_SPOTLIGHT": [
          {
            "idx": 5393,
            "contentsIdx": 11,
            "type": "MO_SPOTLIGHT",
            "fileSize": 22449,
            "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1604390457363",
            "description": "스포트라이트_MO_184x184.png",
            "mainYn": "N"
          }
        ]
      },
      "contentsSpeackerList": [
        {
          "idx": 1547,
          "contentsIdx": 11,
          "nameKo": "신정환",
          "nameEn": "Maydeen",
          "company": "카카오",
          "occupation": "카카오 CTO"
        }
      ],
      "favoriteYn": "N",
      "newCountentsYn": "N",
      "updateCountentsYn": "N",
      "reservationYn": "N",
      "reservationUTC": 1605628800000,
      "companyName": "카카오",
      "speackerName": "Maydeen신정환",
      "videoYn": "Y"
    },
    {
      "idx": 31,
      "createdUserIdx": 10,
      "createdDateTime": "2020-11-03 08:25:33",
      "lastModifiedUserIdx": 4,
      "lastModifiedDateTime": "2020-11-17 08:48:13",
      "categoryIdx": 6,
      "title": "혁신의 씨앗을 뿌리다. <br>카카오임팩트 펠로우십",
      "content": "혁신의 씨앗을 뿌리는 카카오임팩트의 새로운 시작!\n2021년 1월, 우리 사회의 긍정적 변화를 만드는 사회혁신가들을 지원하는 '카카오임팩트펠로우십' 사업이 시작됩니다.\n\n더 나은 사회를 만드는 사람들, 가치있는 혁신을 고민하는 사람들의 발걸음이 꾸준히 나아가고, 그들의 목소리가 퍼질 수 있게 오늘보다 더 나은 미래를 만드는 사람들을 찾아내고 지원합니다. '카카오임팩트펠로우십'은 혁신가들에게 가장 필요한 부분을 지혜롭게 챙겨주고, 그들의 메시지를 확산해주고 연결하는 역할을 하고자 합니다.",
      "contentTag": "#사회혁신 #펠로우십 #카카오임팩트 #사회공헌",
      "reservationDate": "20201118",
      "reservationTime": "1000",
      "spotlightYn": "Y",
      "field": "서비스",
      "sessionType": "A Type",
      "linkList": {
        "FILE": [],
        "IMAGE": [],
        "WEB_URL": [],
        "VIDEO": [
          {
            "idx": 4615,
            "contentsIdx": 31,
            "type": "VIDEO",
            "fileSize": 0,
            "url": "https://tv.kakao.com/embed/player/cliplink/413991179",
            "description": "26:16",
            "mainYn": "N"
          }
        ],
        "PC_THUMBNAIL": [],
        "MO_THUMBNAIL": [],
        "TALK_THUMBNAIL": [],
        "SPEACKER_PROFILE": [
          {
            "idx": 4611,
            "contentsIdx": 31,
            "type": "SPEACKER_PROFILE",
            "fileSize": 117849,
            "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1604907482322",
            "description": "임태완.png",
            "mainYn": "N"
          },
          {
            "idx": 4612,
            "contentsIdx": 31,
            "type": "SPEACKER_PROFILE",
            "fileSize": 117365,
            "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1604907484913",
            "description": "육심나.png",
            "mainYn": "N"
          },
          {
            "idx": 4613,
            "contentsIdx": 31,
            "type": "SPEACKER_PROFILE",
            "fileSize": 108903,
            "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1604907487856",
            "description": "엄윤미.png",
            "mainYn": "N"
          },
          {
            "idx": 4614,
            "contentsIdx": 31,
            "type": "SPEACKER_PROFILE",
            "fileSize": 113737,
            "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1604907491047",
            "description": "정정윤.png",
            "mainYn": "N"
          }
        ],
        "PC_MAIN_IMAGE": [
          {
            "idx": 4606,
            "contentsIdx": 31,
            "type": "PC_MAIN_IMAGE",
            "fileSize": 246649,
            "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1604391908664",
            "description": "추천_PC_1000x800.png",
            "mainYn": "N"
          }
        ],
        "MO_MAIN_IMAGE": [
          {
            "idx": 4607,
            "contentsIdx": 31,
            "type": "MO_MAIN_IMAGE",
            "fileSize": 136229,
            "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1604391910806",
            "description": "추천_MO_640x512.png",
            "mainYn": "N"
          }
        ],
        "PC_IMAGE": [
          {
            "idx": 4608,
            "contentsIdx": 31,
            "type": "PC_IMAGE",
            "fileSize": 275099,
            "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1604391913926",
            "description": "세션_PC_1560x878.png",
            "mainYn": "Y"
          }
        ],
        "MO_IMAGE": [
          {
            "idx": 4609,
            "contentsIdx": 31,
            "type": "MO_IMAGE",
            "fileSize": 73488,
            "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1604391914508",
            "description": "세션_MO_720x406.png",
            "mainYn": "N"
          }
        ],
        "SHARE_IMAGE": [
          {
            "idx": 4610,
            "contentsIdx": 31,
            "type": "SHARE_IMAGE",
            "fileSize": 74170,
            "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1604391916603",
            "description": "공유이미지_800x400.png",
            "mainYn": "N"
          }
        ],
        "PC_SPOTLIGHT": [
          {
            "idx": 4604,
            "contentsIdx": 31,
            "type": "PC_SPOTLIGHT",
            "fileSize": 29102,
            "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1604391891046",
            "description": "스포트라이트_PC_248x248.png",
            "mainYn": "N"
          }
        ],
        "MO_SPOTLIGHT": [
          {
            "idx": 4605,
            "contentsIdx": 31,
            "type": "MO_SPOTLIGHT",
            "fileSize": 17388,
            "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1604391895573",
            "description": "스포트라이트_MO_184x184.png",
            "mainYn": "N"
          }
        ]
      },
      "contentsSpeackerList": [
        {
          "idx": 1370,
          "contentsIdx": 31,
          "nameKo": "김태완",
          "nameEn": "Tan",
          "company": "카카오임팩트",
          "occupation": "매니저"
        },
        {
          "idx": 1371,
          "contentsIdx": 31,
          "nameKo": "육심나",
          "nameEn": "Sienna",
          "company": "카카오임팩트",
          "occupation": "사무국장"
        },
        {
          "idx": 1372,
          "contentsIdx": 31,
          "nameKo": "엄윤미",
          "nameEn": "Yoonmi Eom",
          "company": "C-Program",
          "occupation": "대표"
        },
        {
          "idx": 1373,
          "contentsIdx": 31,
          "nameKo": "정정윤",
          "nameEn": "Jeongyun Jeong",
          "company": "핸드스피크",
          "occupation": "대표"
        }
      ],
      "favoriteYn": "N",
      "newCountentsYn": "N",
      "updateCountentsYn": "N",
      "reservationYn": "N",
      "reservationUTC": 1605628800000,
      "companyName": "카카오임팩트",
      "speackerName": "Tan김태완",
      "videoYn": "Y"
    }
    ],
  "errorMessage": null
}""".trimIndent()
    private val contentService = JsonServiceFactory.contentService
    override suspend fun getData() = contentService.getData()

    fun getDataWithDummy(): Contents {
        val adapter = Moshi.Builder().build().adapter(Contents::class.java)
        return adapter.fromJson(dummy) ?: Contents(0, listOf<ContentData>(), false, "parsing fail")
    }
}