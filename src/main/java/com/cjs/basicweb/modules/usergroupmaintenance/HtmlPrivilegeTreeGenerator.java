package com.cjs.basicweb.modules.usergroupmaintenance;

import java.util.Collection;
import java.util.Iterator;
import java.util.TreeMap;

import com.cjs.basicweb.modules.login.Privilege;

public class HtmlPrivilegeTreeGenerator {

	public static String generateHtmlTree(TreeMap<String, Privilege> treeMap) {
		StringBuilder stringBuilder = new StringBuilder();
		generateHtmlTree(treeMap, stringBuilder);
		return stringBuilder.toString();
	}

	private static void generateHtmlTree(TreeMap<String, Privilege> treeMap,
			StringBuilder stringBuilder) {

		Collection<Privilege> nodes = treeMap.values();
		Iterator<Privilege> iterator = nodes.iterator();
		while (iterator.hasNext()) {

			stringBuilder.append("<li>");
			Privilege privilege = iterator.next();

			stringBuilder.append(privilege.getName());

			if (!privilege.getChilds().isEmpty()) {
				stringBuilder.append("<ul>");
				generateHtmlTree(privilege.getChilds(), stringBuilder);
				stringBuilder.append("</ul>");
			}

			stringBuilder.append("</li>");
		}
	}
}
