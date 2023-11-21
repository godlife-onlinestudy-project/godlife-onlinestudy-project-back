package com.godlife.godlifeback.service.implement;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import com.godlife.godlifeback.dto.response.ResponseDto;
import com.godlife.godlifeback.dto.response.studyServie.GetUserAttendanceInfomationResponseDto;
import com.godlife.godlifeback.repository.UserAttendanceInformationRepository;
import com.godlife.godlifeback.repository.resultSet.UserAttendanceInformationResultset;
import com.godlife.godlifeback.service.StudyService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudyServiceImplement implements StudyService{


    private final UserAttendanceInformationRepository userAttendanceInformationRepository;

    @Override
    public ResponseEntity<? super GetUserAttendanceInfomationResponseDto> getUserAttendanceInformationList(Integer studyNumber, String userEmail) {
        
        List<UserAttendanceInformationResultset> attendanceResultsets = new ArrayList<>();

        try {
            
            boolean existedUser = userRepository.existsByEmail(userEmail);
            if(!existedUser) return GetUserResponseDto.notExistsUser();

            boolean existedStudy = studyRepository.existsByStudyNumber(studyNumber);
            if(!existedStudy) return GetStudyResponseDto.notExistStudy();

            boolean  existedAttendInformation = userAttendanceInformationRepository.existsByStudyNumberAndUserEmail(studyNumber, userEmail);
            if(!existedAttendInformation) return GetUserAttendanceInfomationResponseDto.notExistUserAttendanceInformation();

            attendanceResultsets = userAttendanceInformationRepository.findByStudyAttenanceInformationList(studyNumber, userEmail);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetUserAttendanceInfomationResponseDto.success(attendanceResultsets);

    }
    
}
