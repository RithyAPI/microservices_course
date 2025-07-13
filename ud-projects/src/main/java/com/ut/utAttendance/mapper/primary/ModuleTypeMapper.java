package com.ut.utAttendance.mapper.primary;

import com.ut.utAttendance.model.ModuleType;
import com.ut.utAttendance.model.base.Filter;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModuleTypeMapper {

  List<ModuleType> getList(@Param("filter") Filter filter);

  Long countList(@Param("filter") Filter filter);

  List<ModuleType> getOne(@Param("id") Long id);

}