package com.ness.inputs;

/*############################################################
 * ' Class Name: Constants
 * ' Purpose: constants in project along with file paths
 */
public class Constants {

	// Available platforms
	public final static String URL = "https://mts.wsoz.pearsonclinical.com/wsoTeacherApp/teachApp/login/showLogin.html?product=work";

	public final static String OUNCE_URL = "https://mts.wsoz.pearsonclinical.com/wsoTeacherApp/teachApp/login/showLogin.html?product=ounce";

	// =========================================================================
	// Constant paths

	private final static String rootDir = System.getProperty("user.dir");

	public final static String TESTDATA_LOC = rootDir + "/src/main/java/com/ness/inputs/TestData.xlsx";

	public final static String CONFIG_LOC = rootDir + "/src/main/java/com/ness/inputs/Config.xlsx";

	public final static String FILES_FOR_UPLOAD_LOC = rootDir + "/src/main/java/com/ness/attachments/";

}