package com.godlife.godlifeback.common.object;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import com.godlife.godlifeback.repository.resultSet.StudyToDoListResultSet;

@Getter
@Setter
public class StudyToDoListItem {
    private int studyListNumber;
    private int studyNumber;
    private String studyListContent;
    private String userEmail;
    private Boolean studyListCheck;

    public StudyToDoListItem(StudyToDoListResultSet resultSet){
        this.studyListNumber = resultSet.getStudyListNumber();
        this.studyNumber = resultSet.getStudyNumber();
        this.studyListContent = resultSet.getStudyListContent();
        this.userEmail = resultSet.getUserEmail();
        this.studyListCheck = resultSet.getStudyListCheck();
    }

    public static List<StudyToDoListItem> getToDoList(List<StudyToDoListResultSet> resultSets){
        List<StudyToDoListItem> list = new ArrayList<>();

        for(StudyToDoListResultSet resultSet :  resultSets){
            StudyToDoListItem studyToDoListItem = new StudyToDoListItem(resultSet);
            list.add(studyToDoListItem);
        }

        return list;
    }
}
