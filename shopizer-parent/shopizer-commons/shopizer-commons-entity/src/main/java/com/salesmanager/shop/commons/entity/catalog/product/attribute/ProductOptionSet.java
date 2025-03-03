package com.salesmanager.shop.commons.entity.catalog.product.attribute;

import com.salesmanager.shop.commons.entity.catalog.product.type.ProductType;
import com.salesmanager.shop.commons.entity.generic.SalesManagerEntity;
import com.salesmanager.shop.commons.entity.merchant.MerchantStore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Create a list of option and option value in order to accelerate and 
 * prepare product attribute creation
 * @author carlsamson
 *
 */
@Entity
@Table(name="PRODUCT_OPTION_SET",
uniqueConstraints={
		@UniqueConstraint(columnNames={
				"MERCHANT_ID",
				"PRODUCT_OPTION_SET_CODE"
			})
	}
)
public class ProductOptionSet extends SalesManagerEntity<Long, ProductOptionSet> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="PRODUCT_OPTION_SET_ID")
	@TableGenerator(name = "TABLE_GEN", table = "SM_SEQUENCER", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT", pkColumnValue = "PRODUCT_OPT_SET_SEQ_NEXT_VAL")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN")
	private Long id;
	
	@NotEmpty
	@Pattern(regexp="^[a-zA-Z0-9_]*$")
	@Column(name="PRODUCT_OPTION_SET_CODE")
	private String code;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="PRODUCT_OPTION_ID", nullable=false)
	private ProductOption option;
	
	@ManyToMany(fetch = FetchType.LAZY, targetEntity= ProductOptionValue.class)
	@JoinTable(name = "PRODUCT_OPT_SET_OPT_VALUE")
	private List<ProductOptionValue> values = new ArrayList<ProductOptionValue>();
	
	@ManyToMany(fetch = FetchType.LAZY, targetEntity=ProductType.class)
	@JoinTable(name = "PRODUCT_OPT_SET_PRD_TYPE")
	private Set<ProductType> productTypes = new HashSet<ProductType>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="MERCHANT_ID", nullable=false)
	private MerchantStore store;
	
	@Column(name="PRODUCT_OPTION_SET_DISP")
	private boolean optionDisplayOnly = false;
	
	
	public ProductOption getOption() {
		return option;
	}
	public void setOption(ProductOption option) {
		this.option = option;
	}
	public List<ProductOptionValue> getValues() {
		return values;
	}
	public void setValues(List<ProductOptionValue> values) {
		this.values = values;
	}
	public MerchantStore getStore() {
		return store;
	}
	public void setStore(MerchantStore store) {
		this.store = store;
	}
	@Override
	public Long getId() {
		return this.id;
	}
	@Override
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public boolean isOptionDisplayOnly() {
		return optionDisplayOnly;
	}
	public void setOptionDisplayOnly(boolean optionDisplayOnly) {
		this.optionDisplayOnly = optionDisplayOnly;
	}
	
	public Set<ProductType> getProductTypes() {
		return productTypes;
	}
	public void setProductTypes(Set<ProductType> productTypes) {
		this.productTypes = productTypes;
	}

}
