package xml

import groovy.xml.MarkupBuilder
import org.junit.Test
import sun.jvm.hotspot.debugger.cdbg.TemplateType

/**
 * Created by zhaoyu on 2017/10/18.
 */
class Test1 {
    @Test
    void test1() {
        // MarkupBuilder 来创建xml文档

//        def mb = new MarkupBuilder()    // 输出到标准输出流

        def mb = new MarkupBuilder(new File('book.xml').newPrintWriter())
        mb.book() {     // 伪方法 book() 创建book元素
            author('Lao Zhang')
            title('Groovy')
            publisher('中国邮电出版社')
            isbn("123456")
        }
    }

    @Test
    void test2() {
        def data = ['11111111': ['Groovy', 'Lao Zhang', '人民邮电出版社'],
                    '22222222': ['Java In Mode', 'Zhang', '日报出版社'],
                    '33333333': ['Kotlin in Action', 'Jim', '对外出版社']]

        def mb = new MarkupBuilder(new File("book.xml").newPrintWriter())
        mb.library() {  // 伪方法创建library元素
            data.each { bk ->
                mb.book() {  // 创建book元素
                    title(bk.value[0])
                    author(bk.value[1])
                    publisher(bk.value[2])
                    isbn(number: bk.key)    // number属性
                }
            }
        }
    }

    // 解析xml
    @Test
    void test3() {
        def parser = new XmlParser()
        def doc = parser.parse("book.xml")
        // doc.book 传递了一个节点列表
        println("${doc.book[0].title[0].text()}")

        // 迭代xml内容
        doc.book.each() { bk ->
            println("${bk.title[0].text()}")
        }

        println("========")
        // 简化
        doc.book.title.each() { title ->
            println(title.text())
        }
    }

    @Test
    void test4() {
        // 通过['@number'] 获取属性 isbn值
        def parser = new XmlParser()
        def doc = parser.parse("book.xml")
        doc.book.isbn.each() { it ->
            println(it['@number'])
        }
    }

    @Test
    void test5() {
        // 分组,根据国家分组，转换xml结构
        def parser = new XmlParser()
        def doc = parser.parse(new File('catalogs.xml'))

        def countryMap = [:]
        doc.cd.each() { cd ->
            if (countryMap.containsKey(cd.country[0].text())) {
                def yearMap = countryMap.get(cd.country[0].text())
                def year = cd.year[0].text()
                if (yearMap.containsKey(year)) {
                    yearMap[year] << cd.title[0].text()
                } else {
                    yearMap[year] = [cd.title[0].text()]  // 此为list
                }
                countryMap[cd.country[0].text()] << yearMap
            } else {
                // 因为是 map
                countryMap[cd.country[0].text()] = [(cd.year[0].text()): [cd.title[0].text()]]
            }
        }

        println(countryMap)

// 创建的新的xml
        def mb = new MarkupBuilder(new File('group.xml').newPrintWriter())
        mb.grouping() {     // 节点 grouping
            countryMap.each { country, yearMap ->
                mb.country(name: country) { // 节点 country
                    yearMap.each { year, titleList ->
                        mb.year(year: year) {
                            titleList.each {
                                title(it)
                            }
                        }
                    }
                }
            }
        }
    }

}
