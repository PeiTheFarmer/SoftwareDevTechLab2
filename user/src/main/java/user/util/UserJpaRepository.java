package user.util;

import org.springframework.data.jpa.repository.JpaRepository;
import user.entity.User;

public interface UserJpaRepository extends JpaRepository<User, String> {
}
