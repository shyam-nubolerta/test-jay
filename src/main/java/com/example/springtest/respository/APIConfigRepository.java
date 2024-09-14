package com.example.springtest.respository;

import com.example.springtest.model.APIConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface APIConfigRepository extends JpaRepository<APIConfig, Long> {

    //To retrieve the most recent service API url
    Optional<APIConfig> findTopByOrderByIdDesc();
}
