package com.ut.utAttendance.controller;

import com.ut.utAttendance.model.MessageService;
import com.ut.utAttendance.model.base.BaseResult;
import com.ut.utAttendance.model.base.ResponseMessage;
import com.ut.utAttendance.model.filter.ActivityFilter;
import com.ut.utAttendance.service.ActivityLogService;
import io.micrometer.core.annotation.Timed;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.UnknownHostException;

@RestController
@RequestMapping("/system-activity")
@Api(tags = "24. System Activity", description = "System Activity Resource")
@Timed
public class ActivityController {

    @Autowired
    private ActivityLogService activityLogService;

    @Autowired
    private MessageService messageService;

    @PostMapping("/list")
    @ApiOperation(value = "System Activity (List)", notes = "statusCode: 400: Bad Request (Invalid Parameter); 401: Unauthorized (Token Expired or Invalid); 200: Success")
    public ResponseMessage<BaseResult> getList(@RequestBody ActivityFilter filter, HttpServletRequest httpServletRequest) throws UnknownHostException {
        return activityLogService.getList(filter, httpServletRequest);
    }

    @PostMapping("/find/{id}")
    @ApiOperation(value = "Find System Activity by id", notes = "statusCode: 400: Bad Request (Invalid Parameter); 401: Unauthorized (Token Expired or Invalid); 200: Success")
    public ResponseMessage<BaseResult> findById(@PathVariable("id") Long id, HttpServletRequest httpServletRequest) throws UnknownHostException {
        return activityLogService.getOne(id, httpServletRequest);
    }
}