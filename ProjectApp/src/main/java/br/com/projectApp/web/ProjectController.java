package br.com.projectApp.web;


import br.com.projectApp.domain.Project;
import br.com.projectApp.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping("")
    public ResponseEntity<?> createNewProject(@RequestBody @Valid Project project, BindingResult bindingResult) {
       System.out.println("Chamou createNewProject");
        System.out.println(bindingResult.hasErrors());
        if(bindingResult.hasErrors()) {

            Map<String, String> errorMap = new HashMap<>();

            for(FieldError error : bindingResult.getFieldErrors() ) {
                errorMap.put(error.getField(), error.getDefaultMessage());
            }

           return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST )  ;
       }

        Project project1 = projectService.saveOrUpdateProject(project);
        return new ResponseEntity<Project>(project1, HttpStatus.CREATED);
    }

}
