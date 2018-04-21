package com.consulting.core.cra.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.Month;

/**
 * A CRA
 * Created by nizaraouissaoui on 21/04/2018.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Cra {

    @Id
    @GeneratedValue
    private Long id;

    private Long year;

    private Month month;

    private Long days;

    private Long status;

    //private Contract contract;
}
