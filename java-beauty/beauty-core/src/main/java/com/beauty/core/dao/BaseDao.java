/**  
 * @ProjectName: Java Beauty Framework
 * @Package com.beauty.core.dao
 * @Title: GenericDaoSupport.java
 * @author TivyH
 * @date 2010-5-20 下午03:41:54
 * @version V1.0   
 */

package com.beauty.core.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;

import com.beauty.core.web.page.Page;

/**
 * author: TivyH<br>.
 * date:2010-5-20 下午03:41:54<br>.
 * @version 1.0 <br>.
 *
 */
public abstract interface BaseDao<T,PK extends Serializable>
{
    /**
     * save
     * 
     * @param entity
     */
    public Serializable save(T entity);
    
    /**
     * update
     * 
     * @param entity
     */
    public void update(T entity);
    
    /**
     * saveOrUpdate
     * 
     * @param entity
     */
    public void saveOrUpdate(T entity);
    
    /**
     * saveOrUpdateAll
     * 
     * @param entities
     */
    public void saveOrUpdateAll(Collection<T> entities);
    
    /**
     * delete
     * 
     * @param entity
     */
    public void delete(T entity);
    
    /**
     * delete by PrimaryKey
     * 
     * @param id
     */
    public void delete(PK id);
    
    /**
     * deleteAll
     * 
     * @param entities
     */
    public void deleteAll(Collection<T> entities);
    
    /**
     * find by PrimaryKey
     * 
     * @param id
     * @return T
     */
    public T findByPrimaryKey(PK id);
    
    /**
     * find by findByExample
     * 
     * @param id
     * @return T
     */
    public List<T> findByExample(T entity);
    
    /**
     * load all
     * 
     * @return List
     */
    public List<T> list();
    
    /**
     * 
     * author TivyH 2010-3-17 上午11:45:27
     * @param hql HQL查询语句，根据[:参数名称]匹配动态表达式
     * @param property 根据:后面的参数名称进行动态替换
     * @return int
     */
    public int getTotalCount(String hql,Map<String,? extends Object> property);
    
    /**
    * Title: getTotalCount 
    * @param hql HQL查询语句，根据?匹配动态表达式
    * @param values 根据hql语句中?出现的顺序进行替换
    * @return int   返回总记录条数 
     */
    public int getTotalCount(String hql,Object[] values);
    
    /**
     * Title: getTotalCount 
     * @param hql HQL查询语句，根据?匹配动态表达式
     * @param value 根据hql语句中?出现的顺序进行替换
     * @return int   返回总记录条数 
      */
     public int getTotalCount(String hql,Object value);
     
    /**
     * 
     * Criteria Query
     * @param property
     * @return List
     */
    public List<T> findListByCriteria(String hql,Map<String, Object> property);
    
    /**
     * 
     * Criteria Query
     * @param values
     * @return List
     */
    public List<T> findListByCriteria(String hql,Object[] values);
    
    /**
     * 
     * Criteria Query
     * @param value
     * @return List
     */
    public List<T> findListByCriteria(String hql,Object value);
    
    /**
     * 
     * Criteria Query
     * @return List
     */
    public List<T> findList(String hql);
    
    /**
     * 
     * Criteria Query include paging
     * @param hql
     * @param property
     * @param firstResult
     * @param maxResults
     * @return List
     */
    public List<T> findPageListByCriteria(String hql, Map<String, Object> property, int firstResult, int maxResults);
    
    /**
     * 
     * Criteria Query include paging
     * @param hql
     * @param values
     * @param firstResult
     * @param maxResults
     * @return List
     */
    public List<T> findPageListByCriteria(String hql, Object[] values, int firstResult, int maxResults);
    
    /**
     * 
     * Criteria Query include paging
     * @param hql
     * @param value
     * @param firstResult
     * @param maxResults
     * @return List
     */
    public List<T> findPageListByCriteria(String hql, Object value, int firstResult, int maxResults);
    
    /**
     * 根据参数查询分页信息
     * @param hql
     * @param property
     * @param page
     * @return List
     */
    public Page findPageListByCriteria(String hql, Map<String, Object> property, Page page);
    
    /**
     * 
     * Criteria Query include paging
     * @param hql
     * @param values
     * @param page
     * @return List
     */
    public Page findPageListByCriteria(String hql, Object[] values, Page page);
    
    /**
     * 
     * Criteria Query include paging
     * @param hql
     * @param value
     * @param page
     * @return List
     */
    public Page findPageListByCriteria(String hql, Object value, Page page);
    
    /**
     * update Entity
     * author TivyH 2010-3-18 下午04:19:15
     * @param hql
     * @param map
     * @return int
     */
    public int updateEntity(String hql,Map<String,? extends Object> map);
    
    /**
     * update Entity
     * author TivyH 2010-3-18 下午04:19:15
     * @param hql
     * @param values
     * @return int
     */
    public int updateEntity(String hql,Object[] values);
    
    /**
     * update Entity
     * author TivyH 2010-3-18 下午04:19:15
     * @param hql
     * @param value
     * @return int
     */
    public int updateEntity(String hql,Object value);
    
    /**
     * findListByDetachedCriteria
     * author TivyH 2012-7-11 下午03:58:15
     * @param detachedCriteria
     * @return List
     */
    public List<T> findListByDetachedCriteria(DetachedCriteria detachedCriteria);
    
    /**
     * findListByDetachedCriteria
     * author TivyH 2012-7-11 下午03:58:15
     * @param detachedCriteria
     * @param firstResult
     * @param maxResults
     * @return List
     */
    public List<T> findListByDetachedCriteria(DetachedCriteria detachedCriteria, int firstResult, int maxResults);
    
    
    /**
     * findTotalCountByDetachedCriteria
     * author TivyH 2012-7-11 下午03:58:15
     * @param detachedCriteria
     * @return int
     */
    public int findTotalCountByDetachedCriteria(DetachedCriteria detachedCriteria);
    
    /**
     * findListByDetachedCriteria
     * author TivyH 2012-7-11 下午03:58:15
     * @param detachedCriteria
     * @param page
     * @return List
     */
    public Page findListByDetachedCriteria(DetachedCriteria detachedCriteria,Page page,Order[] order);
    
    /**
     * findListByDetachedCriteria
     * author TivyH 2012-7-11 下午03:58:15
     * @param detachedCriteria
     * @param page
     * @param Order -- 排序字段 
     * @param distincField --非重复字段 
     * @return List
     */
    public Page findListByDetachedCriteria(DetachedCriteria detachedCriteria, Page page,Order[] order,String[] distincField); 
    
    /**
     * 
    * @Title: queryUniqueResult
    * @Description: 根据条件返回一行数据
    * @param @param hql
    * @param @param property
    * @param @return    设定文件 
    * @return Object    返回类型 
    * @throws
     */
    public Object queryUniqueResult(final String hql, final Map<String, ? extends Object> property);
}
