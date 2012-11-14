/**
 * Java Beauty Framework(beauty-core)
 * com.beauty.core.dao
 * UserDaoTest.java
 * 1.0 tivy
 * 2012-11-14-上午9:45:14
 * javaBeauty.com.All rights reserved
 *
 */
package com.beauty.core.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.beauty.core.BaseTest;
import com.beauty.system.bean.User;
import com.beauty.system.dao.UserDao;

 /**
 *
 * UserDaoTest
 * tivy
 * 2012-11-14-上午9:45:14
 */
public class UserDaoTest extends BaseTest {

	private final Logger logger = LoggerFactory.getLogger(UserDaoTest.class);
	
	@Autowired
	private UserDao userDao;

	/**
	 * Test method for {@link com.beauty.core.dao.impl.GenericDaoSupportImpl#delete(java.lang.Object)}.
	 */
	@Test
	public void testDeleteT() {
		User user = new User();
		user.setName("Test AAA");
		userDao.save(user);
		userDao.delete(user);
	}

	/**
	 * Test method for {@link com.beauty.core.dao.impl.GenericDaoSupportImpl#delete(java.io.Serializable)}.
	 */
	@Test
	public void testDeletePK() {
		User user = new User();
		user.setName("BBBB");
		userDao.save(user);
		userDao.delete(user.getId());
	}

	/**
	 * Test method for {@link com.beauty.core.dao.impl.GenericDaoSupportImpl#deleteAll(java.util.Collection)}.
	 */
	@Test
	public void testDeleteAll() {
		//fail("Not yet implemented");
		java.util.List<User> userList = new ArrayList<User>();
		for(int i=0;i<50;i++)
		{
			User user = new User();
			user.setName("asdae"+i);
			userList.add(user);
		}
		userDao.saveOrUpdateAll(userList);
		userDao.deleteAll(userList);
	}

	/**
	 * Test method for {@link com.beauty.core.dao.impl.GenericDaoSupportImpl#findByPrimaryKey(java.io.Serializable)}.
	 */
	@Test
	public void testFindByPrimaryKey() {
		//fail("Not yet implemented");
		User user = new User();
		user.setName("erqwe");
		userDao.save(user);
		User user2 = userDao.findByPrimaryKey(user.getId());
		Assert.assertSame(user, user2);
	}

	/**
	 * Test method for {@link com.beauty.core.dao.impl.GenericDaoSupportImpl#findByExample(java.lang.Object)}.
	 */
	@Test
	public void testFindByExample() {
		//fail("Not yet implemented");
		User user = new User();
		user.setName("Test Name");
		userDao.save(user);
		User user2 = new User();
		user2.setName(user.getName());
		List<User> userList =userDao.findByExample(user2);
		Assert.assertTrue(userList.size()>0);
	}

	/**
	 * Test method for {@link com.beauty.core.dao.impl.GenericDaoSupportImpl#findListByCriteria(java.lang.String, java.util.Map)}.
	 */
	@Test
	public void testFindListByCriteriaStringMapOfStringObject() {
		//fail("Not yet implemented");
		User user = new User();
		user.setName("Test");
		userDao.save(user);
		
		String hql = "from User where name like :name";
		java.util.Map<String,Object> property = new HashMap<String, Object>();
		property.put("name", "Test%");
		List<User> userList = userDao.findListByCriteria(hql, property);
		
		Assert.assertTrue(userList.size()>0);
		
		for(User entry : userList)
		{
			System.out.println(entry.getId()+"    "+entry.getName());
		}
		
	}

	/**
	 * Test method for {@link com.beauty.core.dao.impl.GenericDaoSupportImpl#findListByCriteria(java.lang.String, java.lang.Object[])}.
	 */
	@Test
	public void testFindListByCriteriaStringObjectArray() {
		//fail("Not yet implemented");
		User user = new User();
		user.setName("erqweerasewxtary212");
		userDao.save(user);
		
		String hql = "from User where name = ?";
		java.lang.Object[] values = new java.lang.Object[1];
		values[0] = "erqweerasewxtary212";
		List<User> userList = userDao.findListByCriteria(hql, values);
		Assert.assertEquals(user.getId(), userList.get(0).getId());
	}

	/**
	 * Test method for {@link com.beauty.core.dao.impl.GenericDaoSupportImpl#findListByCriteria(java.lang.String, java.lang.Object)}.
	 */
	@Test
	public void testFindListByCriteriaStringObject() {
		//fail("Not yet implemented");
		
		
	}

	/**
	 * Test method for {@link com.beauty.core.dao.impl.GenericDaoSupportImpl#findList(java.lang.String)}.
	 */
	@Test
	public void testFindList() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.beauty.core.dao.impl.GenericDaoSupportImpl#findPageListByCriteria(java.lang.String, java.util.Map, int, int)}.
	 */
	@Test
	public void testFindPageListByCriteriaStringMapOfStringObjectIntInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.beauty.core.dao.impl.GenericDaoSupportImpl#findPageListByCriteria(java.lang.String, java.lang.Object[], int, int)}.
	 */
	@Test
	public void testFindPageListByCriteriaStringObjectArrayIntInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.beauty.core.dao.impl.GenericDaoSupportImpl#findPageListByCriteria(java.lang.String, java.lang.Object, int, int)}.
	 */
	@Test
	public void testFindPageListByCriteriaStringObjectIntInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.beauty.core.dao.impl.GenericDaoSupportImpl#findPageListByCriteria(java.lang.String, java.util.Map, com.beauty.core.web.page.Page)}.
	 */
	@Test
	public void testFindPageListByCriteriaStringMapOfStringObjectPage() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.beauty.core.dao.impl.GenericDaoSupportImpl#findPageListByCriteria(java.lang.String, java.lang.Object[], com.beauty.core.web.page.Page)}.
	 */
	@Test
	public void testFindPageListByCriteriaStringObjectArrayPage() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.beauty.core.dao.impl.GenericDaoSupportImpl#findPageListByCriteria(java.lang.String, java.lang.Object, com.beauty.core.web.page.Page)}.
	 */
	@Test
	public void testFindPageListByCriteriaStringObjectPage() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.beauty.core.dao.impl.GenericDaoSupportImpl#getTotalCount(java.lang.String, java.util.Map)}.
	 */
	@Test
	public void testGetTotalCountStringMapOfStringQextendsObject() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.beauty.core.dao.impl.GenericDaoSupportImpl#getTotalCount(java.lang.String, java.lang.Object[])}.
	 */
	@Test
	public void testGetTotalCountStringObjectArray() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.beauty.core.dao.impl.GenericDaoSupportImpl#getTotalCount(java.lang.String, java.lang.Object)}.
	 */
	@Test
	public void testGetTotalCountStringObject() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.beauty.core.dao.impl.GenericDaoSupportImpl#list()}.
	 */
	@Test
	public void testList() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.beauty.core.dao.impl.GenericDaoSupportImpl#save(java.lang.Object)}.
	 */
	@Test
	@Rollback(false)
	public void testSave() {
		User user = new User();
		user.setName("zhangsan");
		userDao.save(user);
	}

	/**
	 * Test method for {@link com.beauty.core.dao.impl.GenericDaoSupportImpl#saveOrUpdate(java.lang.Object)}.
	 */
	@Test
	public void testSaveOrUpdate() {
		User user = new User();
		user.setName("Test Name");
		userDao.saveOrUpdate(user);
		Assert.assertEquals("Test Name", userDao.findByPrimaryKey(user.getId()).getName());
	}

	/**
	 * Test method for {@link com.beauty.core.dao.impl.GenericDaoSupportImpl#saveOrUpdateAll(java.util.Collection)}.
	 */
	@Test
	public void testSaveOrUpdateAll() {
		java.util.List<User> userList = new ArrayList<User>();
		for(int i=0;i<50;i++)
		{
			User user = new User();
			user.setName("Test Name"+i);
			userList.add(user);
		}
		userDao.saveOrUpdateAll(userList);
	}

	/**
	 * Test method for {@link com.beauty.core.dao.impl.GenericDaoSupportImpl#update(java.lang.Object)}.
	 */
	@Test
	public void testUpdate() {
		User user = new User();
		user.setName("zhangsan");
		userDao.save(user);
		logger.info(user.getId()+"");
		user.setName("zhangsan 11");
		userDao.update(user);
	}

	/**
	 * Test method for {@link com.beauty.core.dao.impl.GenericDaoSupportImpl#updateEntity(java.lang.String, java.util.Map)}.
	 */
	@Test
	public void testUpdateEntityStringMapOfStringQextendsObject() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.beauty.core.dao.impl.GenericDaoSupportImpl#updateEntity(java.lang.String, java.lang.Object[])}.
	 */
	@Test
	public void testUpdateEntityStringObjectArray() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.beauty.core.dao.impl.GenericDaoSupportImpl#updateEntity(java.lang.String, java.lang.Object)}.
	 */
	@Test
	public void testUpdateEntityStringObject() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.beauty.core.dao.impl.GenericDaoSupportImpl#findListByDetachedCriteria(org.hibernate.criterion.DetachedCriteria)}.
	 */
	@Test
	public void testFindListByDetachedCriteriaDetachedCriteria() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.beauty.core.dao.impl.GenericDaoSupportImpl#findListByDetachedCriteria(org.hibernate.criterion.DetachedCriteria, int, int)}.
	 */
	@Test
	public void testFindListByDetachedCriteriaDetachedCriteriaIntInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.beauty.core.dao.impl.GenericDaoSupportImpl#findTotalCountByDetachedCriteria(org.hibernate.criterion.DetachedCriteria)}.
	 */
	@Test
	public void testFindTotalCountByDetachedCriteria() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.beauty.core.dao.impl.GenericDaoSupportImpl#findListByDetachedCriteria(org.hibernate.criterion.DetachedCriteria, com.beauty.core.web.page.Page, org.hibernate.criterion.Order[])}.
	 */
	@Test
	public void testFindListByDetachedCriteriaDetachedCriteriaPageOrderArray() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.beauty.core.dao.impl.GenericDaoSupportImpl#findListByDetachedCriteria(org.hibernate.criterion.DetachedCriteria, com.beauty.core.web.page.Page, org.hibernate.criterion.Order[], java.lang.String[])}.
	 */
	@Test
	public void testFindListByDetachedCriteriaDetachedCriteriaPageOrderArrayStringArray() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.beauty.core.dao.impl.GenericDaoSupportImpl#queryUniqueResult(java.lang.String, java.util.Map)}.
	 */
	@Test
	public void testQueryUniqueResult() {
		fail("Not yet implemented");
	}

}
