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
public class Cloud_user {

	private static final String[] TABLES = new String[] { };
	private static final String AUTHOR = "wujing";

	private static final boolean JAVA_COMMON = true; // 是否生成java
	private static final boolean JAVA_FEIGN = true; // 是否生成java
	private static final boolean JAVA_SERIVICE = true; // 是否生成java
	private static final boolean JAVA_WEB = true; // 是否生成java
	private static final boolean FTL = true; // 是否生成ftl

	// 包的根路径设置
	private static final String PACKAGE_PATH = "com.roncoo.cloud.user";
	private static final String PACKAGE_PATH_DAO = "com.roncoo.cloud.user.service.dao";
	private static final String PACKAGE_PATH_ENT = "com.roncoo.cloud.user.service.dao.impl.mapper.entity";
	private static final String PACKAGE_PATH_PAGE = "com.roncoo.cloud.util.base";
	private static final String MODULE_NAME = "user";
	private static final String SUPERCONTROLLERCLASS = "com.roncoo.cloud.util.base.BaseController";

	// 文件保存的位置
	private static final String OUTPUT_DIR = "D:/workspace/roncoo-cloud/roncoo-cloud-user/";
	private static final String OUTPUT_DIR_JAVA_COMMON = "roncoo-cloud-user-common/src/main/java/";
	private static final String OUTPUT_DIR_JAVA_FEIGN = "roncoo-cloud-user-feign/src/main/java/";
	private static final String OUTPUT_DIR_JAVA_SERVICE = "roncoo-cloud-user-service/src/main/java/";
	private static final String OUTPUT_DIR_JAVA_WEB = "D:/workspace/roncoo-cloud/roncoo-cloud-web-boss/src/main/java/";
	private static final String OUTPUT_DIR_FTL = "D:/workspace/roncoo-cloud/roncoo-cloud-web-boss/src/main/resources/templates/user/";

	// 数据库配置
	private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	private static final String DB_USER_NAME = "roncoo";
	private static final String DB_PASSWORD = "123456";
	private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/rc_recharge?characterEncoding=utf8";

	/**
	 * 代码生成
	 */
	public static void main(String[] args) {
		// 全局配置
		GlobalConfig gc = new GlobalConfig();
		gc.setOutputDir(OUTPUT_DIR);// 输出目录
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
				this.getConfig().getPackageInfo().put("Biz", "com.roncoo.cloud.web.boss.biz.user");
				this.getConfig().getPackageInfo().put("Ctl", "com.roncoo.cloud.web.boss.controller.user");
				this.getConfig().getPackageInfo().put("Qo", PACKAGE_PATH + ".common.bean.qo");
				this.getConfig().getPackageInfo().put("Vo", PACKAGE_PATH + ".common.bean.vo");
				this.getConfig().getPackageInfo().put("Bo", PACKAGE_PATH + ".common.bean.bo");
				this.getConfig().getPackageInfo().put("Dto", PACKAGE_PATH + ".common.bean.dto");
				this.getConfig().getPackageInfo().put("Dao", PACKAGE_PATH_DAO);
				this.getConfig().getPackageInfo().put("Ent", PACKAGE_PATH_ENT);
				this.getConfig().getPackageInfo().put("Page", PACKAGE_PATH_PAGE);
				this.getConfig().getPackageInfo().put("Base", PACKAGE_PATH);
			}
		};

		List<FileOutConfig> list = new ArrayList<>();
		if (JAVA_COMMON) {
			list.add(new FileOutConfig("/template/cloud/common/qo.java.vm") {
				// 自定义输出文件目录
				@Override
				public String outputFile(TableInfo tableInfo) {
					return OUTPUT_DIR + OUTPUT_DIR_JAVA_COMMON + PACKAGE_PATH.replace(".", "/") + "/common/bean/qo/" + tableInfo.getEntityName() + "QO.java";
				}
			});
			list.add(new FileOutConfig("/template/cloud/common/vo.java.vm") {
				// 自定义输出文件目录
				@Override
				public String outputFile(TableInfo tableInfo) {
					return OUTPUT_DIR + OUTPUT_DIR_JAVA_COMMON + PACKAGE_PATH.replace(".", "/") + "/common/bean/vo/" + tableInfo.getEntityName() + "VO.java";
				}
			});
			list.add(new FileOutConfig("/template/cloud/common/bo.java.vm") {
				// 自定义输出文件目录
				@Override
				public String outputFile(TableInfo tableInfo) {
					return OUTPUT_DIR + OUTPUT_DIR_JAVA_COMMON + PACKAGE_PATH.replace(".", "/") + "/common/bean/bo/" + tableInfo.getEntityName() + "BO.java";
				}
			});
			list.add(new FileOutConfig("/template/cloud/common/dto.java.vm") {
				// 自定义输出文件目录
				@Override
				public String outputFile(TableInfo tableInfo) {
					return OUTPUT_DIR + OUTPUT_DIR_JAVA_COMMON + PACKAGE_PATH.replace(".", "/") + "/common/bean/dto/" + tableInfo.getEntityName() + "DTO.java";
				}
			});
			
			
			list.add(new FileOutConfig("/template/cloud/common/boss.java.vm") {
				// 自定义输出文件目录
				@Override
				public String outputFile(TableInfo tableInfo) {
					return OUTPUT_DIR + OUTPUT_DIR_JAVA_COMMON + PACKAGE_PATH.replace(".", "/") + "/common/interfaces/boss/Boss" + tableInfo.getEntityName() + ".java";
				}
			});
			
			list.add(new FileOutConfig("/template/cloud/common/web.java.vm") {
				// 自定义输出文件目录
				@Override
				public String outputFile(TableInfo tableInfo) {
					return OUTPUT_DIR + OUTPUT_DIR_JAVA_COMMON + PACKAGE_PATH.replace(".", "/") + "/common/interfaces/web/Web" + tableInfo.getEntityName() + ".java";
				}
			});
		}
		
		if (JAVA_FEIGN) {
			list.add(new FileOutConfig("/template/cloud/feign/boss.java.vm") {
				// 自定义输出文件目录
				@Override
				public String outputFile(TableInfo tableInfo) {
					return OUTPUT_DIR + OUTPUT_DIR_JAVA_FEIGN + PACKAGE_PATH.replace(".", "/") + "/feign/boss/" + "IBoss" + tableInfo.getEntityName() + ".java";
				}
			});
			list.add(new FileOutConfig("/template/cloud/feign/web.java.vm") {
				// 自定义输出文件目录
				@Override
				public String outputFile(TableInfo tableInfo) {
					return OUTPUT_DIR + OUTPUT_DIR_JAVA_FEIGN + PACKAGE_PATH.replace(".", "/") + "/feign/web/" + "IWeb" + tableInfo.getEntityName() + ".java";
				}
			});
		}
		
		if (JAVA_SERIVICE) {
			list.add(new FileOutConfig("/template/cloud/service/boss.biz.java.vm") {
				// 自定义输出文件目录
				@Override
				public String outputFile(TableInfo tableInfo) {
					return OUTPUT_DIR + OUTPUT_DIR_JAVA_SERVICE + PACKAGE_PATH.replace(".", "/") + "/service/biz/boss/Boss" + tableInfo.getEntityName() + "Biz.java";
				}
			});
			list.add(new FileOutConfig("/template/cloud/service/boss.controller.java.vm") {
				// 自定义输出文件目录
				@Override
				public String outputFile(TableInfo tableInfo) {
					return OUTPUT_DIR + OUTPUT_DIR_JAVA_SERVICE + PACKAGE_PATH.replace(".", "/") + "/service/controller/boss/Boss" + tableInfo.getEntityName() + "Controller.java";
				}
			});
			
			list.add(new FileOutConfig("/template/cloud/service/web.biz.java.vm") {
				// 自定义输出文件目录
				@Override
				public String outputFile(TableInfo tableInfo) {
					return OUTPUT_DIR + OUTPUT_DIR_JAVA_SERVICE + PACKAGE_PATH.replace(".", "/") + "/service/biz/web/Web" + tableInfo.getEntityName() + "Biz.java";
				}
			});
			list.add(new FileOutConfig("/template/cloud/service/web.controller.java.vm") {
				// 自定义输出文件目录
				@Override
				public String outputFile(TableInfo tableInfo) {
					return OUTPUT_DIR + OUTPUT_DIR_JAVA_SERVICE + PACKAGE_PATH.replace(".", "/") + "/service/controller/web/Web" + tableInfo.getEntityName() + "Controller.java";
				}
			});
		}
		
		if (JAVA_WEB) {
			list.add(new FileOutConfig("/template/cloud/gateway/biz.java.vm") {
				// 自定义输出文件目录
				@Override
				public String outputFile(TableInfo tableInfo) {
					return OUTPUT_DIR_JAVA_WEB + "com.roncoo.cloud.web".replace(".", "/") + "/boss/biz/user/" + tableInfo.getEntityName() + "Biz.java";
				}
			});
			list.add(new FileOutConfig("/template/cloud/gateway/controller.java.vm") {
				// 自定义输出文件目录
				@Override
				public String outputFile(TableInfo tableInfo) {
					return OUTPUT_DIR_JAVA_WEB + "com.roncoo.cloud.web".replace(".", "/") + "/boss/controller/user/" + tableInfo.getEntityName() + "Controller.java";
				}
			});
			
		}

		if (FTL) {
			list.add(new FileOutConfig("/template/cloud/web/ftl/list.ftl.vm") {
				// 自定义输出文件目录
				@Override
				public String outputFile(TableInfo tableInfo) {
					return OUTPUT_DIR_FTL + tableInfo.getEntityPath() + "/list.ftl";
				}
			});
			list.add(new FileOutConfig("/template/cloud/web/ftl/add.ftl.vm") {
				// 自定义输出文件目录
				@Override
				public String outputFile(TableInfo tableInfo) {
					return OUTPUT_DIR_FTL + tableInfo.getEntityPath() + "/add.ftl";
				}
			});
			list.add(new FileOutConfig("/template/cloud/web/ftl/edit.ftl.vm") {
				// 自定义输出文件目录
				@Override
				public String outputFile(TableInfo tableInfo) {
					return OUTPUT_DIR_FTL + tableInfo.getEntityPath() + "/edit.ftl";
				}
			});
			list.add(new FileOutConfig("/template/cloud/web/ftl/view.ftl.vm") {
				// 自定义输出文件目录
				@Override
				public String outputFile(TableInfo tableInfo) {
					return OUTPUT_DIR_FTL + tableInfo.getEntityPath() + "/view.ftl";
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
