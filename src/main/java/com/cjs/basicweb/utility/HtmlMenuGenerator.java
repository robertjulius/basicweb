package com.cjs.basicweb.utility;

import java.util.List;

import com.cjs.basicweb.base.model.module.Module;

public class HtmlMenuGenerator {

	public static String generateHtmlMenu() {
		return "<li></li>";
	}

	public static String generateHtmlMenu(List<Module> modules) {
		StringBuilder stringBuilder = new StringBuilder();
		for (Module module : modules) {
			stringBuilder.append("<li>").append(module.getName());
			generateChilds(stringBuilder, module);
			stringBuilder.append("</li>");
		}

		return stringBuilder.toString();
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
}
