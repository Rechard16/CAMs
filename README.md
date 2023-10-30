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
： User
- password: String
- userID: String
- faculty: String
- id: int
- permission: List<Permission>
# changePassword()
# viewQuery()
# viewCamps()

Staff (inherits from User)
+ createCamp(campInfo: CampInfo): Camp
+ editCamp(campID: int, campInfo: CampInfo)
+ deleteCamp(campID: int)
+ toggleVisibility(campID: int)
+ viewSuggestion(suggestionID: int)
+ approveSuggestion(suggestionID: int)
+ generateReport()

Student (inherits from User)
- points: int
- camps: List<Camp>
+ viewRemainSlots(campID: int)
+ registerCamp(campID: int)
+ submitQuery(campID: int, description: String)
+ submitSuggestion(campID: int, changes: List<Change>)
+ withdrawCamp(campID: int)

CampCommitteeMember (inherits from Student)
+ viewDetailedInfo(campID: int)

<<enumeration>> Permission
Modify
Suggest
View
Query

Query
- user: User
- camp: Camp
+ description: String
+ view()
+ reply()

Suggestion
- user: CampCommitteeMember
- camp: Camp
+ changes: List<Change>
+ view()
+ edit()
+ delete()

<<interface>> Change
+ modify(): campInfo

Camp
- information: CampInfo
- registered: List<Student>
- visibility: Boolean
+ Id: int
- committeeMembers: List<CampCommitteeMember>
- totalRegistered: int
+ addStudent(student: Student)
+ removeStudent(student: Student)
+ addCommitteeMember(member: CampCommitteeMember)
+ removeCommitteeMember(member: CampCommitteeMember)

CampInfo
+ name: String
+ dates: List<Date>
+ eligibility: Eligibility
+ location: String
+ totalSlots: int
+ committeeSlots: int
+ description: String
+ staffInCharge: Staff
+ deadline: Date

<<enumeration>> Eligibility
FACULTY
SCHOOL

Entity ClassDiagram
Control ClassDiagram

campManager
- camps: List<Camp>
+ createCamp(campInfo: CampInfo): Camp
+ deleteCamp(campID: int): boolean
+ editCamp(campID: int, campInfo: CampInfo): boolean
+ checkClash(date: Date): List<Camp>
+ updateSlot(campID: int, number: int): boolean
+ toggleVisibility(campID: int): boolean
+ getCampById(campID: int): Camp

userManager
- staffs: List<Staff>
- students: List<Student>
+ addUser(user: User): boolean
+ removeUser(userID: String): boolean
+ editUser(user: User): boolean
+ getUserByID(userID: String): User
+ checkCommittee(studentID: String): boolean
+ checkStaff(staffID: String): boolean
+ givePoint(student: Student, points: int): boolean
+ loginUser(userID: String, password: String): boolean

queryManager
- queries: List<Query>
+ createQuery(user: Student, camp: Camp, description: String): Query
+ deleteQuery(queryID: int): boolean
+ editQuery(query: Query, description: String): boolean
+ getQueryByID(queryID: int): Query
+ replyToQuery(staff: Staff, query: Query, response: String): boolean

suggestionManager
- suggestions: List<Suggestion>
+ createSuggestion(user: CampCommitteeMember, camp: Camp, changes: List<Change>): Suggestion
+ deleteSuggestion(suggestionID: int): boolean
+ editSuggestion(suggestion: Suggestion, changes: List<Change>): boolean
+ getSuggestionByID(suggestionID: int): Suggestion
+ approveSuggestion(staff: Staff, suggestion: Suggestion): boolean
