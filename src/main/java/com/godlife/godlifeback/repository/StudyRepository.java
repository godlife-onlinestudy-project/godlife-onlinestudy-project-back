package com.godlife.godlifeback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.godlife.godlifeback.entity.StudyEntity;

@Repository
public interface StudyRepository extends JpaRepository<StudyEntity, Integer> {

    boolean existsByStudyNumber(Integer studyNumber);

    StudyEntity findByStudyNumber(Integer studyNumber);
    
}
