package com.example.climalert.clima;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositoryRegistroClima extends JpaRepository<RegistroClima, Long> {

    Optional<RegistroClima> findTopByOrderByFechaHoraDesc();

}