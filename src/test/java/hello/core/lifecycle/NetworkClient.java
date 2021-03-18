package hello.core.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient{
    
    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출 url = " + url);
        connect();
        call("초기화 연결 메세지");
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // 서비스 시작할 때 호출
    public void connect(){
        System.out.println("connect url = " + url);
    }

    public void call(String message){
        System.out.println("call: "+ url + " message = " + message);
    }
    // 서비스 종료 시 호출
    public void disconnect(){
        System.out.println("close: " + url);
    }
    // 의존관계 주입이 끝나면!
    @PostConstruct
    public void init() throws Exception {
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메세지");
    }

    @PreDestroy
    public void close() throws Exception {
        System.out.println("NetworkClient.close");
        disconnect();
    }
}
