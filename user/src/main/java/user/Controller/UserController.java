package user.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import user.entity.Result;
import user.service.UserService;

@RestController
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @PostMapping(value = "/add/{id}")
    public void addUser(@PathVariable String id) {
        userService.saveUser(id);
    }

    @PostMapping(value = "/update/{id}/{password}")
    public Result updateUser(@PathVariable String id, @PathVariable String password) {
        Result result = userService.changePassword(id, password);
        kafkaTemplate.send("UserTask", id);
        return result;
    }

    @PostMapping(value = "/login/{id}/{password}")
    public Result login(@PathVariable String id, @PathVariable String password) {
        return userService.login(id, password);
    }
}
