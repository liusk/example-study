package study.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author liusk
 */
public class MyInvocationHandler implements InvocationHandler {

    private Object o;

    public MyInvocationHandler(Object o) {
        this.o = o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before()");
        Object invoke = method.invoke(o, args);
        System.out.println("after()");
        return invoke;
    }
}
