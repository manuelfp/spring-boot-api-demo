/**
 * COPYRIGHT NOTICE
 * <p>
 * All Technical Data and software is Copyright (c), 2021 by
 * COLOMBIAN AIR FORCE.
 * <p>
 * COPYRIGHT NOTICE
 */
package co.mil.fac.cetad.demo.facades;

import co.mil.fac.cetad.demo.facades.models.EmployeeDTOToWeb;
import co.mil.fac.cetad.demo.jpa.entities.Employee;
import co.mil.fac.cetad.demo.services.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: Ing. Manuel Fernando Garizao; 
 * Email: manuel.garizao@fac.mil.co manuelfp@gmail.com
 * @date: 3/2/21, 3:05 PM
 **/
@Service
public class EmployeeIntFacadeImpl implements EmployeeIntFacade {

    final
    EmployeeService employeeService;

    public EmployeeIntFacadeImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public List<EmployeeDTOToWeb> getEmployees() {
        return employeeService.getEmployees().stream()
                .map(EmployeeDTOToWeb::new)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDTOToWeb getEmployeeByID(String uuid) {
        Employee employee = employeeService.getEmployeeByID(uuid);
        if(null == employee)
            return null;
        return new EmployeeDTOToWeb(employee);
    }

    @Override
    public boolean doCreate(EmployeeDTOToWeb employee) {
        Employee empl = new Employee();
        empl.setEnable(false);
        empl.setFirstName(employee.getFirstName());
        empl.setLastName(employee.getLastName());
        empl.setCellphone(employee.getCellphone());
        empl.setEmail(employee.getEmail());
        empl.setUuid(employee.getUuid());
        empl.setPassword(employee.getUuid());
        Employee result = employeeService.doCreate(empl);
        if (result == null)
            return false;
        return true;
    }

    @Override
    public EmployeeDTOToWeb enableEmployee(String uuid) {
        Employee employee = employeeService.getEmployeeByID(uuid);
        if(employee == null)
            return null;
        employeeService.enableEmployee(employee);
        return new EmployeeDTOToWeb(employee);
    }

    @Override
    public EmployeeDTOToWeb disableEmployee(String uuid) {
        Employee employee = employeeService.getEmployeeByID(uuid);
        if(employee == null)
            return null;
        employeeService.disableEmployee(employee);
        return new EmployeeDTOToWeb(employee);
    }

    @Override
    public List<EmployeeDTOToWeb> getAllEmployees() {
        return employeeService.getAllEmployees().stream().map(EmployeeDTOToWeb::new).collect(Collectors.toList());
    }
}
