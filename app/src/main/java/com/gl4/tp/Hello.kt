package com.gl4.tp

fun main(argv : Array<String> ){
    //Hello
    println("Hello")

    // Rectangle list
    val listOfRectangle = listOf(Rectangle(),
        Rectangle(q=Point(2,2)), Rectangle
            (p= Point(2,5)),Rectangle(p= Point(4,1),q=Point(2,0))
    )

    //test toString() fun
    for(i in listOfRectangle.indices) {
        println(listOfRectangle[i])
    }

    //test surface() fun
    for(i in listOfRectangle.indices) {
        println(listOfRectangle[i].surface())
    }
}