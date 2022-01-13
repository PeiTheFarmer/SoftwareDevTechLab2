# SoftwareDevTechLab2


This lab needs to include three systems, which include staff manage system, task manage system and user manage system. Staff system needs to register new user. Task manage system needs to list task items and update task state. User manage system needs to provide qualification service and update user password. Meanwhile, we need zookeeper and kalfka to deal with the communication between service.

---
## Staff manage system

Staff manage needs one service.
* Register a new user. This service needs three paraments which   are name, id and department. Once inserting sql has finished, it needs to create a new item in task manage system and user manage system.

Staff data struct is as below:
```
{
    string name;
    string id;
    string department;
}
```
---
## Task manage system
Task manage system needs three service which are insert new task, update task and query task.
* creating a new task, and state is set to unfinished. This service needs one parament got from staff manage system (**id**).
* updating a existed task. This service needs one parament, which is **id**.
* query a task. This service needs one parament (**id**).
```
{
    string id;
    string state;
    string message;
}
```
---
## User manage system 
User manage system needs three service:
* inserting a new user. This service needs one parament, which
is **id**. This service will give a default password to user.
* qualification service. This service needs two paraments, which are **id** and **password**.
* updating service. This service needs two paraments, which are **id** and new **password**.
```
{
    string id;
    string password;
}
```