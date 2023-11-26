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
YOu can view them [here](https://github.com/Rechard16/CAMs/tree/main/Report)

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

### File Generation
CAMs allows the user to generate reports about their camps. After generation, the report will be found in the root directory of the project as `camp_report.txt` or `committee_report.txt` (Depending on the type of report).

### Resetting data
All user data is stored in the `data` directory.

To reset data, .txt files in the directory must be removed, and a new set of default data can by copied from `data/defaults`.

```bash
cd /path/to/CAMs/
rm -f data/*
cp data/defaults/students.txt data/
cp data/defaults/staff.txt data/
```

CAMs will be reset to its original state with no camps.
