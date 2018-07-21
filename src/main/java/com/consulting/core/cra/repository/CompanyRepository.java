package com.consulting.core.cra.repository;

import com.consulting.core.cra.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * Created by nizaraouissaoui on 21/04/2018.
 */
@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
