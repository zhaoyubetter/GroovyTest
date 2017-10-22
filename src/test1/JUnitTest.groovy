package test1

import org.junit.Test
import test1.com.better.People

/**
 * 单元测试
 * Created by zhaoyu on 2016/11/20.
 */
class JUnitTest {
    @Test
    void test() {
        def song = new Person(name: "song")
        println(song);
        ArrayList
    }

    @Test
    // range
    void testRange() {
        def range = 1..5
        println range.from
        println range.to

        range = 1..<5
        println range.from
        println range.to
    }

    @Test
    // 闭包
    void testClosure() {

        def closure1 = {
                // closure1 是闭包类型数据变量
            String param1, String param2 ->   // -> 表示闭包定义的参数，箭头后面是代码
                println param1 + " " + param2     // 闭包代码
                return param1                     // 最后一样是返回值，也可以不用return
        }

        // 闭包的调用方式1（类似java方法调用）
        println closure1('hello', 'world')
        // 闭包调用方式2，使用专用的call方法
        println closure1.call('hello', 'world')

//        // 如果闭包没定义参数的话，则隐含有一个参数，这个参数名字叫 it，和 this 的作用类似。it 代表闭包的参数。
//        def closure = { "Hello $it!" }                      // it 表示参数
//        def closure2 = { it -> "Hello $it" }
//        println closure("Better")
//
//        // 或者
//        println closure.call("Better")
//        println closure2.call("Chelsea")
//
//        // 没有参数的闭包
//        def closure3 = { -> "Good Luck" }
//        println closure3()  // println closure3("Jell") 报错
    }

    @Test
    // 闭包
    void testClosure2() {
        def list = [1, 2, 3, 4, 5]
        list.each({
            println it                                      // it 表示集合中的每一项
        })

        // Groovy 中，当函数的最后一个参数是闭包的话，可以省略圆括号
        list.each {
            println it
        }

        println('------------------------------------')
        closure(29, "better", {
            println "welcome"       // 最后一个参数，省略了圆括号
        })
    }

    def closure(int i, String s, Closure closure) {
        print i
        print s
        closure()  // or closure.call()
    }

    @Test
    void testClosure3() {
        def list = [1, 2, 3, 4, 5]
        list.each {
            if (it % 2 == 0) {
                println(it)     // 2 4
            }
        }

        def map = [k1: 'better', k2: 'zhaoyu']
        map.each {
                // 这里的闭包有2个参数， 查看api
            k, v -> println "key:$k, value:$v"
        }

        list.find() {}
        list.any() {}
        list.every {}
        println([1, 2, 3, 4].collect { it -> return it * 2 })   // 变更
    }

    @Test
    // 测试 groovy类
    void testGroovyClass() {
        def p = new People("better", "29")
        p.print()
    }

    @Test
    void testFunc() {
        println(groovyFunc(1, 2))        // 输出 1 2
    }

    def groovyFunc(arg1, arg2) {
        println arg1
        println arg2

        def multieLines = ''' 臭
            line  1
            line  2
            end '''
        println multieLines

        arg1 + " " + arg2
    }

    @Test
    void testField() {
        def greeting = 'Hello'
        def cols = {param -> println("${greeting} ${param}")}
        cols.call('world')
    }

}
