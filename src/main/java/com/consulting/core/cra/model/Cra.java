package com.consulting.core.cra.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Month;
import java.util.List;

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
public class Cra  {

    @Id
    @GeneratedValue
    private Long id;

    private Long year;

    private Month month;

    private Long days;

    private String status;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Contract> contracts;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "cra_bill_id")
    private Bill bill;
}
