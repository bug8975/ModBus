package dao;


import javax.persistence.Query;

import entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/1/9.
 */
@Repository
@Transactional
public class UserDaoImpl1 implements UserDao1 {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> mohufind(String b) {


        TypedQuery a= (TypedQuery) em.createNativeQuery("select id,name,age from userr  where  name LIKE '李%'"+b ,User.class);


        return a.getResultList();
    }
}
