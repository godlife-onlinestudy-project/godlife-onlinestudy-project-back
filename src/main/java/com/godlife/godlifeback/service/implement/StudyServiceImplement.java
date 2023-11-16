package com.godlife.godlifeback.service.implement;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.godlife.godlifeback.dto.request.study.PatchStudyRequestDto;
import com.godlife.godlifeback.dto.request.study.PostStudyRequestDto;
import com.godlife.godlifeback.dto.response.ResponseDto;
import com.godlife.godlifeback.dto.response.study.GetModifyStudyResponseDto;
import com.godlife.godlifeback.dto.response.study.PatchStudyResponseDto;
import com.godlife.godlifeback.dto.response.study.PostStudyResponseDto;
import com.godlife.godlifeback.entity.StudyEntity;
import com.godlife.godlifeback.repository.StudyRepository;
import com.godlife.godlifeback.service.StudyService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudyServiceImplement implements StudyService {

    private final StudyRepository studyRepository;

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
