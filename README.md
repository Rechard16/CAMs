# CAMS

NTU AY2023/24 Semester 1 SC2002 Group Project - Camp manager System (CAMS).

Camp manager System (CAMS) is a Java console application that utilizes object-oriented concepts for student and staff to register and manage a camp. The program is designed with a focus on reusability, extensibility, and maintainability, allowing for easy upgrades and future development. It provides flexibility to accommodate different user types and their requirements.

The initial password for every user is `password`.

## Team Members

We are a group 6 from tutorial group SCL2, Nanyang Technological University, Singapore. There are 5 members in our group:

| Name           | Github Account                                  
|----------------|-------------------------------------------------
|CHEE ZHENG RONG |
|PARK JIHAE      | [pimangnono](https://github.com/pimangnono)
|YANG IIYU       | [POeticPotatoes](https://github.com/POeticPotatoes)
|ZENG RUIXIAO    | [Rechard16](https://github.com/Rechard16)
|ZHANG JIAHUA    | [Paraworks](https://github.com/Paraworks)

## Report and declaration
You can view them [here](https://github.com/Rechard16/CAMs/tree/main/Report)

## Table of Contents
* [Build](#build)
* [Running the Project](#running-the-project)
    * [Login Details](#login-details)
    * [Test Data](#test-data)
    * [File Generation](#file-generation)
    * [Resetting Data](#resetting-data)

## Build

Download the project from GitHub.

```bash
git clone https://github.com/Rechard16/CAMs.git
```

## Running the Project
The main program is found at `src/main/Main.java`.

It may be run with Visual Studio Code, Intellij or Eclipse.

### Login Details
Students and staff have their accounts created by default.
* The default password is "password", and can be changed upon login.

| Username | Position | Faculty |
|-|-|-|
HUKUMAR|Staff|SCSE
OURIN|Staff|ADM
UPAM|Staff|EEE
ANWIT|Staff|SCSE
ARVI|Staff|NBS
YCHERN|Student|SCSE
KOH1|Student|ADM
BRO15|Student|EEE
CT113|Student|SCSE
YCN019|Student|NBS
DL007|Student|SCSE
DON84|Student|ADM
ELI34|Student|EEE
LE51|Student|SCSE
SL22|Student|NBS
AKY013|Student|SSS

### Test data
By default, CAMs initially has no camps in its system.

If you wish to test CAMs with test data, 2 input files are provided under `data/defaults`:

> NOTE: If you wish to test CAMs with these files, remember to [RESET](#resetting-data) the data before running them.

|Filename | Description|
| - | - |
| data/defaults/populate_camps.in | Adds several camps with different names and faculties (and dates)
| data/defaults/register_camps.in | Should be run after `populate_camps.in`. Registers 9 students for the camp "Zenith". YCHERN and AKY013 are not registered. 

* After running the test inputs, some users'  passwords will be changed to "password1".
* Several camps will be added, and 9 students will be registered for camp "Zenith"  
    (Since it only has 9 slots, the camp will be full)

After running `populate_camps`, the following camps will be added to the system:

faculty|camp name|date start|date end|hidden from students|open to school|location|slot|committee|registration deadline
|-|-|-|-|-|-|-|-|-|-|
scse (HUKUMAR)|Journey's End|2023-12-12|2023-12-15|y|n|NTU|10|2|2023-12-10
scse (HUKUMAR)|Zenith|2023-12-16|2023-12-19|y|y|NUS|9|1|2023-12-15
scse (HUKUMAR)|Lord of the Flies|2023-12-25|2023-12-25|y|n|Unknown Island|13|2|2023-10-10
scse (HUKUMAR)|Secret Base|2023-12-20|2023-12-20|n|n|NUS|13|2|2023-12-11
ADM (OURIN)|Apples and Oranges|2023-12-14|2023-12-16|y|y|NTU|10|2|2023-12-10
ADM (OURIN)|Trick or Treat|2023-12-15|2023-12-15|y|n|NTU|10|2|2023-12-10
SCSE (ANWIT)|Modern Horror|2024-01-05|2024-01-07|y|n|NUS|10|2|2023-12-10

### File Generation
CAMs allows the user to generate reports about their camps. After generation, the report will be found in the root directory of the project as `camp_report.txt` or `committee_report.txt` (Depending on the type of report).

### Resetting data
All user data is stored in the `data` directory.

To reset data, .txt files in the directory must be removed, and a new set of default data can by copied from `data/defaults`.

```bash
cd /path/to/CAMs/
rm -f data/*.txt
cp data/defaults/students.txt data/
cp data/defaults/staff.txt data/
```

CAMs will be reset to its original state with no camps.
