# CAMS

NTU AY2023/24 Semester 1 SC2002 Group Project - Camp manager System (CAMS).

Camp manager System (CAMS) is a Java console application that utilizes object-oriented concepts for student and staff to register and manage a camp. The program is designed with a focus on reusability, extensibility, and maintainability, allowing for easy upgrades and future development. It provides flexibility to accommodate different user types and their requirements.

The initial password for every user is `password`.

## Team Members

We are a group 6 from tutorial group A50, Nanyang Technological University, Singapore. There are 4 members in our group:

| Name         | Github Account                                  | Email                 |
|--------------|-------------------------------------------------|-----------------------|
|Chee ZhengRong| [pufanyi](https://github.com/pufanyi)           | [FPU001@e.ntu.edu.sg](mailto:FPU001@e.ntu.edu.sg) |
|Zhang Jiahua  | [ZhangJiahua]([https://github.com/jin-qingyang](https://github.com/Paraworks)) | [Jzhang132@e.ntu.edu.sg](Jzhang132@e.ntu.edu.sg) |
| Jiang Jinyi  | [Jinyi087](https://github.com/Jinyi087)         | [D220006@e.ntu.edu.sg](mailto:D220006@e.ntu.edu.sg) |
| Soo Ying Xi  | [niyaojiayou](https://github.com/niyaojiayou)   | [D220001@e.ntu.edu.sg](mailto:D220001@e.ntu.edu.sg)  |

## Highlights
- **Reflection**: The interface `Model` uses reflection to convert between classes and strings, enabling dynamic handling of model data without manual mapping.
- **Generic Repository Class**: `Repository<Model>` class with generics allows for flexible data storage and retrieval for any model type, reducing duplication and improving maintainability.
- **SHA-3 Password Encryption**: User passwords are encrypted using the SHA-3 algorithm for enhanced
security.
- **Batch CSV Data Import**: The system supports batch importing of initial data from CSV files, making it convenient to process large datasets in chunks.
- **Factory Design Pattern**: The factory pattern is used to quickly generate requests based on different requirements, enhancing system scalability and adaptability.
- **Data Syncing**: The system automatically saves data and synchronizes it with the database, ensuring that data is not lost in the event of a crash. You can even open multiple instances of the program and they will all be synchronized.
- **JUnit 5**: We used JUnit 5 to test our classes, it helps to ensure the correctness and robustness of our code.

## Features

## Build

Download the project from GitHub.

```bash
git clone https://github.com/pufanyi/FYPMS.git
```

Use JetBrains IntelliJ IDEA to build the project.

The project is built with Java 17.

The MANIFEST.MF file is located at `src/META-INF/MANIFEST.MF`.

## UML Class Diagram

### Main Diagram

[![Main Diagram](UMLClassDiagram/main.svg)](UMLClassDiagram/main.svg)

### Entity Sub-Diagram

[![Entity Sub-Diagram](UMLClassDiagram/entity.svg)](UMLClassDiagram/entity.svg)

### Controller Sub-Diagram

[![Controller Sub-Diagram](UMLClassDiagram/controller.svg)](UMLClassDiagram/controller.svg)

### Boundary Sub-Diagram

[![Boundary Sub-Diagram](UMLClassDiagram/boundary.svg)](UMLClassDiagram/boundary.svg)
