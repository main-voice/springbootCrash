package cn.edu.tongji.penghao.springbootcrash.cotroller;

import cn.edu.tongji.penghao.springbootcrash.model.UserEntity;
import cn.edu.tongji.penghao.springbootcrash.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Optional;

// 这个类是从前端到后端传输数据
@RestController // 特殊类，区分普通类
@RequestMapping("api/v1/post") // 可以处理API
public class ExamplePost {
    @Resource
    UserRepository userRepository;

    @RequestMapping(value = "user", method = RequestMethod.POST)
    public void createUser(int id, String name, String password) {
        UserEntity user = new UserEntity();
        user.setPassword(password);
        user.setId(id);
        user.setName(name);

        // 如何存到数据库中？user是在模型中，模型本身不能访问数据库，而是应该有一个管理所有数据的对象，spring也提供了这个
        userRepository.save(user);
    }

    @RequestMapping(value = "by/obj/user", method = RequestMethod.POST)
    public void createUserByObject(@RequestBody UserEntity userEntity) { // 此处要把userEntity放在RequestBody，才可以接受参数
        userRepository.save(userEntity);
    }


}
