package test1.com.io

/**
 * Created by zhaoyu on 2016/12/14.
 */
// 读取文件
def file = new File("../../../readme.txt")
file.eachLine {
    String line -> println line
}


