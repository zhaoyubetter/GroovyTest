package template

import groovy.text.SimpleTemplateEngine
import org.junit.Test

/**
 * Created by zhaoyu on 2017/10/22.
 */
class Test1 {
    @Test
    void test() {
        def file = new File('src/template/book.template')

        def binding = ['author'   : 'Jim',
                       'title'    : 'Groovy',
                       'publisher': '人民邮电出版社',
                       'isbn'     : '123456']

        // 创建引擎
        def engine = new SimpleTemplateEngine()
        def template = engine.createTemplate(file)
        def writable = template.make(binding)
        println(writable)
    }

    // 保存到文件
    @Test
    void test2() {
        def file = new File('src/template/book.template')
        def binding = ['author'   : 'Jim',
                       'title'    : 'Groovy',
                       'publisher': '人民邮电出版社',
                       'isbn'     : '123456']
        def writable = new SimpleTemplateEngine().createTemplate(file)
                .make(binding)
        def destination = new FileWriter('src/template/book.xml')
        writable.writeTo(destination)
        destination.flush()
        destination.close()
    }
}
