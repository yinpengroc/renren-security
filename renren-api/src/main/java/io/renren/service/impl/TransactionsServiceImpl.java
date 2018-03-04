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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.renren.common.utils.StringUtil;
import io.renren.config.ApiConfig;
import io.renren.entity.MutilEntity;
import io.renren.service.TransactionsService;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.http2.StreamResetException;

@Service("transactionsService")
public class TransactionsServiceImpl implements TransactionsService {
	ApiConfig config = ApiConfig.getInstance();
	 private static final Logger log = LoggerFactory.getLogger(TransactionsServiceImpl.class);


	@Override
	public Map<String, Object> getTransactionsByAddress(String address, String bkStart, String bkEnd) {
		// TODO Auto-generated method stub
		String str = getResponseFromRemote(config.getNormalTransactions(address, bkStart, bkEnd));
		return getMapFromSring(str);
	}

	public Map<String, Object> getTransactionsByAddress(String address, String bkStart) {
		return this.getTransactionsByAddress(address, bkStart, String.valueOf(config.getBlockNumber()));

	}

	@Override
	public Map<String, Object> getTransactionsByAddress(String address) {
		long bk = config.getBlockNumber();
		return this.getTransactionsByAddress(address, String.valueOf(0), String.valueOf(bk));
	}

	@Override
	public Map<String, Object> getCurrentBlockNumber() {
		Map<String, Object> map = new HashMap<>(1);

		map.put("blockNumber", config.getBlockNumber());

		return map;

	}

	@Override
	public Map<String, Object> getgasPrice() {
		Map<String, Object> map = new HashMap<>(1);
		map.put("gasPrice", config.getGasPrice());
		return map;

	}

	@Scheduled(fixedDelay = 12000)
	private void getCurrentBkSave() {

		String str = getResponseFromRemote(config.getEth_blockNumber());
		config.setBlockNumber(this.getLongByHex(str));

	}

	@Scheduled(fixedDelay = 12000)
	private void gasPriceSave() {

		String str = getResponseFromRemote(config.getEth_gasPrice());

		config.setGasPrice((this.getLongByHex(str)));

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

	

	@Override
	public Map<String, Object> getBalanceByAddress(String address, Map<String, Object> map) {
		// TODO Auto-generated method stub
		if (map == null) {
			map = new HashMap<String, Object>(1);
		}

		// todo
		String rs = getResponseFromRemote(config.getBalance(address));
		MutilEntity mutilEntity = JSON.parseObject(rs, MutilEntity.class);
		if (mutilEntity == null) {
			return null;
		}
		map.put(address, mutilEntity.getResult());
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

		} catch ( StreamResetException e) {
			//e.printStackTrace();
			
			log.warn("this is call error"+url);
		   // this.getResponseFromRemote(url);
			
		}catch (IOException e) {
			// TODO: handle exception
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

	private Map<String, Object> getMapFromSring(String str) {
		Map<String, Object> map = new HashMap<>();
		MutilEntity mutilEntity = JSON.parseObject(str, MutilEntity.class);
		if (mutilEntity == null) {
			return null;
		}
		map.put("result", mutilEntity.getResult());
		return map;
	}

	@Override
	public Map<String, Object> getTransactionsByHashcode(String Hashcode) {
		// TODO Auto-generated method stub
		String rString = getResponseFromRemote(config.getHashTransactions(Hashcode));
		return getMapFromSring(rString);

	}

}
