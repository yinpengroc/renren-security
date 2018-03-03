package io.renren.entity;

public class TaxEntity {
private String key;
public String getKey() {
	return key;
}
public void setKey(String key) {
	this.key = key;
}
public int getRate() {
	return rate;
}
public void setRate(int rate) {
	this.rate = rate;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
private int rate;
private String name;
}
