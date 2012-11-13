/**  
 * @ProjectName: Java Beauty Framework
 * @Package com.beauty.core.dao.impl
 * @Title: GenericDaoSupportImpl.java
 * @author TivyH
 * @date 2010-5-20 下午03:53:09
 * @version V1.0   
 */

package com.beauty.core.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.beauty.core.dao.GenericDaoSupport;
import com.beauty.core.web.page.Page;

 /**
 *
 * GenericDaoSupportImpl
 * tivy
 * 2012-11-13-下午6:46:44
 */
public class GenericDaoSupportImpl<T,PK extends Serializable> extends HibernateDaoSupport implements GenericDaoSupport<T, PK>
{
	final Logger logger = LoggerFactory.getLogger(GenericDaoSupportImpl.class);
	
    protected Class<T> entityClass;
    
    protected String className;
    
    @SuppressWarnings("unchecked")
    public GenericDaoSupportImpl(){
        entityClass= (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        className = entityClass.getSimpleName();
    }

    /* (non-Javadoc)
     * <p>Title: delete</p>
     * <p>Description: </p>
     * @param entity
     * @see com.beauty.core.dao.impl.GenericDaoSupport#delete(java.lang.Object)
     */
    public void delete(T entity)
    {
    	try {
    		getHibernateTemplate().delete(entity);
    		logger.debug("delete successful");
		} catch (RuntimeException re) {
			logger.error("delete entity error",re);
			throw re;
		}
    }
    
     /* (non-Javadoc)
     * @see com.beauty.core.dao.GenericDaoSupport#delete(java.io.Serializable)
     */
    public void delete(PK id)
    {
    	try {
    		getHibernateTemplate().delete(findByPrimaryKey(id));
    		logger.debug("delete successful");
		} catch (RuntimeException re) {
			logger.error("delete entity error",re);
			throw re;
		}
    }

    /* (non-Javadoc)
     * <p>Title: deleteAll</p>
     * <p>Description: </p>
     * @param entities
     * @see com.foryou.framework.dao.GenericDaoSupport#deleteAll(java.util.Collection)
     */
    public void deleteAll(Collection<T> entities)
    {
    	try {
    		getHibernateTemplate().deleteAll(entities);
    		logger.debug("deleteAll successful");
		} catch (RuntimeException re) {
			logger.error("deleteAll entity error",re);
			throw re;
		}
    }

    /* (non-Javadoc)
     * <p>Title: findByPrimaryKey</p>
     * <p>Description: </p>
     * @param id
     * @return
     * @see com.foryou.framework.dao.GenericDaoSupport#findByPrimaryKey(java.io.Serializable)
     */
    public T findByPrimaryKey(PK id)
    {
      try {
    	  return (T)getHibernateTemplate().get(entityClass, id);
		} catch (RuntimeException re) {
			logger.error("findByPrimaryKey error",re);
			throw re;
		}
    }

    
    /* (non-Javadoc)
     * @see com.beauty.core.dao.GenericDaoSupport#findByExample(java.lang.Object)
     */
    @SuppressWarnings("rawtypes")
    public List findByExample(T entity)
    {
        try {
        	return getHibernateTemplate().findByExample(entity);
  		} catch (RuntimeException re) {
  			logger.error("findByExample error",re);
  			throw re;
  		}
    }
    
    /* (non-Javadoc)
     * @see com.beauty.core.dao.GenericDaoSupport#findListByCriteria(java.lang.String, java.util.Map)
     */
    @Override
    public List<T> findListByCriteria(String hql,Map<String, Object> property)
    {
        try {
        	return findPageListByCriteria(hql,property,-1,-1);
  		} catch (RuntimeException re) {
  			logger.error("findListByCriteria error",re);
  			throw re;
  		}
    }
    
    
    /* (non-Javadoc)
     * @see com.beauty.core.dao.GenericDaoSupport#findListByCriteria(java.lang.String, java.lang.Object[])
     */
    @SuppressWarnings("unchecked")
    public List<T> findListByCriteria(String hql,Object[] values)
    {
        try {
        	return getHibernateTemplate().find(hql, values);
  		} catch (RuntimeException re) {
  			logger.error("findListByCriteria error",re);
  			throw re;
  		}
    }
    
    
    /* (non-Javadoc)
     * @see com.beauty.core.dao.GenericDaoSupport#findListByCriteria(java.lang.String, java.lang.Object)
     */
    @SuppressWarnings("unchecked")
    public List<T> findListByCriteria(String hql,Object value)
    {
        try {
        	 return getHibernateTemplate().find(hql, value);
  		} catch (RuntimeException re) {
  			logger.error("findListByCriteria error",re);
  			throw re;
  		}
    }
    
    
    /* (non-Javadoc)
     * @see com.beauty.core.dao.GenericDaoSupport#findList(java.lang.String)
     */
    @SuppressWarnings("unchecked")
    public List<T> findList(String hql)
    {
        try {
        	return getHibernateTemplate().find(hql);
 		} catch (RuntimeException re) {
 			logger.error("findList error",re);
 			throw re;
 		}
    }
    
    /* (non-Javadoc)
     * @see com.beauty.core.dao.GenericDaoSupport#findPageListByCriteria(java.lang.String, java.util.Map, int, int)
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public List<T> findPageListByCriteria(final String hql,
           final Map<String, Object> property,final int firstResult,final int maxResults)
    {
    	try {
    		return getHibernateTemplate().executeFind(new HibernateCallback<List>(){
                public List doInHibernate(Session session)
                        throws HibernateException, SQLException
                {
                    Query query = session.createQuery(hql);
                    
                    setParameter(query, property);
                    
                    if(firstResult>=0)
                    {
                        query.setFirstResult(firstResult);
                    }
                    
                    if(maxResults>=0)
                    {
                        query.setMaxResults(maxResults); 
                    }
                    return query.list();
                }
                
            });
		} catch (RuntimeException re) {
			logger.error("findPageListByCriteria error",re);
 			throw re;
		}
    }

  
    
    /* (non-Javadoc)
     * @see com.beauty.core.dao.GenericDaoSupport#findPageListByCriteria(java.lang.String, java.lang.Object[], int, int)
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public List<T> findPageListByCriteria(final String hql, final Object[] values, final int firstResult, final int maxResults)
    {
    	try {
    		return getHibernateTemplate().executeFind(new HibernateCallback(){
                public Object doInHibernate(Session session)
                        throws HibernateException, SQLException
                {
                    Query query = session.createQuery(hql);
                    
                    setParameter(query,values);
                    
                    if(firstResult>=0)
                    {
                        query.setFirstResult(firstResult);
                    }
                    
                    if(maxResults>=0)
                    {
                    	query.setMaxResults(maxResults); 
                    }
                     
                    return query.list();
                }
                
            });
		} catch (RuntimeException re) {
			logger.error("findPageListByCriteria error",re);
 			throw re;
		}
    }
    
    /* (non-Javadoc)
     * @see com.beauty.core.dao.GenericDaoSupport#findPageListByCriteria(java.lang.String, java.lang.Object, int, int)
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public List<T> findPageListByCriteria(final String hql, final Object value, final int firstResult, final int maxResults)
    {
    	try {
    		return getHibernateTemplate().executeFind(new HibernateCallback(){
                public Object doInHibernate(Session session)
                        throws HibernateException, SQLException
                {
                    Query query = session.createQuery(hql);
                    
                    query.setParameter(0,value);
                    
                    if(firstResult>=0)
                    {
                        query.setFirstResult(firstResult);
                    }
                    
                    if(maxResults>=0)
                    {
                    query.setMaxResults(maxResults); 
                    }
                     
                    return query.list();
                }
                
            });
		} catch (RuntimeException re) {
			logger.error("findPageListByCriteria error",re);
 			throw re;
		}
    }
    
    /* (non-Javadoc)
     * @see com.beauty.core.dao.GenericDaoSupport#findPageListByCriteria(java.lang.String, java.util.Map, com.beauty.core.web.page.Page)
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public Page findPageListByCriteria(final String hql,final Map<String, Object> property, final Page page)
    {
    	try {
    		int totalCount = getTotalCount(hql, property);
            page.setTotalCount(totalCount);
            
            List list = getHibernateTemplate().executeFind(new HibernateCallback(){
                public Object doInHibernate(Session session)
                        throws HibernateException, SQLException
                {
                    Query query = session.createQuery(hql);
                    
                    setParameter(query,property);
                    
                    if(page.getFirstResult()>=0)
                    {
                        query.setFirstResult(page.getFirstResult());
                    }
                    
                    if(page.getMaxResults()>=0)
                    {
                        query.setMaxResults(page.getMaxResults()); 
                    }
                    return query.list();
                }
            });
            page.setResult(list);
            return page;
		} catch (RuntimeException re) {
			logger.error("findPageListByCriteria error",re);
 			throw re;
		}
    }
    
    /* (non-Javadoc)
     * @see com.beauty.core.dao.GenericDaoSupport#findPageListByCriteria(java.lang.String, java.lang.Object[], com.beauty.core.web.page.Page)
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public Page findPageListByCriteria(final String hql,final Object[] values, final Page page)
    {
    	try {
    		int totalCount = getTotalCount(hql, values);
            page.setTotalCount(totalCount);
            
            List list = getHibernateTemplate().executeFind(new HibernateCallback(){
                public Object doInHibernate(Session session)
                        throws HibernateException, SQLException
                {
                    Query query = session.createQuery(hql);
                    
                    setParameter(query,values);
                    
                    if(page.getFirstResult()>=0)
                    {
                        query.setFirstResult(page.getFirstResult());
                    }
                    
                    if(page.getMaxResults()>=0)
                    {
                        query.setMaxResults(page.getMaxResults()); 
                    }
                    return query.list();
                }
            });
            page.setResult(list);
            return page;
		} catch (RuntimeException re) {
			logger.error("findPageListByCriteria error", re);
			throw re;
		}
    }
    
    /* (non-Javadoc)
     * @see com.beauty.core.dao.GenericDaoSupport#findPageListByCriteria(java.lang.String, java.lang.Object, com.beauty.core.web.page.Page)
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public Page findPageListByCriteria(final String hql,final Object value, final Page page)
    {
    	try {
    		int totalCount = getTotalCount(hql, value);
            page.setTotalCount(totalCount);
            
            List list = getHibernateTemplate().executeFind(new HibernateCallback(){
                public Object doInHibernate(Session session)
                        throws HibernateException, SQLException
                {
                    Query query = session.createQuery(hql);
                    
                    query.setParameter(0,value);
                    
                    if(page.getFirstResult()>=0)
                    {
                        query.setFirstResult(page.getFirstResult());
                    }
                    
                    if(page.getMaxResults()>=0)
                    {
                        query.setMaxResults(page.getMaxResults()); 
                    }
                    return query.list();
                }
            });
            page.setResult(list);
            return page;
		} catch (RuntimeException re) {
			logger.error("findPageListByCriteria error",re);
			throw re;
		}
    }
    
    private String generateCountHql(String hql)
    {
        int lastOrder = hql.toLowerCase().lastIndexOf(" order ");
        if(lastOrder>0)
        {
            if(hql.toLowerCase().startsWith("from "))
            {
                return "SELECT COUNT(*) "+ hql.substring(0,lastOrder);
            }
            else
            {
                return "SELECT COUNT(*) "+ hql.substring(hql.toLowerCase().indexOf(" from "),lastOrder);
            }
        }else
        {
            if(hql.toLowerCase().startsWith("from "))
            {
                return "SELECT COUNT(*) "+ hql;
            }
            else
            {
                return "SELECT COUNT(*) "+ hql.substring(hql.toLowerCase().indexOf(" from "),hql.length());
            }
        }
    }
    
    /* (non-Javadoc)
     * @see com.beauty.core.dao.GenericDaoSupport#getTotalCount(java.lang.String, java.util.Map)
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public int getTotalCount(final String hql, final Map<String, ? extends Object> property)
    {
    	try {
    		Object count = this.getHibernateTemplate().execute(
                    new HibernateCallback() {
                        public Object doInHibernate(Session session)
                                throws HibernateException, SQLException {
                            
                            String countHql = generateCountHql(hql);
                            
                            Query query = session.createQuery(countHql);
                            
                            setParameter(query, property);
                            
                            Integer count = ((Long)query.uniqueResult()).intValue();
                            return count;
                        }
                    });
            return ((Integer)count).intValue();
		} catch (RuntimeException re) {
			logger.error("findPageListByCriteria error",re);
			throw re;
		}
    }
    
    /* (non-Javadoc)
     * @see com.beauty.core.dao.GenericDaoSupport#getTotalCount(java.lang.String, java.lang.Object[])
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public int getTotalCount(final String hql,final Object[] values)
    {
    	try {
    		Object count = this.getHibernateTemplate().execute(
                    new HibernateCallback() {
                        public Object doInHibernate(Session session)
                                throws HibernateException, SQLException {

                            String countHql = generateCountHql(hql);
                            
                            Query query = session.createQuery(countHql);
                            
                            setParameter(query,values);
                            
                            Integer count = ((Long)query.uniqueResult()).intValue();
                            return count;
                        }
                    });
            return ((Integer)count).intValue();
		} catch (RuntimeException re) {
			logger.error("getTotalCount error",re);
			throw re;
		}
    }
    
    
    /* (non-Javadoc)
     * @see com.beauty.core.dao.GenericDaoSupport#getTotalCount(java.lang.String, java.lang.Object)
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public int getTotalCount(final String hql,final Object value)
    {
    	try {
    		Object count = this.getHibernateTemplate().execute(
                    new HibernateCallback() {
                        public Object doInHibernate(Session session)
                                throws HibernateException, SQLException {
                            
                            String countHql = generateCountHql(hql);
                            
                            Query query = session.createQuery(countHql);
                            query.setParameter(0,value);
                            Integer count = ((Long)query.uniqueResult()).intValue();
                            return count;
                        }
                    });
            return ((Integer)count).intValue();
		} catch (RuntimeException re) {
			logger.error("getTotalCount error",re);
			throw re;
		}
    }
    
    /* (non-Javadoc)
     * @see com.beauty.core.dao.GenericDaoSupport#list()
     */
    public List<T> list()
    {
    	try {
    		return getHibernateTemplate().loadAll(entityClass);
		} catch (RuntimeException re) {
			logger.error("list error",re);
			throw re;
		}
    }
    
     /* (non-Javadoc)
     * @see com.beauty.core.dao.GenericDaoSupport#save(java.lang.Object)
     */
    public Serializable save(T entity)
    {
    	try {
    		return getHibernateTemplate().save(entity);
		} catch (RuntimeException re) {
			logger.error("save error",re);
			throw re;
		}
    }

    /* (non-Javadoc)
     * @see com.beauty.core.dao.GenericDaoSupport#saveOrUpdate(java.lang.Object)
     */
    public void saveOrUpdate(T entity)
    {
    	try {
    		getHibernateTemplate().saveOrUpdate(entity);
		} catch (RuntimeException re) {
			logger.error("saveOrUpdate error",re);
			throw re;
		}
    }

    /* (non-Javadoc)
     * @see com.beauty.core.dao.GenericDaoSupport#saveOrUpdateAll(java.util.Collection)
     */
    public void saveOrUpdateAll(Collection<T> entities)
    {
    	try {
    		getHibernateTemplate().saveOrUpdateAll(entities);
		} catch (RuntimeException re) {
			logger.error("saveOrUpdateAll error",re);
			throw re;
		}
    }
    
    /* (non-Javadoc)
     * @see com.beauty.core.dao.GenericDaoSupport#update(java.lang.Object)
     */
    public void update(T entity)
    {
    	try {
    		getHibernateTemplate().update(entity);
		} catch (RuntimeException re) {
			logger.error("update error",re);
			throw re;
		}
    }
    
    /* (non-Javadoc)
     * @see com.beauty.core.dao.GenericDaoSupport#updateEntity(java.lang.String, java.util.Map)
     */
    public int updateEntity(final String hql, final Map<String, ? extends Object> map)
    {
    	try {
            return getHibernateTemplate().execute(new HibernateCallback<Integer>(){
                public Integer doInHibernate(Session session)
                        throws HibernateException, SQLException
                {
                    Query query=session.createQuery(hql);
                    
                    setParameter(query,map);
                    
                    return query.executeUpdate();
                }
                
            });
		} catch (RuntimeException re) {
			logger.error("updateEntity error",re);
			throw re;
		}
    }

     /* (non-Javadoc)
     * @see com.beauty.core.dao.GenericDaoSupport#updateEntity(java.lang.String, java.lang.Object[])
     */
    public int updateEntity(final String hql,final Object[] values)
    {
    	try {
            return getHibernateTemplate().execute(new HibernateCallback<Integer>(){
                public Integer doInHibernate(Session session)
                        throws HibernateException, SQLException
                {
                    Query query=session.createQuery(hql);
                    
                    setParameter(query,values);
                    
                    return query.executeUpdate();
                }
            });
		} catch (RuntimeException re) {
			logger.error("updateEntity error",re);
			throw re;
		}
    }
    
    /* (non-Javadoc)
     * @see com.beauty.core.dao.GenericDaoSupport#updateEntity(java.lang.String, java.lang.Object)
     */
    public int updateEntity(final String hql,final Object value)
    {
    	try {
    		return getHibernateTemplate().execute(new HibernateCallback<Integer>(){
                public Integer doInHibernate(Session session)
                        throws HibernateException, SQLException
                {
                    Query query=session.createQuery(hql);
                    query.setParameter(0,value);
                    return query.executeUpdate();
                }
            });
		} catch (RuntimeException re) {
			logger.error("updateEntity error",re);
			throw re;
		}
    }
    
    /* (non-Javadoc)
     * @see com.beauty.core.dao.GenericDaoSupport#findListByDetachedCriteria(org.hibernate.criterion.DetachedCriteria)
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<T> findListByDetachedCriteria(final DetachedCriteria detachedCriteria) {
    	try {
            return getHibernateTemplate().executeFind(new HibernateCallback(){
                public Object doInHibernate(final Session session)
                        throws HibernateException, SQLException
                {
                    Criteria criteria = detachedCriteria.getExecutableCriteria(session);
                    return criteria.list();
                }
            });
		} catch (RuntimeException re) {
			logger.error("findListByDetachedCriteria error",re);
			throw re;
		}
    }


    
    /* (non-Javadoc)
     * @see com.beauty.core.dao.GenericDaoSupport#findListByDetachedCriteria(org.hibernate.criterion.DetachedCriteria, int, int)
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public List<T> findListByDetachedCriteria(final DetachedCriteria detachedCriteria, final int firstResult, final int maxResults) {
    	try {
    		return getHibernateTemplate().executeFind(new HibernateCallback(){
                public Object doInHibernate(final Session session)
                        throws HibernateException, SQLException
                {
                    Criteria criteria = detachedCriteria.getExecutableCriteria(session);
                    criteria.setFirstResult(firstResult);
                    criteria.setMaxResults(maxResults);
                    return criteria.list();
                }
            });
		} catch (RuntimeException re) {
			logger.error("findListByDetachedCriteria error",re);
			throw re;
		}
    }


    
     /* (non-Javadoc)
     * @see com.beauty.core.dao.GenericDaoSupport#findTotalCountByDetachedCriteria(org.hibernate.criterion.DetachedCriteria)
     */
    public int findTotalCountByDetachedCriteria(final DetachedCriteria detachedCriteria)
    {
    	try {
    		Integer totalCount = getHibernateTemplate().execute(new HibernateCallback<Integer>(){
                public Integer doInHibernate(final Session session)
                        throws HibernateException, SQLException
                {
                    //query total count
                    Criteria criteria = detachedCriteria.getExecutableCriteria(session);
                    
                        Number number = (Number) criteria.setProjection(
                                Projections.rowCount()).uniqueResult();
                    return number.intValue();
                }
            });
            if(totalCount !=null)
            {
                return totalCount;
            }
            else
            {
                return 0;
            }
		} catch (RuntimeException re) {
			logger.error("findTotalCountByDetachedCriteria error",re);
			throw re;
		}
    }
    
    /* (non-Javadoc)
     * @see com.beauty.core.dao.GenericDaoSupport#findListByDetachedCriteria(org.hibernate.criterion.DetachedCriteria, com.beauty.core.web.page.Page, org.hibernate.criterion.Order[])
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public Page findListByDetachedCriteria(final DetachedCriteria detachedCriteria, final Page page,Order[] order) {
    	try {
    		//query total count
            if(page.getTotalCount() ==0 || page.getCurrentPageNo() == 1)
            {
                page.setTotalCount(findTotalCountByDetachedCriteria(detachedCriteria));
                detachedCriteria.setProjection(null);
            }
            
            if(order != null && order.length>0)
            {
                for(Order item : order)
                {
                    detachedCriteria.addOrder(item);
                }
            }
            
            getHibernateTemplate().executeFind(new HibernateCallback(){
                public Object doInHibernate(final Session session)
                        throws HibernateException, SQLException
                {
                    
                    Criteria criteria = detachedCriteria.getExecutableCriteria(session);
                    
                    List list = criteria.setFirstResult(page.getFirstResult()).setMaxResults(page.getMaxResults()).list();
                    
                    page.setResult(list);
                    
                    return list;
                }
            });
             return page;
		} catch (RuntimeException re) {
			logger.error("findListByDetachedCriteria error",re);
			throw re;
		}
    }
    
    /* (non-Javadoc)
     * @see com.beauty.core.dao.GenericDaoSupport#findListByDetachedCriteria(org.hibernate.criterion.DetachedCriteria, com.beauty.core.web.page.Page, org.hibernate.criterion.Order[], java.lang.String[])
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public Page findListByDetachedCriteria(final DetachedCriteria detachedCriteria, final Page page,Order[] order,String[] distincField) {
        
    	try {
    		//query total count
            if(page.getTotalCount() ==0 || page.getCurrentPageNo() == 1)
            {
                page.setTotalCount(findTotalCountByDetachedCriteria(detachedCriteria));
                
                if ( null != distincField && distincField.length >0 ) {
                detachedCriteria.setProjection(Projections.distinct(Projections.id()));
                for(int i=0;i< distincField.length;i++){ 
    	            //非重复字段
    	            Projections.property(distincField[i]);
    	            }
                } else {
                	detachedCriteria.setProjection(null);
                }
            }
            
            if(order != null && order.length>0)
            {
                for(Order item : order)
                {
                    detachedCriteria.addOrder(item);
                }
            }
            
            getHibernateTemplate().executeFind(new HibernateCallback(){
                public Object doInHibernate(final Session session)
                        throws HibernateException, SQLException
                {
                    
                    Criteria criteria = detachedCriteria.getExecutableCriteria(session);
                    
                    List list = criteria.setFirstResult(page.getFirstResult()).setMaxResults(page.getMaxResults()).list();
                    
                    page.setResult(list);
                    
                    return list;
                }
            });
             return page;
		} catch (RuntimeException re) {
			logger.error("findListByDetachedCriteria error",re);
			throw re;
		}
    }
    
    
    /**
     * 
    * @Title: queryUniqueResult
    * @Description: 根据查询条件返回一行数据
    * @param @param hql
    * @param @param property
    * @param @return    设定文件 
    * @return Object    返回类型 
    * @throws
     */
    public Object queryUniqueResult(final String hql, final Map<String, ? extends Object> property)
    {
    	try {
    		return getHibernateTemplate().execute(
                    new HibernateCallback<Object>() {
                        public Object doInHibernate(Session session){
                            
                            Query query = session.createQuery(hql);
                            
                            setParameter(query, property);
                            
                            return query.uniqueResult();
                        }
              });
		} catch (RuntimeException re) {
			logger.error("queryUniqueResult error",re);
			throw re;
		}
    }
    
    @SuppressWarnings("rawtypes")
    private void setParameter(Query query,Map<String,? extends Object> property)
    {
    	
        if(property!=null&&property.keySet()!=null&&property.keySet().size()>0)
        {
            for(Map.Entry<String,? extends Object> m : property.entrySet())
            {
                
                String key = m.getKey();
                
                Object obj = property.get(key);
                
                if(obj instanceof Object[])
                {
                    query.setParameterList(key, (Object[])obj);
                }else if(obj instanceof List)
                {
                    query.setParameterList(key, (List)obj);
                }else if(obj instanceof Set)
                {
                    query.setParameterList(key, (Set)obj);
                }else if(obj instanceof Collection)
                {
                    query.setParameterList(key, (Collection)obj);
                }else if(obj instanceof Date)
                {
                    query.setTimestamp(key, (Date)obj);
                }else
                {
                    query.setParameter(key, obj);
                }
            }
        }
    }
    
    private void setParameter(Query query,Object[] values)
    {
        if(values != null && values.length>0)
        {
            for(int i=0;i<values.length;i++)
            {
                Object obj = values[i];

                if(obj instanceof Date)
                {
                    query.setTimestamp(i, (Date)obj);
                }else
                {
                    query.setParameter(i, obj);
                }
                
            }
        }
    }
}
