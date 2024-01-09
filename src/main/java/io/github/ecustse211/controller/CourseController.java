package io.github.ecustse211.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.ecustse211.common.Result;
import org.springframework.web.bind.annotation.*;
import jakarta.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import io.github.ecustse211.service.ICourseService;
import io.github.ecustse211.entity.Course;

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
@RequestMapping("/course")
public class CourseController {

    @Resource
    private ICourseService courseService;

    //新增或者更新
    @PostMapping
    public Result save(@RequestBody Course course) {
            return Result.success(courseService.saveOrUpdate(course));
    }

    //删除
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
            return Result.success(courseService.removeById(id));
    }

    //批量删除
    @PostMapping("/del/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids){
            return Result.success(courseService.removeByIds(ids));
    }

    @GetMapping("/{id}")
    public Result findOne(@PathVariable Integer id) {
        return Result.success(courseService.getById(id));
    }

    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum,
                                    @RequestParam Integer pageSize) {
        QueryWrapper<Course> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        return Result.success(courseService.page(new Page<>(pageNum, pageSize),queryWrapper));
    }

}
