package org.example;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProjectRepository  {

    Project save(Project project);

    Optional<Project> findById(Long id);
}
