package com.asiainfo.integration.o2p.task.common;

import com.linkage.rainbow.util.StringUtil;

import java.util.HashMap;
import java.util.Map;
/**
 * 
 * @author zhuangyq
 *
 */
public final class Constant {
	private Constant(){}
	
	/**
	 * 成功
	 */
	public static final int SUCCESS_CODE = 0;

	/**
	 * 批量协议内部系统错误
	 */
	public static final int ERROR_CODE_9999 = 9999;

	/**
	 *枢纽校验发起方消息报文控制报头格式错误
	 */
	public static final int ERROR_CODE_9002 = 9002;
	/**
	 * 枢纽校验消息报文格式错误
	 */
	public static final int ERROR_CODE_9006 = 9006;
	/**
	 * 落地方机构尚未在枢纽登记此业务或者落地方机构不存在
	 */
	public static final int ERROR_CODE_9010 = 9010;
	/**
	 * 发起方流水号重复
	 */
	public static final int ERROR_CODE_9018 = 9018;
	/**
	 * 文件超过100M
	 */
	public static final int ERROR_CODE_9022 = 9022;
	/**
	 * 文件名重复
	 */
	public static final int ERROR_CODE_9023 = 9023;
	/**
	 * 非xml文件
	 */
	public static final int ERROR_CODE_9024 = 9024;
	/**
	 * FTP文件名不符合规范
	 */
	public static final int ERROR_CODE_9025 = 9025;
	/** 没找到跟落地方应答报文对应的发起方请求报文名称 **/
	public static final int ERROR_CODE_9030 = 9030;
	/** 落地方应答报文名与目录不对应 **/
	public static final int ERROR_CODE_9031 = 9031;

	/** 发起方请求报文名与目录不对应 **/
	public static final int ERROR_CODE_9036 = 9036;

	/** 没有找到对应的发起方流水号 **/
	public static final int ERROR_CODE_9032 = 9032;

	/** 落地方应答报文非xml文件 **/
	public static final int ERROR_CODE_9033 = 9033;

	/** 落地方应答报文过大 **/
	public static final int ERROR_CODE_9034 = 9034;

	/** 落地方报文名称不符合规范，不等于44位 **/
	public static final int ERROR_CODE_9035 = 9035;

	/** 文件名第40位出错 **/
	public static final int ERROR_CODE_9037 = 9037;

    /** zip目标文件不为目录 **/
    public static final int ERROR_CODE_9230 = 9230;

    /** 目标文件不存在 **/
    public static final int ERROR_CODE_9231 = 9231;

    /** 源文件不存在 **/
    public static final int ERROR_CODE_9232 = 9232;

    /** zip目标文件名不存在 **/
    public static final int ERROR_CODE_9233 = 9233;

    /** 文件名不存在 **/
    public static final int ERROR_CODE_9234 = 9234;

    /** zip IO错误 **/
    public static final int ERROR_CODE_9235 = 9235;

    /** zip ftp/sftp 缺少参数 **/
    public static final int ERROR_CODE_9236 = 9236;

    /** zip 不存在 protocol **/
    public static final int ERROR_CODE_9237 = 9237;

    /** zip 登录文件服务器失败 **/
    public static final int ERROR_CODE_9238 = 9238;

    /** 临时文件已存在 **/
    public static final int ERROR_CODE_9239 = 9239;

    /** zip 远程文件不存在 **/
    public static final int ERROR_CODE_9240 = 9240;

    /** zip 远程文件删除失败 **/
    public static final int ERROR_CODE_9241 = 9241;

    /** zip 创建远程文件失败 **/
    public static final int ERROR_CODE_9242 = 9242;

    /** zip 创建文件目录失败 **/
    public static final int ERROR_CODE_9243 = 9243;

    /** zip 创建文件失败 **/
    public static final int ERROR_CODE_9244 = 9244;

    /** 关闭数据流失败 **/
    public static final int ERROR_CODE_9245 = 9245;

    /** 压缩文件失败 **/
    public static final int ERROR_CODE_9246 = 9246;
    
    public static final int ERROR_CODE_9223 = 9223;
    
    public static final int ERROR_CODE_9221 = 9221;

    /** 传入参数非文件类型 **/
    public static final int ERROR_CODE_9247 = 9247;
    
    /**错误信息长度**/
    public static final int ERROR_MSG_LENGTH = 2000;

	private static Map<Integer, String> errorMap = new HashMap<Integer, String>();
	static {
		errorMap.put(ERROR_CODE_9999, "Batch protocol internal system error");
		errorMap.put(ERROR_CODE_9002, "Hub check the src message contract message format error");
		errorMap.put(ERROR_CODE_9006, "Hub check message format error");
		errorMap.put(ERROR_CODE_9010, "The destination Org no yet register the business or the Dis Org does not exist");
		errorMap.put(ERROR_CODE_9018, "The src serial number repeat");
		errorMap.put(ERROR_CODE_9022, "The file exceed 100M");
		errorMap.put(ERROR_CODE_9023, "The file name repeat");
		errorMap.put(ERROR_CODE_9024, "Non XML file");
		errorMap.put(ERROR_CODE_9025, "FTP file name does not conform to the standard");
		errorMap.put(ERROR_CODE_9030, "Not found with off the response message corresponding to the originating request message name");
		errorMap.put(ERROR_CODE_9031, "The destination response message name not corresponding to the directory");
		errorMap.put(ERROR_CODE_9032, "Not found the corresponding serial number");
		errorMap.put(ERROR_CODE_9033, "The destination response message is not a XML file");
		errorMap.put(ERROR_CODE_9034, "The destination response message is too large");
		errorMap.put(ERROR_CODE_9035, "The destination message name is not conform to the specifications，is not equal to 44");
		errorMap.put(ERROR_CODE_9037, "The file name fortieth error");
		errorMap.put(ERROR_CODE_9036, "The src request message name does not correspond to the directory");
	}
	
	public static String getErrMsgById(int errSpecId) {
		String errMsg = errorMap.get(errSpecId);
		if (StringUtil.isEmpty(errMsg)) {
			return "Unknown error";
		} else {
			return errMsg;
		}
	}

	public static final String REQFile = "req";

	public static final String RESFile = "res";

	public static final String XML_ERROR_RES_TYPE = "9";

	public static final int FILE_NAME_LENGTH = 44;

	/** xml稽核类型 日/半月/月/上月 **/
	public static final String CHECK_TYPE = "ABCD";
	
	//三种操作类型,备份归档文件、搬运文件、删除文件
	public static final String OPER_TYPE_BACKUP="backup";
	public static final String OPER_TYPE_MOVE="move";
	public static final String OPER_TYPE_DELETE="delete";
	
	//搬迁任务管理 任务状态 F:未运行正常
	public static final String TASK_STATE_F = "F";
	//搬迁任务管理 任务状态 I:运行中
	public static final String TASK_STATE_I = "I";
	//搬迁任务管理 任务状态 E:异常未运行
	public static final String TASK_STATE_E = "E";
	
	//搬迁任务管理 任务状态
	private static Map<String,String> taskState = new HashMap<String,String>();
	public static String getTaskState(String taskStateCode){
		return taskState.get(taskStateCode);
	}
	static {
		taskState.put(TASK_STATE_F, "Not Run Normal");
		taskState.put(TASK_STATE_I, "Running");
		taskState.put(TASK_STATE_E, "Anomaly is not running");
	}
	
	//文件搬迁备份时区分搬迁还是备份
	public static final String BACKUP_FLAG = "BACKUP";
	//搬迁文件名称类型验证
	public static final String FILE_NAME_REGEX = "^\\d{10}\\d{10}BUS\\d{5}.*$";
	
	//任务日志类别 1:系统记录
	public static final String TASK_LOG_TYPE_1 = "1";
	//任务日志类别  2:用户操作
	public static final String TASK_LOG_TYPE_2 = "2";
	//任务日志事件类型  任务正常
	public static final String TASK_LOG_EVENT_TYPE_SUCCESS = "1";
	//任务日志事件类型  到点未运行
	public static final String TASK_LOG_EVENT_TYPE_MISFIRED = "2";
	//任务日志事件类型  任务暂停
	public static final String TASK_LOG_EVENT_TYPE_PAUSED = "3";
	//任务日志事件类型  任务添加
	public static final String TASK_LOG_EVENT_TYPE_SCHEDULED = "4";
	//任务日志事件类型  任务移除
	public static final String TASK_LOG_EVENT_TYPE_UNSCHEDULED = "5";
	//任务日志事件类型  任务终止
	public static final String TASK_LOG_EVENT_TYPE_FINALIZED = "6";
	//任务日志事件类型  任务异常
	public static final String TASK_LOG_EVENT_TYPE_EXCEPTION = "7";
	//任务日志事件类型   调度器停止
	public static final String TASK_LOG_EVENT_TYPE_SCHED_SHUTDOWN = "8";
	//任务日志事件类型  用户启动任务
	public static final String TASK_LOG_EVENT_TYPE_START = "9";
	//任务日志事件类型  用户停止任务
	public static final String TASK_LOG_EVENT_TYPE_STOP = "10";
	//任务类型   文件交换请求任务
	public static final String TASK_TYPE_REQ = "1";
	//文件名协议类型
	public static final String FILENAME = "file_name";
	//文件协议类型
	public static final String FILECONTENT = "file_content";
	//错误响应文件
	public static final String ERROR_FILE = "error.txt";
	//通过响应文件
	public static final String SUCCESS_FILE = "ok.txt";
	//目录
	public static final String RESPONSE = "response";
	//分隔符
	public static final String SEPARATORS = "separators";
	//换行符
	public static final String NEWLINE = "newline";

	//是否补全
	public static final String ISSUPPCHAR = "Y";
	//补全类型
	public static final int FILESUPPTYPE = 1;

	//XML协议格式类型
	public static final String CONTYPEXML = "1";
	//TXT协议格式类型
	public static final String CONTYPETXT = "4";
	//定义符号
	public static final String DOT = ".";
	public static final String COMMA = ",";
	public static final String DOUBLELEFTLINE = "//";
	public static final String LEFTLINE = "/";
	public static final String DOUBLERIGHTLINE = "\\";


	public static final String LOCAL_DIR = "L";
	public static final String REMOTE_DIR = "R";

	public static final Integer FILE_REQ = 0;

	public static final String IN_USE = "A";
	public static final String COMPONENT_IN_USE = "D";

	public static final String ENCODING = "encoding";
	public static final String PREFIX = "prefix";
	public static final String SUFFIX = "suffix";
	public static final String SUCCESS = "SUCCESS";
	public static final String ERROR = "ERROR";
	public static final String ERRORMESSAGE = "errorMessage";
	public static final String ATTRSPEC = "attrspec";
	public static final String CONSTMAP = "constmap";
	public static final String DYNPARAMMAP ="dynparammap";
	public static final String NODEVALADAPTERREQ = "nodevaladapterreq";
	public static final String NODEDESCMAPER = "nodedescmaper";
	
	//响应文件属性
	public static final String RES_FILE_NAME_ERROR = "responseErrorFile";
	public static final String RES_FILE_NAME_OK = "responseOkFile";
	public static final String RES_FILE_CONTENT = "responseFileContent";
	public static final String RES_FILE_CODE = "${resCode}";
	public static final String RES_FILE_DESC = "${resDesc}";
	public static final String RES_FILE_CON_TYPE = "4";
	
	//静态名
	public static final String END_PAGE = "endPage";
	public static final String START_PAGE = "startPage";
	public static final String CODE_SUCCESS = "success";
	public static final String PARAM_TASK_ID = "taskId";
	public static final String PARAM_TASK_CONTENT = "taskContent";
	public static final String MESSAGE_ADD_TASK_ABNORMAL = "Add the task running log abnormal ";
	public static final String NAME_START = "start";
	public static final String NAME_STOP = "stop";
	public static final String SESSION_ID = "sessionId";
	public static final String STAFF_NO = "staffNo";
	public static final String IP = "ip";

	public static final String ATTR_SPEC_CODE_POST_READ_ACTION = "POST_READ_ACTION";

	public static final String ATTR_SPEC_CODE_MOVE_TAR_DIR = "FILE_MOVE_TAR_DIR";

	public static final String ATTR_SPEC_CODE_ARCHIVE_DIR_PATH = "FILE_ARCHIVE_DIR";

	public static final String ATTR_SPEC_CODE_IS_SCAN_SUB_DIR = "IS_SCAN_SUB_DIR";
	
	public static final Object ATTR_SPEC_CODE_QUEUE_NAME = "queue_name";

	public static final String POST_ACTION_DEL = "1";

	public static final String POST_ACTION_ARCHIVE_AND_DEL = "2";

    public static final String ZIP_SRC_TAR = "ZIP_SRC_TAR"; //  暂停使用
    public static final String ZIP_REMOTE_ATTR = "ZIP_REMOTE_ATTR"; //  远程登录属性
    public static final String FILE_TAR_PATH = "FILE_TAR_PATH";   //  压缩文件存放路径
    public static final String ZIP_TAR_NAME = "ZIP_TAR_NAME";   //  压缩文件名
    public static final String ZIP_DEL_SRC_PREFIX = "ZIP_DEL_SRC_PREFIX";   //  压缩源文件删除前缀
    public static final String ZIP_INVOKED_ACT = "ZIP_INVOKED_ACT";   //  压缩源文件删除前缀

    public static final String ZIP_OR_UNZIP = "ZIP_OR_UNZIP";   //  压缩或解压缩
    public static final String ZIPING = "ZIP";   // ZIP
    public static final String UNZIPING = "UNZIP";   // ZIP

    public static final String ZIP_TYPE = "ZIP_TYPE";   // 压缩类型
    public static final String ZIP_TYPE_ZIP = "ZIP";   // ZIP
    public static final String ZIP_TYPE_GZIP = "GZIP";   // GZIP
    public static final String ZIP_TYPE_BZIP2 = "BZIP2";   // BZIP
    public static final String ZIP_TYPE_TAR = "TAR";   // TAR
    public static final String ZIP_TYPE_TAR_GZIP = "TAR_GZIP";   // TAR_GZIP
    public static final String ZIP_TYPE_TAR_BZIP2 = "TAR_BZIP2";   // TAR_BZIP2

    public static final String ZIP_METHOD_M = "M";  //  文件压缩后, 远程归档, 源文件改变路径
    public static final String ZIP_METHOD_S = "S";  //  文件压缩后, 不变
    public static final String ZIP_METHOD_D = "D";  //  文件压缩后, 删除

    public static final String FILE_PROTOCOL_SFTP = "SFTP"; //  文件服务端口SFTP
    public static final String FILE_PROTOCOL_FTP = "FTP";   //  文件服务端口FTP

    public static final String ZIP_LOCAL_L = "L";   // 存储在本地
    public static final String ZIP_LOCAL_R = "R";   // 存储在远程

    public static final String TEMPLATE_FILE_PATH_L = "L";   // 使用本地临时目录
    public static final String TEMPLATE_FILE_PATH_Z = "Z";   // 使用本地临时zip目录
    public static final String TEMPLATE_FILE_PATH_U = "U";   // 使用本地临时上传目录
    public static final String TEMPLATE_FILE_PATH_A = "A";   // 使用本地临时归档目录
    public static final String TEMPLATE_FILE_PATH_USER = "USER";   // 使用本地临时用户目录


    /**
     * 内置函数名
     */
    public static final String GET_TIME = "current_time";

    public static final char WILDCAR = '%';
    public static final char BEIGN_CHAR = '{';
    public static final char END_CHAR = '}';
    public static final String WILDCAR_STR = "%";

	public static final String OBJ_TYPE_SER_INVOKE_INS = "1";

}
