package test1

import org.junit.Test

/**
 * Created by zhaoyu on 2017/10/12.
 */
class JUnitTest2 {
    @Test
    void test1() {
        println(123.plus(3))
        println(13 / 5)     // 浮点数 2.6
        println(13.intdiv(5)) // 整数2

        def better = 'better'
        println(better[-1])
        println(better[0..2])   // bet
        println(better[4..2])   // ett
    }

    @Test
    void test2() {
        def message = "better"
        println(message.center(15))                 // better 居中
        println(message.center(15, "*"))   // ****better*****
        println(message.padLeft(15, "*"))  // *********better
        println(message.tokenize('e'))      // [b, tt, r]
    }

    @Test
    void test3() {
        println(('Groovy' =~ 'Groovy').find())
        println(('Groovy' =~ 'oo').find())
        println(('Groovy' ==~ 'Groovy').find())
    }

    @Test
    void test4() {
        def numbers = [1, 2, 3, 4, 5, 6]

// 取值操作
        println(numbers[0])     // 1
        println(numbers[-1])    // 6
        println(numbers[1..4])   // 返回列表[2,3,4,5]
        println(numbers[1, 4])   // 返回列表[2,5]

// 赋值操作
        numbers[0] = ["better", "a"]
        println(numbers)        // [[better, a], 2, 3, 4, 5, 6]
        numbers << 8            // leftShift运算符
        println(numbers)        // [[better, a], 2, 3, 4, 5, 6, 8]
    }


    @Test
    void test5() {
        def names = ['better': 'zhao', 'joy': 'chen']
        println(names.getClass().getName())
// 取值
        println(names['better'])        // zhao
        println(names.get('better'))    // zhao

// 赋值
        names['better'] = [1, 2, 3, 4]
        println(names)              // [better:[1, 2, 3, 4], joy:chen]
        println(names.getClass().getName())
        println(names.keySet())     // [better, joy]
        println(names.values())     // [[1, 2, 3, 4], chen]
    }

    @Test
    void test6() {
        println(1..5)      // [1,2,3,4,5]
        println(1..<5)     // [1, 2, 3, 4]
        println(5..1)      // [5,4,3,2,1]
        println('A'..'D')   // [A,B,C,D]
        println((1..5).getTo()) //5
        println((1..5).getFrom()) //5
    }


    @Test
    void test7() {
        println([12, 13, 14, 15].reverse())
        println([1, [2, [3, 4]]].flatten())

        def a = [11, 12, 13, 14]
        def b = [13, 14, 15]
        a.removeAll(b)
        println(a)
        println(a.getClass().getName())     // 默认ArrayList
        println(([11,22,33] as LinkedList).getClass().getName())

        println(a[20])
        println(a.size())

        println((1..5).getClass().getName())  //

    }


    @Test
    void test8() {
        def softWareHouse = ['Groovy': ['one', 'two', 'three'],
                             'Java'  : ['one', 'two'],
                             'C#'    : ['four']]

        println(softWareHouse.get('Groovy').size())
        def groovy = softWareHouse.get('Groovy')
        def java = softWareHouse.get('Java')
        groovy.retainAll(java)
        println(softWareHouse.get('Groovy'))
    }

    @Test
    void test9() {
        println(chengfang(4))
    }

    private def chengfang(value, time = 2) {
        def result = value
        for (i in 1..<time) {
            result *= result
        }
        return result   // 返回值
    }

}
