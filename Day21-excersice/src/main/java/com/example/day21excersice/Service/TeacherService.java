package com.example.day21excersice.Service;

import com.example.day21excersice.ApiException.ApiException;
import com.example.day21excersice.Model.Teacher;
import com.example.day21excersice.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public List<Teacher> getAllTeachers(){
        return teacherRepository.findAll();
    }
    public void addTeacher(Teacher teacher){
        teacherRepository.save(teacher);
    }
    public void updateTeacher(Teacher teacher, Integer id){
        Teacher teacher1=teacherRepository.findTeacherById(id);
        if(teacher1==null){
            throw new ApiException("not found");
        }
        teacher1.setAge(teacher.getAge());
        teacher1.setEmail(teacher.getEmail());
        teacher1.setName(teacher.getName());
        teacher1.setSalary(teacher.getSalary());

        teacherRepository.save(teacher1);
    }

    public void deleteTeacher(Integer id){
        Teacher teacher=teacherRepository.findTeacherById(id);
        if(teacher==null){
            throw new ApiException("not found");
        }
        teacherRepository.delete(teacher);
    }

    public List<Teacher> getTeachersAddress(Integer id){
        return teacherRepository.findTeachersById(id);
    }

}
