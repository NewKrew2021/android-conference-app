package com.example.ifkakao.model

import java.io.File

const val fileDirectory = "ifkakao/src/main/java/com/example/ifkakao/model/dummyData.txt"
var dummyData = File(fileDirectory).inputStream().bufferedReader().use { it.readText() }