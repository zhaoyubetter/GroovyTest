package test1.com.better;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by zhaoyu on 2017/11/29.
 */
public class Test {
    public static void main(String... addd) {
        List<Integer> ints = new ArrayList<>();
        List<? extends Number> numbers = ints;
        int a = 20;
        ints.add(1);
//        numbers.add((Number) a);
//        numbers.add((Object) a);


        List<? extends Number> f = new ArrayList<Number>();  // Number "extends" Number (in this context)
        List<? extends Number> ff = new ArrayList<Integer>(); // Integer extends Number
        List<? extends Number> fff = new ArrayList<Double>();

        List<? super Integer> cc = new ArrayList<Integer>();  // Integer is a "superclass" of Integer (in this context)
        List<? super Integer> ccc = new ArrayList<Number>();   // Number is a superclass of Integer
        List<? super Integer> cccc = new ArrayList<Object>();
        ccc.add(22);

//        printlnCollection(ints);

        int add1 = add(11,22);
        Number add2 = add(11, 22.22);
        Object add3 = add(11, "abc");

    }


    public static <T> T add(T t1, T t2) {
        return t2;
    }


    public static void printlnCollection(Collection<Object> col) {
        for (Object o : col) {
            System.out.println(o);
        }
    }

    class Base {

    }

    class Base2 extends Base {

    }

    class Base3 extends Base2 {

    }


    private List<Base3> lists = new ArrayList<>(10);


    public void copyTo(List<? super Base2> dest) {
        for (int i = 0; i < 10; i++) {
            dest.add(lists.get(i));
        }
    }
}
