/**
 * COPYRIGHT NOTICE
 * <p>
 * All Technical Data and software is Copyright (c), 2021 by
 * COLOMBIAN AIR FORCE.
 * <p>
 * COPYRIGHT NOTICE
 */
package co.mil.fac.cetad.demo.controllers;

import co.mil.fac.cetad.demo.facades.EmployeeIntFacade;
import co.mil.fac.cetad.demo.facades.models.EmployeeDTOToWeb;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: Ing. Manuel Fernando Garizao; 
 * Email: manuel.garizao@fac.mil.co manuelfp@gmail.com
 * @date: 3/2/21, 3:26 PM
 **/
@RestController
@RequestMapping("/rest/web/employees")
public class EmployeeWebController {

    final
    EmployeeIntFacade employeeIntFacade;

    public EmployeeWebController(EmployeeIntFacade employeeIntFacade) {
        this.employeeIntFacade = employeeIntFacade;
    }

    @GetMapping("/actives")
    public List<EmployeeDTOToWeb> getEmployees() {
        return employeeIntFacade.getEmployees();
    }

    @GetMapping("/{uuid}")
    public EmployeeDTOToWeb getEmployeeByID(@PathVariable String uuid) {
        return employeeIntFacade.getEmployeeByID(uuid);
    }

    @PostMapping
    public boolean doCreate(@RequestBody EmployeeDTOToWeb employee) {
        return employeeIntFacade.doCreate(employee);
    }

    @PutMapping("/enable/{uuid}")
    public EmployeeDTOToWeb enableEmployee(@PathVariable String uuid) {
        return employeeIntFacade.enableEmployee(uuid);
    }

    @PutMapping("/disable/{uuid}")
    public EmployeeDTOToWeb disableEmployee(@PathVariable String uuid) {
        return employeeIntFacade.disableEmployee(uuid);
    }

    @GetMapping
    public List<EmployeeDTOToWeb> getAllEmployees() {
        return employeeIntFacade.getAllEmployees();
    }

}
