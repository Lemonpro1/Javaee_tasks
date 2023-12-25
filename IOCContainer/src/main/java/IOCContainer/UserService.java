package IOCContainer;

import org.springframework.beans.factory.annotation.Autowired;

// UserService.java
public class UserService {
    @Autowired
    private UserDao userDao;

    public void sayHello() {
        System.out.println("Hello from UserService");
        userDao.sayHello();
    }
}



