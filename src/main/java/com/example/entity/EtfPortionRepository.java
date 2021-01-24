package com.example.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EtfPortionRepository extends JpaRepository<EtfPortion, Long> {
    public EtfPortion findByCharIdAndAccountAndSectorCode(String charId, String account, String sectorCode);
    public List<EtfPortion> findByCharIdAndAccount(String charId, String account);
//    @Query("update p Etf_Portion p set p.where p.charId = ?1 and p.account = ?2")
//    User getByCharIdAndAccountAndSectorCode(String charId, String account);
}