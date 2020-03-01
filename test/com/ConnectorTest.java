package com;

import com.dao.StudentDAO;
import com.model.Student;
import com.service.StudentService;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@RunWith(SpringJUnit4ClassRunner.class)// SpringJUnit支持，由此引入Spring-Test框架支持！ 
@ContextConfiguration({"classpath:spring-config.xml"})//用于加载bean
public class ConnectorTest {
//    //获取到logger
//    private static Logger logger = Logger.getLogger(ConnectorTest.class);
//
//    @Autowired
//    private StudentDAO studentDAO;

    static StudentService studentService;

    @BeforeClass
    public static void before(){
        //获取spring配置文件
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring-config.xml");
        studentService = ctx.getBean(StudentService.class);
    }

    //测试是否连接数据库
    @org.junit.Test
    public void getAll(){
        List<Student> studentList = studentService.getAll();
        for(Student student : studentList){
            System.out.println(student);
        }
    }

    @org.junit.Test
    public void test(){
        System.out.println(UUID.randomUUID().toString().replace("-", ""));
    }

    @org.junit.Test
    public void getBySno(){
        System.out.println(studentService.getBySno(1905));
    }

    @org.junit.Test
    public void insertList(){
        List<Student> list = new ArrayList<>();
        Student student1 = new Student("小明", "546544566",
                "JAVA工程师", new Date(), "某个大学", 1905,
                "https://test", "从零开始", "未知", "知乎");
        list.add(student1);
        studentService.insertList(list);
    }


    @org.junit.Test
    public void getList(){
        File dir = new File("C:\\Users\\OnlyMe\\IdeaProjects\\TestArea\\lib"); //修改lib目录
        for (File jar : dir.listFiles()) {
            String jarname  = jar.getName();
            int index = jarname.lastIndexOf("-");
            int jarIndex = jarname.lastIndexOf(".");
            //包名
            String  bundleName = jarname.substring(0,index);
            //包版本
            String bundleVersion = jarname.substring(index +1 ,jarIndex );
            //两者缺一个说明这包不严谨，只能自行导入包
            if (bundleName ==null || bundleVersion == null){
                System.out.println("该包命名不符合要求：【" + jar.getName() + "】，请自行添加");
                continue;
            }

            System.out.println("<!--"+jar.getName()+"-->");
            getDependices(bundleName,bundleVersion);
        }

    }
    //用于查找
    public void getDependices(String key, String ver) {
        //maven的搜索api
        String url ="https://mvnrepository.com/search?q="+key;

        org.jsoup.nodes.Document doc = null;

        try {
            //获取搜索得到的html结果
            doc = Jsoup.connect(url).ignoreContentType(true).timeout(30000).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //获取html的body标签
        org.jsoup.nodes.Element elem = doc.body();
        //获取对应的包详情页地址
        String href = elem.childNodes().get(1).childNodes().get(2).childNodes().get(2).childNodes().get(0).attributes().get("href");
        System.out.println(href);
        String[] jarinfo = href.split("/");
        String result = "<dependency>\n" +
                "    <groupId>"+jarinfo[2]+"</groupId>\n" +
                "    <artifactId>"+key+"</artifactId>\n" +
                "    <version>"+ver+"</version>\n" +
                "</dependency>";
        System.out.println(result);
    }
}