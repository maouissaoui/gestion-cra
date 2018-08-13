package com.consulting.core.cra.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


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

    private Date startDate;

    private Date endDate;

    private Long paiementPeriod;

    private String comment;

    private Boolean active;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Company> companies;

    @ManyToOne
    @JoinColumn(name = "company_cra_id")
    private Cra cra;

}
