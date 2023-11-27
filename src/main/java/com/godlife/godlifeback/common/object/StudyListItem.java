package com.godlife.godlifeback.common.object;

import com.godlife.godlifeback.entity.StudyViewEntity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class StudyListItem {
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
  private int study_totalDay;
  private String createStudyUserEmail;
  private int userCount;

  public StudyListItem(StudyViewEntity studyViewEntity) {
    this.studyNumber = studyViewEntity.getStudyNumber();
    this.studyName = studyViewEntity.getStudyName();
    this.studyStartDate = studyViewEntity.getStudyStartDate();
    this.studyEndDate = studyViewEntity.getStudyEndDate();
    this.studyPersonal = studyViewEntity.getStudyPersonal();
    this.studyCategory1 = studyViewEntity.getStudyCategory1();
    this.studyCategory2 = studyViewEntity.getStudyCategory2();
    this.studyCategory3 = studyViewEntity.getStudyCategory3();
    this.studyPublicCheck = studyViewEntity.getStudyPublicCheck();
    this.studyPrivatePassword = studyViewEntity.getStudyPrivatePassword();
    this.studyCoverImageUrl = studyViewEntity.getStudyCoverImageUrl();
    this.studyNextStartDatetime = studyViewEntity.getStudyNextStartDatetime();
    this.studyNextEndDatetime = studyViewEntity.getStudyNextEndDatetime();
    this.study_totalDay = studyViewEntity.getStudyTotalDay();
    this.createStudyUserEmail = studyViewEntity.getCreateStudyUserEmail();
    this.userCount = studyViewEntity.getUserCount();
  }

  public static List<StudyListItem> getStudyList(List<StudyViewEntity> studyViewEntities) {
    List<StudyListItem> studyList = new ArrayList<>();
    for (StudyViewEntity studyViewEntity : studyViewEntities) {
      StudyListItem studyListItem = new StudyListItem(studyViewEntity);
      studyList.add(studyListItem);
    }
    return studyList;
  }

}
