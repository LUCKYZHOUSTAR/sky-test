package sky.mongo.model;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lucky.sky.db.DbEntity;
import org.mongodb.morphia.annotations.Id;
import org.springframework.stereotype.Repository;

/**
 * @Author:chaoqiang.zhou
 * @Date:Create in 下午7:12 2018/7/10
 */

@Getter
@Setter
@Repository
public class User implements DbEntity<String> {

  @Id
  private String id;
  private String uname;
  private LocalDateTime createTime;

  @Override
  public String getId() {
    return id;
  }

  @Override
  public void setId(String id) {
    this.id = id;
  }
}
