/**
 * Copyright (c) 2011-2016, hubin (jobob@qq.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.roncoo.bjui.generator.test;

import java.util.ArrayList;
import java.util.List;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * 代码生成器-mysql
 * 
 * @author wujing
 */
public class Cloud_boss {

	private static final String[] TABLES = new String[] {};
	private static final String AUTHOR = "wujing";

	private static final boolean JAVA_QV = true; // 是否生成java
	private static final boolean JAVA_SC = true; // 是否生成java
	private static final boolean FTL = false; // 是否生成ftl

	// 包的根路径设置
	private static final String PACKAGE_PATH = "com.roncoo.cloud.web.boss";
	private static final String PACKAGE_PATH_DAO = "com.roncoo.cloud.web.boss.service.dao";
	private static final String PACKAGE_PATH_ENT = "com.roncoo.cloud.web.boss.service.dao.impl.mapper.entity";
	private static final String PACKAGE_PATH_PAGE = "com.roncoo.cloud.util.base";
	private static final String MODULE_NAME = "admin";
	private static final String SUPERCONTROLLERCLASS = "com.roncoo.cloud.util.base.BaseController";

	// 文件保存的位置
	private static final String OUTPUT_DIR = "D:/workspace/roncoo-cloud/roncoo-cloud-web-boss/";
	private static final String OUTPUT_DIR_JAVA = "src/main/java/";
	private static final String OUTPUT_DIR_FTL = "src/main/resources/templates/admin/";

	// 数据库配置
	private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	private static final String DB_USER_NAME = "root";
	private static final String DB_PASSWORD = "www.roncoo.com";
	private static final String DB_URL = "jdbc:mysql://192.168.1.216:3306/cloud_boss?characterEncoding=utf8&useSSL=false";

	/**
	 * 代码生成
	 */
	public static void main(String[] args) {
		// 全局配置
		GlobalConfig gc = new GlobalConfig();
		gc.setOutputDir(OUTPUT_DIR + OUTPUT_DIR_JAVA);// 输出目录
		gc.setFileOverride(true);// 是否覆盖文件
		gc.setActiveRecord(true);// 开启 activeRecord 模式
		gc.setEnableCache(false);// XML 二级缓存
		gc.setBaseResultMap(true);// XML ResultMap
		gc.setBaseColumnList(true);// XML columList
		gc.setAuthor(AUTHOR); // 作者

		// 数据源配置
		DataSourceConfig dsc = new DataSourceConfig();
		dsc.setDbType(DbType.MYSQL).setDriverName(DRIVER_NAME).setUsername(DB_USER_NAME).setPassword(DB_PASSWORD).setUrl(DB_URL);

		// 策略配置
		StrategyConfig sc = new StrategyConfig();

		sc.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
		sc.setInclude(TABLES); // 需要生成的表
		sc.setSuperControllerClass(SUPERCONTROLLERCLASS);
		sc.setEntityLombokModel(true);

		// 包配置
		PackageConfig pc = new PackageConfig();
		pc.setParent(PACKAGE_PATH);// 自定义包路径
		pc.setModuleName(MODULE_NAME);

		// 注入自定义配置，可以在 VM 中使用 cfg.abc 设置的值
		InjectionConfig ic = new InjectionConfig() {
			@Override
			public void initMap() {
				this.getConfig().getPackageInfo().put("Biz", PACKAGE_PATH + ".service");
				this.getConfig().getPackageInfo().put("Ctl", PACKAGE_PATH + ".controller." + MODULE_NAME);
				this.getConfig().getPackageInfo().put("Qo", PACKAGE_PATH + ".common.bean.qo");
				this.getConfig().getPackageInfo().put("Vo", PACKAGE_PATH + ".common.bean.vo");
				this.getConfig().getPackageInfo().put("Dao", PACKAGE_PATH_DAO);
				this.getConfig().getPackageInfo().put("Ent", PACKAGE_PATH_ENT);
				this.getConfig().getPackageInfo().put("Page", PACKAGE_PATH_PAGE);
			}
		};

		List<FileOutConfig> list = new ArrayList<>();
		if (JAVA_QV) {
			list.add(new FileOutConfig("/template/cloud/boss/qo.java.vm") {
				// 自定义输出文件目录
				@Override
				public String outputFile(TableInfo tableInfo) {
					return OUTPUT_DIR + OUTPUT_DIR_JAVA + PACKAGE_PATH.replace(".", "/") + "/common/bean/qo/" + tableInfo.getEntityName() + "QO.java";
				}
			});
			list.add(new FileOutConfig("/template/cloud/boss/vo.java.vm") {
				// 自定义输出文件目录
				@Override
				public String outputFile(TableInfo tableInfo) {
					return OUTPUT_DIR + OUTPUT_DIR_JAVA + PACKAGE_PATH.replace(".", "/") + "/common/bean/vo/" + tableInfo.getEntityName() + "VO.java";
				}
			});
		}

		if (JAVA_SC) {
			list.add(new FileOutConfig("/template/cloud/boss/service.java.vm") {
				// 自定义输出文件目录
				@Override
				public String outputFile(TableInfo tableInfo) {
					return OUTPUT_DIR + OUTPUT_DIR_JAVA + PACKAGE_PATH.replace(".", "/") + "/service/" + tableInfo.getEntityName() + "Service.java";
				}
			});
			list.add(new FileOutConfig("/template/cloud/boss/controller.java.vm") {
				// 自定义输出文件目录
				@Override
				public String outputFile(TableInfo tableInfo) {
					return OUTPUT_DIR + OUTPUT_DIR_JAVA + PACKAGE_PATH.replace(".", "/") + "/controller/" + MODULE_NAME.replace(".", "/") + "/" + tableInfo.getEntityName() + "Controller.java";
				}
			});
		}

		if (FTL) {
			list.add(new FileOutConfig("/template/cloud/boss/ftl/list.ftl.vm") {
				// 自定义输出文件目录
				@Override
				public String outputFile(TableInfo tableInfo) {
					return OUTPUT_DIR + OUTPUT_DIR_FTL + tableInfo.getEntityPath() + "/list.ftl";
				}
			});
			list.add(new FileOutConfig("/template/cloud/boss/ftl/add.ftl.vm") {
				// 自定义输出文件目录
				@Override
				public String outputFile(TableInfo tableInfo) {
					return OUTPUT_DIR + OUTPUT_DIR_FTL + tableInfo.getEntityPath() + "/add.ftl";
				}
			});
			list.add(new FileOutConfig("/template/cloud/boss/ftl/edit.ftl.vm") {
				// 自定义输出文件目录
				@Override
				public String outputFile(TableInfo tableInfo) {
					return OUTPUT_DIR + OUTPUT_DIR_FTL + tableInfo.getEntityPath() + "/edit.ftl";
				}
			});
			list.add(new FileOutConfig("/template/cloud/boss/ftl/view.ftl.vm") {
				// 自定义输出文件目录
				@Override
				public String outputFile(TableInfo tableInfo) {
					return OUTPUT_DIR + OUTPUT_DIR_FTL + tableInfo.getEntityPath() + "/view.ftl";
				}
			});
		}

		ic.setFileOutConfigList(list);

		TemplateConfig tc = new TemplateConfig();
		tc.setXml(null);
		tc.setController(null);
		tc.setEntity(null);
		tc.setMapper(null);
		tc.setService(null);
		tc.setServiceImpl(null);

		// 代码生成器
		AutoGenerator ag = new AutoGenerator();
		ag.setGlobalConfig(gc);
		ag.setDataSource(dsc);
		ag.setStrategy(sc);
		ag.setPackageInfo(pc);
		ag.setCfg(ic);
		ag.setTemplate(tc);
		ag.execute();// 执行生成

		System.out.println("success");
	}

}
