package com.example.annonceapi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AnnonceRepository extends JpaRepository<Annonce,UUID> {}
