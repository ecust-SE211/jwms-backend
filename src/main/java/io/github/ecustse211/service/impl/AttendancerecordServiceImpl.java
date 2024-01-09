package io.github.ecustse211.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.github.ecustse211.common.Constants;
import io.github.ecustse211.entity.Attendancerecord;
import io.github.ecustse211.entity.Teacher;
import io.github.ecustse211.exception.ServiceException;
import io.github.ecustse211.mapper.AttendancerecordMapper;
import io.github.ecustse211.service.IAttendancerecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wwj
 * @since 2024-01-09
 */
@Service
public class AttendancerecordServiceImpl extends ServiceImpl<AttendancerecordMapper, Attendancerecord> implements IAttendancerecordService {

    @Override
    public Attendancerecord find(Attendancerecord one) {
        QueryWrapper<Attendancerecord> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("sid", one.getSid());
        queryWrapper.eq("fid", one.getFid());
        Attendancerecord res = getOne(queryWrapper);    //从数据库查询用户信息
        if(one != null){
            return res;
        }
        else{
            throw new ServiceException(Constants.CODE_600, "查找不到记录");
        }
    }
}
