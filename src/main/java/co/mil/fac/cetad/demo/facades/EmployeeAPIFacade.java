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


import java.util.List;

/**
 * @author: Ing. Manuel Fernando Garizao; 
 * Email: manuel.garizao@fac.mil.co manuelfp@gmail.com
 * @date: 3/2/21, 3:48 PM
 **/
public interface EmployeeAPIFacade {

    List<EmployeeDTOToAPI> getEmployees();

    EmployeeDTOToAPI getEmployeeByID(String uuid);

}
