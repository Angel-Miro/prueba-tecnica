package com.pruebatecnica.controller;



import com.pruebatecnica.dtos.EmployeeDTO;
import com.pruebatecnica.entities.EmployeeEntity;
import com.pruebatecnica.helper.IValidator;
import com.pruebatecnica.service.IEmployeesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.RouterOperation;


import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class EmployeesController {

    private final IValidator iValidator;
    private final IEmployeesService iEmployeesService;

    @RouterOperation(operation = @Operation(operationId = "Find All Employees", summary = "Find All Employees",
            tags = { "find Employees" },
            parameters = { @Parameter(in = ParameterIn.PATH, name = "", description = "Employee Id") },
            responses = {
                    @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema =
                    @Schema(implementation = EmployeeDTO.class))),
                    @ApiResponse(responseCode = "400", description = "Bad Request ")}))
    @GetMapping(path = "/get-all-employees")
    public Object getOrderById(
            @RequestHeader Map<String, String> headers
    ){
        return iValidator.validateHeaderAndAllEmployees(headers);
    }


    @RouterOperation(operation = @Operation(operationId = "Delete Employee", summary = "Delete Employee",
            tags = { "Delete Employee by ID" },
            parameters = { @Parameter(in = ParameterIn.PATH, name = "id", description = "Employee Id") },
            responses = {
                    @ApiResponse(responseCode = "204", description = "successful operation", content = @Content(schema =
                    @Schema(implementation = EmployeeDTO.class))),
                    @ApiResponse(responseCode = "400", description = "Bad Request ")}))
    @DeleteMapping("/delete-employee/{id}")
    public Object deleteEmployee(@PathVariable Integer id) {
        return this.iEmployeesService.deleteEmployee(id);
    }

    @RouterOperation(operation = @Operation(operationId = "Update Employee", summary = "Update Employee",
            tags = { "Update Employee by ID" },
            parameters = { @Parameter(in = ParameterIn.PATH, name = "Employee Entity", description = "Employee to be updated") },
            responses = {
                    @ApiResponse(responseCode = "204", description = "successful operation",
                            content = @Content(schema = @Schema(implementation = EmployeeDTO.class))),
                    @ApiResponse(responseCode = "400", description = "Bad Request ")}))
    @PatchMapping("/update-employee")
    public Object updateEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return this.iEmployeesService.updateEmployee(employeeDTO);
    }


    @RouterOperation(operation = @Operation(operationId = "Save Employees", summary = "Save Employees",
            tags = { "Save Employees List" },
            parameters = { @Parameter(in = ParameterIn.PATH, name = "employees", description = "List of employees") },
            responses = {
                    @ApiResponse(responseCode = "201", description = "successful operation",
                            content = @Content(schema = @Schema(implementation = EmployeeDTO.class))),
                    @ApiResponse(responseCode = "400", description = "Bad Request ")}))
    @PostMapping("/save-employees")
    public Object saveEmployees(@RequestBody List<EmployeeDTO> employeeEntity) {
        return this.iEmployeesService.saveEmployees(employeeEntity);
    }
}
