package io.github.ecustse211.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.ecust_se211.recognition.recognition_camera.FaceRecognize;
import io.github.ecustse211.common.Constants;
import io.github.ecustse211.common.Result;
import io.github.ecustse211.entity.Teacher;
import io.github.ecustse211.utils.ImageUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.opencv.core.Mat;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import jakarta.annotation.Resource;

import java.io.File;
import java.io.IOException;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import io.github.ecustse211.service.IJwteacherService;
import io.github.ecustse211.entity.Jwteacher;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wwj
 * @since 2024-01-09
 */
@RestController
@RequestMapping("/jwteacher")
public class JwteacherController {

    @Resource
    private IJwteacherService jwteacherService;


    @Value("${file.location}")
    private String fileUploadPath;
    //新增或者更新
    @PostMapping
    public Result save(@RequestBody Jwteacher jwteacher) {
            return Result.success(jwteacherService.saveOrUpdate(jwteacher));
    }

    //删除
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
            return Result.success(jwteacherService.removeById(id));
    }

    //批量删除
    @PostMapping("/del/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids){
            return Result.success(jwteacherService.removeByIds(ids));
    }

    @GetMapping("/{id}")
    public Result findOne(@PathVariable Integer id) {
        return Result.success(jwteacherService.getById(id));
    }

    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum,
                                    @RequestParam Integer pageSize) {
        QueryWrapper<Jwteacher> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        return Result.success(jwteacherService.page(new Page<>(pageNum, pageSize),queryWrapper));
    }

    @PostMapping("/login")
    public Result login(@RequestBody Jwteacher jwteacher){
        String id = jwteacher.getId().toString();
        String password = jwteacher.getPassword();
        if(id.isEmpty() || password == null || password.isEmpty()){
            return Result.error(Constants.CODE_400,"参数错误");
        }
        Jwteacher teach = jwteacherService.login(jwteacher);
        return Result.success(teach);
    }
    @PostMapping("/setImage/{studentId}")
    public Result uploadImage(@PathVariable Integer studentId, HttpServletRequest request) throws IOException {
        if (studentId == null) {
            return Result.error(Constants.CODE_400, "参数错误");
        }

        // 从MultipartHttpServletRequest中获取文件
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile file = (MultipartFile) multipartRequest.getFile("file");

        if (file == null) {
            return Result.error(Constants.CODE_400, "未接收到图片文件");
        }
        System.out.println(file.getOriginalFilename());
        String refImg = fileUploadPath+"src/main/resources/referenceImage/"+studentId+".png";
        String faceXML = fileUploadPath+"src/main/resources/faceConfig/haarcascade_frontalface_alt.xml";
        file.transferTo(new File(refImg));
        Mat refimgMat = FaceRecognize.GetImage(refImg);
        FaceRecognize.StoreImage(refimgMat,refImg,true,faceXML);

        return Result.success(true);
    }

}
