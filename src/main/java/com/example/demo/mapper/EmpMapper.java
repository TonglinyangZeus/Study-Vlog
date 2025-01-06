package com.example.demo.mapper;

import com.example.demo.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Mapper
public interface EmpMapper {

    // 查询总记录数
    @Select("select count(*) from emp e left join dept d on e.dept_id = d.id")
    public Long count();

    // 分页查询
    public List<Emp> list(String name, Integer gender, LocalDate begin, LocalDate end);
    // 插入员工信息
    @Options(useGeneratedKeys = true, keyProperty = "id") // 主键返回，使用这个过后会将id赋值给emp
    @Insert("insert into emp( username, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time )\n" +
            "values ( #{username}, #{name}, #{gender}, #{phone}, #{job}, #{salary}, #{image}, #{entryDate}, #{deptId}, #{createTime}, #{updateTime} )")
    void insert(Emp emp);

    void deleteByIds(List<Integer> ids);


    Emp getInfo(Integer id);

    void updateById(Emp emp);

    @MapKey("")
    List<Map<String, Object>> countEmpJobData();
    @MapKey("")
    List<Map<String, Object>> countEmpGenderData();

    @Select("select * from emp")
    List<Emp> getlist();
}
