package com.apple.repository;

import org.springframework.data.repository.CrudRepository;
import com.apple.model.AppleBag;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AppleRepository extends CrudRepository<AppleBag, UUID>
{
    List<AppleBag> findAll();
    Optional<AppleBag> findById(UUID id);


}