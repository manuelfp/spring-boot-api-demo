/**
 * COPYRIGHT NOTICE
 * <p>
 * All Technical Data and software is Copyright (c), 2021 by
 * COLOMBIAN AIR FORCE.
 * <p>
 * COPYRIGHT NOTICE
 */
package co.mil.fac.cetad.demo.controllers;

import co.mil.fac.cetad.demo.facades.EmployeeAPIFacade;
import co.mil.fac.cetad.demo.facades.models.EmployeeDTOToAPI;
import co.mil.fac.cetad.demo.facades.models.EmployeeDTOToWeb;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: Ing. Manuel Fernando Garizao; 
 * Email: manuel.garizao@fac.mil.co manuelfp@gmail.com
 * @date: 3/2/21, 3:26 PM
 **/
@RestController
@RequestMapping("/rest/api/employees")
public class EmployeeAPIController {

    final
    EmployeeAPIFacade employeeAPIFacade;

    public EmployeeAPIController(EmployeeAPIFacade employeeAPIFacade) {
        this.employeeAPIFacade = employeeAPIFacade;
    }

    @GetMapping
    public List<EmployeeDTOToAPI> getEmployees() {
        return employeeAPIFacade.getEmployees();
    }

    @GetMapping("/{uuid}")
    public ResponseEntity getEmployeeByID(@PathVariable String uuid) {
        EmployeeDTOToAPI employeeByID = employeeAPIFacade.getEmployeeByID(uuid);
        if(null == employeeByID)
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        return new ResponseEntity(employeeByID, HttpStatus.OK) ;
    }

}
