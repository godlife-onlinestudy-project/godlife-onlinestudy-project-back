package com.godlife.godlifeback.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "study_material")
@Table(name = "study_material")
public class StudyMaterialEntity {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studyMaterialNumber;

    private int studyNumber;

    private String studyMaterialName;

    private String studyMaterialImageUrl;

    private String studyMaterialWrite;

    private String studyMaterialDatetime;

}
