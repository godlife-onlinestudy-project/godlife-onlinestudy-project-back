package com.godlife.godlifeback.dto.response.study;

import com.godlife.godlifeback.common.object.StudyListItem;
import com.godlife.godlifeback.dto.response.ResponseCode;
import com.godlife.godlifeback.dto.response.ResponseDto;
import com.godlife.godlifeback.dto.response.ResponseMessage;
import com.godlife.godlifeback.entity.StudyViewEntity;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetTop5StudyListResponseDto extends ResponseDto {

  private List<StudyListItem> top5List;

  private GetTop5StudyListResponseDto(String code, String message, List<StudyViewEntity> studyViewEntities) {
    super(code, message);
    this.top5List = StudyListItem.getStudyList(studyViewEntities);
  }

  public static ResponseEntity<GetTop5StudyListResponseDto> success(List<StudyViewEntity> studyViewEntities) {
    GetTop5StudyListResponseDto result = new GetTop5StudyListResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS,
        studyViewEntities);
    return ResponseEntity.status(HttpStatus.OK).body(result);
  }

}
