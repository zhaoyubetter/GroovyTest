package book.dsl

/**
 * Created by zhaoyu on 2017/12/12.
 */
class Test {
    @org.junit.Test
    void test() {
        use(DateUtils) {
            println(2.days.ago.at(22: 52))
        }
    }

    // 分类
    // 通过 use
    class DateUtils {
        static Integer getDays(Integer self) {
            self
        }

        static Calendar getAgo(self) {
            def date = Calendar.instance
            date.add(Calendar.DAY_OF_MONTH, -self)
            date
        }

        static Date at(Calendar self, Map<Integer, Integer> time) {
            def hour = 0
            def minute = 0
            time.each { key, value ->
                hour = Integer.valueOf(key)
                minute = Integer.valueOf(value)
            }
            self.set(Calendar.HOUR_OF_DAY, hour)
            self.set(Calendar.MINUTE, minute)
            self.set(Calendar.SECOND, 0)
            self.time
        }
    }

}