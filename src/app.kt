/**
 * Created by Eric on 11/21/2014.
 */
import java.util.ArrayList

fun main(args: Array<String>) {

    fun foo(i: Int) = i*i

    val sum = { Int.(other: Int) : Int -> this + other }  // this is an 'extension method' like in C#
                                                          // Int. indicates that this is an extension method on Int

    fun <T> MutableList<T>.swap(x : Int, y : Int) {
        val tmp = this[x]
        this[x] = this[y]
        this[y] = tmp
    }

    println("Hello, World!")

    val square = foo(42)  // val's are immutable variables, or values

    println(square)

    for (x in 1..5) println(x)

    val xs = listOf(1,2,3,4)
    val ys = xs.map({ a -> a*2 }).filter({ it < 5 }) // map and filter are higher-order functions on lists
                                                     // lambda expressions are surrounded by curly braces
                                                     // if the lambda expression has one parameter, you can use 'it'

    println(ys)

    println(1.sum(2))

    val list = Cons(head = 3, tail = Nil())

    println(list.length())

    val list2 = Cons(5, tail = list)

    println(list2.length())
}

abstract data class List<T>()
data class Nil<T>(): List<T>() {}
data class Cons<T>(val head: T, val tail: List<T>) : List<T>() {}
// length is a an extension method that treats Nil and Cons as case-classes
fun <T> List<T>.length(): Int {
    return when(this) {
        is Nil  -> 0
        is Cons -> 1+this.tail.length() // putting 1+ before the recursive call makes it tail-recursive
        else    -> throw Exception("impossible")
    }
}