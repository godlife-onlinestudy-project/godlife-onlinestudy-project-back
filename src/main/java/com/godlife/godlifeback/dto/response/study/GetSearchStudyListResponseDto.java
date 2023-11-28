package com.godlife.godlifeback.dto.response.study;

import com.godlife.godlifeback.dto.response.ResponseCode;
import com.godlife.godlifeback.dto.response.ResponseDto;
import com.godlife.godlifeback.dto.response.ResponseMessage;
import com.godlife.godlifeback.entity.StudyViewEntity;
import com.godlife.godlifeback.common.object.StudyListItem;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.Getter;

@Getter
public class GetSearchStudyListResponseDto extends ResponseDto {

  private List<StudyListItem> searchList;

  private GetSearchStudyListResponseDto(String code, String message, List<StudyViewEntity> studyViewEntities) {
    super(code, message);
    this.searchList = StudyListItem.getStudyList(studyViewEntities);
  }

  public static ResponseEntity<GetSearchStudyListResponseDto> success(List<StudyViewEntity> studyViewEntities) {
    GetSearchStudyListResponseDto result = new GetSearchStudyListResponseDto(ResponseCode.SUCCESS,
        ResponseMessage.SUCCESS, studyViewEntities);
    return ResponseEntity.status(HttpStatus.OK).body(result);
  }

}
