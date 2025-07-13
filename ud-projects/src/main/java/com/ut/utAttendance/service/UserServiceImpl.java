package com.ut.utAttendance.service;

import com.ut.utAttendance.base.UserAuthSession;
import com.ut.utAttendance.helper.FileUploadUtils;
import com.ut.utAttendance.helper.ResponseMessageUtils;
import com.ut.utAttendance.mapper.primary.ModuleMapper;
import com.ut.utAttendance.mapper.primary.PermissionMapper;
import com.ut.utAttendance.mapper.primary.RoleMapper;
import com.ut.utAttendance.mapper.primary.UserMapper;
import com.ut.utAttendance.model.MessageService;
import com.ut.utAttendance.model.ModuleType;
import com.ut.utAttendance.model.Users.User;
import com.ut.utAttendance.model.base.BaseResult;
import com.ut.utAttendance.model.base.Filter;
import com.ut.utAttendance.model.base.Pagination;
import com.ut.utAttendance.model.base.ResponseMessage;
import com.ut.utAttendance.model.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.net.UnknownHostException;
import java.time.LocalTime;
import java.util.List;
import java.util.Locale;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ModuleMapper moduleMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private PermissionMapper permissionMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private MessageService messageService;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private ActivityLogService activityLogService;

    @Autowired
    Environment environment;

    public ResponseMessage<BaseResult> getList(Filter filter, HttpServletRequest httpServletRequest) throws UnknownHostException {
        LocalTime startDuration = LocalTime.now();
        Long line = 1033L;
        try {
            // Check Permission
            Long userId = userService.getUserAuth().getId();
            if (permissionMapper.checkPermission(userId, "User (View)") == 0) {
                return ResponseMessageUtils.makeResponseByPermission(true, messageService.message("No Permission access.", false));
            }

            Pagination pagination = new Pagination();
            pagination.setPage(filter.getPage());
            pagination.setRowsPerPage(filter.getRowsPerPage());
            pagination.setTotal(userMapper.countList(filter));
            filter.setPage((filter.getPage() - 1) * filter.getRowsPerPage());

            List<UserResponse> userList = userMapper.getList(filter);
            if (userList != null && userList.size() > 0) {
                for (UserResponse userResponse : userList) {
                    userResponse.setUserRoleList(userMapper.getOneUserGroupList(userResponse.getId()));
                }
            }
            /*System Activity*/
            LocalTime endDuration = LocalTime.now();
            activityLogService.insert("/user/list",null,null,"User","User (View)","View",1,"Success",startDuration,endDuration, httpServletRequest);
            return ResponseMessageUtils.makeResponse(true, messageService.message("Success", userList, pagination, true));
        } catch (Exception error) {
            /*System Activity*/
            LocalTime endDuration = LocalTime.now();
            activityLogService.insert("/user/list",line, error.toString(),"User","User (View)","View",2,"Error",startDuration,endDuration, httpServletRequest);
            return ResponseMessageUtils.makeResponse(true, messageService.message("Error", null, false));
        }
    }

    public ResponseMessage<BaseResult> getOne(Long id, HttpServletRequest httpServletRequest) throws UnknownHostException {
        LocalTime startDuration = LocalTime.now();
        Long line = 1033L;
        try {
            // Check Permission
            Long userId = userService.getUserAuth().getId();
            if (permissionMapper.checkPermission(userId, "User (View)") == 0) {
                return ResponseMessageUtils.makeResponseByPermission(true, messageService.message("No Permission access.", false));
            }

            List<User> userList = userMapper.getOne(id);
            if (userList != null && userList.size() > 0) {
                for (User user : userList) {
                    user.setUserRoleList(userMapper.getOneUserGroupList(user.getId()));
                }
            }
            /*System Activity*/
            LocalTime endDuration = LocalTime.now();
            activityLogService.insert("/user/find/{id}",null,null,"User","User (View)","View",1,"Success",startDuration,endDuration, httpServletRequest);
            return ResponseMessageUtils.makeResponse(true, messageService.message("Success", userList, true));
        } catch (Exception error) {
            /*System Activity*/
            LocalTime endDuration = LocalTime.now();
            activityLogService.insert("/user/find/{id}",line, error.toString(),"User","User (View)","View",2,"Error",startDuration,endDuration, httpServletRequest);
            return ResponseMessageUtils.makeResponse(true, messageService.message("Error", null, false));
        }
    }

    public ResponseMessage<BaseResult> insert(User user, MultipartFile file, HttpServletRequest httpServletRequest) throws UnknownHostException {
        LocalTime startDuration = LocalTime.now();
        Long line = 1033L;
        try {
            // Check Permission
            Long userId = userService.getUserAuth().getId();
            if (permissionMapper.checkPermission(userId, "User (Add)") == 0) {
                return ResponseMessageUtils.makeResponseByPermission(true, messageService.message("No Permission access.", false));
            }

            String passwd = user.getPassword();
            String pattern = "(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}";

            if(passwd != null){
                if(!passwd.matches(pattern)){
                    return ResponseMessageUtils.makeResponse(true, messageService.message("Password must have at least one upperCase, number, 8 characters and special character", false));
                }
            }


            List<User> existingUserList = userMapper.getOneByUsername(user.getUsername());
            if (existingUserList.size() > 0) {
                return ResponseMessageUtils.makeResponse(true, messageService.message("Duplicate User", false));
            }

            // password
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            user.setPassword(passwordEncoder.encode(user.getPassword()));

            // upload Signature
            if (file != null) {
                String fileSignature = FileUploadUtils.saveFileUploaded(file, "logs/" + environment.getProperty("server.servlet.context-path"));
                user.setSignature(fileSignature);
            }

            // check data
            user.setCreatedBy(userId);
            user.setIsActive(1);

            Boolean result = userMapper.insert(user);
            if (result) {
                // check user role
                if (user.getUserGroup().length > 0) {
                    insertSystemRoleUser(user.getUserGroup(), user.getId());
                }

                /*System Activity*/
                LocalTime endDuration = LocalTime.now();
                activityLogService.insert("/user/add",null,null,"User","User (Add)","Add",1,"Success",startDuration,endDuration, httpServletRequest);
                return ResponseMessageUtils.makeResponse(true, messageService.message("Success", true));
            } else {
                return ResponseMessageUtils.makeResponse(true, messageService.message("Fail", false));
            }
        } catch (Exception error) {
            /*System Activity*/
            LocalTime endDuration = LocalTime.now();
            activityLogService.insert("/user/add",line, error.toString(),"User","User (Add)","Add",2,"Error",startDuration,endDuration, httpServletRequest);
            return ResponseMessageUtils.makeResponse(true, messageService.message("Error", null, false));
        }
    }

    public ResponseMessage<BaseResult> update(User user, MultipartFile file, HttpServletRequest httpServletRequest) throws UnknownHostException {
        LocalTime startDuration = LocalTime.now();
        Long line = 1033L;
        try {
            // Check Permission
            Long userId = userService.getUserAuth().getId();
            if (permissionMapper.checkPermission(userId, "User (Edit)") == 0) {
                return ResponseMessageUtils.makeResponseByPermission(true, messageService.message("No Permission access.", false));
            }

            String passwd = user.getPassword();
            String pattern = "(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}";

            if(passwd != null) {
                if(!passwd.matches(pattern)) {
                    return ResponseMessageUtils.makeResponse(true, messageService.message("Password must have at least one upperCase, number, 8 characters and special character", false));
                }
            }

            if (user.getPassword() != null && !user.getPassword().equals("")) {
                PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                user.setPassword(passwordEncoder.encode(user.getPassword()));
            }

            // upload Signature
            if (file != null) {
                String fileSignature = FileUploadUtils.saveFileUploaded(file, "logs/" + environment.getProperty("server.servlet.context-path"));
                user.setSignature(fileSignature);
            }

            // check Data
            user.setModifiedBy(getUserAuth().getId());
            user.setIsActive(1);

            Boolean result = userMapper.update(user);
            if (result) {
                // check user role
                if (user.getUserGroup().length > 0) {
                    insertSystemRoleUser(user.getUserGroup(), user.getId());
                }
                /*System Activity*/
                LocalTime endDuration = LocalTime.now();
                activityLogService.insert("/user/update",null,null,"User","User (Edit)","Edit",1,"Success",startDuration,endDuration, httpServletRequest);
                return ResponseMessageUtils.makeResponse(true, messageService.message("Success", true));
            } else {
                return ResponseMessageUtils.makeResponse(true, messageService.message("Fail", false));
            }
        } catch (Exception error) {
            /*System Activity*/
            LocalTime endDuration = LocalTime.now();
            activityLogService.insert("/user/update",line, error.toString(),"User","User (Edit)","Edit",2,"Error",startDuration,endDuration, httpServletRequest);
            return ResponseMessageUtils.makeResponse(true, messageService.message("Error", null, false));
        }
    }

    public ResponseMessage<BaseResult> editProfile(User user, HttpServletRequest httpServletRequest) throws UnknownHostException {
        LocalTime startDuration = LocalTime.now();
        Long line = 1033L;
        try {
            // check Data
            user.setModifiedBy(getUserAuth().getId());
            user.setIsActive(1);

            String passwd = user.getPassword();
            String pattern = "(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}";

            if(passwd != null){
                if(!passwd.matches(pattern)){
                    return ResponseMessageUtils.makeResponse(true, messageService.message("Password must have at least one upperCase, number, 8 characters and special character", false));
                }
            }

            Boolean result = userMapper.editProfile(user);
            if (result) {
                /*System Activity*/
                LocalTime endDuration = LocalTime.now();
                activityLogService.insert("/user/edit-profile",null,null,"User","","Edit Profile",1,"Success",startDuration,endDuration, httpServletRequest);
                return ResponseMessageUtils.makeResponse(true, messageService.message("Success", true));
            } else {
                return ResponseMessageUtils.makeResponse(true, messageService.message("Fail", false));
            }
        } catch (Exception error) {
            /*System Activity*/
            LocalTime endDuration = LocalTime.now();
            activityLogService.insert("/user/edit-profile",line, error.toString(),"User","","Edit Profile",2,"Error",startDuration,endDuration, httpServletRequest);
            return ResponseMessageUtils.makeResponse(true, messageService.message("Error", null, false));
        }
    }

    public ResponseMessage<String> delete(Long id, HttpServletRequest httpServletRequest) throws UnknownHostException {
        LocalTime startDuration = LocalTime.now();
        Long line = 1033L;
        try {
            // Check Permission
            Long userId = userService.getUserAuth().getId();
            if (permissionMapper.checkPermission(userId, "User (Delete)") == 0) {
                return ResponseMessageUtils.makeResponseByPermission(true, messageService.message("No Permission access.", false));
            }

            if (id == 1) {
                return ResponseMessageUtils.makeResponse(true, messageService.message("User Admin Cannot Deleted!", false));
            }

            Boolean result = userMapper.delete(id);
            if (result) {
                /*System Activity*/
                LocalTime endDuration = LocalTime.now();
                activityLogService.insert("/user/delete/{id}",null,null,"User","User (Delete)","Delete",1,"Success",startDuration,endDuration, httpServletRequest);
                return ResponseMessageUtils.makeResponse(true, messageService.message("Success", true));
            } else {
                return ResponseMessageUtils.makeResponse(true, messageService.message("Fail", false));
            }
        } catch (Exception error) {
            /*System Activity*/
            LocalTime endDuration = LocalTime.now();
            activityLogService.insert("/user/delete/{id}",line, error.toString(),"User","User (Delete)","Delete",2,"Error",startDuration,endDuration, httpServletRequest);
            return ResponseMessageUtils.makeResponse(true, messageService.message("Error", null, false));
        }
    }

    public ResponseMessage<UserResponse> me(HttpServletRequest httpServletRequest) throws UnknownHostException {
        LocalTime startDuration = LocalTime.now();
        Long line = 1033L;
        try {
            Long userId = userService.getUserAuth().getId();

            List<UserResponse> userList = userMapper.getOneByUserId(userId);
            if (userList != null && userList.size() > 0) {
                userList.get(0).setModuleTypeList(roleMapper.getModule(userId));
                List<ModuleType> moduleTypeList = userList.get(0).getModuleTypeList();

                if (moduleTypeList != null && moduleTypeList.size() > 0) {
                    for (ModuleType moduleType : moduleTypeList) {
                        Long moduleTypeId = moduleType.getId();
                        moduleType.setModuleList(moduleMapper.getOneByUserId(moduleTypeId, userId));
                    }
                }
            }

            /*System Activity*/
            LocalTime endDuration = LocalTime.now();
            activityLogService.insert("/user/me",null,null,"User","","Me",1,"Success",startDuration,endDuration, httpServletRequest);
            assert userList != null;
            return ResponseMessageUtils.makeSuccessResponse(userList.get(0));
        } catch (Exception error) {
            /*System Activity*/
            LocalTime endDuration = LocalTime.now();
            activityLogService.insert("/user/me",line, error.toString(),"User","","Me",2,"Error",startDuration,endDuration, httpServletRequest);
            return ResponseMessageUtils.makeResponse(true, messageService.message("Error", null, false));
        }
    }

    public ResponseMessage<String> changePassword(String oldPassword, String newPassword, HttpServletRequest httpServletRequest) throws UnknownHostException {
        LocalTime startDuration = LocalTime.now();
        Long line = 1033L;
        try {
            List<User> userList = userMapper.getOne(getUserAuth().getId());
            User user = userList.get(0);

            String pattern = "(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}";

            if(newPassword != null){
                if(!newPassword.matches(pattern)){
                    return ResponseMessageUtils.makeResponse(true, messageService.message("Password must have at least one upperCase, number, 8 characters and special character", false));
                }
            }

            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            if (passwordEncoder.matches(oldPassword, user.getPassword())) {
                user.setPassword(passwordEncoder.encode(newPassword));
            } else {
                return ResponseMessageUtils.makeResponse(false, "The password you entered is incorrect.");
            }

//        user.setUsername(username);
            user.setModifiedBy(getUserAuth().getId());
            user.setStatusLogin(2L);
            /*System Activity*/
            LocalTime endDuration = LocalTime.now();
            activityLogService.insert("/user/change-password",null,null,"User","","Change Password",1,"Success",startDuration,endDuration, httpServletRequest);
            Boolean result = userMapper.update(user);
            if (result) {
                String msgEntityname = messageSource.getMessage("user.entityname", null, Locale.getDefault());
                String msgSuccess = messageSource.getMessage("form.update.success", null, Locale.getDefault());
                return ResponseMessageUtils.makeResponse(true, messageService.message("Success", true));
            } else {
                String msgEntityname = messageSource.getMessage("user.entityname", null, Locale.getDefault());
                String msgSuccess = messageSource.getMessage("form.update.fail", null, Locale.getDefault());
                return ResponseMessageUtils.makeResponse(true, messageService.message("Fail", false));
            }
        } catch (Exception error) {
            /*System Activity*/
            LocalTime endDuration = LocalTime.now();
            activityLogService.insert("/user/change-password",line, error.toString(),"User","","Change Password",2,"Error",startDuration,endDuration, httpServletRequest);
            return ResponseMessageUtils.makeResponse(true, messageService.message("Error", null, false));
        }
    }

    public User getUserAuth() {
        try {
            if (UserAuthSession.getUserAuth() != null) {
                List<User> userList = userMapper.getOneByUsername(UserAuthSession.getUserAuth().getUsername());
                return userList.get(0);
            } else {
                return new User();
            }
        } catch (Exception errorr) {
            return null;
        }
    }

    // function delete UserGroup before update
    private void insertSystemRoleUser(String[] groupId, Long userId) {
        if (groupId.length > 0) {
            userMapper.deleteSystemRoleUser(userId);
            for (String s : groupId) {
                userMapper.insertSystemRoleUser(userId, s.replace("\"", ""));
            }
        }
    }

}