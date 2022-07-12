package study.example;

public class UserService implements IUserService {
    @Override
    public void test(String name) {
        System.out.println("name:" + name);
    }
}
