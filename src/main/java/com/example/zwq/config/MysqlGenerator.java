package com.example.zwq.config;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * description: TODO
 *
 * @author zwq
 * @date 2022/1/4 16:20
 */


public class MysqlGenerator {


	public static void main(String[] args) {
		AutoGenerator mpg = new AutoGenerator();
		//1、全局配置
		GlobalConfig gc = new GlobalConfig();
		String projectPath = System.getProperty("user.dir");
		gc.setOutputDir(projectPath + "/src/main/java");  //生成路径(一般都是生成在此项目的src/main/java下面)
		gc.setAuthor("zwq"); //设置作者
		gc.setOpen(false);
		gc.setFileOverride(true); //第二次生成会把第一次生成的覆盖掉
		gc.setServiceName("%sService"); //生成的service接口名字首字母是否为I，这样设置就没有
		gc.setBaseResultMap(true); //生成resultMap
		mpg.setGlobalConfig(gc);

		//2、数据源配置
		DataSourceConfig dsc = new DataSourceConfig();
		// dsc.setUrl("jdbc:mysql://localhost:3306/mybatis-plus-demo?useUnicode=true&serverTimezone=GMT&useSSL=false&characterEncoding=utf8");
		dsc.setUrl("jdbc:mysql://127.0.0.1:3306/mybatis-plus-demo?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC&autoReconnect=true&failOverReadOnly=false");

		dsc.setDriverName("com.mysql.cj.jdbc.Driver");
		dsc.setUsername("root");
		dsc.setPassword("root");
		mpg.setDataSource(dsc);

		// 3、包配置
		PackageConfig pc = new PackageConfig();
		pc.setModuleName("sys");
		pc.setParent("com.example.zwq");
		mpg.setPackageInfo(pc);

		// 4、策略配置
		StrategyConfig strategy = new StrategyConfig();
		strategy.setNaming(NamingStrategy.underline_to_camel);
		strategy.setColumnNaming(NamingStrategy.underline_to_camel);
		strategy.setSuperControllerClass("com.example.zwq.controller.BaseController");
		strategy.setSuperEntityClass("com.example.zwq.entity.BaseEntity");
		// strategy.setTablePrefix("t_"); // 表名前缀
		strategy.setEntityLombokModel(true); //使用lombok
		String[] strings = {"user","role"};
		//strategy.setInclude("user");  // 逆向工程使用的表   如果要生成多个,这里可以传入String[]
		strategy.setInclude(strings);
		mpg.setStrategy(strategy);

		//5、执行
		mpg.execute();
	}

}
