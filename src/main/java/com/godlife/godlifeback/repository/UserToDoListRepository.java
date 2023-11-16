package com.godlife.godlifeback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.godlife.godlifeback.entity.UserToDoListEntity;

@Repository
public interface UserToDoListRepository extends JpaRepository<UserToDoListEntity, Integer> {

  List<UserToDoListEntity> findByEmailContainsAndUserListDatetimeContainsOrderByUserListNumber(String email, String userListDatetime);
  
}
