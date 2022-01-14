package staff.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import staff.entity.Staff;
import staff.util.StaffJpaRepository;

import javax.transaction.Transactional;

@Service
@Transactional
public class StaffServiceImpl implements StaffService{
    @Autowired
    private StaffJpaRepository staffJpaRepository;

    @Override
    public void saveStaff(Staff staff) {
        staffJpaRepository.save(staff);
    }
}
