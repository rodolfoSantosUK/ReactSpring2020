package br.com.projectApp.services;

import br.com.projectApp.domain.Project;
import br.com.projectApp.exceptions.ProjectIdException;
import br.com.projectApp.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject( Project project ) {
        try {
            return projectRepository.save(project);
        } catch (Exception e) {
            throw new ProjectIdException(" Project ID '" + project.getProjectIdentifier().toUpperCase() + "' already exist");
        }

    }

}
