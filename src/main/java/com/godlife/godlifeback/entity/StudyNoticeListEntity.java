package com.godlife.godlifeback.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.godlife.godlifeback.dto.request.studyService.PatchNoticeRequestDto;
import com.godlife.godlifeback.dto.request.studyService.PostNoticeRequestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="study_notice")
@Table(name="study_notice")
public class StudyNoticeListEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studyNoticeNumber;
    private int studyNumber;

    @NotBlank
    private String studyNoticeContent;  

    public StudyNoticeListEntity(PostNoticeRequestDto dto, Integer studyNumber){
        this.studyNumber = studyNumber;
        this.studyNoticeContent = dto.getNoticeContent();
    }

    public void patch(PatchNoticeRequestDto dto){
        this.studyNoticeContent = dto.getNoticeContent();
    }

}
