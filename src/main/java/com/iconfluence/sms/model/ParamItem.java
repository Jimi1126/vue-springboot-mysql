package com.iconfluence.sms.model;

/**
 * 分页查询参数类.
 * @param <T>
 */
public class ParamItem<T extends BaseEntity> {
  /**
   * 页码.
   */
  private Integer pageNum;
  /**
   * 数目.
   */
  private Integer size;
  /**
   * 查询对象.
   */
  private T entity;

  public ParamItem() {
    super();
  }

  public ParamItem(Integer pageNum, Integer size, T entity) {
    this.pageNum = pageNum;
    this.size = size;
    this.entity = entity;
  }

  public Integer getPageNum() {
    return pageNum;
  }

  public void setPageNum(Integer pageNum) {
    this.pageNum = pageNum;
  }

  public Integer getSize() {
    return size;
  }

  public void setSize(Integer size) {
    this.size = size;
  }

  public T getEntity() {
    return entity;
  }

  public void setEntity(T entity) {
    this.entity = entity;
  }
}
