package com.nhs.trust.utils;
/**
 * @author arif.mohammed
 */

public final class GeneralUtilities {
	
	public static final String multiLevel= "multilevel";
	public static final String folderish= "Folderish";

	public static String buildFolderPath(String path, String folder){
		if(path == null || folder == null){
			return null;
		}
		folder = folder != null && folder.contains("|") ? folder.replace("|", "/") : folder;
		int sIndex=path.indexOf(folder);
		int lIndex=path.length();
		return path.substring(sIndex, lIndex);
	}


}
