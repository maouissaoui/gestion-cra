package com.consulting.core.cra.model;

import lombok.*;

import javax.persistence.*;

/**
 * A Company: le client
 * Created by nizaraouissaoui on 21/04/2018.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Company {

    @Id
    @GeneratedValue
    private Long id;

    private String companyId;

    private String name;

    private String phone;

    private String emailBill;

    private String emailContrat;

    @ManyToOne
    @JoinColumn(name = "company_contrat_id")
    private Contract contract;

}
