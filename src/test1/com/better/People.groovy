package test1.com.better

/**
 * Created by zhaoyu on 2016/12/14.
 */
class People {
    String name
    String age

    People(String name, String age) {
        this.name = name
        this.age = age
    }

    def print() {
        print name + " " + age
    }
}
