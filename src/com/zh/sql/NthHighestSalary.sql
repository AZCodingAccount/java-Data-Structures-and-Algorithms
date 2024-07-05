create database leetcode;
use leetcode;
# leetcode 177 https://leetcode.cn/problems/nth-highest-salary/description/
Create table If Not Exists Employee
(
    Id     int,
    Salary int
);
Truncate table Employee;
insert into Employee (id, salary)
values ('1', '100');
insert into Employee (id, salary)
values ('2', '200');
insert into Employee (id, salary)
values ('3', '300');
# 查询第N高的薪资
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
    declare m INT; # 声明变量
    SET M = N - 1; # 给变量赋值
    RETURN (
        # Write your MySQL query statement below.
        SELECT IFNULL( # ifnull函数接收两个参数，如果这个第一个参数是子查询时，需要用括号包裹起来，以便直到何时是第一个参数
                       (SELECT DISTINCT Salary
                        FROM Employee
                        ORDER BY Salary DESC
                        LIMIT M, 1), # 不能直接用传过来的N，必须用声明的M
                       NULL
               ) AS NthHighestSalary);
END

