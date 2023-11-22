package com.godlife.godlifeback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.godlife.godlifeback.entity.UserToDoListEntity;

public interface UserToDoListRepository extends JpaRepository<UserToDoListEntity, Integer> {

  boolean existsByUserEmail(String userEmail);

  boolean existsByUserListNumber(int userListNumber);

  UserToDoListEntity findByUserListNumber(Integer userListNumber);

  List<UserToDoListEntity> findByUserListNumberIn(List<Integer> userListNumber);

}
