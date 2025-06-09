package com.pruebatecnica.service;

import com.pruebatecnica.dtos.EmployeeDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IEmployeesService {

    /**
     * This methods return a List of all employees
     * @return list of employeeDTO
     */
    List<EmployeeDTO> getAllEmployees();


    /**
     * This methods delete the employee with id
     * @param employeeId id of employee to be deleted
     * @return 204 not content
     */
    ResponseEntity deleteEmployee(Integer employeeId);


    /**
     * This methods return a List of all employees
     * @param employee employee to be updated
     * @return list of employeeDTO
     */
    ResponseEntity updateEmployee(EmployeeDTO employee);

    /**
     * This methods save one or more employees
     * @param employees employee to be save
     * @return no content 201
     */
    ResponseEntity saveEmployees(List<EmployeeDTO> employees);
}
