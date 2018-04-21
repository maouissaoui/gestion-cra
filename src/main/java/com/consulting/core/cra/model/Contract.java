package com.consulting.core.cra.model;

import java.time.ZonedDateTime;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


/**
 * A Contract.
 * Created by nizaraouissaoui on 21/04/2018.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Contract {

    @Id
    @GeneratedValue
    private Long id;

    private Long contractId;

    private Long tjm;

    private ZonedDateTime startDate;

    private ZonedDateTime endDate;

    private Long paiementPeriod;

    private String comment;

    private Company company;

    private Boolean active;
}
