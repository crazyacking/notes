package com.ht.entity;

public class CustomerDetailInfo {
	private int customerId;
	private String realname;
	private String tel;
	private String address;
	private float countMoney;
	private String qq;
	
	
	
	public CustomerDetailInfo() {

	}

	public CustomerDetailInfo(int customerId, String realname, String tel,
			String address, String qq) {
		super();
		this.customerId = customerId;
		this.realname = realname;
		this.tel = tel;
		this.address = address;
		this.qq = qq;
	}
	
	
	public CustomerDetailInfo(int customerId, String realname, String tel,
			String address, float countMoney, String qq) {
		super();
		this.customerId = customerId;
		this.realname = realname;
		this.tel = tel;
		this.address = address;
		this.countMoney = countMoney;
		this.qq = qq;
	}

	
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public float getCountMoney() {
		return countMoney;
	}

	public void setCountMoney(float countMoney) {
		this.countMoney = countMoney;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + Float.floatToIntBits(countMoney);
		result = prime * result + customerId;
		result = prime * result + ((qq == null) ? 0 : qq.hashCode());
		result = prime * result
				+ ((realname == null) ? 0 : realname.hashCode());
		result = prime * result + ((tel == null) ? 0 : tel.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerDetailInfo other = (CustomerDetailInfo) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (Float.floatToIntBits(countMoney) != Float
				.floatToIntBits(other.countMoney))
			return false;
		if (customerId != other.customerId)
			return false;
		if (qq == null) {
			if (other.qq != null)
				return false;
		} else if (!qq.equals(other.qq))
			return false;
		if (realname == null) {
			if (other.realname != null)
				return false;
		} else if (!realname.equals(other.realname))
			return false;
		if (tel == null) {
			if (other.tel != null)
				return false;
		} else if (!tel.equals(other.tel))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CustomerDetailInfo [address=" + address + ", countMoney="
				+ countMoney + ", customerId=" + customerId + ", qq=" + qq
				+ ", realname=" + realname + ", tel=" + tel + "]";
	}
	
}
