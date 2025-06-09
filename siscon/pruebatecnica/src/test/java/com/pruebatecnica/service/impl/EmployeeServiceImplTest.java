package com.pruebatecnica.service.impl;

import com.pruebatecnica.dtos.EmployeeDTO;
import com.pruebatecnica.entities.EmployeeEntity;
import com.pruebatecnica.repositories.EmployeeRepository;
import com.pruebatecnica.service.IEmployeesService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@SpringBootTest
class EmployeeServiceImplTest {
    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeServiceImpl;


    @Test
    void getAllEmployees() {
        when(this.employeeRepository.findAll()).thenReturn(createEmployeEntity());
        List<EmployeeDTO> employeeDTOS = this.employeeServiceImpl.getAllEmployees();
        assertNotNull(employeeDTOS);
    }

    @Test
    void deleteEmployee() {
        EmployeeEntity employeeEntity = new EmployeeEntity(1,"Angel", "Juan", "Martinez Garcia", 31, "M", LocalDate.now(),"Desarrollador");
        when(this.employeeRepository.findById(anyInt())).thenReturn(Optional.of(employeeEntity));
        this.employeeServiceImpl.deleteEmployee(employeeEntity.getEmployeeId());
    }

    @Test
    void updateEmployee() {
        EmployeeEntity employeeEntity = new EmployeeEntity(1,"Angel", "Juan", "Martinez Garcia", 31, "M", LocalDate.now(),"Desarrollador");
        EmployeeDTO employeeDTO = new EmployeeDTO(1,"Angel", "Juan", "Martinez Garcia","Desarrollador","30/10/1993",33);
        when(this.employeeRepository.findById(anyInt())).thenReturn(Optional.of(employeeEntity));
        this.employeeServiceImpl.updateEmployee(employeeDTO);
    }

    @Test
    void saveEmployees() {
        List<EmployeeDTO> employeeDTOS = createEmployeeDTOs();
        this.employeeServiceImpl.saveEmployees(employeeDTOS);
    }

    private List<EmployeeDTO> createEmployeeDTOs() {
        List<EmployeeDTO> employeeDTOs = new ArrayList<>();
        EmployeeDTO employeeDTO = new EmployeeDTO(1,"Angel", "Juan", "Martinez Garcia","Desarrollador","30/10/1993",33);
        EmployeeDTO employeeDTO2 = new EmployeeDTO(1,"Angel", "Juan", "Martinez Garcia","Desarrollador","30/10/1993",33);
        EmployeeDTO employeeDTO3 = new EmployeeDTO(1,"Angel", "Juan", "Martinez Garcia","Desarrollador","30/10/1993",33);
        EmployeeDTO employeeDTO4 = new EmployeeDTO(1,"Angel", "Juan", "Martinez Garcia","Desarrollador","30/10/1993",33);
        EmployeeDTO employeeDTO5 = new EmployeeDTO(1,"Angel", "Juan", "Martinez Garcia","Desarrollador","30/10/1993",33);

        employeeDTOs.add(employeeDTO);
        employeeDTOs.add(employeeDTO2);
        employeeDTOs.add(employeeDTO3);
        employeeDTOs.add(employeeDTO4);
        employeeDTOs.add(employeeDTO5);

        return employeeDTOs;
    }

    private List<EmployeeEntity> createEmployeEntity() {
        List<EmployeeEntity> employeeDTOs = new ArrayList<>();
        EmployeeEntity employeeDTO = new EmployeeEntity(1,"Angel", "Juan", "Martinez Garcia", 31, "M", LocalDate.now(),"Desarrollador");
        EmployeeEntity employeeDTO2 = new EmployeeEntity(2,"Angel", "Juan", "Martinez Garcia", 31, "M", LocalDate.now(),"Desarrollador");
        EmployeeEntity employeeDTO3 = new EmployeeEntity(3,"Angel", "Juan", "Martinez Garcia", 31, "M", LocalDate.now(),"Desarrollador");
        EmployeeEntity employeeDTO4 = new EmployeeEntity(4,"Angel", "Juan", "Martinez Garcia", 31, "M", LocalDate.now(),"Desarrollador");


        employeeDTOs.add(employeeDTO);
        employeeDTOs.add(employeeDTO2);
        employeeDTOs.add(employeeDTO3);
        employeeDTOs.add(employeeDTO4);

        return employeeDTOs;
    }

}