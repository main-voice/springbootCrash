package cn.edu.tongji.penghao.springbootcrash.repository;

import cn.edu.tongji.penghao.springbootcrash.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// jpa允许指定这个接口但是不实现它（java中一个接口必须实现才有实体）
// JpaRepository是一个泛型类，两个参数，一个是类型，一个是索引类型的类型，也就是主键类型
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    List<UserEntity> findAllById(int id);
}
