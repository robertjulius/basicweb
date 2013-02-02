package com.cjs.basicweb.utility.path;

import java.util.Arrays;

public class PathUtils {

	private static final String[] PATH_DOESNT_NEED_SESSION = { "a", "b", "c" };
	private static final String[] MODULE_DOESNT_NEED_PRIVILEGE = { "a", "b", "c" };

	public static boolean isModuleNeedPrivilege(String module) {
		return Arrays.binarySearch(PathUtils.MODULE_DOESNT_NEED_PRIVILEGE,
				module) < 0;
	}

	public static boolean isPathNeedSession(String path) {
		return Arrays.binarySearch(PathUtils.PATH_DOESNT_NEED_SESSION,
				path) < 0;
	}
}
