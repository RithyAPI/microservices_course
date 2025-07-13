package com.ut.utAttendance.service;

import com.ut.utAttendance.model.ModuleTypeFilter;
import com.ut.utAttendance.model.base.BaseResult;
import com.ut.utAttendance.model.base.ResponseMessage;

import javax.servlet.http.HttpServletRequest;
import java.net.UnknownHostException;

public interface ModuleTypeService {

  ResponseMessage<BaseResult> getList(ModuleTypeFilter filter, HttpServletRequest httpServletRequest) throws UnknownHostException;

  ResponseMessage<BaseResult> getOne(Long id, HttpServletRequest httpServletRequest) throws UnknownHostException;

}