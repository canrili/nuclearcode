package com.dddinjava.portal.entity;


import lombok.*;

/**
 * 帐户实体
 * @author zhaox
 */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Account {

  private long id;

  @NonNull
  private String username;

  @NonNull
  private String password;

  @NonNull
  private String ownerFullName;

}
