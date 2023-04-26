package org.example.mapper;

import org.example.Employee;
import org.example.EmployeeDTO;
import org.example.Project;
import org.mapstruct.*;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
, uses = {ProjectMapper.class})
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



   @InheritInverseConfiguration
    public void updateFromNonNullAttrsOfDto(EmployeeDTO source,@MappingTarget Employee target);


}