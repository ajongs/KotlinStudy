class Scope {

}

fun main() {
    var a = Book(
        age = 1,
        name = "이름"
        ).apply { name = "원종" }
    var b = a.apply {
        name = "주형"
    }
    println(a.equals(b))
}

class Book(var name:String, var age: Int) {

}
//스코프 함수란?
//기본 제공하는 함수들 apply, run, with, also, let

//apply
