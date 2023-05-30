package com.example.day21excersice.Repository;

import com.example.day21excersice.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Integer> {

    Teacher findTeacherById(Integer id);

    List<Teacher> findTeachersById(Integer id);

}
