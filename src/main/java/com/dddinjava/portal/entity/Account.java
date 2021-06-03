package com.dddinjava.portal.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author zhaox
 */
@Setter
@Getter
@ToString
public class Account implements Serializable {

  private static final long serialVersionUID = 8004429408560234933L;

  private Long id;

  private String username;

  private String password;

  private String ownerFullName;

}
