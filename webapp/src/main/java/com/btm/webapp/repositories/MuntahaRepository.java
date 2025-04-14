package com.btm.webapp.repositories;


import com.btm.webapp.models.Muntaha;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MuntahaRepository extends JpaRepository<Muntaha, Integer> {

    public Muntaha findByEmail(String email);
}
