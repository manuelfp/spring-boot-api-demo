/**
 * COPYRIGHT NOTICE
 * <p>
 * All Technical Data and software is Copyright (c), 2021 by
 * COLOMBIAN AIR FORCE.
 * <p>
 * COPYRIGHT NOTICE
 */
package co.mil.fac.cetad.demo.services;

import co.mil.fac.cetad.demo.jpa.entities.Employee;
import co.mil.fac.cetad.demo.jpa.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * @author: Ing. Manuel Fernando Garizao; 
 * Email: manuel.garizao@fac.mil.co manuelfp@gmail.com
 * @date: 3/2/21, 2:35 PM
 **/
@Service
public class EmployeeServiceImpl implements EmployeeService {

    final
    EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getEmployees() {
        return StreamSupport.stream(employeeRepository.findAll().spliterator(),false)
                .filter(employee -> employee.isEnable())
                .collect(Collectors.toList());
    }

    @Override
    public Employee getEmployeeByID(String uuid) {
        return employeeRepository.findById(uuid).orElse(null);
    }

    @Override
    public Employee doCreate(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee enableEmployee(Employee employee) {
        Employee emp = employeeRepository.findById(employee.getUuid()).orElse(null);
        if(emp == null)
            return null;
        emp.setEnable(true);
        return employeeRepository.save(emp);
    }

    @Override
    public Employee disableEmployee(Employee employee) {
        Employee emp = employeeRepository.findById(employee.getUuid()).orElse(null);
        if(emp == null)
            return null;
        emp.setEnable(false);
        return employeeRepository.save(emp);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return StreamSupport.stream(employeeRepository.findAll().spliterator(),false)
                .collect(Collectors.toList());
    }

}
