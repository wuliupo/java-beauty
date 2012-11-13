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
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.util.Assert;

import com.beauty.core.dao.GenericDaoSupport;
import com.beauty.core.web.page.Page;


/**
 * author: TivyH<br>.
 * date:2010-5-20 下午03:53:09<br>.
 * @version 1.0 <br>.
 *
 */
public class GenericDaoSupportImpl<T,PK extends Serializable> extends HibernateDaoSupport implements GenericDaoSupport<T, PK>
{
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
     * @see com.foryou.framework.dao.GenericDaoSupport#delete(java.lang.Object)
     */
    public void delete(T entity)
    {
        Assert.notNull(entity);
        getHibernateTemplate().delete(entity);
    }

    /* (non-Javadoc)
     * <p>Title: delete</p>
     * <p>Description: </p>
     * @param id
     * @see com.foryou.framework.dao.GenericDaoSupport#delete(java.io.Serializable)
     */
    public void delete(PK id)
    {
        Assert.notNull(id);
        getHibernateTemplate().delete(findByPrimaryKey(id));
    }

    /* (non-Javadoc)
     * <p>Title: deleteAll</p>
     * <p>Description: </p>
     * @param entities
     * @see com.foryou.framework.dao.GenericDaoSupport#deleteAll(java.util.Collection)
     */
    public void deleteAll(Collection<T> entities)
    {
        getHibernateTemplate().deleteAll(entities);
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
      return (T)getHibernateTemplate().get(entityClass, id);
    }

    @SuppressWarnings("rawtypes")
    public List findByExample(T entity)
    {
        Assert.notNull(entity);
        return getHibernateTemplate().findByExample(entity);
    }
    
    /* (non-Javadoc)
     * <p>Title: findPageListByCriteria</p>
     * <p>Description: </p>
     * @param hql
     * @param property
     * @param firstResult
     * @param maxResults
     * @return
     * @see com.foryou.framework.dao.GenericDaoSupport#findPageListByCriteria(java.lang.String, java.util.Map, int, int)
     */   
    @Override
    public List<T> findListByCriteria(String hql,Map<String, Object> property)
    {
        return findPageListByCriteria(hql,property,-1,-1);
    }
    
    @SuppressWarnings("unchecked")
    public List<T> findListByCriteria(String hql,Object[] values)
    {
        return getHibernateTemplate().find(hql, values);
    }
    
    @SuppressWarnings("unchecked")
    public List<T> findListByCriteria(String hql,Object value)
    {
        return getHibernateTemplate().find(hql, value);
    }
    
    @SuppressWarnings("unchecked")
    public List<T> findList(String hql)
    {
        return getHibernateTemplate().find(hql);
    }
    
    /* (non-Javadoc)
     * <p>Title: findPageListByCriteria</p>
     * <p>Description: </p>
     * @param hql
     * @param property
     * @param firstResult
     * @param maxResults
     * @return
     * @see com.foryou.framework.dao.GenericDaoSupport#findPageListByCriteria(java.lang.String, java.util.Map, int, int)
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public List<T> findPageListByCriteria(final String hql,
           final Map<String, Object> property,final int firstResult,final int maxResults)
    {
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
    }

    /* (non-Javadoc)
     * <p>Title: findPageListByCriteria</p>
     * <p>Description: </p>
     * @param hql
     * @param values
     * @param firstResult
     * @param maxResults
     * @return
     * @see com.foryou.framework.dao.GenericDaoSupport#findPageListByCriteria(java.lang.String, java.util.Map, int, int)
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public List<T> findPageListByCriteria(final String hql, final Object[] values, final int firstResult, final int maxResults)
    {
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
    }
    
    /* (non-Javadoc)
     * <p>Title: findPageListByCriteria</p>
     * <p>Description: </p>
     * @param hql
     * @param value
     * @param firstResult
     * @param maxResults
     * @return
     * @see com.foryou.framework.dao.GenericDaoSupport#findPageListByCriteria(java.lang.String, java.util.Map, int, int)
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public List<T> findPageListByCriteria(final String hql, final Object value, final int firstResult, final int maxResults)
    {
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
    }
    
    /**
     * 根据参数查询分页信息
     * @param hql
     * @param property
     * @param page
     * @return List
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public Page findPageListByCriteria(final String hql,final Map<String, Object> property, final Page page)
    {
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
    }
    
    /**
     * 
     * Criteria Query include paging
     * @param hql
     * @param values
     * @param page
     * @return List
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public Page findPageListByCriteria(final String hql,final Object[] values, final Page page)
    {
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
    }
    
    /**
     * 
     * Criteria Query include paging
     * @param hql
     * @param value
     * @param page
     * @return List
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public Page findPageListByCriteria(final String hql,final Object value, final Page page)
    {
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
     * <p>Title: getTotalCount</p>
     * <p>Description: </p>
     * @param hql
     * @param map
     * @return
     * @see com.foryou.framework.dao.GenericDaoSupport#getTotalCount(java.lang.String, java.util.Map)
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public int getTotalCount(final String hql, final Map<String, ? extends Object> property)
    {
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
    }

    /* (non-Javadoc)
     * <p>Title: getTotalCount</p>
     * <p>Description: </p>
     * @param hql
     * @param values
     * @return
     * @see com.foryou.framework.dao.GenericDaoSupport#getTotalCount(java.lang.String, java.util.Map)
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public int getTotalCount(final String hql,final Object[] values)
    {
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
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public int getTotalCount(final String hql,final Object value)
    {
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
    }
    
    /* (non-Javadoc)
     * <p>Title: list</p>
     * <p>Description: </p>
     * @return
     * @see com.foryou.framework.dao.GenericDaoSupport#list()
     */
    public List<T> list()
    {
        return getHibernateTemplate().loadAll(entityClass);
    }

    /* (non-Javadoc)
     * <p>Title: save</p>
     * <p>Description: </p>
     * @param entity
     * @see com.foryou.framework.dao.GenericDaoSupport#save(java.lang.Object)
     */
    public Serializable save(T entity)
    {
       return getHibernateTemplate().save(entity);
    }

    /* (non-Javadoc)
     * <p>Title: saveOrUpdate</p>
     * <p>Description: </p>
     * @param entity
     * @see com.foryou.framework.dao.GenericDaoSupport#saveOrUpdate(java.lang.Object)
     */
    public void saveOrUpdate(T entity)
    {
        getHibernateTemplate().saveOrUpdate(entity);
    }

    /* (non-Javadoc)
     * <p>Title: saveOrUpdateAll</p>
     * <p>Description: </p>
     * @param entities
     * @see com.foryou.framework.dao.GenericDaoSupport#saveOrUpdateAll(java.util.Collection)
     */
    public void saveOrUpdateAll(Collection<T> entities)
    {
        getHibernateTemplate().saveOrUpdateAll(entities);
    }

    /* (non-Javadoc)
     * <p>Title: update</p>
     * <p>Description: </p>
     * @param entity
     * @see com.foryou.framework.dao.GenericDaoSupport#update(java.lang.Object)
     */
    public void update(T entity)
    {
        getHibernateTemplate().update(entity);
    }

    /* (non-Javadoc)
     * <p>Title: updateEntity</p>
     * <p>Description:  根据条件更新数据</p>
     * @param hql hql expression eg: from User where name =:user
     * @param map 根据变量替换hql语句中的参数
     * @return
     * @see com.foryou.framework.dao.GenericDaoSupport#updateEntity(java.lang.String, java.util.Map)
     */
    public int updateEntity(final String hql, final Map<String, ? extends Object> map)
    {
        return getHibernateTemplate().execute(new HibernateCallback<Integer>(){
            public Integer doInHibernate(Session session)
                    throws HibernateException, SQLException
            {
                Query query=session.createQuery(hql);
                
                setParameter(query,map);
                
                return query.executeUpdate();
            }
            
        });
    }

    /* (non-Javadoc)
     * <p>Title: updateEntity</p>
     * <p>Description:  根据条件更新数据</p>
     * @param hql hql expression eg: from User where name =?
     * @param map 根据变量替换hql语句中的参数
     * @return
     */
    public int updateEntity(final String hql,final Object[] values)
    {
        return getHibernateTemplate().execute(new HibernateCallback<Integer>(){
            public Integer doInHibernate(Session session)
                    throws HibernateException, SQLException
            {
                Query query=session.createQuery(hql);
                
                setParameter(query,values);
                
                return query.executeUpdate();
            }
        });
    }
    
    /* (non-Javadoc)
     * <p>Title: updateEntity</p>
     * <p>Description:  根据条件更新数据</p>
     * @param hql hql expression eg: from User where name =?
     * @param map 根据变量替换hql语句中的参数
     * @return
     */
    public int updateEntity(final String hql,final Object value)
    {
        return getHibernateTemplate().execute(new HibernateCallback<Integer>(){
            public Integer doInHibernate(Session session)
                    throws HibernateException, SQLException
            {
                Query query=session.createQuery(hql);
                query.setParameter(0,value);
                return query.executeUpdate();
            }
        });
    }
    
    /**
     * findListByDetachedCriteria
     * author TivyH 2012-7-11 下午03:58:15
     * @param detachedCriteria
     * @return List
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public List<T> findListByDetachedCriteria(final DetachedCriteria detachedCriteria) {
        return getHibernateTemplate().executeFind(new HibernateCallback(){
            public Object doInHibernate(final Session session)
                    throws HibernateException, SQLException
            {
                Criteria criteria = detachedCriteria.getExecutableCriteria(session);
                return criteria.list();
            }
        });
    }

    /**
     * findListByDetachedCriteria
     * author TivyH 2012-7-11 下午03:58:15
     * @param detachedCriteria
     * @param firstResult
     * @param maxResults
     * @return List
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public List<T> findListByDetachedCriteria(final DetachedCriteria detachedCriteria, final int firstResult, final int maxResults) {
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
    }

    /**
     * findTotalCountByDetachedCriteria
     * author TivyH 2012-7-11 下午03:58:15
     * @param detachedCriteria
     * @return int
     */
    public int findTotalCountByDetachedCriteria(final DetachedCriteria detachedCriteria)
    {
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
            
    }
    
    /**
     * findListByDetachedCriteria
     * author TivyH 2012-7-11 下午03:58:15
     * @param detachedCriteria
     * @param page
     * @return List
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public Page findListByDetachedCriteria(final DetachedCriteria detachedCriteria, final Page page,Order[] order) {
        
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
    }
    
    
    /************************************
     * Criteria测试通过Hibernate去重复方法
     * author TivyH 2012-7-11 下午03:58:15
     * @param detachedCriteria
     * @param page
     * @return List
     *************************************/
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public Page findListByDetachedCriteria(final DetachedCriteria detachedCriteria, final Page page,Order[] order,String[] distincField) {
        
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
        return getHibernateTemplate().execute(
                new HibernateCallback<Object>() {
                    public Object doInHibernate(Session session){
                        
                        Query query = session.createQuery(hql);
                        
                        setParameter(query, property);
                        
                        return query.uniqueResult();
                    }
          });
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
