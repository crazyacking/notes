//作者：陈太汉
//博客：http://www.cnblogs.com/hlxs/ 
#include "SServer.h"

bool SServer::Start(int port)
{
	isStart=true;
	if(WSAStartup(MAKEWORD(2,2),&wsa)!=0)//初始化套接字DLL
	{
		SetSocketError(SocketEnum::WSAStartupError); 
		isStart=false;
	}
	if(isStart)
	{ 
		if((ssocket=socket(AF_INET,SOCK_STREAM,IPPROTO_TCP))==INVALID_SOCKET){
			SetSocketError(SocketEnum::InvalidSocket);
			isStart=false;
		} 
	}
	if(isStart)
	{
		//初始化指定的内存区域
		memset(&serverAddress,0,sizeof(sockaddr_in));
		serverAddress.sin_family=AF_INET;
		serverAddress.sin_addr.S_un.S_addr = htonl(INADDR_ANY);
		if(port>0)
		{
			serverAddress.sin_port = htons(port);
		}else
		{
			SetSocketError(SocketEnum::InvalidPort);
			isStart=false;
		}
	}
	if(isStart)
	{
		//绑定
		if(bind(ssocket,(sockaddr*)&serverAddress,sizeof(serverAddress))==SOCKET_ERROR){
			SetSocketError(SocketEnum::BindError);
		}else
		{
			if(listen(ssocket,SOMAXCONN)==SOCKET_ERROR)//进入侦听状态
			{
				 SetSocketError(SocketEnum::ListenError);
			} 
		}
	}

	return isStart; 
}
 
void SServer::SetSocketError(SocketEnum::SocketError error)
{
	socketError=error;
}
 
CSocket* SServer::Accept()
{
	CSocket* csocket=new CSocket();
	struct sockaddr_in clientAddress;//用来和客户端通信的套接字地址
	int addrlen = sizeof(clientAddress);
	memset(&clientAddress,0,addrlen);//初始化存放客户端信息的内存 
	SOCKET socket;
	if((socket=accept(ssocket,(sockaddr*)&clientAddress,&addrlen))!=INVALID_SOCKET)
	{
		csocket->SetSocketHandle(socket);
	} 
	return csocket;
}
 
SServer::~SServer()
{
	Close();
}
 
bool SServer::ShutDown(SocketEnum::ShutdownMode mode)
{ 
	SocketEnum::SocketError nRetVal = (SocketEnum::SocketError)shutdown(ssocket, SocketEnum::Both); 
	return (nRetVal == SocketEnum::Success) ? true: false;
}
 
void SServer::Close()
{
	ShutDown(SocketEnum::Both);
	if( closesocket(ssocket)!=SocketEnum::Error)
	{
		ssocket= INVALID_SOCKET;
	}
	WSACleanup();//清理套接字占用的资源
}

