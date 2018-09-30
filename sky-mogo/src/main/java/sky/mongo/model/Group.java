package sky.mongo.model;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lucky.sky.db.AbstractEntity;
import org.mongodb.morphia.annotations.Id;

/**
 * @Author:chaoqiang.zhou
 * @Date:Create in 下午7:42 2018/7/10
 */

@Getter
@Setter
public class Group extends AbstractEntity<Long> {


  @Id
  private Long id;
  private String name;
  private LocalDateTime createTime;
}
