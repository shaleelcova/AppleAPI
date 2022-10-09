package com.apple.controller;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.apple.repository.AppleRepository;
import com.apple.service.AppleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.apple.model.AppleBag;

import javax.validation.Valid;

//creating RestController
@RestController
public class AppleController
{
    //autowired the StudentService class
    @Autowired
    AppleService appleService;

    @GetMapping("/market/")
    public List<AppleBag> getAppleBags(@RequestParam("quantity") Optional<Integer> quantity) {
          List<AppleBag> appleBags = appleService.getAppleBags(quantity.orElse(3));
        return appleBags;
    }

    @RequestMapping(value="/addAppleBag", method = RequestMethod.POST)
    public ResponseEntity<AppleBag> addAppleBag(@Valid @RequestBody AppleBag appleBag){
        return appleService.addAppleBag(appleBag);
    }


}
