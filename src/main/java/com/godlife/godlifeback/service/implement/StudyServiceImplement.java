package com.godlife.godlifeback.service.implement;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import com.godlife.godlifeback.dto.request.study.PatchStudyRequestDto;
import com.godlife.godlifeback.dto.request.study.PostStudyRequestDto;
import com.godlife.godlifeback.dto.response.ResponseDto;
import com.godlife.godlifeback.dto.response.study.GetSearchStudyListResponseDto;
import com.godlife.godlifeback.dto.response.study.GetSearchWordStudyListResponseDto;
import com.godlife.godlifeback.dto.response.study.DeleteStudyUserListResponseDto;
import com.godlife.godlifeback.dto.response.study.GetModifyStudyResponseDto;
import com.godlife.godlifeback.dto.response.study.GetStudyUserListResponseDto;
import com.godlife.godlifeback.dto.response.study.PatchStudyResponseDto;
import com.godlife.godlifeback.dto.response.study.PostStudyResponseDto;
import com.godlife.godlifeback.entity.StudyEntity;
import com.godlife.godlifeback.entity.StudyUserListEntity;
import com.godlife.godlifeback.repository.StudyRepository;
import com.godlife.godlifeback.repository.StudyUserListRepository;
import com.godlife.godlifeback.repository.resultSet.StudyUserListResultSet;
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

  private final StudyRepository studyRepository;
  private final StudyUserListRepository studyUserListRepository;
  private final StudyViewRespository studyViewRespository;

  Date now = Date.from(Instant.now());
  SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  String DaysAgo = simpleDateFormat.format(now);

  @Override
  public ResponseEntity<? super GetModifyStudyResponseDto> getModifyStudy(Integer studyNumber, String userEmail) {

    StudyEntity studyEntity = null;

    try {

      studyEntity = studyRepository.findByStudyNumber(studyNumber);
      if (studyEntity == null)
        return GetModifyStudyResponseDto.notExistStudy();

    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }

    return GetModifyStudyResponseDto.success(studyEntity);
  }

  @Override
  public ResponseEntity<? super GetStudyUserListResponseDto> getStudyUserList(Integer studyNumber, String userEmail) {

    List<StudyUserListResultSet> studyUserListResultSets = new ArrayList<>();

    try {

      // boolean existedUser = userRepository.existsByEmail(userEmail);
      // if(!existedUser) return PostUserResponseDto.notExistsUser();

      boolean existedStudy = studyRepository.existsByStudyNumber(studyNumber);
      if (!existedStudy)
        return GetStudyUserListResponseDto.notExistStudy();

      System.out.println(userEmail);

      boolean existedUserList = studyUserListRepository.existsByUserEmailAndStudyNumber(userEmail, studyNumber);
      if (!existedUserList)
        return GetStudyUserListResponseDto.notExistUser();

      studyUserListResultSets = studyUserListRepository.findByStudyUserList(studyNumber);

    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }
    return GetStudyUserListResponseDto.success(studyUserListResultSets);
  }

  @Override
  public ResponseEntity<? super PostStudyResponseDto> postStudy(PostStudyRequestDto dto, String userEmail) {

    try {

      StudyEntity studyEntity = new StudyEntity(dto, userEmail);
      studyRepository.save(studyEntity);

      Integer studyNumber = studyEntity.getStudyNumber();

    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }

    return PostStudyResponseDto.success();
  }

  @Override
  public ResponseEntity<? super PatchStudyResponseDto> patchStudy(PatchStudyRequestDto dto, Integer studyNumber,
      String userEmail) {

    try {

      StudyEntity studyEntity = studyRepository.findByStudyNumber(studyNumber);
      if (studyEntity == null)
        return PatchStudyResponseDto.notExistStudy();

      boolean equalCreater = studyEntity.getCreateStudyUserEmail().equals(userEmail);
      if (!equalCreater)
        return PatchStudyResponseDto.noPermission();

      studyEntity.patch(dto);
      studyRepository.save(studyEntity);

    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }

    return PatchStudyResponseDto.success();
  }

  @Override
  public ResponseEntity<? super DeleteStudyUserListResponseDto> deleteStudyUserList(Integer studyNumber,
      String userEmail, String createStudyUserEmail) {

    try {

      StudyEntity studyEntity = studyRepository.findByStudyNumber(studyNumber);
      if (studyEntity == null)
        return DeleteStudyUserListResponseDto.notExistStudy();

      boolean isCreater = studyEntity.getCreateStudyUserEmail().equals(createStudyUserEmail);
      if (!isCreater)
        return DeleteStudyUserListResponseDto.noPermission();

      StudyUserListEntity studyUserListEntity = studyUserListRepository.findByStudyNumberAndUserEmail(studyNumber,
          userEmail);
      if (studyUserListEntity == null)
        return DeleteStudyUserListResponseDto.notExistUser();

      studyUserListRepository.delete(studyUserListEntity);

    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }

    return DeleteStudyUserListResponseDto.success();

  }

  @Override
  public ResponseEntity<? super GetTop5StudyListResponseDto> getTop5StudyList(String studyCategory1, String email) {

    List<StudyViewEntity> studyViewEntities = new ArrayList<>();

    try {

      studyViewEntities = studyViewRespository
          .findTop5ByStudyCategory1AndStudyEndDateGreaterThanOrderByStudyEndDateDesc(studyCategory1, DaysAgo);
    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }

    return GetTop5StudyListResponseDto.success(studyViewEntities);

  }

  @Override
  public ResponseEntity<? super GetSearchStudyListResponseDto> getSearchStudyList(String Email) {

    List<StudyViewEntity> studyViewEntities = new ArrayList<>();

    try {
      studyViewEntities = studyViewRespository
          .findByStudyEndDateGreaterThanOrderByStudyPublicCheckDescStudyEndDateDesc(DaysAgo);
    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }

    return GetSearchStudyListResponseDto.success(studyViewEntities);
  }

  @Override
  public ResponseEntity<? super GetSearchWordStudyListResponseDto> getSearchWordStudyList(String studyName,
      String Email) {

    List<StudyViewEntity> studyViewEntities = new ArrayList<>();

    try {
      studyViewEntities = studyViewRespository
          .findByStudyNameContainsAndStudyEndDateGreaterThanOrderByStudyEndDateDesc(studyName, DaysAgo);
    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }

    return GetSearchWordStudyListResponseDto.success(studyViewEntities);
  }
}