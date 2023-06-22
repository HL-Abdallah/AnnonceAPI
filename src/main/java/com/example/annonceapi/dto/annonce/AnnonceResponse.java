package com.example.annonceapi.dto.annonce;

import com.example.annonceapi.entities.TypeAnnonce;

import java.util.UUID;

public record AnnonceResponse(
         UUID id,
         String titre,
         String description,
         double prix,
         TypeAnnonce type
) {
}
