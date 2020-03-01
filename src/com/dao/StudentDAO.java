package com.dao;

import com.model.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


import java.util.List;

public interface StudentDAO {
//    @Select("SELECT * FROM student WHERE sno = #{sno}")
//    public Student get(@Param("sno") int sno);
    Student getBySno(int sno);
    List<Student> getAll();
    int insertList(List<Student> studentList);
}
