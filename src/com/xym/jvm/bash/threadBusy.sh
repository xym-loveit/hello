#!/bin/bash

#ͨ�����βɼ��������߳�ջ��Ϣ�ȽϷ�������

#��ȡtomcat�����id
java_pid=`ps -ef | grep '^.*java.*tomcat.*$' | grep -v grep |awk '{print $2}'`
echo "java pid is :$java_pid"

#ʹ��jstack
jstack_path=/usr/java/jdk1.8.0_112/bin/jstack
#thread dump ���·��
logs_path=/tmp/java/thread_dump
#��ȡ��ǰtomcat��������cpu��ߵ�ǰ15���߳���Ϣ�洢����ʱ�ļ���
top -p $java_pid -H | head -15 > $logs_path/top_dump_111.txt
sudo $jstack_path $java_pid > $logs_path/111.dump
echo "create $logs_path/111/dump success ,sleep 10s;"

#�ȴ�10���ظ�������̣���������dump����Աȷ���
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