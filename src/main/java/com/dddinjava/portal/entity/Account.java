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
@RequiredArgsConstructor
public class Account implements Serializable {

  private static final long serialVersionUID = -4605836191379150771L;
  private long id;

  @NonNull
  private String username;

  @NonNull
  private String password;

  @NonNull
  private String ownerFullName;

}
