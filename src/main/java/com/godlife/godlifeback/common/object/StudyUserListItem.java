package com.godlife.godlifeback.common.object;

import java.util.ArrayList;
import java.util.List;

import com.godlife.godlifeback.repository.resultSet.StudyUserListResultSet;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudyUserListItem {
    private String nickname;
    private String profileImageUrl;
    private String studyGrade;

    public StudyUserListItem(StudyUserListResultSet resultSet) {
        this.nickname = resultSet.getNickname();
        this.profileImageUrl = resultSet.getProfileImageUrl();
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
