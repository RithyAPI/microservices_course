package com.ut.utAttendance.model;

import com.ut.utAttendance.model.base.Filter;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ModuleTypeFilter extends Filter {

  @ApiModelProperty(position = 101)
  private Long roleId;

}
