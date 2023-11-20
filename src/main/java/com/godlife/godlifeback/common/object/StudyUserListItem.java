package com.godlife.godlifeback.common.object;

import java.util.ArrayList;
import java.util.List;

import com.godlife.godlifeback.entity.StudyUserListEntity;
import com.godlife.godlifeback.repository.resultSet.StudyUserListResultSet;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudyUserListItem {
    private int studyNumber;
    private String userEmail;
    private String studyGrade;

    public StudyUserListItem(StudyUserListEntity studyUserListEntity) {
        this.studyNumber = studyUserListEntity.getStudyNumber();
        this.userEmail = studyUserListEntity.getUserEmail();
        this.studyGrade = studyUserListEntity.getStudyGrade();
    }

    public static List<StudyUserListItem> getList(List<StudyUserListEntity> studyUserListEntities) {
        List<StudyUserListItem> list = new ArrayList<>();
        for (StudyUserListEntity userList: studyUserListEntities) {
            StudyUserListItem studyUserListItem = new StudyUserListItem(userList);
            list.add(studyUserListItem);
        }
        return list;
    }
}
