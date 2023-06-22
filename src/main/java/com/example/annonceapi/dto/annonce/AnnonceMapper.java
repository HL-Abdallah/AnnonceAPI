package com.example.annonceapi.dto.annonce;

import com.example.annonceapi.entities.Annonce;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class AnnonceMapper implements Function<Annonce,AnnonceResponse> {
    @Override
    public AnnonceResponse apply(Annonce annonce) {
        return new AnnonceResponse(
                annonce.getId(),
                annonce.getTitre(),
                annonce.getDescription(),
                annonce.getPrix(),
                annonce.getType()
        );
    }
}
