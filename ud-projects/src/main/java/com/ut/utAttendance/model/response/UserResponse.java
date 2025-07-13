package com.ut.utAttendance.model.response;

import com.ut.utAttendance.model.ModuleType;
import com.ut.utAttendance.model.Users.UserGroupList;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class UserResponse implements Serializable {


  @ApiModelProperty(position = 1)
  private Long id;

  @ApiModelProperty(position = 2)
  private String fullName;

  @ApiModelProperty(position = 3)
  private String username;

  @ApiModelProperty(position = 4)
  private String password;

  @ApiModelProperty(position = 5)
  private String sex;

  @ApiModelProperty(position = 6)
  private String address;

  @ApiModelProperty(position = 7)
  private String photo;

  @ApiModelProperty(position = 8)
  private String email;

  @ApiModelProperty(position = 9)
  private String telephone;

  @ApiModelProperty(position = 10)
  private Long employeeId;

  @ApiModelProperty(position = 11)
  private String employeeName;

  @ApiModelProperty(position = 12)
  private String createdDate;

  @ApiModelProperty(position = 12)
  private Long statusLogin;

  @ApiModelProperty(position = 13)
  private List<ModuleType> moduleTypeList;

  @ApiModelProperty(position = 14)
  private List<UserGroupList> userRoleList;
}