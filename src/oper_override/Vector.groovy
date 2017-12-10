package oper_override

/**
 * 操作符重载
 * Created by zhaoyu on 2017/11/1.
 */
class Vector {

    private def values = []

    Vector(v) {
        this.values = v
    }

    def plus(vec) {
        def res = []
        def size = this.values.size()
        def vecSize = vec.values.size()

        if (size == vecSize) {
            for (index in 0..<size) {
                res << (values[index] + vec.values[index])
            }
        }

        return res
    }

    static void main(args) {
        def vec1 = new Vector([1, 2, 3, 4])
        def vec2 = new Vector([10, 11, 12, 13])
        println("vec1 + vec2 = ${vec1 + vec2}")
    }
}
