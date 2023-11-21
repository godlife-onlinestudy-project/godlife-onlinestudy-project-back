package com.godlife.godlifeback.entity.primarykey;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserAttendanceInformationPk implements Serializable{
    @Column(name = "study_number")
    private int studyNumber;
    @Column(name = "user_email")
    private String userEmail;
}
