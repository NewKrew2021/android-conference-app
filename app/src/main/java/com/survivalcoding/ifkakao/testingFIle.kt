package com.survivalcoding.ifkakao

fun main() {


    var str = "hello my name<br>is jin<br>hong"
    var imageUrl = str.replace("<br>", "\n")

    println(imageUrl)
}