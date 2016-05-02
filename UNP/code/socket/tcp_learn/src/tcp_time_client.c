#include <stdio.h>
#include <stdlib.h>
#include <errno.h>
#include <string.h>
#include <netdb.h>
#include <time.h>

int sockfd;

int main(int argc,char* argv[])
{
    if(argc<3)
    {
        fprintf(stderr,"usage：ip_addr and port\n");
        exit(1);
    }

    // create socket
    sockfd=socket(AF_INET,SOCK_STREAM,0);
    if(sockfd<0)
    {
        fprintf(stderr,"socket:%s\n",strerror(errno));
        exit(1);
    }
    struct sockaddr_in sockaddr;
    memset(&sockaddr,0,sizeof(sockaddr));
    sockaddr.sin_family=AF_INET;
    sockaddr.sin_port=htons(atoi(argv[2]));
    int len=sizeof(sockaddr);
    inet_pton(AF_INET,argv[1],&sockaddr.sin_addr.s_addr);
    if(connect(sockfd,(struct sockaddr*)&sockaddr,len)<0)
    {
         fprintf(stderr,"connect:%s\n",strerror(errno));
         exit(1);
    }
    char res[1024];
    memset(res,0,sizeof res);
    ssize_t n;
    n=read(sockfd,res,1024);
    if(n<0)
    {
         fprintf(stderr,"read:%s\n",strerror(errno));
         exit(1);
    }
    else
    {
        puts(res);
    }
    return 0;
}
