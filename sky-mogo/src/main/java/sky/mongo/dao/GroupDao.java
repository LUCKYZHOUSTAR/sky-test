package sky.mongo.dao;

import lucky.sky.db.mongo.ReadWriteShardMgoDao;
import org.springframework.stereotype.Repository;
import sky.mongo.model.Group;

/**
 * @Author:chaoqiang.zhou
 * @Date:Create in 下午7:47 2018/7/10
 */

@Repository
public class GroupDao extends ReadWriteShardMgoDao<Group, Long> {


  public GroupDao() {
    super("sky_cluster");
  }


  public void insertGroup(Group group) {

    save(group);

  }

}
