package io.github.ecustse211.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.ecustse211.common.Result;
import io.github.ecustse211.entity.Teacher;
import org.springframework.web.bind.annotation.*;
import jakarta.annotation.Resource;

import java.time.LocalDateTime;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import io.github.ecustse211.service.IAttendancerecordService;
import io.github.ecustse211.entity.Attendancerecord;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wwj
 * @since 2024-01-09
 */
@RestController
@RequestMapping("/attendancerecord")
public class AttendancerecordController {

    @Resource
    private IAttendancerecordService attendancerecordService;

    //新增或者更新
    @PostMapping
    public Result save(@RequestBody Attendancerecord attendancerecord) {
            attendancerecord.setDate(LocalDateTime.now());
            return Result.success(attendancerecordService.saveOrUpdate(attendancerecord));
    }

    @GetMapping("/find")
    public Result findOne(@RequestBody Attendancerecord one) {
        Attendancerecord res = attendancerecordService.find(one);
        return Result.success(res);
    }

    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum,
                                    @RequestParam Integer pageSize) {
        QueryWrapper<Attendancerecord> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        return Result.success(attendancerecordService.page(new Page<>(pageNum, pageSize),queryWrapper));
    }

    @GetMapping("/student")
    public Result findStudents(@RequestParam Integer fid) {
        QueryWrapper<Attendancerecord> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("fid", fid);
        queryWrapper.orderByDesc("id");
        return Result.success(attendancerecordService.page(new Page<>(1, 100),queryWrapper));
    }
}
