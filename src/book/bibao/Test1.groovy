package book.bibao

/**
 * Created by zhaoyu on 2017/10/15.
 */
class Test1 {
    static void main(args) {
        def clos = { name -> println("${name} for better life!") }
        clos.call('YY')
        clos('CC')

        // 单个隐参数
        def cols2 = { println("${it} for better life!") }
        cols2('YY')

        println('============================')
        def my_clos = { param1 -> println("Welcome ${param1}") }
        method() {
            param1 -> println("Welcome ${param1}")
        }

        println("===== 使用闭包求 1 到 100 的和 ===========")
        def result = 0
        1.upto(100) { result = result + it }
        println(result)
    }


    static def method(clos) {
        def name = 'better'
        clos(name)
    }

}
