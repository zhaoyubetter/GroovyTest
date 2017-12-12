package book.dsl

/**
 * Created by zhaoyu on 2017/12/12.
 */
class Test2 {
    @org.junit.Test
    void test() {
        Integer.metaClass {
            getDays = { -> delegate }
            getAgo = { ->
                def date = Calendar.instance
                date.add(Calendar.DAY_OF_MONTH, -delegate)
                date
            }
        }

        Calendar.metaClass.at = { Map time ->
            def hour = 0
            def minute = 0
            time.each { key, value ->
                hour = Integer.valueOf(key)
                minute = Integer.valueOf(value)
            }
            delegate.set(Calendar.HOUR_OF_DAY, hour)
            delegate.set(Calendar.MINUTE, minute)
            delegate.set(Calendar.SECOND, 0)
            delegate.time
        }


        println(2.days.ago.at(23: 01))

    }
}
