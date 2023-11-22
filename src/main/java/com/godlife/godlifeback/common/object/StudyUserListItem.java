package com.godlife.godlifeback.common.object;

import java.util.ArrayList;
import java.util.List;

import com.godlife.godlifeback.repository.resultSet.StudyUserListResultSet;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudyUserListItem {
    private String userEmail;
    private String userNickname;
    private String userProfileImageUrl;
    private String studyGrade;

    public StudyUserListItem(StudyUserListResultSet resultSet) {
        this.userEmail = resultSet.getEmail();      // 해당방의 특정 유저를 받아와야 하기에 추가
        this.userNickname = resultSet.getNickname();
        this.userProfileImageUrl = resultSet.getProfileImageUrl();
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
