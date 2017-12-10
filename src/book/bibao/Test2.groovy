package book.bibao

import org.junit.Test

/**
 * Created by zhaoyu on 2017/11/23.
 */
class Test2 {

    @Test
    void test1() {
        method() {
            println("Hello")
        }
    }

    def method(closure) {
        if (closure) {   // 判断闭包是否提供了
            closure()
        } else {
            println("use default closure")
        }
    }

    //======================s
    // 闭包的委托 this,owner,delegate

    def examingClosure(closure) {
        closure()
    }

    @Test
    void test2() {
        examingClosure() {
            println("First Closure: ")
            println("class is ${getClass().name}")
            println("this is ${this}, super: ${this.getClass().superclass.name}")
            println("owner is ${owner}, super:${owner.getClass().superclass.name}")
            println("delegate is ${delegate}, super: ${delegate.getClass().superclass.name}")
        }
    }

    // ========== s改变闭包委托
    class Handler {
        def f1() { println("f1 of Handler called...") }

        def f2() { println("f2 of Handler called...") }
    }

    class Example {
        def f1() { println("f1 of Example called...") }

        def f2() { println("f2 of Example called...") }

        def foo(closure) {
            closure.delegate = new Handler()        // 设置代理
            closure()
        }
    }

    def f1() {
        println("f1 of Script called...")
    }

    @Test
    void test3() {
        new Example().foo() {
            f1()
            f2()
        }
    }

    // ======== 尾递归 ===
    @Test
    void test4() {
//        println(factorial(5, 1))
        println(factorial(1000))
    }

    // theFactorial 表示通过此递归计算的部分结果
    // 如果 number 为1，则返回 theFactorial的值作为结果，否则调用 trampoline方法


    def factorial(int n) {
        def inner_factorial
        inner_factorial = { int number, BigInteger theFactorial = 1 ->
            number == 1 ? theFactorial :
                    inner_factorial.trampoline(number - 1, number * theFactorial)
        }.trampoline()
        inner_factorial(n)
    }

    @Test
    void test5() {

    }
}
