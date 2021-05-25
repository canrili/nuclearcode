package com.dddinjava.portal.entity;


import lombok.*;

import java.io.Serializable;

/**
 * 帐户实体
 * @author zhaox
 */
@Getter
@Setter
@ToString
public class Account implements Serializable {

  private static final long serialVersionUID = -4605836191379150771L;

  private Long id;

  private String username;

  private String password;

  private String ownerFullName;

  public Account() {
  }

  public Account(String username, String password, String ownerFullName) {
    this.username = username;
    this.password = password;
    this.ownerFullName = ownerFullName;
  }

  public Account(Long id, String username, String password, String ownerFullName) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.ownerFullName = ownerFullName;
  }
}
