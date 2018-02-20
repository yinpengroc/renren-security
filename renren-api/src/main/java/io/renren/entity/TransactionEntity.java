/**
 * 
 */
package io.renren.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author PENG
 *
 */
public class TransactionEntity {

    @JsonProperty("blockNumber")
    private String blocknumber;
    @JsonProperty("timeStamp")
    private String timestamp;
    private String hash;
    private String nonce;
    @JsonProperty("blockHash")
    private String blockhash;
    @JsonProperty("transactionIndex")
    private String transactionindex;
    private String from;
    private String to;
    private String value;
    private String gas;
    @JsonProperty("gasPrice")
    private String gasprice;
    @JsonProperty("isError")
    private String iserror;
    @JsonProperty("txreceipt_status")
    private String txreceiptStatus;
    private String input;
    @JsonProperty("contractAddress")
    private String contractaddress;
    @JsonProperty("cumulativeGasUsed")
    private String cumulativegasused;
    @JsonProperty("gasUsed")
    private String gasused;
    private String confirmations;
    public void setBlocknumber(String blocknumber) {
         this.blocknumber = blocknumber;
     }
     public String getBlocknumber() {
         return blocknumber;
     }

    public void setTimestamp(String timestamp) {
         this.timestamp = timestamp;
     }
     public String getTimestamp() {
         return timestamp;
     }

    public void setHash(String hash) {
         this.hash = hash;
     }
     public String getHash() {
         return hash;
     }

    public void setNonce(String nonce) {
         this.nonce = nonce;
     }
     public String getNonce() {
         return nonce;
     }

    public void setBlockhash(String blockhash) {
         this.blockhash = blockhash;
     }
     public String getBlockhash() {
         return blockhash;
     }

    public void setTransactionindex(String transactionindex) {
         this.transactionindex = transactionindex;
     }
     public String getTransactionindex() {
         return transactionindex;
     }

    public void setFrom(String from) {
         this.from = from;
     }
     public String getFrom() {
         return from;
     }

    public void setTo(String to) {
         this.to = to;
     }
     public String getTo() {
         return to;
     }

    public void setValue(String value) {
         this.value = value;
     }
     public String getValue() {
         return value;
     }

    public void setGas(String gas) {
         this.gas = gas;
     }
     public String getGas() {
         return gas;
     }

    public void setGasprice(String gasprice) {
         this.gasprice = gasprice;
     }
     public String getGasprice() {
         return gasprice;
     }

    public void setIserror(String iserror) {
         this.iserror = iserror;
     }
     public String getIserror() {
         return iserror;
     }

    public void setTxreceiptStatus(String txreceiptStatus) {
         this.txreceiptStatus = txreceiptStatus;
     }
     public String getTxreceiptStatus() {
         return txreceiptStatus;
     }

    public void setInput(String input) {
         this.input = input;
     }
     public String getInput() {
         return input;
     }

    public void setContractaddress(String contractaddress) {
         this.contractaddress = contractaddress;
     }
     public String getContractaddress() {
         return contractaddress;
     }

    public void setCumulativegasused(String cumulativegasused) {
         this.cumulativegasused = cumulativegasused;
     }
     public String getCumulativegasused() {
         return cumulativegasused;
     }

    public void setGasused(String gasused) {
         this.gasused = gasused;
     }
     public String getGasused() {
         return gasused;
     }

    public void setConfirmations(String confirmations) {
         this.confirmations = confirmations;
     }
     public String getConfirmations() {
         return confirmations;
     }
}
