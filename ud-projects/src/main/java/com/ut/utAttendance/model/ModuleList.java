package com.ut.utAttendance.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ModuleList {

  private static final long serialVersionUID = 1L;

  @ApiModelProperty(position = 1)
  private Long moduleId;

}
