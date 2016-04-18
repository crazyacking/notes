#include <stdio.h>
#include <stdlib.h>
#include <errno.h>
#include <string.h>
#include <time.h>
#include <netdb.h>
#include <string.h>

// 定义一个socket套接字
int sockfd;

void write_data(int fd)
{
    long t=time(0); // linux时间
    char *s=ctime(&t);
    write(fd,s,strlen(s));
}

void print_client_information(struct sockaddr_in client_addr)
{
    char ip_addr[16];
    inet_ntop(AF_INET,&client_addr.sin_addr.s_addr,ip_addr,sizeof(client_addr));
    unsigned short port=ntohs(client_addr.sin_port);
    printf("client ip:%s : %d\n",ip_addr,port);
}

int main(int argc,char *argv[])
{
    if(argc<2)
    {
        fprintf(stderr,"usage:%s port\n",argv[0]);
        exit(1);
    }
    // 创建一个socket套接字
    sockfd=socket(AF_INET,SOCK_STREAM,0);
    // AF_INET表示使用IPv4地址族(AF_INET6表示使用IPv6地址族)
    // SOCK_STREAM是数据流（tcp协议）;若传递报文则是udp协议
    // 0由tcp决定
    if(sockfd<0)
    {
        fprintf(stderr,"socket:%s\n",strerror(errno));
        exit(1);
    }
    // 设置ip和端口号
    struct sockaddr_in addr;
    memset(&addr,0,sizeof(addr)); // 目的：把ip地址中的后8个字节置为0
    addr.sin_family=AF_INET;

    addr.sin_port=htons(atoi(argv[1]));// argv[1]是传入的端口地址,atio将其转为整形，htons将这个整形转为网络字节序

    addr.sin_addr.s_addr=INADDR_ANY; // INADDR_ANY是本地的一个宏，代表本地回环地址的网络字节序

    //绑定ip和端口号
    int len=sizeof(addr);
    if(bind(sockfd,(struct sockaddr*)&addr,len)<0)
    {
         fprintf(stderr,"bind:%s\n",strerror(errno));
         exit(1);
    }

    // 开始监听
    if(listen(sockfd,10)<0) // 10 代表客户端的个数，假定有10个
    {
         fprintf(stderr,"listen:%s\n",strerror(errno));
         exit(1);
    }

    while(1) // 循环获取监听对象
    {
        struct sockaddr_in client_addr;
        int c_len=sizeof(client_addr);
        int fd=accept(sockfd,(struct sockaddr*)&client_addr,&len); // 返回一个文件描述符

        if(fd<0)
        {
            fprintf(stderr,"accept:%s\n",strerror(errno));
            continue;
        }
        print_client_information(client_addr); // 将客户端的连接信息打印出来
        write_data(fd);//向fd中写入要传入的信息
        close(fd);
    }

    return 0;
}