package com.godlife.godlifeback.service.implement;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.godlife.godlifeback.dto.response.ResponseDto;
import com.godlife.godlifeback.dto.response.study.GetTop5StudyListResponseDto;
import com.godlife.godlifeback.entity.StudyViewEntity;
import com.godlife.godlifeback.repository.StudyViewRespository;
import com.godlife.godlifeback.service.StudyService;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class StudyServiceImplement implements StudyService {

  private final StudyViewRespository studyViewRespository;

  @Override
  public ResponseEntity<? super GetTop5StudyListResponseDto> getTop5StudyList(String studyCategory1, String email) {

    List<StudyViewEntity> studyViewEntities = new ArrayList<>();

    try {
      Date now = Date.from(Instant.now());
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      String DaysAgo = simpleDateFormat.format(now);

      studyViewEntities = studyViewRespository
          .findTop5ByStudyCategory1AndStudyEndDateGreaterThanOrderByStudyEndDateDesc(studyCategory1, DaysAgo);
    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }

    return GetTop5StudyListResponseDto.success(studyViewEntities);

  }
}
