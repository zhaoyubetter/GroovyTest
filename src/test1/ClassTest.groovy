package test1

/**
 * Groovy 中的类
 * Created by zhaoyu on 2016/11/20.
 */
class Person {
    def name
    def age
    def gender

    def like

    String toString() {
        return "${name}, ${age}, ${gender}"
    }

    def getName() {
        name.toUpperCase()
    }

    def getLike() {
        like?.toUpperCase()     // ? 解决 null pointer
    }
}

class ClassTest {
    static void main(args) {
        def person = new Person(name: "Better", age: 29, gender: "男")
        println(person);

        println("---------------")

        println(person.getLike());      // null pointer 的解决
    }
}