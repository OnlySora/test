package com.service;

import com.dao.StudentDAO;
import com.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentDAO studentDAO;

    public Student getBySno(int sno){
        return studentDAO.getBySno(sno);
    }

    public List<Student> getAll(){
        return studentDAO.getAll();
    }

    public void insertList(List<Student> studentList){
        int num = studentDAO.insertList(studentList);
        if(num > 0){
            System.out.println("成功插入" + num + "条！");
        }
        else{
            System.out.println("插入失败");
        }
    }




}
