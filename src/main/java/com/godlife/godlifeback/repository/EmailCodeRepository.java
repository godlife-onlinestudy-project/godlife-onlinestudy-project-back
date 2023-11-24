package com.godlife.godlifeback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.godlife.godlifeback.entity.EmailCodeEntity;

@Repository
public interface EmailCodeRepository extends JpaRepository<EmailCodeEntity, String> {
    EmailCodeEntity findByEmail(String email);
}
