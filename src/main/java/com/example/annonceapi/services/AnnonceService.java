package com.example.annonceapi.services;

import com.example.annonceapi.dto.annonce.AnnonceMapper;
import com.example.annonceapi.dto.annonce.AnnonceResponse;
import com.example.annonceapi.entities.Annonce;
import com.example.annonceapi.entities.TypeAnnonce;
import com.example.annonceapi.exceptions.AnnonceNotFound;
import com.example.annonceapi.repositories.AnnonceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AnnonceService {

    private final AnnonceRepository annonceRepository;
    private final AnnonceMapper annonceMapper;

    public AnnonceService(AnnonceRepository annonceRepository, AnnonceMapper annonceMapper) {
        this.annonceRepository = annonceRepository;
        this.annonceMapper = annonceMapper;
    }

    public List<AnnonceResponse> getAllAnnonces(Map<String,String> requestParams) {
        log.debug(String.format(" all params are %s",requestParams));

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreCase()
                .withMatcher("titre", ExampleMatcher.GenericPropertyMatchers.contains())
//                .withMatcher("type", ExampleMatcher.GenericPropertyMatchers.exact())
                .withIgnorePaths("prix","uuid","type");

//        var typeAnnonce = Optional.ofNullable(requestParams.get("type")).orElse(null);
//        TypeAnnonce type = null;
//        if (typeAnnonce != null) {
//            type = TypeAnnonce.valueOf(typeAnnonce);
//        }

        Annonce exampleAnnonce = Annonce.builder()
                .titre(Optional.ofNullable(requestParams.get("titre")).orElse(null))
               // .type(type)
                .build();

        Example<Annonce> example = Example.of(exampleAnnonce,matcher);

        return annonceRepository.findAll(example)
                .stream()
                .map(annonceMapper)
                .collect(Collectors.toList());
    }

    public AnnonceResponse getAnnonceById(UUID id) {
        return annonceRepository.findById(id)
                .map(annonceMapper)
                .orElse(null);
    }

    public Annonce createAnnonce(Annonce annonce) {
        return annonceRepository.save(annonce);
    }

    public AnnonceResponse updateAnnonce(Annonce annonce) {
        Annonce savedAnnonce =  annonceRepository.save(annonce);
        return annonceMapper.apply(savedAnnonce);
    }

    public void deleteAnnonce(UUID id) {
        annonceRepository.deleteById(id);
    }
}
