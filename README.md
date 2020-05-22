# 学生信息管理系统 (老旧项目再修改)
(有可能不再更新了)
这是一个 2017年年底开始做的系统, 原用于毕设, 限于当时的技术水平有限, 底层各个方面都不是十分合理, 复用性也很差.
但是设计当初是为了以 SrinpBoot + SpringSecurity + JWT 配合颗粒度细分至按钮 (url)而构建的, 所以其他逻辑代码比较烂也能够理解! (强行洗白...)
## 项目目录
```
├── README.md
├── lib
├── pom.xml
src
├── main
│   ├── java
│   │   └── com
│   │       └── student
│   │           └── info
│   │               ├── Application.java (SpringBoot主入口文件)
│   │               ├── DTO (Data Transfer Object: 数据传输类)
│   │               │   ├── CourseInfoStuCondition.java (课程信息查找条件)
│   │               │   ├── CoursefInfoDTO.java (课程关键信息)
│   │               │   ├── RolesDTO.java (角色)
│   │               │   ├── RolesPermissionDTO.java (角色权限)
│   │               │   ├── RolesUserDTO.java (用户角色)
│   │               │   ├── TokenDTO.java (JWT相关)
│   │               │   ├── UserDTO.java (用户)
│   │               │   └── UserRepository.java (忘了)
│   │               ├── configurer (基础配置)
│   │               │   ├── MybatisConfigurer.java (Mybatis工具的配置类)
│   │               │   └── WebMvcConfigurer.java (SpringBoot拦截器的基础配置类)
│   │               ├── core (核心类)
│   │               │   ├── AbstractService.java
│   │               │   ├── Mapper.java
│   │               │   ├── ProjectConstant.java
│   │               │   ├── Result.java
│   │               │   ├── ResultCode.java
│   │               │   ├── ResultGenerator.java
│   │               │   ├── RoleCode.java
│   │               │   ├── Service.java
│   │               │   └── ServiceException.java
│   │               ├── dao
│   │               │   ├── CourseInfoMapper.java (课程信息)
│   │               │   ├── CourseInfoStudentMapper.java (学生选课信息)
│   │               │   ├── LearningguidStudentslistMapper.java (学生导师信息)
│   │               │   ├── PermissionMapper.java (权限)
│   │               │   ├── PermissionRoleMapper.java (权限角色)
│   │               │   ├── RoleMapper.java (角色)
│   │               │   ├── StudentsMapper.java (学生)
│   │               │   ├── TeacherInfoMapper.java (老师)
│   │               │   ├── UserMapper.java (用户 -- 用于关联学生和老师)
│   │               │   ├── UserRoleMapper.java (用户角色)
│   │               │   └── confirmListMapper.java (老师确认)
│   │               ├── model (实体类, 同上, 不多赘述)
│   │               │   ├── CourseInfo.java
│   │               │   ├── CourseInfoStudent.java
│   │               │   ├── LearningguidStudentslist.java
│   │               │   ├── Permission.java
│   │               │   ├── PermissionRole.java
│   │               │   ├── Role.java
│   │               │   ├── Students.java
│   │               │   ├── TeacherInfo.java
│   │               │   ├── User.java
│   │               │   ├── UserRole.java
│   │               │   └── confirmList.java
│   │               ├── securitConf (SpringSecurity相关)
│   │               │   ├── CustomUserService.java (自定义用户信息类 -- 重写 security的)
│   │               │   ├── JWTAuthenticationFilter.java (JWT授权过滤器)
│   │               │   ├── JWTLoginFilter.java (JWT登陆类)
│   │               │   ├── MyAccessDecisionManager.java (权限过滤)
│   │               │   ├── MyFilterSecurityInterceptor.java (权限拦截)
│   │               │   ├── MyGrantedAuthority.java (授权检查)
│   │               │   ├── MyInvocationSecurityMetadataSourceService.java (emmm忘了)
│   │               │   └── WebSecurityConfig.java (忘了)
│   │               ├── service (类似 dao不赘述了)
│   │               │   ├── CourseInfoService.java
│   │               │   ├── CourseInfoStudentService.java
│   │               │   ├── LearningguidStudentslistService.java
│   │               │   ├── PermissionRoleService.java
│   │               │   ├── PermissionService.java
│   │               │   ├── RoleService.java
│   │               │   ├── StudentsService.java
│   │               │   ├── TeacherInfoService.java
│   │               │   ├── UserRoleService.java
│   │               │   ├── UserService.java
│   │               │   ├── confirmListService.java
│   │               │   └── impl
│   │               │       ├── CourseInfoServiceImpl.java
│   │               │       ├── CourseInfoStudentServiceImpl.java
│   │               │       ├── LearningguidStudentslistServiceImpl.java
│   │               │       ├── PermissionRoleServiceImpl.java
│   │               │       ├── PermissionServiceImpl.java
│   │               │       ├── RoleServiceImpl.java
│   │               │       ├── StudentsServiceImpl.java
│   │               │       ├── TeacherInfoServiceImpl.java
│   │               │       ├── UserRoleServiceImpl.java
│   │               │       ├── UserServiceImpl.java
│   │               │       └── confirmListServiceImpl.java
│   │               ├── utils (工具类)
│   │               │   ├── DATEUtils.java (日期格式规范)
│   │               │   ├── JWTUtils.java (JWT 解析/加密)
│   │               │   ├── MD5Utils.java (密码加密)
│   │               │   └── UUIDUtils.java (数据库 id唯一生成器)
│   │               └── web (同 dao, 不多赘述)
│   │                   ├── CourseInfoController.java
│   │                   ├── CourseInfoStudentController.java
│   │                   ├── LearningguidStudentslistController.java
│   │                   ├── PermissionController.java
│   │                   ├── PermissionRoleController.java
│   │                   ├── RoleController.java
│   │                   ├── StudentsController.java
│   │                   ├── TeacherInfoController.java
│   │                   ├── UserController.java
│   │                   ├── UserRoleController.java
│   │                   └── confirmListController.java
│   └── resources (资源文件夹)
│       ├── application-dev.properties (开发环境配置)
│       ├── application-prod.properties (生成环境配置)
│       ├── application-test.properties (测试环境配置)
│       ├── application.properties (配置文件入口)
│       ├── banner.txt (神奇的东西)
│       └── mapper (数据操作类/映射类)
│           ├── CourseInfoMapper.xml
│           ├── CourseInfoStudentMapper.xml
│           ├── LearningguidStudentslistMapper.xml
│           ├── PermissionMapper.xml
│           ├── PermissionRoleMapper.xml
│           ├── RoleMapper.xml
│           ├── StudentsMapper.xml
│           ├── TeacherInfoMapper.xml
│           ├── UserMapper.xml
│           ├── UserRoleMapper.xml
│           └── confirmListMapper.xml
└── test
    ├── java
    │   ├── CodeGenerator.java
    │   └── com
    │       └── conpany
    │           └── project
    │               └── Tester.java
    └── resources
        ├── demo-user.sql
        └── generator
            └── template
                ├── controller-restful.ftl
                ├── controller.ftl
                ├── service-impl.ftl
                └── service.ftl
├── sudent-info-management.iml
└── target
```
