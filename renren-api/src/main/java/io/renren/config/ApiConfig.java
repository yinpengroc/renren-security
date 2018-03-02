package io.renren.config;

import java.text.MessageFormat;

public class ApiConfig {
	// ethscan
	//

	private  String url = "https://api.etherscan.io/api?";
	private  String key = "&apikey=YourApiKeyToken";

	private  String balance = url + "module=account&action=balance&address={0}&tag=latest" + key;
	public long getGasPrice() {
		return gasPrice;
	}

	public void setGasPrice(long gasPrice) {
		this.gasPrice = gasPrice;
	}

	private  long gasPrice;
	
	private static  ApiConfig instance;
	
	public long getBlockNumber() {
		return blockNumber;
	}


	public void setBlockNumber(long blockNumber) {
		this.blockNumber = blockNumber;
	}

	private long blockNumber;
	
	private ApiConfig(){
		
	}
	
    public static ApiConfig getInstance() {
		if(instance==null){
			instance=new ApiConfig();
		}
		return instance;
	} 
	public  String  getBalance(String address) {

		return MessageFormat.format(balance, address);
	}

	// Get a list of 'Normal' Transactions By Address
	// http://api.etherscan.io/api?&apikey=YourApiKeyToken
	private  String normalTransactions = url
			+ "module=account&action=txlist&address={0}&startblock={1}&endblock={2}&sort=asc" + key;;

	public  String getNormalTransactions(String address, String startblock, String endblock) {
		return MessageFormat.format(normalTransactions, address, startblock, endblock);
	}

	public String getHashTransactions() {
		return hashTransactions;
	}

	public String getTotalSupply() {
		return totalSupply;
	}

	public String getTokenContractAddressBalance() {
		return tokenContractAddressBalance;
	}

	public  String getEth_blockNumber() {
		return eth_blockNumber;
	}

	public String getEth_gasPrice() {
		return eth_gasPrice;
	}

	// Get a list of 'Internal' Transactions by Address
	// http://api.etherscan.io/api?module=account&action=txlistinternal&address={address}&startblock=0&endblock=2702578&sort=asc&apikey=YourApiKeyToken
	private String internalTransactions = url
			+ "module=account&action=txlistinternal&address={address}&startblock={1}&endblock={2}&sort=asc" + key;

	public String getInternalTransactions(String address, long startblock, long endblock) {
		return MessageFormat.format(internalTransactions, address, startblock, endblock);
	}

	// Get "Internal Transactions" by Transaction Hash
	// https://api.etherscan.io/api?module=account&action=txlistinternal&txhash={hash}&apikey=YourApiKeyToken
	private String hashTransactions;
	// Get ERC20-Token TotalSupply by ContractAddress
	// https://api.etherscan.io/api?module=stats&action=tokensupply&contractaddress={ContractAddress}&apikey=YourApiKeyToken
	private String totalSupply;
	// Get ERC20-Token Account Balance for TokenContractAddress
	// https://api.etherscan.io/api?module=account&action=tokenbalance&contractaddress={contractaddress}&address={address}&tag=latest&apikey=YourApiKeyToken
	private  String tokenContractAddressBalance;
	// https://api.etherscan.io/api?module=proxy&action=eth_blockNumber&apikey=YourApiKeyToken
	private  String eth_blockNumber=url+"module=proxy&action=eth_blockNumber"+key;
	
	// eth_gasPrice
	// https://api.etherscan.io/api?module=proxy&action=eth_gasPrice&apikey=YourApiKeyToken
	private String eth_gasPrice=url+"module=proxy&action=eth_gasPrice"+key;
}
