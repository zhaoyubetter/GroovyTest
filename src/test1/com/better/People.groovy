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

    void test() {
        List<Integer> ints = new ArrayList<>();
        List<? extends Number> numbers = ints;
        int a = 20
        numbers.add(a)
        numbers.add(a)
    }
}
