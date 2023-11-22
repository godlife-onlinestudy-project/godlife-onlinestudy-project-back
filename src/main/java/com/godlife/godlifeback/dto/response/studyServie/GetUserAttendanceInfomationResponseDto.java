package com.godlife.godlifeback.dto.response.studyServie;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.godlife.godlifeback.common.object.UserAttendanceInformationListItem;
import com.godlife.godlifeback.dto.response.ResponseCode;
import com.godlife.godlifeback.dto.response.ResponseDto;
import com.godlife.godlifeback.dto.response.ResponseMessage;
import com.godlife.godlifeback.repository.resultSet.UserAttendanceInformationResultset;

import lombok.Getter;

@Getter
public class GetUserAttendanceInfomationResponseDto extends ResponseDto{
    
    private List<UserAttendanceInformationListItem> userAttendanceInformationList;
    
    private GetUserAttendanceInfomationResponseDto(String code, String message, List<UserAttendanceInformationResultset> resultSets){
        super(code, message);
        this.userAttendanceInformationList = UserAttendanceInformationListItem.getUserAttendanceInformationList(resultSets);
    }

    public static ResponseEntity<GetUserAttendanceInfomationResponseDto> success(List<UserAttendanceInformationResultset> resultSets){
        GetUserAttendanceInfomationResponseDto result = new GetUserAttendanceInfomationResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS, resultSets);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> notExistUserAttendanceInformation(){
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXIST_USER_ATTENDANCE_INFORMATION, ResponseMessage.NOT_EXIST_USER_ATTENDANCE_INFORMATION);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }
}
