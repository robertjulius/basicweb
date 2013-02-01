package com.cjs.basicweb.utility;

import java.util.ArrayList;
import java.util.List;

import com.cjs.basicweb.base.model.module.Module;
import com.cjs.basicweb.base.model.user.UserImpl;
import com.cjs.core.exception.AppException;

public class HtmlMenuGenerator {

	public static String generateHtmlMenu(UserImpl user) throws AppException {
		List<Module> parents = new ArrayList<Module>();
		
		for (Module module : user.getUserGroup().getModules()) {
			getParents(parents, module);
		}
		
		return generateHtmlMenu(parents);
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

	private static String generateHtmlMenu(List<Module> modules) {
		StringBuilder stringBuilder = new StringBuilder();
		for (Module module : modules) {
			stringBuilder.append("<li>").append(module.getName());
			generateChilds(stringBuilder, module);
			stringBuilder.append("</li>");
		}

		return stringBuilder.toString();
	}

	private static void getChilds(List<Module> modules, List<Module> childs) {
		for (Module module : modules) {
			if (module.getChilds().isEmpty()) {
				childs.add(module);
			} else {
				getChilds(module.getChilds(), childs);
			}
		}
	}

	private static void getParents(List<Module> parents, Module child) {
		if (child.getParent() == null) {
			parents.add(child);
		} else {
			getParents(parents, child.getParent());
		}
	}

	private static boolean isExistsOnTree(Module check, List<Module> modules) {
		for (Module module : modules) {

			if (check.getId().equals(module.getId())) {
				return true;
			}

			if (!module.getChilds().isEmpty()) {
				return isExistsOnTree(check, module.getChilds());
			}
		}

		return false;
	}
	
	private static boolean isValidChild(Module check, List<Module> modules) {
		for (Module module : modules) {
			if (module.getId().equals(check.getId())) {
				return true;
			}
		}
		return false;
	}
}
