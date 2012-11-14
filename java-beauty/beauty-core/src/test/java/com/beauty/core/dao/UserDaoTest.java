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

import org.junit.Test;
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

	@Autowired
	private UserDao userDao;

	/**
	 * Test method for {@link com.beauty.core.dao.impl.GenericDaoSupportImpl#delete(java.lang.Object)}.
	 */
	@Test
	public void testDeleteT() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.beauty.core.dao.impl.GenericDaoSupportImpl#delete(java.io.Serializable)}.
	 */
	@Test
	public void testDeletePK() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.beauty.core.dao.impl.GenericDaoSupportImpl#deleteAll(java.util.Collection)}.
	 */
	@Test
	public void testDeleteAll() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.beauty.core.dao.impl.GenericDaoSupportImpl#findByPrimaryKey(java.io.Serializable)}.
	 */
	@Test
	public void testFindByPrimaryKey() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.beauty.core.dao.impl.GenericDaoSupportImpl#findByExample(java.lang.Object)}.
	 */
	@Test
	public void testFindByExample() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.beauty.core.dao.impl.GenericDaoSupportImpl#findListByCriteria(java.lang.String, java.util.Map)}.
	 */
	@Test
	public void testFindListByCriteriaStringMapOfStringObject() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.beauty.core.dao.impl.GenericDaoSupportImpl#findListByCriteria(java.lang.String, java.lang.Object[])}.
	 */
	@Test
	public void testFindListByCriteriaStringObjectArray() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.beauty.core.dao.impl.GenericDaoSupportImpl#findListByCriteria(java.lang.String, java.lang.Object)}.
	 */
	@Test
	public void testFindListByCriteriaStringObject() {
		fail("Not yet implemented");
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
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.beauty.core.dao.impl.GenericDaoSupportImpl#saveOrUpdateAll(java.util.Collection)}.
	 */
	@Test
	public void testSaveOrUpdateAll() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.beauty.core.dao.impl.GenericDaoSupportImpl#update(java.lang.Object)}.
	 */
	@Test
	public void testUpdate() {
		fail("Not yet implemented");
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
