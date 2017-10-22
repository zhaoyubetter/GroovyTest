groovy学习资料：
https://my.oschina.net/baochanghong/blog/415579

0.groovy类，跟Java类类似，如果不声明 public/private 等访问权限的 话，Groovy 中类 其变量默认都是 public 的。


##1.groovy 脚本的概念##
 正常的Java类，需要写Class or Integer 或者其他，表示一个具体类，
 在Groovy中，可以直接编写代码，类似于脚本一样，这样的脚本代码，Groovy会将所有的脚本代码
 生成一个类，
 将脚本代码 copy到 run 函数方法中，如 def a = 1;
 如果定义了函数，则函数会定义在类中,如 def fun() {}
 并生成一个main函数，执行脚本时，实际上就是调用main函数的过程，run 中执行脚本代码；

 如果想要 脚本中定义的 变量，如 a = 1, 当做脚本中的 成员变量，需要加入 @Field注解，参考：TestScript.java

*脚本中的变量和作用域*

