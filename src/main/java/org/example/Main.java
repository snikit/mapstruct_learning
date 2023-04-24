package org.example;


import org.example.mapper.EmployeeMapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

public class Main {



    public static void main(String[] args) {

        EmployeeMapper mapper = Mappers.getMapper(EmployeeMapper.class);

        Project one = new Project();
        one.setId(1);
        one.setName("one");

        Project two = new Project();
        two.setId(2);
        two.setName("two");


        Employee e = new Employee();
        e.setDepartment("department");
        e.setId(1);
        e.setName("name");
        e.setSalary(2.0);
        e.setProjects(List.of(one,two));

        EmployeeDTO dto = mapper.asDTO(e);

        System.out.println(dto);

        Employee ee = mapper.asEntity(dto);

        System.out.println(ee);

    }
}