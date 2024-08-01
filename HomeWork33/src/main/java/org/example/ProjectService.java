package org.example;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public Project save(Project project) {
        return projectRepository.save(project);
    }

    public Optional<Project> findById(Long id) {
        return projectRepository.findById(id);
    }
}
