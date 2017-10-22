package test1.re

import java.util.regex.Matcher
import java.util.regex.Pattern

/**
 * Created by zhaoyu on 2017/5/7.
 */
String re = "(\\+86)?\\d{11}"               // 正则
String origin = '+8613146429670'            // 字符串
Pattern pattern = Pattern.compile(re)       // 封装成 Pattern
final def matcher = pattern.matcher(origin) // 匹配引擎
println(matcher.matches())


println('----------> 普通文本字符： 匹配普通文本字符（精确）')
println('better'.matches('better'))         // true
println('better'.matches('zhaoyubetter'))   // false

println('----------> 句点符号：        匹配任意单个字符（.）')
def match = 'ios' =~ 'i.s'  // 将操作符左边的字符串跟右边的Pattern进行局部匹配，返回为Mather
println(match.matches())
println( ('ios' =~ 'i.s').matches())
println( ('i\ts' =~ 'i.s').matches())

println('----------> 范围符号：        范围内匹配单个字符（[]）')
pattern = ~'i[o|O]s'
println( pattern.matcher('ios').matches() )
println( pattern.matcher('iOs').matches() )

println('----------> 或符号：        范围内匹配字符（|）')
pattern = ~'i(o|O|oo)s'
println( pattern.matcher('ioos').matches() )