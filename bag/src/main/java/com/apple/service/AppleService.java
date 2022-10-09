package com.apple.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import com.apple.repository.AppleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.apple.model.AppleBag;

@Service
public class AppleService {
    @Autowired
    AppleRepository appleRepository;
    public Optional<AppleBag> getAppleBagsById(UUID id) {
        Optional<AppleBag> appleBag = appleRepository.findById(id);
        return appleBag;
    }

    public List<AppleBag> getAppleBags(int n) {
        if (n < 1) n = 1;
        else if (n > 100) n = 100;

        List<AppleBag> appleBags = new ArrayList<>();
        appleRepository.findAll().forEach(appleBag -> appleBags.add(appleBag));
        return appleBags.stream().limit(n).collect(Collectors.toList());
    }


    public ResponseEntity<AppleBag>addAppleBag(AppleBag appleBag) {
        System.out.println(appleBag.toString());
        appleRepository.save(appleBag);
        return new ResponseEntity<>(appleBag, HttpStatus.CREATED);
    }


}