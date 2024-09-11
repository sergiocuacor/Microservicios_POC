package com.sergiocuacor.microservices.verifier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerifierCheckHistoryRepository extends JpaRepository<VerifierCheckHistory, Integer> {

}
