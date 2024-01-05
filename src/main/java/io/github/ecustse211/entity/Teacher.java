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
 * @since 2024-01-05
 */
@Getter
@Setter
  public class Teacher implements Serializable {

    private static final long serialVersionUID = 1L;

      /**
     * 教师id
     */
        private Integer id;

      /**
     * 教师姓名
     */
      private String name;

      /**
     * 密码
     */
      private String password;
}
