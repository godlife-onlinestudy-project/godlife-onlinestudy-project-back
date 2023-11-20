package com.godlife.godlifeback.service.implement;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import com.godlife.godlifeback.dto.request.study.PatchStudyRequestDto;
import com.godlife.godlifeback.dto.request.study.PostStudyRequestDto;
import com.godlife.godlifeback.dto.response.ResponseDto;
import com.godlife.godlifeback.dto.response.study.GetModifyStudyResponseDto;
import com.godlife.godlifeback.dto.response.study.GetStudyUserListResponseDto;
import com.godlife.godlifeback.dto.response.study.PatchStudyResponseDto;
import com.godlife.godlifeback.dto.response.study.PostStudyResponseDto;
import com.godlife.godlifeback.entity.StudyEntity;
import com.godlife.godlifeback.entity.StudyUserListEntity;
import com.godlife.godlifeback.repository.StudyRepository;
import com.godlife.godlifeback.repository.StudyUserListRepository;
import com.godlife.godlifeback.service.StudyService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudyServiceImplement implements StudyService {

    private final StudyRepository studyRepository;
    private final StudyUserListRepository studyUserListRepository;

    @Override
    public ResponseEntity<? super GetModifyStudyResponseDto> getModifyStudy(Integer studyNumber, String userEmail) {

        StudyEntity studyEntity = null;

        try {

            studyEntity = studyRepository.findByStudyNumber(studyNumber);
            if (studyEntity == null) return GetModifyStudyResponseDto.notExistStudy();
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetModifyStudyResponseDto.success(studyEntity);
    }

    @Override
    public ResponseEntity<? super GetStudyUserListResponseDto> getStudyUserList(Integer studyNumber, String userEmail) {

        List<StudyUserListEntity> studyUserListEntities = new ArrayList<>();

        try {

            // boolean existedUser = userRepository.existsByEmail(userEmail);
            // if(!existedUser) return PostUserResponseDto.notExistsUser();

            boolean existedStudy = studyRepository.existsByStudyNumber(studyNumber);
            if(!existedStudy) return GetStudyUserListResponseDto.notExistStudy();

            boolean existedUserList = studyUserListRepository.existsByUserEmailAndStudyNumber(userEmail, studyNumber);
            if(!existedUserList) return GetStudyUserListResponseDto.notExistUser();

            studyUserListEntities = studyUserListRepository.findByStudyNumber(studyNumber);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetStudyUserListResponseDto.success(studyUserListEntities);
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
    public ResponseEntity<? super PatchStudyResponseDto> patchStudy(PatchStudyRequestDto dto, Integer studyNumber, String userEmail) {

        try {

            StudyEntity studyEntity = studyRepository.findByStudyNumber(studyNumber);
            if (studyEntity == null) return PatchStudyResponseDto.notExistStudy();

            boolean equalCreater = studyEntity.getCreateStudyUserEmail().equals(userEmail);
            if (!equalCreater) return PatchStudyResponseDto.noPermission();

            studyEntity.patch(dto);
            studyRepository.save(studyEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return PatchStudyResponseDto.success();
    }
    
    
}
