package com.godlife.godlifeback.common.object;

import java.util.ArrayList;
import java.util.List;

import com.godlife.godlifeback.repository.resultSet.StudyUserListResultSet;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudyUserListItem {
    private int studyNumber;
    private String userEmail;
    private String studyGrade;

    public StudyUserListItem(StudyUserListResultSet resultSet) {
        this.studyNumber = resultSet.getStudyNumber();
        this.userEmail = resultSet.getUserEmail();
        this.studyGrade = resultSet.getStudyGrade();
    }

    public static List<StudyUserListItem> getList(List<StudyUserListResultSet> resultSets) {
        List<StudyUserListItem> list = new ArrayList<>();
        for (StudyUserListResultSet resultSet: resultSets) {
            StudyUserListItem studyUserListItem = new StudyUserListItem(resultSet);
            list.add(studyUserListItem);
        }
        return list;
    }
}
