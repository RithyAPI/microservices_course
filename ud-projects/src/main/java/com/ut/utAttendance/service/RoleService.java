package com.ut.utAttendance.service;

import com.ut.utAttendance.model.RoleData;
import com.ut.utAttendance.model.RoleDataUpdate;
import com.ut.utAttendance.model.base.BaseResult;
import com.ut.utAttendance.model.base.Filter;
import com.ut.utAttendance.model.base.ResponseMessage;
import org.springframework.validation.BindingResult;

import javax.servlet.http.HttpServletRequest;
import java.net.UnknownHostException;

public interface RoleService {

  ResponseMessage<BaseResult> getList(Filter filter, HttpServletRequest httpServletRequest) throws UnknownHostException;

  ResponseMessage<BaseResult> getOne(Long id, HttpServletRequest httpServletRequest) throws UnknownHostException;

  ResponseMessage<BaseResult> menu(HttpServletRequest httpServletRequest) throws UnknownHostException;

  ResponseMessage<BaseResult> insert(RoleData roleData, BindingResult bindingResult, HttpServletRequest httpServletRequest) throws UnknownHostException;

  ResponseMessage<BaseResult> update(RoleDataUpdate roleDataUpdate, BindingResult bindingResult, HttpServletRequest httpServletRequest) throws UnknownHostException;

  ResponseMessage<BaseResult> delete(Long id, HttpServletRequest httpServletRequest) throws UnknownHostException;

}