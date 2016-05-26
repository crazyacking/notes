#ifndef __CSOCKET_H__
#define __CSOCKET_H__
#include <windows.h>
#include "SocketEnum.h"
#include <iostream>
using namespace std; 

class CSocket
{
	public:
		CSocket(SocketEnum::SocketType _socketType=SocketEnum::Tcp);
	    ~CSocket();
		bool Connect(const char* ip,int port);		//���� 
		int Send(char* pBuf,int len);	//����
		int Receive(int strLen);	//����
		bool SetBlocking(bool isBlocking);//��������ģʽ
		bool ShutDown(SocketEnum::ShutdownMode mode);
		const char* GetData() const;//��ȡ��������
		SocketEnum::SocketError GetSocketError();
		void SetSocketHandle(SOCKET socket);
		void Close(); 
		bool IsExit();
	private: 

		void SetSocketError(SocketEnum::SocketError error);	//���ô�����Ϣ
		void SetSocketError(void);
		bool IsSocketValid(void);
		SOCKET csocket;
		bool isConnected;	//����״̬
		struct sockaddr_in serverAddress; 
		char* buffer;	//���������
		int sendCount;	//�������ݳ���
		int recvCount;	//�������ݳ���
		bool isBlocking;	//�Ƿ�������ģʽ
		SocketEnum::SocketError socketError;
		SocketEnum::SocketType socketType; 
		WSADATA wsa; 
};

#endif