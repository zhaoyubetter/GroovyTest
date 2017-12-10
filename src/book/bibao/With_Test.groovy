package book.bibao

import org.junit.Test

/**
 * Created by zhaoyu on 2017/12/4.
 */
class With_Test {

    class Person {
        String name
        int age

        Person(name,age) {
            this.name = name
            this.age = age
        }
    }

    @Test
    void test() {
        def list = [1,2]
        list.add(1)
        list.add(2)

        println(list)

        list.with {
            add(3)
            add(4)
        }
        println(list)

        list.with {
            println("this is ${this}")
            println("own is ${owner}")
            println("delegate is ${delegate}")
        }
    }
}
