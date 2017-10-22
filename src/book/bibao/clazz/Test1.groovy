package book.bibao.clazz

import org.junit.Test

/**
 * Created by zhaoyu on 2017/10/18.
 */

// groovy 类
class Account {
    def number
    def balance

    Account() {

    }

    // 构造方法
    Account(number, balance) {
        this.number = number
        this.balance = balance
    }

    @Override
    String toString() {
        return "Account: ${number} with balance: ${balance}"
    }
}

class Test1 {
    @Test
    void test1() {
        // 创建类对象
        def acc = new Account(number: '1234', balance: 22.5)
        println(acc)
        println(acc.getBalance())       // 隐士调用 getter setter

        // 使用构造方法，来创建对象
        def acc2 = new Account("better", 1200000)
        println(acc2)
    }
}
