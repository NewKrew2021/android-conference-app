package com.survivalcoding.ifkakao

fun main() {

/*
    var a = 1
    var list = mutableListOf<Int>()
    list.add(a)

    var ins = tmp()
    ins.list = list
    ins.update()

    println(list[0])
    println(ins.list[0])

 */

    var a = ins(3)

    var wrapper = tmp()
    wrapper.b = a
    wrapper.update()

    println(wrapper.b)
    println(a)
}

data class ins(var data: Int) {}

class tmp() {

    var b: ins? = null
    var list = mutableListOf<Int>()


    fun update() {
        b!!.data = 5
    }
}