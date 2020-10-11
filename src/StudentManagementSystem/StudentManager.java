package StudentManagementSystem;
/*
    学生类
    根据自己的需要进行选择
 */
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    public static void main(String[] args) {
     //用输出语句完成主界面的编写
        ArrayList<Student> arrayList = new ArrayList<Student>();
        while(true) {
            System.out.println("--------------学生信息管理系统--------------");
            System.out.println("1.添加学生");
            System.out.println("2.删除学生");
            System.out.println("3.修改学生");
            System.out.println("4.查看所有学生");
            System.out.println("5.退出");
            System.out.println("请输入你的选择:");

            Scanner sc = new Scanner(System.in);
            String line = sc.nextLine();

            switch (line) {
                case "1":
                    addStudent(arrayList);
                    break;
                case "2":
//                    System.out.println("删除学生");
                    deleteStudent(arrayList);
                    break;
                case "3":
//                    System.out.println("修改学生");
                    updateStudent(arrayList);
                    break;
                case "4":
//                    System.out.println("查看所有学生");
                    findAllStudent(arrayList);
                    break;
                case "5":
                    System.out.println("谢谢使用");
                    System.exit(0);
            }
        }
    }
    /*
    public static void addStudent(ArrayList<Student> arrayList)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入学生学号:");
        String sid = sc.nextLine();
        System.out.println("请输入学生姓名:");
        String name=sc.nextLine();
        System.out.println("请输入学生年龄:");
        String age=sc.nextLine();
        System.out.println("请输入学生居住地:");
        String address=sc.nextLine();

        Student s =new Student();
        s.setSid(sid);
        s.setName(name);
        s.setAge(age);
        s.setAddress(address);
        arrayList.add(s);

        System.out.println("添加学生成功");
    }
     */
    public static void addStudent(ArrayList<Student> arrayList)
    {
        Scanner sc = new Scanner(System.in);
        //为了使sid在while循环外可以被访问到，这里定义sid
        String sid;

        while(true){
            System.out.println("请输入学生学号:");
            sid = sc.nextLine();

            boolean flag = isUsed(arrayList, sid);

            if (flag == true) {
                System.out.println("你输入的学号已被使用过,请重新输入!");
            }else{
                break;
            }
        }

        System.out.println("请输入学生姓名:");
        String name=sc.nextLine();
        System.out.println("请输入学生年龄:");
        String age=sc.nextLine();
        System.out.println("请输入学生居住地:");
        String address=sc.nextLine();

        Student s =new Student();
        s.setSid(sid);
        s.setName(name);
        s.setAge(age);
        s.setAddress(address);
        arrayList.add(s);

        System.out.println("添加学生成功");
    }

    public static void findAllStudent(ArrayList<Student> arrayList){
        if(arrayList.size()==0)
        {
            System.out.println("无信息,请先添加信息再查询");
            //为了不让程序往下执行
            return;
        }
        System.out.println("学号\t\t姓名\t\t年龄\t\t居住地");
        for(int i=0;i<arrayList.size();i++){
            Student student = arrayList.get(i);
            System.out.println(student.getSid()+"\t"+ student.getName()+"\t\t"+student.getAge()+"岁\t\t"+student.getAddress());
        }
    }
    /*
    public static void deleteStudent(ArrayList<Student> arrayList){
        Scanner sc= new Scanner(System.in);

        System.out.println("请输入你要删除的学生的学号:");
        String sid = sc.nextLine();

        for(int i=0;i<arrayList.size();i++){
            Student s=arrayList.get(i);
            if(s.getSid().equals(sid)){
                arrayList.remove(i);
                break;
            }
        }

        System.out.println("删除学生信息成功");
    }
    */
    public static void deleteStudent(ArrayList<Student> arrayList){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要删除的学生学号:");
        String sid = sc.nextLine();
        int index=-1;
        for(int i=0;i<arrayList.size();i++)
        {
            Student s = arrayList.get(i);
            if(s.getSid().equals(sid)){
                index  =i;
                break;
            }
        }
        if(index==-1){
            System.out.println("该信息不存在,请重新输入！");
        }else{
            arrayList.remove(index);
            System.out.println("删除学生成功");
        }
    }

    public static void updateStudent(ArrayList<Student> arrayList) {
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入你要修改的学生学号:");
        String sid = sc.nextLine();

        //键盘录入要修改的学生信息
        System.out.println("请输入学生新姓名:");
        String name = sc.nextLine();
        System.out.println("请输入学生新年龄:");
        String age = sc.nextLine();
        System.out.println("请输入学生新居住地:");
        String address = sc.nextLine();

        //创建学生对象
        Student s = new Student();
        s.setSid(sid);
        s.setName(name);
        s.setAge(age);
        s.setAddress(address);

        //遍历集合修改对应的学生信息
        for (int i = 0; i < arrayList.size(); i++) {
            Student student = arrayList.get(i);
            if (student.getSid().equals(sid)) {
                arrayList.set(i, s);
                break;
            }
        }
        System.out.println("修改学生成功");
    }

    public static boolean isUsed(ArrayList<Student> arrayList,String sid){
        boolean flag = false;

        for(int i=0;i<arrayList.size();i++){
            Student s = arrayList.get(i);
            if(s.getSid().equals(sid)){
                flag=true;
                break;
            }
        }
        return flag;
    }





}
