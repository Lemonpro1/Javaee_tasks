import IOCContainer.MiniApplicationContext;
import IOCContainer.UserService;

public class MiniApplicationContextTest {
    public static void main(String[] args) {
        MiniApplicationContext context = new MiniApplicationContext("beans.xml");

        // 测试
        UserService userService = (UserService) context.getBean("userService");
        userService.sayHello();
    }
}
