package com.godlife.godlifeback.service.implement;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.godlife.godlifeback.dto.request.study.PostStudyRequestDto;
import com.godlife.godlifeback.dto.response.ResponseDto;
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
    
}
