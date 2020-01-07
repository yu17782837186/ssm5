package com.ning.mapper;

import com.ning.pojo.Users;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
public interface UsersMapper {

    @Results(value={
            @Result(id=true,column="id",property="id"),
            @Result(column="username",property="username"),
            @Result(column="password",property="password"),
            @Result(property="menus",many=@Many(select="com.ning.mapper.MenuMapper.selByPid"),column="{uid=id,pid=pid}")
    })
    //如果需要传递多个参数 column="{"key"=列名,"key"=列名}"  key自定义
    //另一个查询中获取传递过来的参数  #{key}
    //另一个查询public void select(Map<String,Object> map);
    @Select("select *,0 pid from users where username=#{username} and password=#{password}")
    Users selByUsers(Users users);
}
