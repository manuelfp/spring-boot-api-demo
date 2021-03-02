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

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Ing. Manuel Fernando Garizao; 
 * Email: manuel.garizao@fac.mil.co manuelfp@gmail.com
 * @date: 3/2/21, 3:00 PM
 **/
@Service
public interface EmployeeIntFacade {

    List<EmployeeDTOToWeb> getEmployees();

    EmployeeDTOToWeb getEmployeeByID(String uuid);

    boolean doCreate(EmployeeDTOToWeb employee);

    EmployeeDTOToWeb enableEmployee(String uuid);

    EmployeeDTOToWeb disableEmployee(String uuid);

    List<EmployeeDTOToWeb> getAllEmployees();

}
