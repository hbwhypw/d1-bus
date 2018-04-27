package com.tmtc.utils.huanxin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.tmtc.utils.StringUtility;

public class EasemobChatrooms {

	private static final Logger LOGGER = LoggerFactory.getLogger(EasemobChatrooms.class);
	
	// 通过app的client_id和client_secret来获取app管理员token
    private static Credential credential = new ClientSecretCredential(Constants.APP_CLIENT_ID,
            Constants.APP_CLIENT_SECRET, Roles.USER_ROLE_APPADMIN);
    
    private static JsonNodeFactory factory = new JsonNodeFactory(false);
	private static final String APPKEY = Constants.APPKEY;
	
	public static void main(String[] args) {
		
		 /**
         * 注册IM用户[单个]
         */
        ObjectNode datanode = JsonNodeFactory.instance.objectNode();
        String uuid = StringUtility.UUID();
        datanode.put("username",uuid);
        datanode.put("password", Constants.DEFAULT_PASSWORD);
        ObjectNode createNewIMUserSingleNode = createNewIMUserSingle(datanode);
        if (null != createNewIMUserSingleNode) {
            LOGGER.info("注册IM用户[单个]: " + createNewIMUserSingleNode.toString());
        }
//		System.out.println(uuid);
//		ObjectNode dataObjectNode = JsonNodeFactory.instance.objectNode();
//		dataObjectNode.put("name", "嘀一巴士聊天室01");
//		dataObjectNode.put("description", "测试聊天室");
//		dataObjectNode.put("maxusers", 2);
//		dataObjectNode.put("owner", uuid);
//		ObjectNode creatChatGroupNode = creatChatRooms(dataObjectNode);
//		System.out.println(creatChatGroupNode.toString());
	}
	
	/**
	 * 创建聊天室
	 * 
	 */
	public static ObjectNode creatChatRooms(ObjectNode dataObjectNode) {
		ObjectNode objectNode = factory.objectNode();
		
		// check appKey format
		if (!HTTPClientUtils.match("^(?!-)[0-9a-zA-Z\\-]+#[0-9a-zA-Z]+", APPKEY)) {
			LOGGER.error("appkey 错误");
			objectNode.put("message", "appkey 错误");
			return objectNode;
		}

		// check properties that must be provided
		if (!dataObjectNode.has("name")) {
			LOGGER.error("聊天室名称 错误");
			objectNode.put("message", "聊天室名称错误");
			return objectNode;
		}
		if (!dataObjectNode.has("description")) {
			LOGGER.error("聊天室描述错误");
			objectNode.put("message", "聊天室描述错误");
			return objectNode;
		}
		if (!dataObjectNode.has("owner")) {
			LOGGER.error("聊天室的管理员错误");
			objectNode.put("message", "聊天室的管理员错误");
			return objectNode;
		}
		
		try {
			objectNode = HTTPClientUtils.sendHTTPRequest(EndPoints.CHATROOMS_URL, credential, dataObjectNode,
					HTTPMethod.METHOD_POST);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return objectNode;
	}
	
	 /**
		 * 注册IM用户[单个]
		 * 
		 * 给指定Constants.APPKEY创建一个新的用户
		 * 
		 * @param dataNode
		 * @return
		 */
		public static ObjectNode createNewIMUserSingle(ObjectNode dataNode) {

			ObjectNode objectNode = factory.objectNode();

			// check Constants.APPKEY format
			if (!HTTPClientUtils.match("^(?!-)[0-9a-zA-Z\\-]+#[0-9a-zA-Z]+", Constants.APPKEY)) {
				LOGGER.error("Bad format of Constants.APPKEY: " + Constants.APPKEY);

				objectNode.put("message", "Bad format of Constants.APPKEY");

				return objectNode;
			}

			objectNode.removeAll();

			// check properties that must be provided
			if (null != dataNode && !dataNode.has("username")) {
				LOGGER.error("Property that named username must be provided .");

				objectNode.put("message", "Property that named username must be provided .");

				return objectNode;
			}
			if (null != dataNode && !dataNode.has("password")) {
				LOGGER.error("Property that named password must be provided .");

				objectNode.put("message", "Property that named password must be provided .");

				return objectNode;
			}

			try {

			    objectNode = HTTPClientUtils.sendHTTPRequest(EndPoints.USERS_URL, credential, dataNode,
						HTTPMethod.METHOD_POST);

			} catch (Exception e) {
				e.printStackTrace();
			}

			return objectNode;
		}
}
