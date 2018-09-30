package sky.mongo.test;

import java.time.LocalDateTime;
import org.junit.Test;
import sky.mongo.dao.GroupDao;
import sky.mongo.model.Group;

/**
 * @Author:chaoqiang.zhou
 * @Date:Create in 下午12:32 2018/7/11
 */
public class GroupDaoTest {


  GroupDao groupDa = new GroupDao();


  @Test
  public void insertGroup() {

    Group group = new Group();

    group.setId(2323L);
    group.setCreateTime(LocalDateTime.now());
    group.setName("分组名称信息");


    groupDa.insertGroup(group);
  }
}
