package com.example.backend.domain.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="issue_board")
@NoArgsConstructor(access=AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Getter
public class Issue_board {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "bid")
    private Long bid; 

    @Column(nullable = false)
    private String btitle;

    @Column(nullable = false)
    private String bname;
    
    @Column(columnDefinition="TEXT" , nullable = false)
    private String bcontent;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime bdate;

    @Column(nullable = false)
    private int bhit;

    @Builder
    public Issue_board(Long bid, String btitle, String bname, String bcontent , int bhit) {

        this.bid = bid;
        this.btitle = btitle;
        this.bname = bname;
        this.bcontent = bcontent;
        this.bhit = bhit;
    }
   
}
