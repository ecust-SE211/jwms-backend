package io.github.ecustse211.utils;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;

import java.sql.Types;
import java.util.Collections;

/**
 * mp代码生成器
 */
public class CodeGenerator {

    public static void main(String[] args) {
        generate();
    }

    private static void generate(){
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/jwms?serverTimezone=GMT%2b8", "root", "root")
                .globalConfig(builder -> {
                    builder.author("wwj") // 设置作者
                            .outputDir("D:\\DeskTop\\FaceReconigitionBackend\\jwms-backend\\src\\main\\java\\"); // 指定输出目录
                })
                .dataSourceConfig(builder -> builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
                    int typeCode = metaInfo.getJdbcType().TYPE_CODE;
                    if (typeCode == Types.SMALLINT) {
                        // 自定义类型转换
                        return DbColumnType.INTEGER;
                    }
                    return typeRegistry.getColumnType(metaInfo);

                }))
                .packageConfig(builder -> {
                    builder.parent("io.github.ecustse211") // 设置父包名
                            .moduleName(null) // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "D:\\DeskTop\\FaceReconigitionBackend\\jwms-backend\\src\\main\\resources\\mapper\\")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.entityBuilder().enableLombok();
                    builder.controllerBuilder().enableHyphenStyle()  // 开启驼峰转连字符
                            .enableRestStyle();  // 开启生成@RestController 控制器
                    builder.addInclude("teacherrole") // 设置需要生成的表名
                            .addTablePrefix("t_", "sys_"); // 设置过滤表前缀
                })
                .execute();
    }
}
