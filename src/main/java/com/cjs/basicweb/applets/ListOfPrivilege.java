package com.cjs.basicweb.applets;

import java.util.HashMap;
import java.util.List;

import com.cjs.basicweb.base.model.module.Module;

public class ListOfPrivilege {

	private static final HashMap<String, Privilege> hashMap = new HashMap<String, Privilege>();

	public static HashMap<String, Privilege> generateHashMap(
			List<Module> modules) {
		hashMap.clear();
		generateHashMap(modules, hashMap);
		return hashMap;
	}

	private static void generateHashMap(List<Module> modules,
			HashMap<String, Privilege> hashMap) {

		for (Module module : modules) {
			String parentId = null;
			if (module.getParent() != null) {
				parentId = module.getParent().getId();
			}

			hashMap.put(module.getId(),
					new Privilege(module.getId(), module.getName(), parentId,
							module.getAction()));

			if (!module.getChilds().isEmpty()) {
				generateHashMap(modules, hashMap);
			}
		}
	}

	public static HashMap<String, Privilege> getHashMap() {
		return hashMap;
	}
}
