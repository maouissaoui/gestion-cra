package com.consulting.core.cra.model;

import lombok.*;

import javax.persistence.Entity;

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

    private Cra cra;
    private Long tva;
    private Boolean paid;
    private Long globalAmount;

}
