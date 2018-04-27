package com.tmtc.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.tmtc.dao.CompanyDao;
import com.tmtc.dao.TalkDao;
import com.tmtc.frame.PageResult;
import com.tmtc.po.Company;
import com.tmtc.po.Talk;
import com.tmtc.po.TalkRepository;
import com.tmtc.service.TalkService;
import com.tmtc.utils.IdWorker;
import com.tmtc.utils.StringUtility;
import com.tmtc.utils.VerificationUtil;
import com.tmtc.utils.huanxin.Constants;
import com.tmtc.utils.huanxin.EasemobChatrooms;
import com.tmtc.vo.TalkVo;

@Service
public class TalkServiceImpl implements TalkService {

	@Autowired
	TalkDao talkDao;

	@Autowired
	CompanyDao companyDao;

	public int insert(Talk talk) {
		talk.setId(IdWorker.nextId());
		talk.setCreate_time(new Date());
		talk.setRoom_num(5000);
		String uuid = StringUtility.UUID();
		ObjectNode datanode = JsonNodeFactory.instance.objectNode();
		datanode.put("username", uuid);
		datanode.put("password", Constants.DEFAULT_PASSWORD);
		EasemobChatrooms.createNewIMUserSingle(datanode);
		// if (null != createNewIMUserSingleNode) {
		// LOGGER.info("注册IM用户[单个]: " + createNewIMUserSingleNode.toString());
		// }

		ObjectNode dataObjectNode = JsonNodeFactory.instance.objectNode();
		dataObjectNode.put("name", talk.getRoom_name());
		dataObjectNode.put("description", talk.getRomm_des());
		dataObjectNode.put("maxusers", 5000);
		dataObjectNode.put("owner", uuid);
		ObjectNode creatChatGroupNode = EasemobChatrooms.creatChatRooms(dataObjectNode);
		JsonNode node = creatChatGroupNode.get("data").get("id");
		talk.setRoom_id(node.toString().substring(1, node.toString().length() - 1));
		return talkDao.insert(talk);
	}

	public int update(Talk talk) {
		return talkDao.updateByPrimaryKeySelective(talk);
	}

	public PageResult select(Integer page, Integer rows, String type, String room_name, String company_id) {
		TalkRepository talkRepository = new TalkRepository();
		TalkRepository.Criteria criteria = talkRepository.createCriteria();
		talkRepository.setPageSize(rows);
		talkRepository.setRowIndex((page - 1) * rows);
		if (0 != VerificationUtil.length(type)) {
			criteria.andTypeLike("%" + type + "%");
		}
		if (0 != VerificationUtil.length(room_name)) {
			criteria.andRoom_nameLike("%" + room_name + "%");
		}
		if (0 != VerificationUtil.length(company_id)) {
			criteria.andCompany_idEqualTo(company_id);
		}
		List<Talk> list = talkDao.selectByExample(talkRepository);
		List<TalkVo> talkVolist = new ArrayList<TalkVo>();
		for (Iterator<Talk> iterator = list.iterator(); iterator.hasNext();) {
			Talk talk = (Talk) iterator.next();
			Company company = companyDao.selectByPrimaryKey(talk.getCompany_id());
			TalkVo talkVo = null;
			if (null == company) {
				talkVo = new TalkVo(talk, null);
			} else {
				talkVo = new TalkVo(talk, company.getName());
			}
			talkVolist.add(talkVo);
		}
		return new PageResult(talkDao.countByExample(talkRepository), talkVolist, 1);
	}

	@Override
	public Talk select(String company_id) {
		TalkRepository talkRepository = new TalkRepository();
		talkRepository.or().andCompany_idEqualTo(company_id);
		List<Talk> talkList = talkDao.selectByExample(talkRepository);
		if (0 == VerificationUtil.size(talkList)) {
			return null;
		}
		return talkList.get(0);
	}
}
