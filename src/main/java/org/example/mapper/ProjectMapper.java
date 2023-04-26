package org.example.mapper;

import org.example.Project;
import org.mapstruct.Mapper;

@Mapper
public interface ProjectMapper {

    default Project mapProjectId(int id) {
        Project project = new Project();
        project.setId(id);
        return project;
    }

    default int mapProject(Project project) {
        return project.getId();
    }
}
