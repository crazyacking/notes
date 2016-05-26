//作者：陈太汉
//博客：http://www.cnblogs.com/hlxs/
#include <windows.h>
#include <process.h>
#include <bits/stdc++.h>
#include <iostream>
using namespace std;
#pragma comment(lib,"ws2_32.lib")
#include "SServer.h"
#include "CSocket.h"
#include <vector>
#include "ClientList.h"
const int BUF_LEN=1024;

void recv(PVOID pt)
{
	CSocket* csocket=(CSocket*)pt;
	if(csocket!=NULL)
	{
		int count= csocket->Receive(BUF_LEN);
		if(count==0)
		{
			ClientList* list=ClientList::GetInstance();
			list->Remove(csocket);
			cout<<"一个用户下线，在线人数："<<list->Count()<<endl;
			_endthread(); //用户下线，终止接收数据线程
		}
	}
}

void sends(PVOID pt)
{
	ClientList* list=(ClientList*)pt;
	while(1)
	{
		char* buf=new char[BUF_LEN] ;
		cin>>buf;
		int bufSize=0;
		while(buf[bufSize++]!='\0');
		for(int i=list->Count()-1;i>=0;i--)
		{
			(*list)[i]->Send(buf,bufSize);
		}
		delete buf;
	}
}

int main(int argc, char* argv[])
{
	SServer server;
	bool isStart=server.Start(1986);
	if(isStart)
	{
		cout<<"server start success..."<<endl;
	}else
	{
		cout<<"server start error"<<endl;
	}
	ClientList* list=ClientList::GetInstance();
	_beginthread(sends,0,list);//启动一个线程广播数据
	while(1)
	 {
		CSocket* csocket=server.Accept();

		list->Add(csocket);
		cout<<"新上线一个用户，在线人数："<<list->Count()<<endl;
		_beginthread(recv,0,csocket);//启动一个接收数据的线程
	 }

	getchar();
	return 0;
}
