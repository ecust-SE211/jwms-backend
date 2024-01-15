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
  public class Class implements Serializable {

    private static final long serialVersionUID = 1L;

      /**
     * 教学班id
     */
        @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      /**
     * 课程id
     */
      private Integer cid;
}
