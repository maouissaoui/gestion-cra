package com.consulting.core.cra.model;

import lombok.*;

import javax.persistence.*;

/**
 * A Bill: Facture
 * Created by nizaraouissaoui on 21/04/2018.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Bill {

    @Id
    @GeneratedValue
    private Long id;

    //private Cra cra;
    private Long tva;
    private Boolean paid;
    private Long globalAmount;

    /*@OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "bill")
    private Cra cra;*/


}
