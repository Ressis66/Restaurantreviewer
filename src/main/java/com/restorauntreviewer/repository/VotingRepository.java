package com.restorauntreviewer.repository;
import com.restorauntreviewer.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
@Repository
public interface VotingRepository extends JpaRepository<Vote, Long> {

    @Query("SELECT v FROM Vote v JOIN FETCH v.restaurant WHERE v.user.id =?1 and v.dcreated = ?2 ORDER BY v.dcreated DESC")
    List<Vote> getVotesByUserIdByDate(Long userId, LocalDate date);

    @Override
    @Transactional
    <S extends Vote> S save(S vote);
}
