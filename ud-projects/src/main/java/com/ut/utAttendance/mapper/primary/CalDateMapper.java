package com.ut.utAttendance.mapper.primary;


import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface CalDateMapper {

  Long countNumberOfDay(@Param("startDate") String startDate, @Param("endDate") String endDate);

  String minusOneDay(@Param("date") String date);
}