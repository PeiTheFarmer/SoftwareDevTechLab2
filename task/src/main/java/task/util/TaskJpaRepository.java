package task.util;

import org.springframework.data.jpa.repository.JpaRepository;
import task.entity.Task;

public interface TaskJpaRepository extends JpaRepository<Task, String> {
}
