package com.salesmanager.shop.user.model;

/**
 * Object used for saving a group
 * 
 * @author carlsamson
 *
 */
public class PersistableGroup extends GroupEntity {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
  public PersistableGroup() {}
  
  public PersistableGroup(String name) {
    super.setName(name);
  }

}
