package io.github.ecustse211.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;
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
  public class Attendance implements Serializable {

    private static final long serialVersionUID = 1L;

      /**
     * 考勤表id
     */
        @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

    private Integer clid;

    private LocalDateTime date;
}
