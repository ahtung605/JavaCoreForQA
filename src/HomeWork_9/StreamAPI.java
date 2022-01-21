package HomeWork_9;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Konstantin Babenko
 * @create 30.12.2021
 */

public class StreamAPI {
    /*
    Имеется следующая структура:
       interface Student {
            String getName();
            List<Course> getAllCourses();
        }
        interface Course {}
     */
    public static void main(String[] args) {

        Student student1 = new Student("Вася", Course.ADMINISTRATION);
        Student student2 = new Student("Вася", Course.DESIGN);
        Student student3 = new Student("Вася", Course.MATHEMATICS);
        Student student4 = new Student("Петя", Course.PHYSICS);
        Student student5 = new Student("Петя", Course.PROGRAMMING);
        Student student6 = new Student("Коля", Course.TESTING);
        Student student7 = new Student("Коля", Course.PROGRAMMING);
        Student student8 = new Student("Игорь", Course.TESTING);
        Student student9 = new Student("Катя", Course.ADMINISTRATION);

        ArrayList<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
        students.add(student6);
        students.add(student7);
        students.add(student8);
        students.add(student9);

//        List<String> result = students.stream()
//                .filter(student -> student.course == Course.TESTING)
//                .map((student -> student.getName()))
//                .collect(Collectors.toList());
//        System.out.println(result);

// 1. Написать функцию, принимающую список Student и возвращающую список уникальных курсов, на которые подписаны студенты.
        System.out.println("Task 1");
        List<Course> unicCourse = students.stream()
                .map((student -> student.getCourse()))
                .distinct()
                .collect(Collectors.toList());
        System.out.println(unicCourse);

//          2. Написать функцию, принимающую на вход список Student и возвращающую список из трех самых любознательных
//            (любознательность определяется количеством курсов).
        System.out.println("Task 2");
        List<String> studentsCurious = students.stream()
                .sorted((s1, s2) -> student1.getCourse().compareTo(student2.getCourse()))
//                .filter(student -> student.getCourse() == Course.TESTING) // отбор по курсу
//                .map((student -> student.getName()))
                .map((student -> student.getName()))
                .collect(Collectors.toList());
        System.out.println(studentsCurious);

//        3. Написать функцию, принимающую на вход список Student и экземпляр Course, возвращающую список студентов,
//        которые посещают этот курс.
        System.out.println("Task 3");
        List<String> studentsOnCourse = students.stream()
                .filter(student -> student.getCourse() == Course.TESTING) // отбор по курсу
                .map((student -> student.getName()))
                .collect(Collectors.toList());
        System.out.println(studentsOnCourse);

//        System.out.println(students);
    }
}
