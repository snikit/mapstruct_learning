package org.example.mapper;

import org.example.Employee;
import org.example.EmployeeDTO;
import org.example.Project;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface EmployeeMapper extends GenericMapper<Employee, EmployeeDTO> {
    @Override
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "department", source = "dept"),
            @Mapping(target = "projects", source = "projectIds")
    })
    Employee asEntity(EmployeeDTO dto);

    @Override
    @Mappings({
            @Mapping(target = "dept", source = "department"),
            @Mapping(target = "projectIds", source = "projects")
    })
    EmployeeDTO asDTO(Employee e);

    default Project mapProjectId(int id) {
        Project project = new Project();
        project.setId(id);
        return project;
    }

    default int mapProject(Project project) {
        return project.getId();
    }
}