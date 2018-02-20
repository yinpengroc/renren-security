package io.renren.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

import okhttp3.FormBody;
import okhttp3.FormBody.Builder;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import io.renren.entity.MutilEntity;
import io.renren.entity.TransactionEntity;
import io.renren.service.TransactionsService;
import io.renren.config.ApiConfig;

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
		String str = getResponseFromRemote(ApiConfig.getInstance().getEth_blockNumber());
		MutilEntity mutilEntity=null;
		if(StringUtils.isNotBlank(str)){
			//JsonUtil(str,MutilEntity.class);
			System.out.println(str);
			 mutilEntity=	 (MutilEntity) JSON.parseArray(str, MutilEntity.class);
			map.put("blockNumber", mutilEntity.getResult() );
		
		
			ApiConfig.getInstance().setBlockNumber(	Integer.parseInt(mutilEntity.getResult(),16));
		}	
		//System.out.println(st[3]);
		return map;

	}

	@Override
	public Map<String, Object> getBalanceByAddress(String address) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>(1);
		String rs = getResponseFromRemote(ApiConfig.getInstance().getBalance(address));
		
		
		return map;
	}

	// only for get
	private String getResponseFromRemote(String url) {
		OkHttpClient client = new OkHttpClient.Builder().readTimeout(60000, TimeUnit.MILLISECONDS)
				.writeTimeout(60000, TimeUnit.MILLISECONDS).build();
		Request request = new Request.Builder().url(url).get().build();
        String rString=null;
		Response response = null;
		try {

			response = client.newCall(request).execute();

			if (response != null && response.isSuccessful()) {
				// throw new IOException("服务器端错误: " + response);
			
				rString=response.body().string();
			} else {
				return null;
			}

//			if (response != null && response.code() != 200) {
//				System.out.println(Thread.currentThread().getName() + response.code());
//				// System.out.println(response.message());
//				System.out.println(response.body().string());
//				// System.out.println(Info.getErrorTimes() + Info.getN());
//			}

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
