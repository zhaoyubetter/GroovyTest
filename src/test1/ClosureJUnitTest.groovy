package test1

import org.junit.Test
import test1.com.better.People

/**
 * 单元测试
 * Created by zhaoyu on 2016/11/20.
 */
class ClosureJUnitTest {
    @Test
    void test() {
        def doubles = { item -> item * 2 }
        def triples = { item -> item * 3 }
        def isEven = { item -> item % 2 == 0 }

        println("Doubles: ${map(doubles, [1, 2, 3, 4])}")
        println("Triples: ${map(triples, [1, 2, 3, 4])}")
        println("Evens: ${map(isEven, [1, 2, 3, 4])}")
    }

    /**
     * map 转换方法
     * @param clos 闭包
     * @param list 集合
     */
    def map(clos, list) {
        return list.collect(clos)
    }

    @Test
    void test2() {
        [1, 2, 3, 4].inject()
        // 累加
        def clos = (0..100).inject(0) { prev, element -> prev + element }
        println("Sum : ${clos}")
    }

    @Test
    void test3() {
        def isEven = { item -> item % 2 == 0 }
        def isOdd = { item -> !isEven(item) }
        println(filter([1, 2, 3, 4], isEven))
    }

    /**
     * 闭包作为方法的参数
     * @param list
     * @param clos
     */
    def filter(list, clos) {
        return list.findAll(clos)
    }

    @Test
    void test4() {
        // 闭包1
        def isEven = { item -> item % 2 == 0 }
        // 闭包2，使用闭包1作为参数
        def takeWhile = { closure, list ->
            def result = []
            for (item in list) {
                if (closure(item)) {
                    result << item
                }
            }
            return result
        }

        println(takeWhile(isEven, [1, 2, 3, 4]))
    }

    @Test
    void test5() {
        def twice = multiply(2)
        println("twice(4): ${twice(4)}")

        // == 闭包返回闭包 ==
        def multiplication = { x -> return { y -> x * y } }
        def quadruple = multiplication(4)
        println("quadruple(3): ${quadruple(3)}")

    }
// 方法返回闭包
    def multiply(x) {
        return { y -> return x * y }
    }

// 闭包嵌套闭包
    @Test
    void test6() {
        // 选择排序闭包
        def selectionSoft = { list ->
            def swap = { sList, p, q ->
                def temp = sList[p]
                sList[p] = sList[q]
                sList[q] = temp
            }

            // 找最小的闭包
            def minimumPosition = { pList, from ->
                def mPos = from
                def nextFrom = 1 + from
                for (j in nextFrom..<pList.size()) {
                    if (pList[j] < pList[mPos]) {
                        mPos = j
                    }
                }
                return mPos
            }

            def size = list.size() - 1
            for (k in 0..<size) {
                def minPos = minimumPosition(list, k)
                swap(list, minPos, k)       // 交换
            }

            return list
        }

        def table = [-11, 2, -20, 15, 0]
        def sorted = selectionSoft(table)
        println(sorted)
    }

    //================================================

    @Test
    void test7() {
        // 交集
        def intersect = { list1, list2 ->
            list1.retainAll(list2)      // 交集
            return list1
        }
        println(intersect([1, 2, 3], [1, 2]))

        // union
        def union = { list1, list2 ->
            list1.addAll(list2)     // addAll 并集
            return list1
        }
        println(union([1, 2], [2, 3, 4]))

        [].removeAll()
        println("========================================================")
        def substact = { list1, list2 ->
            list1.removeAll(list2)      // removeAll 差集
            return list1
        }
        println(substact([1, 2, 3], [1, 2]))
    }

    @Test
    void test8() {
        def staff = ['Ken'   : ['John', 'Peter'], 'Jon': ['Ken', 'Jessie'],
                     'Jessie': ['Jim', 'Tom']]
        println(findManagerOf('Jessie', staff))
        println(findNoManager(staff))
    }

    // 根据value找 key
    def findManagerOf(name, map) {
        return map.find() { entry ->
            entry.value.find() {
                it.equals(name)
            }
        }?.key
    }

    def findNoManager(map) {
        def list1 = map.keySet()
        def list2 = map.values().flatten()
        list1.removeAll(list2)
        return list1
    }

    @Test
    void test9() {
        def lSub = { x -> return { y -> return x - y } }
        def rSub = { y -> return { x -> return x - y } }

        def p = lSub(100)
        def q = rSub(1)
        println(p(25))
        println(q(9))
    }

    @Test
    void test10() {
        def soft = ['Groovy': ['One', 'Two', 'Jon'],
                    'Java'  : ['One', 'Two'],
                    'C#'    : ['Four']
        ]

        soft.each { key, value -> if (value.size() >= 2) println(value) }

        soft['Groovy'].each() { g ->
            soft['Java'].each() { j ->
                if(j == g) {
                    println(g)
                }
            }
        }
    }
}