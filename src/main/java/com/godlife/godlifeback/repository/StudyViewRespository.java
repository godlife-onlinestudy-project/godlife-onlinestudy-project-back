package com.godlife.godlifeback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.godlife.godlifeback.entity.StudyViewEntity;

@Repository
public interface StudyViewRespository extends JpaRepository<StudyViewEntity, Integer> {

  List<StudyViewEntity> findTop5ByStudyCategory1AndStudyEndDateGreaterThanOrderByStudyEndDateDesc(String studyCategory1,
      String studyEndDate);

}
