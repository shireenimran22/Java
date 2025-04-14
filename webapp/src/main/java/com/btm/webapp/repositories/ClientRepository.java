package com.btm.webapp.repositories;


import com.btm.webapp.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer>
{
    public Client findByEmail(String email);

}
