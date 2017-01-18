package dao;


import entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserDao extends JpaRepository<User, Long> {

    @Query(value = "select * from userr where name=?1" ,nativeQuery = true)//nativeQuery原生态sql语句，代表能用mysql本身的sql语句
    public User findByName(String name);
    @Query(value = "insert into userr(age,name) value(?1,?2)",nativeQuery = true)
    @Modifying    //执行修改数据库操作时必须使用此注解
    public int add(int age, String name);
    @Query(value="update userr set name=?1 where id=?2",nativeQuery = true)
    @Modifying
    public int update(String name, long id);
    @Query(value = "delete from userr where id=?1",nativeQuery = true)
    @Modifying
    public int delete(long id);
}