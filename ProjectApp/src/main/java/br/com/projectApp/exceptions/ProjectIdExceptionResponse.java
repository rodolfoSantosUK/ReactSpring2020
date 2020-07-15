package br.com.projectApp.exceptions;

import org.springframework.web.bind.annotation.RestController;

public class ProjectIdExceptionResponse {

     private String projectIdentifier;

    public ProjectIdExceptionResponse(String projectIdentifier) {
        this.projectIdentifier = projectIdentifier;
    }

    public String getProjectIdentifier() {
         return projectIdentifier;
     }

     public void  setProjectIdentifier( String projectIdentifier ) {
         this.projectIdentifier = projectIdentifier;
     }


}
