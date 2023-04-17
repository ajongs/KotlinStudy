fun main(args: Array<String>) {

    var a: Int = 123
    //val : 일종의 상수? (한번 할당되면 재할당 불가)
    val b: Int = 123
    a = 124
    //b = 124  -> 컴파일 에러
    println(a) // == 124
    println(b) // == 123

}