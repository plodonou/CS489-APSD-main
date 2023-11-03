package edu.miu.adsApp.advice;

import edu.miu.adsApp.exception.PatientNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class adsAppWebApiExceptionHandler {

    @ExceptionHandler(PatientNotFoundException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) //@ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handlePatientNotFoundException(PatientNotFoundException patientNotFoundException) {
        Map<String, String> errorMessageMap = new HashMap<>();
        errorMessageMap.put("errorMessage", patientNotFoundException.getMessage());
        return errorMessageMap;
    }
}
