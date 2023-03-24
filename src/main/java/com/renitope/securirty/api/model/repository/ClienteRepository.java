package com.renitope.securirty.api.model.repository;

import com.renitope.securirty.api.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
}
