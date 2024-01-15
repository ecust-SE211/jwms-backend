package io.github.ecustse211.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
  public class Classstudent implements Serializable {

    private static final long serialVersionUID = 1L;

      /**
     * id
     */
      @TableId(value = "id", type = IdType.AUTO)
        private Integer id;

      /**
     * 教学班id
     */
      private Integer clid;

      /**
     * 学生id
     */
      private Integer sid;
}
