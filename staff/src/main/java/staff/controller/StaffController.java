package staff.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import staff.entity.Staff;
import staff.service.StaffService;

@RestController
@RequestMapping(value = "/staff")
public class StaffController {
    @Autowired
    private StaffService staffService;

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @PostMapping(value = "/register/{id}/{name}/{department}")
    public Staff addStaff(@PathVariable String id, @PathVariable String name, @PathVariable String department) {
        Staff staff = new Staff();
        staff.setId(id);
        staff.setName(name);
        staff.setDepartment(department);
        staffService.saveStaff(staff);
        kafkaTemplate.send("StaffUser", id);
        kafkaTemplate.send("StaffTask", id);
        return staff;
    }
}
