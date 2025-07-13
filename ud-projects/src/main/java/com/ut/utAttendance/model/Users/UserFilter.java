package com.ut.utAttendance.model.Users;

import com.ut.utAttendance.model.base.Filter;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserFilter extends Filter {

  @ApiModelProperty(position = 101)
  private Long groupId;

}
