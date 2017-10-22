package test1.com.script

import groovy.transform.Field

/**
 * Created by zhaoyu on 2016/12/14.
 */

// groovy 脚本代码
@Field a = 1  // not def a = 1, @Field 将是 a 变成成员变量

def printa() {
    println a
}

printa()