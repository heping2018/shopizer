package com.salesmanager.shop.commons.entity.order.attributes;

import com.salesmanager.shop.commons.entity.generic.SalesManagerEntity;
import com.salesmanager.shop.commons.entity.order.Order;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 * Entity used for storing various attributes related to an Order
 * @author c.samson
 *
 */
@Entity
@Table (name="ORDER_ATTRIBUTE" )
public class OrderAttribute extends SalesManagerEntity<Long, OrderAttribute> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ORDER_ATTRIBUTE_ID", unique=true, nullable=false)
	@TableGenerator(name = "TABLE_GEN", table = "SM_SEQUENCER", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT", pkColumnValue = "ORDER_ATTR_ID_NEXT_VALUE")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN")
	private Long id;
	
	@Column (name ="IDENTIFIER", nullable=false)
	private String key;
	
	@Column (name ="VALUE", nullable=false)
	private String value;
	
	@ManyToOne(targetEntity = Order.class)
	@JoinColumn(name = "ORDER_ID", nullable=false)
	private Order order;

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}
