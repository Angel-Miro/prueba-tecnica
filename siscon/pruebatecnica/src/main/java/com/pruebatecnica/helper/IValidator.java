package com.pruebatecnica.helper;

import java.util.Map;

public interface IValidator {
    Object validateHeaderAndAllEmployees(Map<String, String> header);
}
