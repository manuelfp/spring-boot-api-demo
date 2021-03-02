/**
 * COPYRIGHT NOTICE
 * <p>
 * All Technical Data and software is Copyright (c), 2021 by
 * COLOMBIAN AIR FORCE.
 * <p>
 * COPYRIGHT NOTICE
 */
package co.mil.fac.cetad.demo.facades;

import co.mil.fac.cetad.demo.facades.models.EmployeeDTOToAPI;
import co.mil.fac.cetad.demo.facades.models.EmployeeDTOToWeb;
import co.mil.fac.cetad.demo.jpa.entities.Employee;
import co.mil.fac.cetad.demo.services.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: Ing. Manuel Fernando Garizao; 
 * Email: manuel.garizao@fac.mil.co manuelfp@gmail.com
 * @date: 3/2/21, 3:49 PM
 **/
@Service
public class EmployeeAPIFacadeImpl implements EmployeeAPIFacade {

    final
    EmployeeService employeeService;

    public EmployeeAPIFacadeImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public List<EmployeeDTOToAPI> getEmployees() {
        return employeeService.getEmployees().stream().map(EmployeeDTOToAPI::new).collect(Collectors.toList());
    }

    @Override
    public EmployeeDTOToAPI getEmployeeByID(String uuid) {
        Employee employee = employeeService.getEmployeeByID(uuid);
        if(null == employee)
            return null;
        if(employee.isEnable())
            return new EmployeeDTOToAPI(employee);
        return null;
    }
}
