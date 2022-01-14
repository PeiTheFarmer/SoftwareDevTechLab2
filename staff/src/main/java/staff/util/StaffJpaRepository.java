package staff.util;

import org.springframework.data.jpa.repository.JpaRepository;
import staff.entity.Staff;

public interface StaffJpaRepository extends JpaRepository<Staff, Long> {
}
