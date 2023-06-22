package com.example.annonceapi.controllers;

import com.example.annonceapi.dto.annonce.AnnonceResponse;
import com.example.annonceapi.entities.Annonce;
import com.example.annonceapi.entities.TypeAnnonce;
import com.example.annonceapi.services.AnnonceService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(path="/annonce",produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class AnnonceController {

    private final AnnonceService annonceService;

    public AnnonceController(AnnonceService annonceService) {
        this.annonceService = annonceService;
    }

    @Operation(summary = "fetch all annonces stored in db.")
    @GetMapping
    public ResponseEntity<List<AnnonceResponse>> getAllAnnonces(
            @RequestParam Map<String,String> requestParams
    ) {
        List<String> list = new ArrayList<String>();
        List<AnnonceResponse> annonces = annonceService.getAllAnnonces(requestParams);
        return ResponseEntity.ok(annonces);
    }

    @Operation(summary = "fetch one annonce using a pathVariable {id}")
    @GetMapping("/{id}")
    public ResponseEntity<AnnonceResponse> getAnnonceById(@PathVariable UUID id) {
        AnnonceResponse annonce = annonceService.getAnnonceById(id);
        if (annonce != null) {
            return ResponseEntity.ok(annonce);
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Create a new annonce")
    @PostMapping
    public ResponseEntity<Annonce> createAnnonce(@RequestBody Annonce annonce) {
        Annonce createdAnnonce = annonceService.createAnnonce(annonce);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAnnonce);
    }

    @Operation(summary = "Replace an existing annonce")
    @PutMapping("/{id}")
    public ResponseEntity<AnnonceResponse> updateAnnonce(@PathVariable UUID id, @RequestBody Annonce updatedAnnonce) {
        AnnonceResponse annonceResponse = annonceService.getAnnonceById(id);
        if (annonceResponse != null) {
            updatedAnnonce.setId(annonceResponse.id());
            AnnonceResponse savedAnnonceResponse = annonceService.updateAnnonce(updatedAnnonce);
            return ResponseEntity.ok(savedAnnonceResponse);
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Delete an annonce by {id}")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnnonce(@PathVariable UUID id) {
        AnnonceResponse annonceResponse = annonceService.getAnnonceById(id);
        if (annonceResponse != null) {
            annonceService.deleteAnnonce(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
