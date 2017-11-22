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
public class MysqlGenerator_jui {

	private static final String[] TABLES = new String[] { "web_site", "web_site_url" };
	private static final String AUTHOR = "wujing";

	private static final boolean JAVA = true; // 是否生成java
	private static final boolean FTL = true; // 是否生成ftl

	// 包的根路径设置
	private static final String PACKAGE_PATH = "com.roncoo.jui.web";
	private static final String MODULE_NAME = "admin";
	private static final String SUPERCONTROLLERCLASS = "com.roncoo.jui.common.util.base.BaseController";

	// 文件保存的位置
	private static final String OUTPUT_DIR = "C:/Users/Administrator/git/roncoo-jui-springboot/roncoo-jui-springboot-web/";
	private static final String OUTPUT_DIR_JAVA = "src/main/java/";
	private static final String PACKAGE_PATH_COMMON = "com.roncoo.jui.common";
	private static final String OUTPUT_DIR_FTL = "src/main/resources/templates/admin/";

	// 数据库配置
	private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	private static final String DB_USER_NAME = "roncoo";
	private static final String DB_PASSWORD = "123456";
	private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/roncoo_jui_springboot?characterEncoding=utf8";

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
		// 自定义 controller 父类
		sc.setSuperControllerClass(SUPERCONTROLLERCLASS);
		// 【实体】是否为lombok模型（默认 false）
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
				this.getConfig().getPackageInfo().put("Qo", PACKAGE_PATH + ".bean.qo");
				this.getConfig().getPackageInfo().put("Vo", PACKAGE_PATH + ".bean.vo");

				this.getConfig().getPackageInfo().put("Dao", PACKAGE_PATH_COMMON + ".dao");
				this.getConfig().getPackageInfo().put("Ent", PACKAGE_PATH_COMMON + ".entity");
				this.getConfig().getPackageInfo().put("Page", PACKAGE_PATH_COMMON + ".util.jui.Page");
				this.getConfig().getPackageInfo().put("PageUtil", PACKAGE_PATH_COMMON + ".util.PageUtil");
			}
		};

		List<FileOutConfig> list = new ArrayList<>();
		if (JAVA) {
			list.add(new FileOutConfig("/template/jui/service.java.vm") {
				// 自定义输出文件目录
				@Override
				public String outputFile(TableInfo tableInfo) {
					return OUTPUT_DIR + OUTPUT_DIR_JAVA + PACKAGE_PATH.replace(".", "/") + "/service/" + tableInfo.getEntityName() + "Service.java";
				}
			});
			list.add(new FileOutConfig("/template/jui/controller.java.vm") {
				// 自定义输出文件目录
				@Override
				public String outputFile(TableInfo tableInfo) {
					return OUTPUT_DIR + OUTPUT_DIR_JAVA + PACKAGE_PATH.replace(".", "/") + "/controller/" + MODULE_NAME.replace(".", "/") + "/" + tableInfo.getEntityName() + "Controller.java";
				}
			});
			list.add(new FileOutConfig("/template/jui/qo.java.vm") {
				// 自定义输出文件目录
				@Override
				public String outputFile(TableInfo tableInfo) {
					return OUTPUT_DIR + OUTPUT_DIR_JAVA + PACKAGE_PATH.replace(".", "/") + "/bean/qo/" + tableInfo.getEntityName() + "QO.java";
				}
			});
			list.add(new FileOutConfig("/template/jui/vo.java.vm") {
				// 自定义输出文件目录
				@Override
				public String outputFile(TableInfo tableInfo) {
					return OUTPUT_DIR + OUTPUT_DIR_JAVA + PACKAGE_PATH.replace(".", "/") + "/bean/vo/" + tableInfo.getEntityName() + "VO.java";
				}
			});
		}

		if (FTL) {
			// -------- 页面
			list.add(new FileOutConfig("/template/jui/ftl/list.ftl.vm") {
				// 自定义输出文件目录
				@Override
				public String outputFile(TableInfo tableInfo) {
					return OUTPUT_DIR + OUTPUT_DIR_FTL + tableInfo.getEntityPath() + "/list.ftl";
				}
			});
			list.add(new FileOutConfig("/template/jui/ftl/add.ftl.vm") {
				// 自定义输出文件目录
				@Override
				public String outputFile(TableInfo tableInfo) {
					return OUTPUT_DIR + OUTPUT_DIR_FTL + tableInfo.getEntityPath() + "/add.ftl";
				}
			});
			list.add(new FileOutConfig("/template/jui/ftl/edit.ftl.vm") {
				// 自定义输出文件目录
				@Override
				public String outputFile(TableInfo tableInfo) {
					return OUTPUT_DIR + OUTPUT_DIR_FTL + tableInfo.getEntityPath() + "/edit.ftl";
				}
			});
			list.add(new FileOutConfig("/template/jui/ftl/view.ftl.vm") {
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

		// 打印注入设置，这里演示模板里面怎么获取注入内容【可无】
		System.out.println("success");
	}

}
