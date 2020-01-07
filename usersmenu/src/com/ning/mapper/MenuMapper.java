package com.ning.mapper;

import com.ning.pojo.Menu;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface MenuMapper {
    @Results(value={
            @Result(id=true,property="id",column="id"),
            @Result(property="name",column="name"),
            @Result(property="pid",column="pid"),
            @Result(property="children",many=@Many(select="selByPid"),column="{uid=uid,pid=id}"),
    })
    @Select("select *,#{uid} uid from menu where id in (select mid from users_menu where uid=#{uid}) and pid=#{pid}")
    List<Menu> selByPid(Map<String,Object> map);
}
