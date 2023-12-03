package com.godlife.godlifeback.service.implement;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import com.godlife.godlifeback.dto.request.study.PatchStudyRequestDto;
import com.godlife.godlifeback.dto.request.study.PostStudyRequestDto;
import com.godlife.godlifeback.dto.request.studyService.PatchStudyNoticeRequestDto;
import com.godlife.godlifeback.dto.request.studyService.PatchStudyTodoListRequestDto;
import com.godlife.godlifeback.dto.request.studyService.PostStudyNoticeRequestDto;
import com.godlife.godlifeback.dto.request.studyService.PostStudyToDoListRequestDto;
import com.godlife.godlifeback.dto.response.ResponseDto;
import com.godlife.godlifeback.dto.response.study.GetSearchStudyListResponseDto;
import com.godlife.godlifeback.dto.response.study.GetSearchWordStudyListResponseDto;
import com.godlife.godlifeback.dto.response.study.DeleteStudyUserListResponseDto;
import com.godlife.godlifeback.dto.response.study.GetModifyStudyResponseDto;
import com.godlife.godlifeback.dto.response.study.GetStudyUserListResponseDto;
import com.godlife.godlifeback.dto.response.study.PatchStudyResponseDto;
import com.godlife.godlifeback.dto.response.study.PostStudyResponseDto;
import com.godlife.godlifeback.dto.response.studyService.DeleteStudyNoticeResponseDto;
import com.godlife.godlifeback.dto.response.studyService.DeleteStudyTodoListResponseDto;
import com.godlife.godlifeback.dto.response.studyService.GetStudyNoticeListResponseDto;
import com.godlife.godlifeback.dto.response.studyService.GetStudyResponseDto;
import com.godlife.godlifeback.dto.response.studyService.GetStudyTodoListResponseDto;
import com.godlife.godlifeback.dto.response.studyService.PatchStudyNoticeResponseDto;
import com.godlife.godlifeback.dto.response.studyService.PatchStudyTodoListResponseDto;
import com.godlife.godlifeback.dto.response.studyService.PostStudyNoticeResponseDto;
import com.godlife.godlifeback.dto.response.studyService.PostStudyTodoListResponseDto;
import com.godlife.godlifeback.entity.StudyEntity;
import com.godlife.godlifeback.entity.StudyNoticeEntity;
import com.godlife.godlifeback.entity.StudyTodolistEntity;
import com.godlife.godlifeback.entity.StudyUserListEntity;
import com.godlife.godlifeback.repository.StudyNoticeRepository;
import com.godlife.godlifeback.repository.StudyRepository;
import com.godlife.godlifeback.repository.StudyToDoListRepository;
import com.godlife.godlifeback.repository.StudyUserListRepository;
import com.godlife.godlifeback.repository.resultSet.StudyNoticeListResultSet;
import com.godlife.godlifeback.repository.resultSet.StudyToDoListResultSet;
import com.godlife.godlifeback.repository.resultSet.StudyUserListResultSet;
import com.godlife.godlifeback.dto.response.study.GetTop5StudyListResponseDto;
import com.godlife.godlifeback.entity.StudyViewEntity;
import com.godlife.godlifeback.repository.StudyViewRespository;
import com.godlife.godlifeback.repository.UserRepository;
import com.godlife.godlifeback.service.StudyService;

import lombok.RequiredArgsConstructor;

// import java.util.List;
// import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class StudyServiceImplement implements StudyService {

    private final StudyRepository studyRepository;
    private final StudyUserListRepository studyUserListRepository;
    private final StudyViewRespository studyViewRespository;


    private final UserRepository userRepository;
    

    Date now = Date.from(Instant.now());
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String DaysAgo = simpleDateFormat.format(now);


    @Override
    public ResponseEntity<? super GetModifyStudyResponseDto> getModifyStudy(Integer studyNumber, String userEmail) {


      StudyEntity studyEntity = null;

      try {

        studyEntity = studyRepository.findByStudyNumber(studyNumber);
        if (studyEntity == null)
          return GetModifyStudyResponseDto.notExistStudy();

      } catch (Exception exception) {
        exception.printStackTrace();
        return ResponseDto.databaseError();
      }

      return GetModifyStudyResponseDto.success(studyEntity);
    }

  @Override
  public ResponseEntity<? super GetStudyUserListResponseDto> getStudyUserList(Integer studyNumber, String userEmail) {

    List<StudyUserListResultSet> studyUserListResultSets = new ArrayList<>();

    try {

      // boolean existedUser = userRepository.existsByEmail(userEmail);
      // if(!existedUser) return PostUserResponseDto.notExistsUser();

      boolean existedStudy = studyRepository.existsByStudyNumber(studyNumber);
      if (!existedStudy)
        return GetStudyUserListResponseDto.notExistStudy();

      boolean existedUserList = studyUserListRepository.existsByUserEmailAndStudyNumber(userEmail, studyNumber);
      if (!existedUserList)
        return GetStudyUserListResponseDto.notExistUser();

      studyUserListResultSets = studyUserListRepository.findByStudyUserList(studyNumber);

    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }
    return GetStudyUserListResponseDto.success(studyUserListResultSets);
  }

  @Override
  public ResponseEntity<? super PostStudyResponseDto> postStudy(PostStudyRequestDto dto, String userEmail) {

    try {

      StudyEntity studyEntity = new StudyEntity(dto, userEmail);
      studyRepository.save(studyEntity);

      Integer studyNumber = studyEntity.getStudyNumber();

    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }

    return PostStudyResponseDto.success();
  }

  @Override
  public ResponseEntity<? super PatchStudyResponseDto> patchStudy(PatchStudyRequestDto dto, Integer studyNumber,
      String userEmail) {

    try {

      StudyEntity studyEntity = studyRepository.findByStudyNumber(studyNumber);
      if (studyEntity == null)
        return PatchStudyResponseDto.notExistStudy();

      boolean equalCreater = studyEntity.getCreateStudyUserEmail().equals(userEmail);
      if (!equalCreater)
        return PatchStudyResponseDto.noPermission();

      studyEntity.patch(dto);
      studyRepository.save(studyEntity);

    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }

    return PatchStudyResponseDto.success();
  }

  @Override
  public ResponseEntity<? super DeleteStudyUserListResponseDto> deleteStudyUserList(Integer studyNumber,
      String userEmail, String createStudyUserEmail) {

    try {

      StudyEntity studyEntity = studyRepository.findByStudyNumber(studyNumber);
      if (studyEntity == null)
        return DeleteStudyUserListResponseDto.notExistStudy();

      boolean isCreater = studyEntity.getCreateStudyUserEmail().equals(createStudyUserEmail);
      if (!isCreater)
        return DeleteStudyUserListResponseDto.noPermission();

      StudyUserListEntity studyUserListEntity = studyUserListRepository.findByStudyNumberAndUserEmail(studyNumber,
          userEmail);
      if (studyUserListEntity == null)
        return DeleteStudyUserListResponseDto.notExistUser();

      studyUserListRepository.delete(studyUserListEntity);

    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }

    return DeleteStudyUserListResponseDto.success();

  }

  @Override
  public ResponseEntity<? super GetTop5StudyListResponseDto> getTop5StudyList(String studyCategory1, String email) {

    List<StudyViewEntity> studyViewEntities = new ArrayList<>();

    try {

        studyViewEntities = studyViewRespository.findTop5ByStudyCategory1AndStudyEndDateGreaterThanOrderByStudyEndDateDesc(studyCategory1, DaysAgo);
    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }

    return GetTop5StudyListResponseDto.success(studyViewEntities);

  }

  @Override
  public ResponseEntity<? super GetSearchStudyListResponseDto> getSearchStudyList(String Email) {

    List<StudyViewEntity> studyViewEntities = new ArrayList<>();

      try {
        studyViewEntities = studyViewRespository.findByStudyEndDateGreaterThanOrderByStudyPublicCheckDescStudyEndDateDesc(DaysAgo);
      } catch (Exception exception) {
        exception.printStackTrace();
        return ResponseDto.databaseError();
      }

      return GetSearchStudyListResponseDto.success(studyViewEntities);
  }

    @Override
    public ResponseEntity<? super GetSearchWordStudyListResponseDto> getSearchWordStudyList(String studyName,String Email) {
      List<StudyViewEntity> studyViewEntities = new ArrayList<>();

      try {
        studyViewEntities = studyViewRespository
            .findByStudyNameContainsAndStudyEndDateGreaterThanOrderByStudyEndDateDesc(studyName, DaysAgo);
      } catch (Exception exception) {
        exception.printStackTrace();
        return ResponseDto.databaseError();
      }      

      return GetSearchWordStudyListResponseDto.success(studyViewEntities);
    }

    
    private final StudyNoticeRepository studyNoticeRepository;

    
    @Override
    public ResponseEntity<? super GetStudyNoticeListResponseDto> getNotice(String userEmail,Integer studyNumber) {

        List<StudyNoticeListResultSet> resultSets = new ArrayList<>();
        
        try {

            // 접속 유저가 존재하는지 확인 여부
            boolean existedUser = userRepository.existsByUserEmail(userEmail);
            if(!existedUser ) return GetStudyNoticeListResponseDto.notExistUser();

            // 스터디 방 존재 여부
            boolean existedStudy =  studyRepository.existsByStudyNumber(studyNumber);
            if(!existedStudy) return GetStudyNoticeListResponseDto.notExistStudy();        
            
            
            resultSets = studyNoticeRepository.findByNoticeList(studyNumber);

            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetStudyNoticeListResponseDto.success(resultSets);
    }


    @Override
    public ResponseEntity<? super PostStudyNoticeResponseDto> postNotice(PostStudyNoticeRequestDto dto,String createStudyUserEmail, Integer studyNumber) {

        try {

            // 접속 유저가 존재하는지 확인 여부
            boolean existedUser = userRepository.existsByUserEmail(createStudyUserEmail);
            if(!existedUser ) return PostStudyNoticeResponseDto.notExistUser();

            // 스터디 방 존재 여부
            StudyEntity studyEntity = studyRepository.findByStudyNumber(studyNumber);
            if( studyEntity == null) return PostStudyNoticeResponseDto.notExistStudy();    
            
            //  유저가 방생성 유저인지
            boolean equalCreater = studyEntity.getCreateStudyUserEmail().equals(createStudyUserEmail);
            if(!equalCreater) return PostStudyNoticeResponseDto.noPermission();            
            
            StudyNoticeEntity studyNoticeEntity = new StudyNoticeEntity(dto, studyNumber);
            studyNoticeRepository.save(studyNoticeEntity);            
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return PostStudyNoticeResponseDto.success();
    }

    @Override
    public ResponseEntity<? super PatchStudyNoticeResponseDto> patchNotice(PatchStudyNoticeRequestDto dto,String createStudyUserEmail, Integer studyNumber, Integer studyNoticeNumber) {
        
        try {

            // 접속 유저가 존재하는지 확인 여부
            boolean existedUser = userRepository.existsByUserEmail(createStudyUserEmail);
            if(!existedUser ) return PatchStudyNoticeResponseDto.notExistUser();

            // 스터디 방 존재 여부
            boolean existedStudy =  studyRepository.existsByStudyNumber(studyNumber);
            if(!existedStudy) return PatchStudyNoticeResponseDto.notExistStudy();        

            StudyNoticeEntity studyNoticeEntity = studyNoticeRepository.findByStudyNoticeNumber(studyNoticeNumber);
            if(studyNoticeEntity == null) return PatchStudyNoticeResponseDto.notExistNotice();            
            
            studyNoticeEntity.patchNotice(dto);
            studyNoticeRepository.save(studyNoticeEntity);
            

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return PatchStudyNoticeResponseDto.success();
    }

    @Override
    public ResponseEntity<? super DeleteStudyNoticeResponseDto> deleteNotice(String createStudyUserEmail,Integer studyNumber, Integer studyNoticeNumber) {

        try {
            // 접속 유저가 존재하는지 확인 여부
            boolean existedUser = userRepository.existsByUserEmail(createStudyUserEmail);
            if(!existedUser ) return DeleteStudyNoticeResponseDto.notExistUser();

            // 스터디 방 존재 여부
            boolean existedStudy =  studyRepository.existsByStudyNumber(studyNumber);
            if(!existedStudy) return DeleteStudyNoticeResponseDto.notExistStudy();  
            
            StudyNoticeEntity studyNoticeEntity = studyNoticeRepository.findByStudyNoticeNumber(studyNoticeNumber);
            if(studyNoticeEntity == null) return DeleteStudyNoticeResponseDto.notExistNotice();

            studyNoticeRepository.delete(studyNoticeEntity);;

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return DeleteStudyNoticeResponseDto.success();
    }

    private final StudyToDoListRepository studyToDoListRespository;

    @Override
    public ResponseEntity<? super GetStudyTodoListResponseDto> getTodolist(String userEmail,Integer studyNumber) {

        List<StudyToDoListResultSet> resultSets = new ArrayList<>();

        try {
            boolean existedUser = userRepository.existsByUserEmail(userEmail);
            if(!existedUser) GetStudyTodoListResponseDto.notExistsUser();

            boolean existedStudy =  studyRepository.existsByStudyNumber(studyNumber);
            if(!existedStudy) return GetStudyTodoListResponseDto.notExistStudy();

            resultSets = studyToDoListRespository.findByStudyNumber(studyNumber);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetStudyTodoListResponseDto.success(resultSets);
    }

    @Override
    public ResponseEntity<? super PostStudyTodoListResponseDto> postTodo(PostStudyToDoListRequestDto dto,String createStudyUserEmail, Integer studyNumber) {
        
        try {

            boolean existedUser = userRepository.existsByUserEmail(createStudyUserEmail);
            if(!existedUser ) return PostStudyNoticeResponseDto.notExistUser();

            StudyEntity studyEntity = studyRepository.findByStudyNumber(studyNumber);
            if( studyEntity == null) return PostStudyNoticeResponseDto.notExistStudy();

            //  유저가 방생성 유저인지
            boolean equalCreater = studyEntity.getCreateStudyUserEmail().equals(createStudyUserEmail);
            if(!equalCreater) return PostStudyNoticeResponseDto.noPermission();
            
            StudyTodolistEntity studyTodolistEntity = new StudyTodolistEntity(dto , studyNumber);
            studyToDoListRespository.save(studyTodolistEntity);      

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return PostStudyTodoListResponseDto.success();
    }

    @Override
    public ResponseEntity<? super PatchStudyTodoListResponseDto> patchTodo(PatchStudyTodoListRequestDto dto,String createStudyUserEmail, Integer studyNumber, Integer studyListNumber) {
        
        try {

            boolean existedUser = userRepository.existsByUserEmail(createStudyUserEmail);
            if(!existedUser) return PatchStudyTodoListResponseDto.notExistUser();

            StudyEntity studyEntity = studyRepository.findByStudyNumber(studyNumber);
            if (studyEntity == null) return PatchStudyTodoListResponseDto.notExistStudy();

            boolean equalCreater = studyEntity.getCreateStudyUserEmail().equals(createStudyUserEmail);
            if(!equalCreater) return PatchStudyTodoListResponseDto.noPermission();

            StudyTodolistEntity studyTodolistEntity = studyToDoListRespository.findByStudyListNumber(studyListNumber);
            if(studyTodolistEntity == null) return PatchStudyTodoListResponseDto.notExistToDoList();

            studyTodolistEntity.patchTodoList(dto);
            studyToDoListRespository.save(studyTodolistEntity);            
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return PatchStudyTodoListResponseDto.success();
    }

    @Override
    public ResponseEntity<? super DeleteStudyTodoListResponseDto> deleteTodo(String createStudyUserEmail,Integer studyNumber, Integer studyListNumber) {
        
        try {
            boolean existedUser = userRepository.existsByUserEmail(createStudyUserEmail);
            if(!existedUser) return  DeleteStudyTodoListResponseDto.notExistUser();

            StudyEntity studyEntity = studyRepository.findByStudyNumber(studyNumber);
            if (studyEntity == null) return DeleteStudyTodoListResponseDto.notExistStudy();
            

            boolean equalCreater = studyEntity.getCreateStudyUserEmail().equals(createStudyUserEmail);
            if(!equalCreater) return DeleteStudyTodoListResponseDto.noPermission();

            StudyTodolistEntity studyTodolistEntity = studyToDoListRespository.findByStudyListNumber(studyListNumber);
            if(studyTodolistEntity == null) return DeleteStudyTodoListResponseDto.notExistToDoList();

            studyToDoListRespository.delete(studyTodolistEntity);            

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return DeleteStudyTodoListResponseDto.success();
    }

    @Override
    public ResponseEntity<? super GetStudyResponseDto> getStudy(String userEmail, Integer studyNumber) {

        StudyEntity studyEntity = null;

        try {
            
            boolean existedUser = userRepository.existsByUserEmail(userEmail);
            if(!existedUser) return  GetStudyResponseDto.notExistUser();

            boolean  existedStudy = studyRepository.existsByStudyNumber(studyNumber);
            if(!existedStudy) return  GetStudyResponseDto.notExistStudy();
 
            studyEntity = studyRepository.findByStudyNumber(studyNumber);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetStudyResponseDto.success(studyEntity);
    }


}
