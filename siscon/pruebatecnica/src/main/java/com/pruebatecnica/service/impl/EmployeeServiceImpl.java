package com.pruebatecnica.service.impl;

import com.pruebatecnica.dtos.EmployeeDTO;
import com.pruebatecnica.entities.EmployeeEntity;
import com.pruebatecnica.repositories.EmployeeRepository;
import com.pruebatecnica.service.IEmployeesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements IEmployeesService {

    private final EmployeeRepository employeeRepository;


    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeEntity> employees = this.employeeRepository.findAll();
        if (employees.isEmpty()) {
            return new ArrayList<>();
        } else {
            return employees.stream().map(emp -> {
                EmployeeDTO empDTO = new EmployeeDTO();
                empDTO.setId(emp.getEmployeeId());
                empDTO.setName(emp.getGivenName());
                empDTO.setSecondName(emp.getMiddleName());
                empDTO.setSurname(emp.getSurname());
                empDTO.setPosition(emp.getPosition());
                empDTO.setBirthDay(emp.getBirthDay().toString());
                empDTO.setAge(emp.getAge());
                return empDTO;
            }).sorted(Comparator.comparing(EmployeeDTO::getId)).toList();
        }
    }

    @Override
    public ResponseEntity deleteEmployee(Integer employeeId) {
        EmployeeEntity employeeEntity = this.employeeRepository.findById(employeeId).orElse(null);
        if (employeeEntity != null) {
            this.employeeRepository.delete(employeeEntity);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Override
    public ResponseEntity updateEmployee(EmployeeDTO employee) {
        EmployeeEntity employeeEntity = this.employeeRepository.findById(employee.getId()).orElse(null);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date2 = LocalDate.parse(employee.getBirthDay(), formatter);
        EmployeeEntity emp = new EmployeeEntity();
        if (employeeEntity != null) {
            emp.setEmployeeId(employee.getId());
            emp.setGivenName(employee.getName());
            emp.setMiddleName(employee.getSecondName());
            emp.setSurname(employee.getSurname());
            emp.setAge(employee.getAge());
            emp.setBirthDay(date2);
            emp.setPosition(employee.getPosition());
        }
        this.employeeRepository.save(emp);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Override
    public ResponseEntity saveEmployees(List<EmployeeDTO> employees) {
        List<EmployeeEntity> save = employees.stream().map(e -> {
            EmployeeEntity empl = new EmployeeEntity();
            empl.setGivenName(e.getName());
            empl.setMiddleName(e.getSecondName());
            empl.setSurname(e.getSurname());
            empl.setAge(e.getAge());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate date2 = LocalDate.parse(e.getBirthDay(), formatter);
            empl.setBirthDay(date2);
            empl.setPosition(e.getPosition());
            return empl;
        }).toList();
        this.employeeRepository.saveAllAndFlush(save);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
