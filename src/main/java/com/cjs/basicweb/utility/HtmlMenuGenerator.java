package com.cjs.basicweb.utility;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

import com.cjs.basicweb.applets.Privilege;
import com.cjs.basicweb.applets.PrivilegeUtils;
import com.cjs.basicweb.base.model.module.Module;
import com.cjs.core.exception.AppException;

public class HtmlMenuGenerator {

	public static TreeMap<String, Privilege> generateTreeMap(
			List<Module> userModules, List<Module> completes)
			throws AppException {
		List<String> privilegeIds = new ArrayList<String>();
		for (Module userModule : userModules) {
			privilegeIds.add(userModule.getId());
		}

		String[] initialPrivilegeIds = new String[privilegeIds.size()];
		privilegeIds.toArray(initialPrivilegeIds);

		TreeMap<String, Privilege> treeMap = PrivilegeUtils.generateTree(
				initialPrivilegeIds, completes);

		return treeMap;
	}

	public static String generateHtmlMenu(TreeMap<String, Privilege> node) {
		StringBuilder stringBuilder = new StringBuilder();
		generateTree(stringBuilder, node);
		return stringBuilder.toString();
	}

	private static void generateTree(StringBuilder stringBuilder,
			TreeMap<String, Privilege> node) {
		Collection<Privilege> childs = node.values();
		if (childs.isEmpty()) {
			return;
		}

		stringBuilder.append("<ul>");
		Iterator<Privilege> childIterator = childs.iterator();
		while (childIterator.hasNext()) {
			Privilege child = (Privilege) childIterator.next();
			stringBuilder.append("<li>").append(child.getName());
			generateTree(stringBuilder, child.getChilds());
			stringBuilder.append("</li>").append("\n");
		}
		stringBuilder.append("</ul>").append("\n");
	}
}
