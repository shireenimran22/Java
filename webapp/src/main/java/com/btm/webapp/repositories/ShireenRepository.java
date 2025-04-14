package com.btm.webapp.repositories;


import com.btm.webapp.models.Shireen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShireenRepository extends JpaRepository<Shireen, Integer>
{
    public Shireen findByName(String Name);

}
