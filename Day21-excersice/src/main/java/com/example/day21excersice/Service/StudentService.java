package com.example.day21excersice.Service;

import com.example.day21excersice.ApiException.ApiException;
import com.example.day21excersice.Model.Course;
import com.example.day21excersice.Model.Student;
import com.example.day21excersice.Repository.CourseRepository;
import com.example.day21excersice.Repository.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;


    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public void updateStudent(Student student, Integer id) {
        Student student1 = studentRepository.findStudentById(id);
        if (student1 == null) {
            throw new ApiException("not found");
        }
        student1.setName(student.getName());
        student1.setAge(student.getAge());
        student1.setMajor(student.getMajor());

        studentRepository.save(student1);
    }

    public void deleteStudent(Integer id) {
        Student student1 = studentRepository.findStudentById(id);
        if (student1 == null) {
            throw new ApiException("not found");
        }
        studentRepository.delete(student1);
        studentRepository.save(student1);
    }

    public void assignStudentToCourse(Integer studentId,Integer courseId){
        Student student=studentRepository.findStudentById(studentId);
        Course course=courseRepository.findCourseById(courseId);
        if(student==null || course==null){
            throw new ApiException("id wrong");
        }
        course.getStudents().add(student);
        student.getCourses().add(course);

        studentRepository.save(student);
        courseRepository.save(course);
}

    public void changeMajor(Integer studentId,String major){
        Student student=studentRepository.findStudentById(studentId);
        if(student==null){
            throw new ApiException("student not found");
        }
        Set<Course> courses = student.getCourses();
        for (Course course : courses) {
            course.getStudents().remove(student);
            courseRepository.save(course);
        }

        student.setMajor(major);
        studentRepository.save(student);
        }

        public Set<Student> getAllByCourseId(Integer courseId){
            Course courses=courseRepository.findCourseById(courseId);
            if (courses==null){
                throw new ApiException("not found");
            }
            return courses.getStudents();
        }







}
