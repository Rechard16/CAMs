# 这是草稿
```
CAMS/
│
├── src/
│   ├── Main.java                          # 主程序入口，启动应用程序。
│   │
│   ├── model/                             # 用于存放所有的模型类。
│   │   ├── User.java
│   │   ├── Staff.java
│   │   ├── Student.java
│   │   ├── Permission.java
│   │   ├── Query.java
│   │   ├── Suggestion.java
│   │   ├── Change.java
│   │   ├── Camp.java
│   │   ├── CampInfo.java
│   │   └── Eligibility.java
│   │
│   ├── manager/                           # 用于存放所有管理器类。
│   │   ├── CampManager.java
│   │   ├── UserManager.java
│   │   ├── QueryManager.java
│   │   └── SuggestionManager.java
│   │
│   └── util/                              # 存放一些实用程序或辅助类。
│       ├── IOUtil.java                    # 用于文件输入/输出的实用程序。
│       ├── MenuDisplay.java               # 负责显示各种菜单和提示。
│       ├── Authentication.java            # 负责登录和身份验证功能。
│       └── ...
│
├── data/
│   ├── student_list.xlsx                  # 学生数据。
│   └── staff_list.xlsx                    # 员工数据。
│
└── README.md                              # 项目说明文档。
```