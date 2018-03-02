package io.renren.service.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.StringUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

import io.renren.common.utils.StringUtil;
import io.renren.config.ApiConfig;
import io.renren.entity.MutilEntity;
import io.renren.service.TransactionsService;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Service("transactionsService")
public class TransactionsServiceImpl implements TransactionsService {

	@Override
	public Map<String, Object> getTransactionsByAddress(String address, String bkStart, String bkEnd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> getTransactionsByAddress(String address) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> getCurrentBlockNumber() {
		Map<String, Object> map = new HashMap<>(1);

		map.put("blockNumber", ApiConfig.getInstance().getBlockNumber());

		return map;

	}

	@Override
	public Map<String, Object> getgasPrice() {
		Map<String, Object> map = new HashMap<>(1);
		map.put("gasPrice", ApiConfig.getInstance().getGasPrice());
		return map;

	}

	@Scheduled(fixedDelay = 12000)
	private void getCurrentBkSave() {

		String str = getResponseFromRemote(ApiConfig.getInstance().getEth_blockNumber());
		ApiConfig.getInstance().setBlockNumber(this.getLongByHex(str));

	}

	@Scheduled(fixedDelay = 12000)
	private void gasPriceSave() {

		String str = getResponseFromRemote(ApiConfig.getInstance().getEth_gasPrice());

		ApiConfig.getInstance().setGasPrice((this.getLongByHex(str)));

	}

	private long getLongByHex(String str) {

		MutilEntity mutilEntity = null;
		long rs = 0;
		if (StringUtils.isNotBlank(str)) {

			mutilEntity = JSON.parseObject(str, MutilEntity.class);

			String oString = StringUtil.getRidOfPro(mutilEntity.getResult(), "0x");
			rs = Long.parseLong(oString, 16);
		}
		return rs;

	}

	// gasPrice

	@Override
	public Map<String, Object> getBalanceByAddress(String address, Map<String, Object> map) {
		// TODO Auto-generated method stub
		if (map == null) {
			map = new HashMap<String, Object>(1);
		}

		// todo
		String rs = null;
		MutilEntity	mutilEntity = JSON.parseObject(getResponseFromRemote(ApiConfig.getInstance().getBalance(address)), MutilEntity.class);
		if(mutilEntity!=null){
			rs=mutilEntity.getResult();
		}
		
		map.put(address, rs);
		return map;
	}

	@Override
	public Map<String, Object> getBalanceByAddressList(List addresses) {
		// TODO Auto-generated method stub

		Map<String, Object> map = new HashMap();

		for (Object add : addresses) {
			map = this.getBalanceByAddress((String) add, map);
		}

		return map;
	}

	// only for get
	private String getResponseFromRemote(String url) {
		OkHttpClient client = new OkHttpClient.Builder().readTimeout(60000, TimeUnit.MILLISECONDS)
				.writeTimeout(60000, TimeUnit.MILLISECONDS).build();
		Request request = new Request.Builder().url(url).get().build();
		String rString = null;
		Response response = null;
		try {

			response = client.newCall(request).execute();

			if (response != null && response.isSuccessful()) {
				// throw new IOException("服务器端错误: " + response);

				rString = response.body().string();
			} else {
				return null;
			}

			// if (response != null && response.code() != 200) {
			// System.out.println(Thread.currentThread().getName() +
			// response.code());
			// // System.out.println(response.message());
			// System.out.println(response.body().string());
			// // System.out.println(Info.getErrorTimes() + Info.getN());
			// }

		} catch (IOException e) {
			// TODO Auto-generated catch block
			// Info.setException();
			// System.out.println("exception
			// :"+Thread.currentThread().getName()+response.code());
			e.printStackTrace();
		}

		finally {
			if (response != null) {

				response.close();
			}
			// response = null;
			// formBody = null;
			// client.
			client = null;
		}

		return rString;

	}

}
