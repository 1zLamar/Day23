package com.example.day21excersice.Service;

import com.example.day21excersice.ApiException.ApiException;
import com.example.day21excersice.Model.Course;
import com.example.day21excersice.Model.Teacher;
import com.example.day21excersice.Repository.CourseRepository;
import com.example.day21excersice.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;

    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    public void addCourse(Course course){
        courseRepository.save(course);
    }

    public void updateCourse(Course course,Integer id){
        Course course1=courseRepository.findCourseById(id);
        if(course1==null){
            throw new ApiException("not found");
        }
        course1.setName(course.getName());

        courseRepository.save(course1);
    }

    public void deleteCourse(Integer id){
        Course course=courseRepository.findCourseById(id);
        if(course==null){
            throw new ApiException("not found");
        }
        courseRepository.delete(course);
    }

    public void assignCourseToTeacher(Integer courseId,Integer teacherId){
        Course course=courseRepository.findCourseById(courseId);
        Teacher teacher=teacherRepository.findTeacherById(teacherId);
        if(course==null||teacher==null){
            throw new ApiException("id not found");
        }
        course.setTeacher(teacher);
        courseRepository.save(course);
    }

    public String findTeacherName(Integer id){

        Course course=courseRepository.findCourseById(id);
        if(course==null){
            throw new ApiException("id not found");
        }
        return course.getTeacher().getName();
    }

}
