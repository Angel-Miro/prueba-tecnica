package com.pruebatecnica.helper.imp;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pruebatecnica.exceptions.dtos.ErrorCustomeResponse;
import com.pruebatecnica.helper.IValidator;
import com.pruebatecnica.service.IEmployeesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class ValidatorImpl implements IValidator {

    private final IEmployeesService employeesService;

    @Override
    public Object validateHeaderAndAllEmployees(Map<String, String> header) {
        ObjectMapper objectMapper = new ObjectMapper();
        String headersInput ;
        try {
            headersInput = objectMapper.writeValueAsString(header);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        log.info("Validating header: {} ",headersInput);
        if(!header.containsKey("channel") && !header.containsValue("MOBILE") ) {
            ErrorCustomeResponse error = new ErrorCustomeResponse("ERROR-400", "Missing header [channel]", LocalDateTime.now());
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }else{
            return ResponseEntity.ok(this.employeesService.getAllEmployees());
        }

    }
}
