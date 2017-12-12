package book.mop

import org.junit.Test

/**
 * Created by zhaoyu on 2017/12/11.
 */
class MopTest {
    @Test
    void testInterceptedMethodCAllOnPoJO() {
        def val = new Integer(3)
        val.metaClass.toString = { -> "intercepted" }
        assert "intercepted" == (val.toString())     // 被拦截
    }

    @Test
    void testInterceptableCalled() {
        def obj = new AnInterceptable()
        assert "intercepted" == obj.existingMethod()        // 存在的方法，拦截，执行invokeMethod()
        assert "intercepted" == obj.nonexistingMethod()     // 不存在的方法，拦截,执行invokeMethod()
    }

    class AnInterceptable implements GroovyInterceptable {
        def existingMethod() { "Hello" }      // 返回Hello无效，返回还是 "intercepted"
        def invokeMethod(String name, Object args) { "intercepted" }
    }

    @Test
    void testInterceptedExistingMethodCalled() {
        AGroovyObject.metaClass.existingMethod2 = { -> 'intercepted' }
        def obj = new AGroovyObject()
        assert 'intercepted' == obj.existingMethod2()   // 方法拦截
        assert 'existingMethod' == obj.existingMethod() // 此方法未拦截
    }

    // 属性闭包调用
    @Test
    void testPropertyThatIsClosureCalled() {
        def obj = new AGroovyObject()
        assert 'closure called' == obj.closueProp()
    }


    class AGroovyObject {
        def existingMethod() { "existingMethod" }

        def existingMethod2() { "existingMethod2" }
        def closueProp = { "closure called" }
    }

    @Test
    void testInvokedMethodCalled() {
        def obj = new ClassWithInvokeOnly()
        assert "existingMethod" == obj.existingMethod()
        assert 'invoke called' == obj.nonExisintMethod()  // 报错
    }


    class ClassWithInvokeOnly {
        def existingMethod() { "existingMethod" }
        def invokeMethod(String name, Object args) { "invoke called" }
    }


}
