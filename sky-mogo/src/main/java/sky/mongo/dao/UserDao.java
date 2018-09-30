package sky.mongo.dao;

import java.time.LocalDateTime;
import java.util.List;
import lucky.sky.db.mongo.MgoDao;
import lucky.sky.util.data.PageInfo;
import org.bson.types.ObjectId;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;
import sky.mongo.model.User;

/**
 * @Author:chaoqiang.zhou
 * @Date:Create in 下午7:13 2018/7/10
 */
public class UserDao extends MgoDao<User, String> {

  public UserDao() {
    super("sky_read");
  }


  public User users(String id) {

    return get(id);
//    return createMgoQuery().filterIf("uid", id).get();
  }


  public User user(ObjectId id) {
    return createMgoQuery().filterIf("_id", id).get();
  }

  public void addUsers(User user) {

    //save 方法对于已经存在的 key 将进行 update，而 insert 方法对于已经存在的 key 将抛出 DuplicateKeyException 异常。
    insertEntities(user);
    save(user);
  }


  public List<User> users(String status, PageInfo pageInfo, LocalDateTime startTime,
      LocalDateTime endTime) {

    return createMgoQuery().filterIf("status", status)
        .btw("createtime", startTime, endTime).page(pageInfo).asList();
  }

  public void updateUser(User user) {
    save(user);
  }

  public void updateUserPwd(String pwd, String uid) {
    UpdateOperations updOps = createUpdateOperations().set("pwd", pwd);
    UpdateResults result = updateById(uid, updOps);
  }

}
