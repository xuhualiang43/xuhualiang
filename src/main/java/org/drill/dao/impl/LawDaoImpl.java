package org.drill.dao.impl;

import java.util.List;

import org.drill.dao.LawDao;
import org.drill.model.po.Information;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class LawDaoImpl extends HibernateDaoSupport implements LawDao {

	@Autowired
	public void setSessionFactoryOverride(SessionFactory sessionFactory) {

		super.setSessionFactory(sessionFactory);
	}

	@Override
	public int selectUsers(String username, String password) {
		List list = this.getHibernateTemplate().find(
				"from Users u where " + "u.username='" + username + "' and u.password='" + password + "'");
		if (list.size() > 0) {
			return 1;
		}
		return 0;
	}

	@Override
	public void save(Information information) {
		this.getHibernateTemplate().save(information);
	}

}
