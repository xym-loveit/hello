#!/bin/bash

#通过三次采集耗性能线程栈信息比较分析问题

#获取tomcat活动进程id
java_pid=`ps -ef | grep '^.*java.*tomcat.*$' | grep -v grep |awk '{print $2}'`
echo "java pid is :$java_pid"

#使用jstack
jstack_path=/usr/java/jdk1.8.0_112/bin/jstack
#thread dump 存放路径
logs_path=/tmp/java/thread_dump
#获取当前tomcat进程里面cpu最高的前15个线程信息存储到临时文件里
top -p $java_pid -H | head -15 > $logs_path/top_dump_111.txt
sudo $jstack_path $java_pid > $logs_path/111.dump
echo "create $logs_path/111/dump success ,sleep 10s;"

#等待10秒重复上面过程，生成三个dump方便对比分析
sleep 10s


top -p $java_pid -H | head -15 > $logs_path/top_dump_222.txt
sudo $jstack_path $java_pid > $logs_path/222.dump
echo "create $logs_path/222.dump success ,sleep 10s;"
echo "create $logs_path/top_dump_222.txt success,sleep 10s;"

sleep 10s

top -p $java_pid -H | head -15 > $logs_path/top_dump_333.txt
sudo $jstack_path $java_pid > $logs_path/333.dump
echo "create $logs_path/333.dump success ,sleep 10s;"
echo "create $logs_path/top_dump_333.txt success,sleep 10s;"

sleep 10s