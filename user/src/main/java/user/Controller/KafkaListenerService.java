package user.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import user.service.UserService;

@Service
public class KafkaListenerService {
    @Autowired
    UserService userService;

    @KafkaListener(topics = {"StaffUser"})
    public void listener(String id) {
        userService.saveUser(id);
    }
}
