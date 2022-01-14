package user.service;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user.entity.Result;
import user.entity.User;
import user.util.UserJpaRepository;

import javax.transaction.Transactional;
import java.util.Random;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserJpaRepository userJpaRepository;

    @Override
    public void saveUser(String id) {
        User user = new User();
        user.setId(id);
        String password = String.valueOf((new Random()).nextLong());
        user.setPassword(password);
        System.out.println(password);
        userJpaRepository.save(user);
    }

    @Override
    public Result login(String id, String password) {
        Result result = new Result();
        User user = userJpaRepository.getOne(id);
        if (user.getPassword().equals(password)) {
            result.setMessage("login succedd");
        } else {
            result.setMessage("wrong password or username");
        }
        return result;
    }

    @Override
    public Result changePassword(String id, String password) {
        Result result = new Result();
        User user = userJpaRepository.getOne(id);
        user.setPassword(password);
        userJpaRepository.save(user);
        result.setMessage("password changed");
        return result;
    }
}
