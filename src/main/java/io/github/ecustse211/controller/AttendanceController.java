package io.github.ecustse211.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.ecustse211.common.Result;
import org.springframework.web.bind.annotation.*;
import jakarta.annotation.Resource;

import java.time.LocalDateTime;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import io.github.ecustse211.service.IAttendanceService;
import io.github.ecustse211.entity.Attendance;

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
@RequestMapping("/attendance")
public class AttendanceController {

    @Resource
    private IAttendanceService attendanceService;

    //新增或者更新
    @PostMapping
    public Result save(@RequestBody Attendance attendance) {
        attendance.setDate(LocalDateTime.now());
        return Result.success(attendanceService.saveOrUpdate(attendance));
    }

    //删除
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
            return Result.success(attendanceService.removeById(id));
    }

    //批量删除
    @PostMapping("/del/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids){
            return Result.success(attendanceService.removeByIds(ids));
    }

    @GetMapping("/{id}")
    public Result findOne(@PathVariable Integer id) {
        return Result.success(attendanceService.getById(id));
    }

    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum,
                                    @RequestParam Integer pageSize) {
        QueryWrapper<Attendance> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        return Result.success(attendanceService.page(new Page<>(pageNum, pageSize),queryWrapper));
    }

    //根据班级id查询Attendance表
    @GetMapping("/findAttendance")
    public Result findAttendance(@RequestParam Integer clid) {
        QueryWrapper<Attendance> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("clid", clid);
        queryWrapper.orderByDesc("id");
        return Result.success(attendanceService.page(new Page<>(1, 100),queryWrapper));
    }

}
