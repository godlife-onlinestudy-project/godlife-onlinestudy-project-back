package com.godlife.godlifeback.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "study_view")
@Table(name = "study_view")
public class StudyViewEntity {
  @Id
  private int studyNumber;
  private String studyName;
  private String studyStartDate;
  private String studyEndDate;
  private int studyPersonal;
  private String studyCategory1;
  private String studyCategory2;
  private String studyCategory3;
  private int studyPublicCheck;
  private String studyPrivatePassword;
  private String studyCoverImageUrl;
  private String studyNextStartDatetime;
  private String studyNextEndDatetime;
  private int studyTotalDay;
  private String createStudyUserEmail;
  private int userCount;
}
