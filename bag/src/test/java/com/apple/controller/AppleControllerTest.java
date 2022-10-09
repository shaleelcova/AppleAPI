package com.apple.controller;

import com.apple.controller.AppleController;
import com.apple.exceptions.GlobalExceptionHandler;
import com.apple.model.AppleBag;
import com.apple.repository.AppleRepository;
import com.apple.service.AppleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.TransactionSystemException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class AppleControllerTest {

    @Autowired
    private AppleController appleController;

    @Autowired
    private AppleRepository appleRepository;

    @Autowired
    private AppleService appleService;

    @Test
    void getAppleBagTest() {
        AppleBag appleBag = new AppleBag("Pink Lady", 5, 10);
        appleRepository.save(appleBag);
        UUID id = appleBag.getId();

        Optional<AppleBag> result = appleService.getAppleBagsById(id);

        boolean equal = result.get().toString().equals(appleBag.toString());
        assertThat(equal).isTrue();
    }

    @Test
    void marketDefaultTest() {
        AppleBag appleBag1 = new AppleBag("Pink Lady", 5, 10);
        AppleBag appleBag2 = new AppleBag("Royal Gala", 2, 3);
        AppleBag appleBag3 = new AppleBag("Pink Lady", 5, 10);
        appleRepository.save(appleBag1);
        appleRepository.save(appleBag2);
        appleRepository.save(appleBag3);

        List<AppleBag> actualResult = appleController.getAppleBags(Optional.empty());

        boolean equal = actualResult.size() == 3;
        assertThat(equal).isTrue();
    }

    @Test
    void marketCustomTest() {
        AppleBag appleBag1 = new AppleBag("Pink Lady", 5, 10);
        AppleBag appleBag2 = new AppleBag("Royal Gala", 2, 3);
        AppleBag appleBag3 = new AppleBag("Pink Lady", 5, 10);
        AppleBag appleBag4 = new AppleBag("Pink Lady", 5, 1.25);
        AppleBag appleBag5 = new AppleBag("Royal Gala", 2, 10);
        appleRepository.save(appleBag1);
        appleRepository.save(appleBag2);
        appleRepository.save(appleBag3);
        appleRepository.save(appleBag4);
        appleRepository.save(appleBag5);

        List<AppleBag> actualResult = appleController.getAppleBags(Optional.of(4));

        boolean equal = actualResult.size() == 4;
        assertThat(equal).isTrue();
    }

    @Test
    void wrongSupplierTest() {
        AppleBag appleBag4 = new AppleBag("Apple California", 5, 49.99);
        try {
            appleRepository.save(appleBag4);
        } catch(TransactionSystemException e){
            appleBag4 = null;
        }
        boolean result = appleBag4 == null;
        assertThat(result).isTrue();
    }

    @Test
    void correctSupplierTest() {
        AppleBag appleBag4 = new AppleBag("Pink Lady", 5, 49.99);
        try {
            appleRepository.save(appleBag4);
        } catch(TransactionSystemException e){
            appleBag4 = null;
        }
        boolean result = appleBag4 != null;
        assertThat(result).isTrue();
    }

}