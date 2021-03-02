/**
 * COPYRIGHT NOTICE
 * <p>
 * All Technical Data and software is Copyright (c), 2021 by
 * COLOMBIAN AIR FORCE.
 * <p>
 * COPYRIGHT NOTICE
 */
package co.mil.fac.cetad.demo.facades.models;

import co.mil.fac.cetad.demo.jpa.entities.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author: Ing. Manuel Fernando Garizao; 
 * Email: manuel.garizao@fac.mil.co manuelfp@gmail.com
 * @date: 3/2/21, 3:01 PM
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTOToWeb {

    private String uuid;
    private String firstName;
    private String lastName;
    private String email;
    private String cellphone;
    private boolean enable;

    public EmployeeDTOToWeb(Employee employee) {
        this.uuid = employee.getUuid();
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
        this.email = employee.getEmail();
        this.cellphone = employee.getCellphone();
        this.enable = employee.isEnable();
    }
}
