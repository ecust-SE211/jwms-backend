package io.github.ecustse211.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.ecustse211.common.Constants;
import io.github.ecustse211.common.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import jakarta.annotation.Resource;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import io.github.ecustse211.service.IStudentService;
import io.github.ecustse211.entity.Student;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.github.ecust_se211.recognition.recognition_camera.FaceRecognize;
import org.opencv.core.Mat;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wwj
 * @since 2024-01-09
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Resource
    private IStudentService studentService;

    @Value("${file.location}")
    private String fileUploadPath;

    //新增或者更新
    @PostMapping
    public Result save(@RequestBody Student student) {
            return Result.success(studentService.saveOrUpdate(student));
    }

    //删除
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
            return Result.success(studentService.removeById(id));
    }

    //批量删除
    @PostMapping("/del/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids){
            return Result.success(studentService.removeByIds(ids));
    }

    @GetMapping("/{id}")
    public Result findOne(@PathVariable Integer id) {
        return Result.success(studentService.getById(id));
    }

    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum,
                                    @RequestParam Integer pageSize) {
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        return Result.success(studentService.page(new Page<>(pageNum, pageSize),queryWrapper));
    }
    @PostMapping("/compare")
    public Result compare(@RequestParam Integer studentId, @RequestParam MultipartFile file) throws IOException {
        if(studentId == null || file== null){
            return Result.error(Constants.CODE_400,"参数错误");
        }
        String sesimg = fileUploadPath+"src/main/resources/tempImage/"+studentId.toString()+".png";
        String refImg = fileUploadPath+"src/main/resources/referenceImage/"+studentId.toString()+ ".png";
        file.transferTo(new File(sesimg));
        Mat refImgMat = FaceRecognize.GetImage(refImg);
        Mat sesimgMat = FaceRecognize.GetImage(sesimg);
        boolean result=FaceRecognize.ComparePicture(refImgMat, sesimgMat);
        return Result.success(result);
    }
    @PostMapping("/login")
    public Result login(@RequestBody Student student){
        String id = student.getId().toString();
        String password = student.getPassword();
        if(id.isEmpty() || password == null || password.isEmpty()){
            return Result.error(Constants.CODE_400,"参数错误");
        }
        Student stu = studentService.login(student);
        return Result.success(stu);
    }
}
