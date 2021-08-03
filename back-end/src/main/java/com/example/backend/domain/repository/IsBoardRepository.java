package com.example.backend.domain.repository;


import com.example.backend.domain.entity.Issue_boardEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface IsBoardRepository extends JpaRepository<Issue_boardEntity , Long>{

    @Modifying
    @Query(nativeQuery = true , value = "update issue_board set bhit = bhit + 1 where bid IN (:bid)")
    void uphit(Long bid);

}
