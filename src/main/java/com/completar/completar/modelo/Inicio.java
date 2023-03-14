
package com.completar.completar.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table (name="inicio")
public class Inicio {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String mail;
    private String contraseña;
}
