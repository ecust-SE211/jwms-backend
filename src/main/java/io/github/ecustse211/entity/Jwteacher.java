package io.github.ecustse211.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
  public class Jwteacher implements Serializable {

    private static final long serialVersionUID = 1L;

      /**
     * 教务老师id
     */
        @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      /**
     * 密码
     */
      private String password;

    private String name;
}
