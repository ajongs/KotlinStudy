import kotlin.math.sin

fun main(args: Array<String>) {


    //TODO "var" vs "val"
    println("var vs val-------------")
    //var : 일반적인 변수
    var a: Int = 123
    //val : 일종의 상수? (한번 할당되면 재할당 불가)
    val b: Int = 123
    a = 124
    //b = 124  -> 컴파일 에러
    println(a) // == 124
    println(b) // == 123

    //TODO 배열 사용법
    println("array -------------")
    var intArr = arrayOf(1, 2, 3, 4, 5)
    var nullArr = arrayOfNulls<Int>(5) //arrayOfNulls<자료형>(개수)
    intArr[2] = 8 // 재할당/재초기화
    println(intArr[2])

    //TODO 타입추론 : 자료형을 명시하지 않아도 코틀린이 추론

    //TODO 함수사용
    println("fun -------------")
    println("함수 결과 " + add(1, 2, 3))
    println("리턴 타입이 없는 함수 " + addNonReturnType(1, 2, 3))
    //코틀린의 함수는 변수에 하나로 인식하는 것이 함수형 프로그래밍에 도움이 됨 --> 단지 파라미터를 넣는 점을 제외하고는 자료형이 결정된 변수로 인식하자

    //자료형 체크
    //is, !is
    println("is, !is -------------")
    var int = 1
    var notInt = "notInt"
    if (int is Int) {
        println("i는 int 자료형 입니다.")
    }
    if (notInt !is String) {
        println("notInt는 int 자료형이 아닙니다.")
    }

    //TODO When
    println("when -------------")
    //Any --> 코틀린의 최상위 자료형 (마치 자바의 object 와 같음)
    doWhen(100L)
    doWhen(1)
    doWhen("Hyundai")

    //TODO for문
    println("for -------------")
    //인덱스로 활용할 변수에는 var 키워드 생략 가능
    for (i in 0..9) {
        println(i)
    }
    println("step -------------")
    for (i in 0..9 step 3) {
        println(i)
    }
    println("downTo -------------")
    for (i in 9 downTo 0) {
        println(i)
    }
    println("char -------------")
    for (i in 'a'..'e') {
        println(i)
    }

    //TODO label
    //break, continue 가 적용될 반복문을 선택할 수 있음
    println("label -------------")
    loop@ for (i in 1..10) {
        for (j in 1..10) {
            if (i == 1 && j == 2) break@loop
            println("i $i j $j")
        }
    }

    //TODO class
    println("class -------------")
    //var cls = person("원종", 1997)
    var cls = person("원종")


    //TODO 상속
    //코틀린은 상속금지가 기본값 --> open 키워드를 클래스 앞에 붙여주어야함
    //조건1. 슈퍼클래스의 존재하는 속성값과 같은 이름 불가
    //조건2. 서브클래스는 항상 슈퍼클래스의 생성자를 무조건 호출
    println("상속  -------------")
    var person1 = employee("박원종")
    person1.job()


    //TODO 오버라이딩
    //재정의 대상 함수(수퍼클래스) 앞에 open
    //재정의 하는 함수(서브클래스) 앞에 override 키워드 붙이기
    var person2 = singer("감광석")
    person2.job()


    //패키지
    //자바와 달리 폴더구조와 패키지 명을 일치시키지 않아도댐
    //따라서 폴더안에 소스코드를 넣을 필요없고 그냥 소스코드 상단에 패키지 명단 선언해주면 알아서 묶임
    //선언 안하면 default 패키지에 속함


    //scope
    //동일 스코프 내에서는 멤버를 공유할 수 있다
    //하위 스코프에서는 상위 스코프 재정의 가능 -> conflicting 에러 안남
}

//fun 함수명(파라미터..): 반환형   --> 반환형이 없다면 생략 가능
fun add(a: Int, b: Int, c: Int): Int {
    return a + b + c
}

//단일 표현식 함수(single-expression function) --> 반환형 타입 추론이 가능하므로 생략 가능
fun addNonReturnType(a: Int, b: Int, c: Int) = a + b + c

fun doWhen(a: Any) {
    when (a) {
        1 -> println("1")
        "Hyundai" -> println("현다이")
        is Long -> println("Long 타입")
    }
}

open class person(var name: String, var birthYear: Int) {  //속성을 파라미터에 정의함 --> 그러면 생성자는 하나뿐인가?

    //기본생성자
    init {
        println("안녕하세요 ${name}입니다. ${birthYear}년생입니다")
        //println("안녕하세요 ${this.name}입니다. ${this.birthYear}년생입니다")
        //this.생략 가능
    }

    //보조생성자
    constructor(name: String) : this(name, 1997) {
        println("보조 생성자 생성")
        println("defuault birthYear 1997로 설정됩니다")
    }

}

open class employee(name: String) : person(name, 1997) { //보조 생성자로 상속도 가능
    open fun job() {
        println("회사원입니다")
    }
}

class singer(name: String) : employee(name) {
    override fun job() {
        println("가수입니다.")
    }
}

abstract class Animal { //단독으로 생성 불가
    abstract fun eat()
    fun sniff() {
        println("킁킁")
    }
}
interface Runner { //생성자를 가질 수 없음
    fun run()
}