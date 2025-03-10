package com.salesmanager.core.model.customer.connection;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Identity key for storing spring social objects
 * @author carlsamson
 *
 */
@Deprecated
@Embeddable
public class UserConnectionPK implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String userId;
	private String providerId;
	private String providerUserId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	public String getProviderUserId() {
		return providerUserId;
	}

	public void setProviderUserId(String providerUserId) {
		this.providerUserId = providerUserId;
	}

	public boolean equals(Object o) {
		if (o instanceof UserConnectionPK) {
			UserConnectionPK other = (UserConnectionPK) o;
			return other.getProviderId().equals(getProviderId())
					&& other.getProviderUserId().equals(getProviderUserId())
					&& other.getUserId().equals(getUserId());
		} else {
			return false;
		}
	}

	public int hashCode() {
		return getUserId().hashCode() + getProviderId().hashCode()
				+ getProviderUserId().hashCode();
	}

}
