package com.tmtc.service.appAPI;

public interface ValidTimeService {

	int insertTime(String company_id, String card_num, Integer user_type, String line_id, String line_time_id,
			String line_station_id);

	int insertUpEmployee(String company_id, String cn_ls_st, String line_id, String line_time_id);

	int insertUpEmployeeNocheck(String company_id, String cn_ls_st, String line_id, String line_time_id,Integer validDate);
}
