package study.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author liusk
 */
public class Main {
    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        IUserService userService = new UserService();
        ClassLoader classLoader = userService.getClass().getClassLoader();
        Class<?>[] interfaces = userService.getClass().getInterfaces();

        InvocationHandler invocationHandler = new MyInvocationHandler(userService);

        IUserService userServiceImpl = (IUserService) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
        userServiceImpl.test("lsk");
    }
}