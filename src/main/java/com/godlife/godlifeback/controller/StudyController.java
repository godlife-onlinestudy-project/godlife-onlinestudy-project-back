package com.godlife.godlifeback.controller;

import org.springframework.web.bind.annotation.RestController;

import com.godlife.godlifeback.service.StudyService;

import lombok.RequiredArgsConstructor;

@RestController

@RequiredArgsConstructor
public class StudyController {
    
    private final StudyService studyService;
}
