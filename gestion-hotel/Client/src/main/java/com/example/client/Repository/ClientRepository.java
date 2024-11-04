package com.example.client.Repository;

import com.example.client.Entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository  extends JpaRepository<Client,Integer> {
}
