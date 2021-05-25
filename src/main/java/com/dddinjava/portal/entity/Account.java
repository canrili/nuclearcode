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
@NoArgsConstructor
@RequiredArgsConstructor
public class Account implements Serializable {

  private static final long serialVersionUID = -4605836191379150771L;

  private Long id;

  @NonNull
  private String username;

  @NonNull
  private String password;

  @NonNull
  private String ownerFullName;

}
