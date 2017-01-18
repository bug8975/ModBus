import org.hibernate.metamodel.source.binder.JpaCallbackClass;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jmx.export.annotation.ManagedMetric;

import javax.transaction.Transactional;

/**
 * Created by Administrator on 2017/1/11.
 */
@Transactional
public interface Dao extends JpaRepository {
    @Query(value = "insert into test(test)  value(?1)" ,nativeQuery = true)
    @Modifying
    public int add(int a);

}
