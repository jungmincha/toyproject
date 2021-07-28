package com.example.backend.domain.repository;


import java.util.List;
import com.example.backend.domain.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReplyRepository extends JpaRepository<Reply , Long> {

    @Query(nativeQuery = true , value = "select * from reply r inner join issue_board i on r.bid = i.bid where i.bid IN (:bid)")
    List<Reply> findByBoard_id(@Param("bid")Long bid );

    @Modifying
    @Query(nativeQuery = true , value = "delete from reply where bid IN (:bid)")
    void deleteBoard_id(@Param("bid")Long bid );
    
}