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

import java.util.List;

/**
 * @author: Ing. Manuel Fernando Garizao; 
 * Email: manuel.garizao@fac.mil.co manuelfp@gmail.com
 * @date: 3/2/21, 2:27 PM
 **/
public interface EmployeeService {

    List<Employee> getEmployees();

    Employee getEmployeeByID(String uuid);

    Employee doCreate(Employee employee);

    Employee enableEmployee(Employee employee);

    Employee disableEmployee(Employee employee);

    List<Employee> getAllEmployees();

}
