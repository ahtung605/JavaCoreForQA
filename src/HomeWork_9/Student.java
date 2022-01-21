package HomeWork_9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Konstantin Babenko
 * @create 30.12.2021
 */

public class Student {
    private String name;
private      Course course;


    public Student(String name, Course course) {
        this.name = name;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public Course getCourse() {
        return course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", course=" + course +
                '}';
    }
}



    enum Course {
        MATHEMATICS, PHYSICS, PROGRAMMING, TESTING, ADMINISTRATION, DESIGN;
    }

//    public String getCource() {
//        return course;
//    }

    /*
Имеется следующая структура:
   interface Student {
        String getName();
        List<Course> getAllCourses();
    }
    interface Course {}
1. Написать функцию, принимающую список Student и возвращающую список уникальных курсов, на которые подписаны студенты.
2. Написать функцию, принимающую на вход список Student и возвращающую список из трех самых любознательных
(любознательность определяется количеством курсов).
3. Написать функцию, принимающую на вход список Student и экземпляр Course, возвращающую список студентов,
которые посещают этот курс.
 */


