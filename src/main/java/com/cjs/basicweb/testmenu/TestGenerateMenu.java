package com.cjs.basicweb.testmenu;

import java.util.List;

import com.cjs.basicweb.base.model.module.Module;

public class TestGenerateMenu {
	private static List<Module> modules;

	private static String htmlMenu;

	public static void generateHtmlMenu() {
		StringBuilder stringBuilder = new StringBuilder();
		for (Module module : modules) {
			stringBuilder.append("<li>").append(module.getName());
			generateChilds(stringBuilder, module);
			stringBuilder.append("</li>").append("\n");
		}
		
		htmlMenu = stringBuilder.toString();
	}

	private static void generateChilds(StringBuilder stringBuilder,
			Module module) {
		List<Module> childs = module.getChilds();
		if (!childs.isEmpty()) {
			stringBuilder.append("<ul>");
			for (Module child : childs) {
				stringBuilder.append("<li>").append(child.getName());
				generateChilds(stringBuilder, child);
				stringBuilder.append("</li>").append("\n");
			}
			stringBuilder.append("</ul>").append("\n");
		}
	}

	public static List<Module> getModules() {
		return modules;
	}

	public static void setModules(List<Module> modules) {
		TestGenerateMenu.modules = modules;
	}

	public static String getHtmlMenu() {
		return htmlMenu;
	}

	public static void setHtmlMenu(String htmlMenu) {
		TestGenerateMenu.htmlMenu = htmlMenu;
	}
}
