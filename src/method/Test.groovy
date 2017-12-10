package method

/**
 * Created by zhaoyu on 2017/10/25.
 */
class Test {

    def times(x, y) {
        return x * y
    }

    @org.junit.Test
    void test1() {
        println("3 * 4 = ${times(3, 4)}")
        println("better * 4 = ${times('better', 4)}")
    }

    @org.junit.Test
    void test2() {
        println("better * 4 = ${time2('better', 4)}")
    }

    int times2(int x, int y) {
        return x * y
    }

}
