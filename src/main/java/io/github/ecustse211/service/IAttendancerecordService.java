package io.github.ecustse211.service;

import io.github.ecustse211.entity.Attendancerecord;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wwj
 * @since 2024-01-09
 */
public interface IAttendancerecordService extends IService<Attendancerecord> {

    Attendancerecord find(Attendancerecord one);
}
