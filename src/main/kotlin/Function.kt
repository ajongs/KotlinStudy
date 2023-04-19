
fun main() {
    //고차함수 -> 함수를 클래스에서 만들어낸 인스턴스처럼 취급하는 방법 -> 자바의 함수형 인터페이스라고 보면 될듯 ? -> 함수를 함수의 파라미터나 반환값으로 받을 수 있는 방법
    //코틀린에서는 모든 함수를 고차함수로 변환 가능
    b(::a) //:: 일반함수를 고차함수로 바꾸어주는 연산자
    b(::c)
    var d : (String)->Unit = {str -> println("$str 람다함수")}  //(파라미터 나열, ) -> 반환 자료형 //함수의 시그니처가 자료형이 된다고 생각하면 편함
    //{} 안에는 함수가 수행할 로직을 작성하는데 함수의 파라미터로 넘어온 값을 받을 변수를 선언해야함 str: String 이렇게 해야하지만
    //함수의 형식을 보고 타입추론이 가능하기 때문에 자료형을 생략할 수 있음
    //따라서 (String)->Unit = {str} 로 가능함

    var f = {str: String -> println("$str 함수형식 생략도 가능")}
    //파라미터와 리턴값 타입추론 가능 -> 함수형식((String) -> Unit) 의 객체로 f 변수에 저장
    val noPram: () -> Unit = { println("파람없는 경우")}
    //파라미터가 하나인 경우 it을 사용할 수 있음
    var onePram: (String) -> Unit = { println("$it 원 파람")}


    b(d) //람다함수를 매개변수로 넣을 때는 :: 이 필요없음 -> 람다함수는 그 자체가 고차함수이기 때문
    name{"string"}
}

fun name(lambda: () -> String) {
    name(lambda)
}

fun a(str: String) {
    println("$str 함수 a")
}

fun b(function: (String) -> Unit) {//Unit은 반환값이 없음을 나타냄
    function("b가 호출한")
}

fun c(str: String) {
    println("$str 함수 c")
}
