package book.bibao

import org.junit.Test

/**
 * 卖杆问题
 * Created by zhaoyu on 2017/12/4.
 */
class Test3_Sell_Pole {

    def timeAt(length, closure) {
        long start = System.nanoTime()
        println("Max revenue for $length is ${closure(length)}")
        long end = System.nanoTime()
        println("Time taken ${(end - start) / 1.0e9} seconds")
    }

    // 每段价格，不同长度的杆价格不同
    def rodPrices = [0, 1, 3, 4, 5, 8, 9, 11, 12, 14,
                     15, 15, 16, 18, 19, 15, 20, 21, 22, 24,
                     25, 24, 26, 28, 29, 35, 37, 38, 39, 40]



    @Test
    void test1() {

    }
}
