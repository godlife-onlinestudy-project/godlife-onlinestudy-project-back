package com.godlife.godlifeback.service.implement;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import com.godlife.godlifeback.dto.request.study.PatchStudyRequestDto;
import com.godlife.godlifeback.dto.request.study.PostStudyRequestDto;
import com.godlife.godlifeback.dto.request.studyService.PatchNoticeRequestDto;
import com.godlife.godlifeback.dto.request.studyService.PatchToDoListRequestDto;
import com.godlife.godlifeback.dto.request.studyService.PostNoticeRequestDto;
import com.godlife.godlifeback.dto.request.studyService.PostToDoListRequestDto;
import com.godlife.godlifeback.dto.response.ResponseDto;
import com.godlife.godlifeback.dto.response.study.GetSearchStudyListResponseDto;
import com.godlife.godlifeback.dto.response.study.GetSearchWordStudyListResponseDto;
import com.godlife.godlifeback.dto.response.study.DeleteStudyUserListResponseDto;
import com.godlife.godlifeback.dto.response.study.GetModifyStudyResponseDto;
import com.godlife.godlifeback.dto.response.study.GetStudyUserListResponseDto;
import com.godlife.godlifeback.dto.response.study.PatchStudyResponseDto;
import com.godlife.godlifeback.dto.response.study.PostStudyResponseDto;
import com.godlife.godlifeback.dto.response.studyService.DeleteNoticeResponseDto;
import com.godlife.godlifeback.dto.response.studyService.DeleteToDoListResponseDto;
import com.godlife.godlifeback.dto.response.studyService.GetNoticeListResponseDto;
import com.godlife.godlifeback.dto.response.studyService.GetStudyResponseDto;
import com.godlife.godlifeback.dto.response.studyService.GetToDoListResponseDto;
import com.godlife.godlifeback.dto.response.studyService.PatchNoticeResponseDto;
import com.godlife.godlifeback.dto.response.studyService.PatchToDoListResponseDto;
import com.godlife.godlifeback.dto.response.studyService.PostNoticeResponseDto;
import com.godlife.godlifeback.dto.response.studyService.PostToDoListResponseDto;
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

      System.out.println(userEmail);

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
    public ResponseEntity<? super GetNoticeListResponseDto> getNotice(String userEmail,Integer studyNumber) {

        List<StudyNoticeListResultSet> resultSets = new ArrayList<>();
        
        try {

            // 접속 유저가 존재하는지 확인 여부
            boolean existedUser = userRepository.existsByUserEmail(userEmail);
            if(!existedUser ) return GetNoticeListResponseDto.notExistUser();

            // 스터디 방 존재 여부
            boolean existedStudy =  studyRepository.existsByStudyNumber(studyNumber);
            if(!existedStudy) return GetNoticeListResponseDto.notExistStudy();        
            
            resultSets = studyNoticeRepository.findByNoticeList(studyNumber);

            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetNoticeListResponseDto.success(resultSets);
    }


    @Override
    public ResponseEntity<? super PostNoticeResponseDto> postNotice(PostNoticeRequestDto dto,String createStudyUserEmail, Integer studyNumber) {

        try {

            // 접속 유저가 존재하는지 확인 여부
            boolean existedUser = userRepository.existsByUserEmail(createStudyUserEmail);
            if(!existedUser ) return PostNoticeResponseDto.notExistUser();

            // 스터디 방 존재 여부
            boolean existedStudy =  studyRepository.existsByStudyNumber(studyNumber);
            if(!existedStudy) return PostNoticeResponseDto.notExistStudy();         
            
            StudyNoticeEntity studyNoticeEntity = new StudyNoticeEntity(dto, studyNumber);
            studyNoticeRepository.save(studyNoticeEntity);            
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return PostNoticeResponseDto.success();
    }

    @Override
    public ResponseEntity<? super PatchNoticeResponseDto> patchNotice(PatchNoticeRequestDto dto,String createStudyUserEmail, Integer studyNumber, Integer studyNoticeNumber) {
        
        try {

            // 접속 유저가 존재하는지 확인 여부
            boolean existedUser = userRepository.existsByUserEmail(createStudyUserEmail);
            if(!existedUser ) return PatchNoticeResponseDto.notExistUser();

            // 스터디 방 존재 여부
            boolean existedStudy =  studyRepository.existsByStudyNumber(studyNumber);
            if(!existedStudy) return PatchNoticeResponseDto.notExistStudy();        

            StudyNoticeEntity studyNoticeEntity = studyNoticeRepository.findByStudyNoticeNumber(studyNoticeNumber);
            if(studyNoticeEntity == null) return PatchNoticeResponseDto.notExistNotice();            
            
            studyNoticeEntity.patchNotice(dto);
            studyNoticeRepository.save(studyNoticeEntity);
            

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return PatchNoticeResponseDto.success();
    }

    @Override
    public ResponseEntity<? super DeleteNoticeResponseDto> deleteNotice(String createStudyUserEmail,Integer studyNumber, Integer studyNoticeNumber) {

        try {
            // 접속 유저가 존재하는지 확인 여부
            boolean existedUser = userRepository.existsByUserEmail(createStudyUserEmail);
            if(!existedUser ) return DeleteNoticeResponseDto.notExistUser();

            // 스터디 방 존재 여부
            boolean existedStudy =  studyRepository.existsByStudyNumber(studyNumber);
            if(!existedStudy) return DeleteNoticeResponseDto.notExistStudy();  
            
            StudyNoticeEntity studyNoticeEntity = studyNoticeRepository.findByStudyNoticeNumber(studyNoticeNumber);
            if(studyNoticeEntity == null) return DeleteNoticeResponseDto.notExistNotice();

            studyNoticeRepository.delete(studyNoticeEntity);;

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return DeleteNoticeResponseDto.success();
    }

    private final StudyToDoListRepository studyToDoListRespository;

    @Override
    public ResponseEntity<? super GetToDoListResponseDto> getTodolist(String userEmail,Integer studyNumber) {

        List<StudyToDoListResultSet> resultSets = new ArrayList<>();

        try {
            boolean existedUser = userRepository.existsByUserEmail(userEmail);
            if(!existedUser) GetToDoListResponseDto.notExistsUser();

            boolean existedStudy =  studyRepository.existsByStudyNumber(studyNumber);
            if(!existedStudy) return GetToDoListResponseDto.notExistStudy();

            resultSets = studyToDoListRespository.findByStudyNumber(studyNumber);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetToDoListResponseDto.success(resultSets);
    }

    @Override
    public ResponseEntity<? super PostToDoListResponseDto> postTodo(PostToDoListRequestDto dto,String createStudyUserEmail, Integer studyNumber) {
        
        try {
            StudyEntity studyEntity = studyRepository.findByStudyNumber(studyNumber);
            if( studyEntity == null) return PostNoticeResponseDto.notExistStudy();

            //  유저가 방생성 유저인지
            boolean equalCreater = studyEntity.getCreateStudyUserEmail().equals(createStudyUserEmail);
            if(!equalCreater) return PostNoticeResponseDto.noPermission();
            
            StudyTodolistEntity studyTodolistEntity = new StudyTodolistEntity(dto , studyNumber);
            studyToDoListRespository.save(studyTodolistEntity);            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return PostToDoListResponseDto.success();
    }

    @Override
    public ResponseEntity<? super PatchToDoListResponseDto> patchTodo(PatchToDoListRequestDto dto,String createStudyUserEmail, Integer studyNumber, Integer studyListNumber) {
        
        try {

            boolean existedUser = userRepository.existsByUserEmail(createStudyUserEmail);
            if(!existedUser) return PatchToDoListResponseDto.notExistUser();

            StudyEntity studyEntity = studyRepository.findByStudyNumber(studyNumber);
            if (studyEntity == null) return PatchToDoListResponseDto.notExistStudy();

            boolean equalCreater = studyEntity.getCreateStudyUserEmail().equals(createStudyUserEmail);
            if(!equalCreater) return PatchToDoListResponseDto.noPermission();

            StudyTodolistEntity studyTodolistEntity = studyToDoListRespository.findByStudyListNumber(studyListNumber);
            if(studyTodolistEntity == null) return PatchToDoListResponseDto.notExistToDoList();

            studyTodolistEntity.patchTodoList(dto);
            studyToDoListRespository.save(studyTodolistEntity);            
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return PatchToDoListResponseDto.success();
    }

    @Override
    public ResponseEntity<? super DeleteToDoListResponseDto> deleteTodo(String createStudyUserEmail,Integer studyNumber, Integer studyListNumber) {
        
        try {
            boolean existedUser = userRepository.existsByUserEmail(createStudyUserEmail);
            if(!existedUser) return  DeleteToDoListResponseDto.notExistUser();

            StudyEntity studyEntity = studyRepository.findByStudyNumber(studyNumber);
            if (studyEntity == null) return DeleteToDoListResponseDto.notExistStudy();
            

            boolean equalCreater = studyEntity.getCreateStudyUserEmail().equals(createStudyUserEmail);
            if(!equalCreater) return DeleteToDoListResponseDto.noPermission();

            StudyTodolistEntity studyTodolistEntity = studyToDoListRespository.findByStudyListNumber(studyListNumber);
            if(studyTodolistEntity == null) return DeleteToDoListResponseDto.notExistToDoList();

            studyToDoListRespository.delete(studyTodolistEntity);            

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return DeleteToDoListResponseDto.success();
    }

    @Override
    public ResponseEntity<? super GetStudyResponseDto> getStudy(String userEmail, Integer studyNumber) {

        StudyEntity studyEntity = null;

        try {
            
            boolean existedUser = userRepository.existsByUserEmail(userEmail);
            if(!existedUser) return  GetStudyResponseDto.notExistUser();

            studyEntity = studyRepository.findByStudyNumber(studyNumber);
            // Integer studyNumber = studyEntity.getStudyNumber();

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetStudyResponseDto.success(studyEntity);
    }


}
