package io.github.ecustse211.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.ecustse211.common.Result;
import io.github.ecustse211.entity.Classstudent;
import io.github.ecustse211.entity.Course;
import org.springframework.web.bind.annotation.*;
import jakarta.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import io.github.ecustse211.service.ITeacherroleService;
import io.github.ecustse211.entity.Teacherrole;

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
@RequestMapping("/teacherrole")
public class TeacherroleController {

    @Resource
    private ITeacherroleService teacherroleService;

    //新增或者更新
    @PostMapping
    public Result save(@RequestBody Teacherrole teacherrole) {
            return Result.success(teacherroleService.saveOrUpdate(teacherrole));
    }

    //删除
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
            return Result.success(teacherroleService.removeById(id));
    }

    //按照id查找
    @GetMapping("/{id}")
    public Result findOne(@PathVariable Integer id) {
        return Result.success(teacherroleService.getById(id));
    }

    //按照Teacherrole变量删除
    @DeleteMapping("/delete")
    public Result deleteOne(@RequestBody Teacherrole one) {
        Boolean res = teacherroleService.delete(one);
        return Result.success(res);
    }

    //按照Teacherrole变量查找
    @GetMapping("/find")
    public Result findOne(@RequestBody Teacherrole one) {
        Teacherrole res = teacherroleService.find(one);
        return Result.success(res);
    }

    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum,
                                    @RequestParam Integer pageSize) {
        QueryWrapper<Teacherrole> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        return Result.success(teacherroleService.page(new Page<>(pageNum, pageSize),queryWrapper));
    }

    @GetMapping("/course")
    public Result getCourseByTid(@RequestParam Integer tid){
        List<Course> courseList = teacherroleService.getCourseListByTeacherId(tid);
        return Result.success(courseList);
    }

    //根据教师id查询学生id
    @GetMapping("/student")
    public Result getStudentIdByTid(@RequestParam Integer tid){
        List<Integer> studentIdList = teacherroleService.getStudentIdByTeacherId(tid);
        return Result.success(studentIdList);
    }

}
