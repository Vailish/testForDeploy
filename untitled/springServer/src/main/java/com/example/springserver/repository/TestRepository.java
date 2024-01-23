package com.example.springserver.repository;

import com.example.springserver.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Long> {
    Test findByTestId(Long id);
}
