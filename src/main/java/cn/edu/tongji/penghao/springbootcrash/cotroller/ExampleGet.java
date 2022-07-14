package cn.edu.tongji.penghao.springbootcrash.cotroller;

//import org.springframework.web.bind.annotation.CrossOrigin;
import cn.edu.tongji.penghao.springbootcrash.model.UserEntity;
import cn.edu.tongji.penghao.springbootcrash.repository.UserRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Optional;

// 通过restController，这个是springboot提供的，为这个类添加全注解，就可以把这个类与普通的类区分开（或者函数）
@RestController
// 请求是需要一个路径的，在里面给出，函数内也可以使用
@RequestMapping("api/v1/get")
public class ExampleGet {

    //@CrossOrigin("*")//指允许所有ip的跨域访问
    @RequestMapping("method/default")
    // request mapping 是标记一个函数能不能处理API，否则该函数无法处理
    public String simpleGetExample() {
        return "I can hear from you";
    }
    @RequestMapping("method/path/var")
    //http://localhost:8080/api/v1/get/method/path/var?number=205338&name=ph
    public String pathGetExampleV1(String number, String name) {
        return "Here is " + number + " " + name;
    }
    // 将参数放在路径中
    @RequestMapping("method/path/var/{number}/{name}")
    public String pathGetExampleV2(@PathVariable String number, @PathVariable String name) {
        return "Here is " + number + ", " + name;
    }

    @RequestMapping("query/param")
    public String queryExample(String userId, String userName) {
        return "Get user Info : " + userId + ", " + userName;
    }

    // 但API的访问，不是所有的host主机地址都可以访问的，本机是随便的，也可以配置所有的

    // 连接数据库：
    @RequestMapping("user")
    public UserEntity getUser() {
        UserEntity user = new UserEntity();
        user.setId(2053381);
        user.setName("wang");
        user.setPassword("4564156");
        return user; // 返回一个json格式的对象，相当于后端传到前端（？maybe），前端到后端存储就需要post了
    }

    @Resource
    UserRepository userRepository;

    //post是创建对象的，get是查询的，put是update对象的
    @RequestMapping("user/{id}")
    public UserEntity getUserById(@PathVariable Integer id) {
        Optional<UserEntity> user = userRepository.findById(id); // 查了后可能没有，所以用optional
        return user.orElse(null);
        /* equal to
        if (user.isPresent()) {
            return user.get();
        } else {
            return null;
        }*/
    }
}
