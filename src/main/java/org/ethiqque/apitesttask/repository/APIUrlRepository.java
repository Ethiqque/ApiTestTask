package org.ethiqque.apitesttask.repository;

import org.ethiqque.apitesttask.entity.APIUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface APIUrlRepository extends JpaRepository<APIUrl, Long> {
    APIUrl findByName(String name);
}
