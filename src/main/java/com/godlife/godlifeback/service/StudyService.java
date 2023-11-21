package com.godlife.godlifeback.service;

import org.springframework.http.ResponseEntity;

import com.godlife.godlifeback.dto.response.studyServie.GetUserAttendanceInfomationResponseDto;

public interface StudyService {

    ResponseEntity<? super GetUserAttendanceInfomationResponseDto> getUserAttendanceInformationList(Integer studyNumber, String userEmail);
}
