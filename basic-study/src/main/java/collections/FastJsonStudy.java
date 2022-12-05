package collections;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.TypeUtils;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FastJsonStudy {
    public static void main(String[] args) {
//        ParserConfig.getGlobalInstance().setSafeMode(true);
//        ParserConfig.getGlobalInstance().addAutoTypeCheckHandler(new SelfAutoTypeCheckHandler());
//
//        User user = new User();
//        user.setUserId(12);
//        user.setUserName("123");
//        System.out.println(JSON.toJSONString(user, SerializerFeature.WriteClassName));
//        System.out.println(JSON.parseObject("{\"username\":1,\"id\":1}"));
//
//        String str = "{\"@type\":\"collections.FastJsonStudy.User\",\"userId\":1,\"userId\":\"test\"}";
//        user = JSON.parseObject(str, User.class);
//        System.out.println(user.getUserId());
//
//        str = "{\"@type\":\"collections.FastJsonStudy.SystemInfo\",\"code\":123,\"name\":\"snyh\"}";
//        SystemInfo systemInfo = JSON.parseObject(str, SystemInfo.class);
//        System.out.println(systemInfo.getCode());


        int[] nums1 = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        List<Integer> nums = new ArrayList<>();
        nums.add(0);
        nums.add(1);
        nums.add(2);

//        Map<String, Object> map = new HashMap<>();
//        map.put("nums_1", nums1);
//        map.put("nums_2", nums);

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");

        System.out.println(JSONObject.toJSONString(nums1));
        System.out.println(JSONObject.toJSONString(list));
    }
}

@Data
class User implements Serializable {
    private int userId;
    private String userName;
}

@Data
class SystemInfo implements Serializable {
    private String code;
    private String name;
}

class SelfAutoTypeCheckHandler implements ParserConfig.AutoTypeCheckHandler {

    @Override
    public Class<?> handler(String typeName, Class<?> expectClass, int features) {
        if (typeName.contains("User")) {
            return TypeUtils.loadClass(typeName);
        }
        return null;
    }
}
