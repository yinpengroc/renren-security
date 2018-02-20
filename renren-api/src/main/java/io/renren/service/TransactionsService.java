/**
 * 
 */
package io.renren.service;

import java.util.List;
import java.util.Map;

import io.renren.entity.TransactionEntity;

/**
 * @author PENG
 *
 */
public interface TransactionsService {
public Map<String, Object> getTransactionsByAddress(String address,String bkStart,String bkEnd);
public Map<String, Object> getTransactionsByAddress(String address);
public Map<String, Object> getCurrentBlockNumber();
public Map<String, Object> getBalanceByAddress(String address);
	 
 
}
