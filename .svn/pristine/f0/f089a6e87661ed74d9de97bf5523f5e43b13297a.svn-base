package com.tmtc.service.appAPI;

import com.tmtc.po.ExpOrder;
import com.tmtc.po.ExpOrderRepository;
import com.tmtc.po.ShopOrder;
import com.tmtc.po.ShopOrderRepository;
import com.tmtc.vo.ExpOrderVo;
import com.tmtc.vo.ShopOrderVo;

import java.util.List;

public interface OrderAppService {

	ShopOrder addShopOrder(String order,ShopOrder shopOrder);

	void updateShopOrderTimeOut();
	
	ExpOrder addExpOrder(ExpOrder expOrder);
	
	List<ExpOrderVo> select(ExpOrderRepository expOrderRepository);
	
	List<ShopOrderVo> select(ShopOrderRepository shopOrderRepository);
}
