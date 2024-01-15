package io.github.ecustse211.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author wwj
 * @since 2024-01-09
 */
@Getter
@Setter
  public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

      /**
     * 学生id
     */
        private Integer id;

      /**
     * 学生姓名
     */
      private String name;

      /**
     * 学生密码
     */
      private String password;
}
