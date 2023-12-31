package com.godlife.godlifeback.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.godlife.godlifeback.entity.StudyUserListEntity;
import com.godlife.godlifeback.entity.primaryKey.StudyUserListPK;
import com.godlife.godlifeback.repository.resultSet.StudyUserListResultSet;

@Repository
public interface StudyUserListRepository extends JpaRepository<StudyUserListEntity, StudyUserListPK> {

  boolean existsByUserEmailAndStudyNumber(String userEmail, Integer studyNumber);

  StudyUserListEntity findByStudyNumberAndUserEmail(Integer studyNumber, String userEmail);

  @Query(value = "SELECT " +
      "U.user_email AS email, " +
      "U.user_nickname AS nickname, " +
      "U.user_profile_image_url AS profileImageUrl, " +
      "S.study_grade AS studyGrade " +
      "FROM study_user_list AS S " +
      "INNER JOIN user AS U " +
      "ON S.user_email = U.user_email " +
      "WHERE S.study_number = ?1 " +
      "ORDER BY S.study_grade ASC ", nativeQuery = true)
  List<StudyUserListResultSet> findByStudyUserList(Integer studyNumber);

  @Transactional
  void deleteByUserEmail(String userEmail);
}
