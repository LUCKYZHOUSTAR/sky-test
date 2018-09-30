package sky.test.order;


import com.sky.service.iface.OrderService;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lucky.sky.util.reflect.MethodAccess;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;

/**
 * @Author:chaoqiang.zhou
 * @Date:Create in 下午7:29 2018/6/12
 */
public class Test {


  public static void main(String[] args) {
    MethodAccess access = MethodAccess.get(Test.class);

    System.out.println(getParameterNameJava8(OrderService.class, "getOrderInfos"));
  }

  public static List<String> getParamterName(Class clazz, String methodName) {
    LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
    Method[] methods = clazz.getDeclaredMethods();
    for (Method method : methods) {
      if (methodName.equals(method.getName())) {
        String[] params = u.getParameterNames(method);
        return Arrays.asList(params);
      }
    }

    return null;
  }


  public static List<String> getParameterNameJava8(Class clazz, String methodName){
    List<String> paramterList = new ArrayList<>();
    Method[] methods = clazz.getDeclaredMethods();
    for (Method method : methods) {
      if (methodName.equals(method.getName())) {
        Parameter[] params = method.getParameters();
        for(Parameter parameter : params){
          paramterList.add(parameter.getName());
        }

      }
    }

    return paramterList;
  }

}
