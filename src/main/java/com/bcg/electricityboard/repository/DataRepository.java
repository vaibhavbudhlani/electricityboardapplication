package com.bcg.electricityboard.repository;

import com.bcg.electricityboard.model.Records;
import com.bcg.electricityboard.model.RecordsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.Date;
import java.util.List;

@Repository
public interface DataRepository extends JpaRepository<RecordsEntity,Integer> {
    RecordsEntity findByIdNumber(float id);

//    @Query("SELECT e FROM YourEntity e WHERE e.dateOfApplication " +
//            "BETWEEN TO_DATE(:startDate, 'dd-MM-yyyy') AND TO_DATE(:endDate, 'dd-MM-yyyy')")
//    List<Records> findBetweenDates(@Param("startDate") String startDate, @Param("endDate") String endDate);

    List<RecordsEntity> findByDateOfApplicationBetween(Date startDate, Date endDate);
}
