/**
 * COPYRIGHT NOTICE
 * <p>
 * All Technical Data and software is Copyright (c), 2021 by
 * COLOMBIAN AIR FORCE.
 * <p>
 * COPYRIGHT NOTICE
 */
package co.mil.fac.cetad.demo.jpa.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author: Ing. Manuel Fernando Garizao; 
 * Email: manuel.garizao@fac.mil.co manuelfp@gmail.com
 * @date: 3/2/21, 9:53 AM
 **/
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    private String uuid;
    private String firstName;
    private String lastName;
    private String email;
    private String cellphone;
    private String password;
    private boolean enable = false;

    public Employee(String uuid) {
        this.uuid = uuid;
    }

}
